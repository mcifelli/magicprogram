package edu.ycp.cs320.magicprogram.client;

import com.google.gwt.event.dom.client.*;
import com.google.gwt.canvas.client.Canvas;
import com.google.gwt.canvas.dom.client.Context2d;
import com.google.gwt.user.client.ui.*;

import edu.ycp.cs320.magicprogram.shared.*;

public class GameView extends Composite{
	// Constants
	private final int WIDTH = 500;
	private final int HEIGHT = 500;

	// Widgets and Panels
	private Canvas background;			// contains terrain, constant rendering not necessary  
	private Canvas foreground;			// contains structures and creeps, uses context from background as a backdrop
	private AbsolutePanel mainPanel;	// main panel of the application

	// Fields
	private Game model;
	private int pieceWidth;		// width of one grid piece
	private int pieceHeight; 	// height of one grid piece
	private boolean buildMode;	// if true, a build overlay is displayed and a tower can be placed
	private boolean canBuild;	// if true, the selector will indicate that a tower can be placed
	private boolean showRange;
	private Structure select;

	public GameView(Game game) {
		// GAME
		model = game;
		buildMode = false;
		canBuild = false;
		showRange = false;
		pieceWidth = WIDTH / model.getState().getMap()[0].length;
		pieceHeight = HEIGHT / model.getState().getMap().length;
		select = new Structure(Structure.Type.tower, new Point(), pieceWidth);

		// LAYOUT PANEL
		mainPanel = new AbsolutePanel();

		// FOREGROUND CANVAS
		foreground = Canvas.createIfSupported();			// init the foreground canvas
		foreground.setSize(WIDTH + "px", HEIGHT + "px");	// set size to height and width
		foreground.setCoordinateSpaceHeight(HEIGHT);		// set coordinate height
		foreground.setCoordinateSpaceWidth(WIDTH);			// set coordinate width
		mainPanel.add(foreground);							// add to main panel

		// BACKGROUND CANVAS
		background = Canvas.createIfSupported();			// init the background canvas
		background.setSize(WIDTH + "px", HEIGHT + "px");	// set size to height and width
		background.setCoordinateSpaceHeight(HEIGHT);		// set coordinate height
		background.setCoordinateSpaceWidth(WIDTH);			// set coordinate width
		mainPanel.add(background);							// add to main panel
		updateBackground();

		// INIT WIDGET
		initWidget(mainPanel);
		setSize(WIDTH + "px", HEIGHT + "px");

		// MOUSE MOVE HANDLER
		foreground.addMouseMoveHandler(new MouseMoveHandler() {
			@Override
			public void onMouseMove(MouseMoveEvent event) {
				if (buildMode) {												// if in build mode:
					select.tl().setX(event.getX() - (event.getX() % pieceWidth));	// update top left x of select
					select.tl().setY(event.getY() - (event.getY() % pieceWidth));	// update top left y of select
					canBuild = model.canBuildTower(select);						// test if can build at location
				}
			}
		});

		// MOUSE DOWN HANDLER
		foreground.addMouseDownHandler(new MouseDownHandler() {
			@Override
			public void onMouseDown(MouseDownEvent event) {
				if (buildMode) {								// if in build mode:
					if (model.buildTower(select)) {				// attempt tower construction
						buildMode = false;								// turn off build mode
						canBuild = false;								// can build out of build mode...
					}
				}
			}
		});  
	}

	private void updateBackground() {
		Context2d context = background.getContext2d();
		context.clearRect(0, 0, WIDTH, HEIGHT);
		Terrain map[][] = model.getState().getMap();
		for (int row = 0; row < map.length; row++) {
			for (int col = 0; col < map[row].length; col++) {
				switch(map[row][col]) {
				case grass:
					context.setFillStyle("#228B22");
					break;
				case road:
					context.setFillStyle("#C0C0C0");
					break;
				case water:
					context.setFillStyle("#0000FF");
					break;
				default:
					context.setFillStyle("#FFFFFF");
					break;
				}
				if (map[row][col] != null) {
					context.fillRect(col * pieceWidth, row * pieceHeight, pieceWidth, pieceHeight);
				}
			}
		}
	}

	public void updateForeground() {
		Context2d context = foreground.getContext2d();			// get the context
		context.drawImage(background.getCanvasElement(), 0, 0);	// refresh the canvas with the background

		// DRAW SPAWNER
		Structure spawner = model.getState().getSpawner();
		context.setFillStyle("black");
		context.fillRect(spawner.tl().x(), spawner.tl().y(), pieceWidth, pieceHeight);
		context.setFillStyle("white");
		context.fillText(Integer.toString(model.creepsInWave()), spawner.tl().x(), spawner.tl().y());

		// DRAW TOWERS
		for (Structure tower : model.getState().getTowers()) {
			context.setFillStyle("cyan");
			if (tower.getFocus() != null) {
				drawLine(context, tower.getCenter(), tower.getFocus().getCenter());
			}
			if (showRange) {
				context.beginPath();
				context.arc(tower.getCenter().x(), tower.getCenter().y(), tower.getRange(), 0, 2 * Math.PI);
				context.stroke();
				context.closePath();
			}
			context.fillRect(tower.tl().x(), tower.tl().y(), pieceWidth, pieceHeight);
		}

		// DRAW BASE
		context.setFillStyle("white");
		context.fillRect(model.getState().getBase().tl().x(), model.getState().getBase().tl().y(), pieceWidth, pieceHeight);
		context.setFont("bold 18px sans-serif");
		context.setFillStyle("black");
		context.fillText(Integer.toString(model.getLife()), model.getState().getBase().tl().x(), model.getState().getBase().tl().y() + pieceHeight);

		// DRAW CREEPS
		context.setFillStyle("#FF0000");
		for (Creep c : model.getCreeps()) {
			context.fillRect(c.getTopLeft().x(), c.getTopLeft().y(), c.getSize(), c.getSize());
		}

		// DRAW BUILD OVERLAY
		if (buildMode) {
			// grid
			context.setStrokeStyle("#000000");
			for (int y = 0; y < HEIGHT; y += pieceHeight) {
				drawLine(context, 0, y - 0.5, WIDTH, y - 0.5);
			}
			for (int x = 0; x < WIDTH; x += pieceWidth) {
				drawLine(context, x - 0.5, 05, x - 0.5, HEIGHT);
			}

			// selector
			if (canBuild) {
				context.setFillStyle("#FF00FF");
			}
			else {
				context.setFillStyle("#000000");
			}
			context.fillRect(select.tl().x(), select.tl().y(), pieceWidth, pieceHeight);
		}
	}

	public void drawLine(Context2d context, Point a, Point b) {
		drawLine(context, a.x(), a.y(), b.x(), b.y());
	}

	public void drawLine(Context2d context, double a_x, double a_y, double b_x, double b_y) {
		context.beginPath();
		context.moveTo(a_x, a_y);
		context.lineTo(b_x, b_y);
		context.stroke();
		context.closePath();
	}

	public boolean getBuildMode() {
		return buildMode;
	}

	public void toggleBuildMode() {
		buildMode = !buildMode;
	}

	public void toggleShowRange() {
		showRange = !showRange;
	}


	//	protected void getUserScore(){
	//		RPC.userServ.getUserScore(null/*Put Username here*/, new AsyncCallback<String>() {
	//			
	//			@Override
	//			public void onSuccess(String result) {
	//				// TODO Auto-generated method stub
	//				Integer.parseInt(result);
	//				
	//				}
	//			
	//			@Override
	//			public void onFailure(Throwable caught) {
	//				// TODO Auto-generated method stub
	//				return;
	//			}
	//		});		
	//	}
	//	
	//	protected void setUserScore(){
	//		RPC.userServ.setUserScore(null/*Put Username here*/, 0/*Put User's score here*/, new AsyncCallback<String>() {
	//			
	//			@Override
	//			public void onSuccess(String result) {
	//				// TODO Auto-generated method stub
	//						
	//				}
	//			
	//			@Override
	//			public void onFailure(Throwable caught) {
	//				// TODO Auto-generated method stub
	//				return;
	//			}
	//		});		
	//	}




}