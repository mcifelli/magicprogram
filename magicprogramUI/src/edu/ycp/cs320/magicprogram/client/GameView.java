package edu.ycp.cs320.magicprogram.client;

import com.google.gwt.event.dom.client.*;
import com.google.gwt.canvas.client.Canvas;
import com.google.gwt.canvas.dom.client.Context2d;
import com.google.gwt.user.client.Timer;
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
	private Structure select;
	
	public GameView(Game game) {
		// GAME
		model = game;
		buildMode = false;
		canBuild = false;
		pieceWidth = WIDTH / model.getMap()[0].length;
		pieceHeight = HEIGHT / model.getMap().length; 
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
		
		// MOUSE MOVE HANDLER
		foreground.addMouseMoveHandler(new MouseMoveHandler() {
			@Override
			public void onMouseMove(MouseMoveEvent event) {					// on mouse move:
				if (buildMode) {												// if in build mode:
					select.tl().setX(event.getX() - (event.getX() % pieceWidth));	// update top left x of select
					select.tl().setY(event.getY() - (event.getY() % pieceWidth));	// update top left y of select
					canBuild = model.canBuildStructure(select);						// test if can build at location
				}
			}
		});
		
		// MOUSE DOWN HANDLER
		foreground.addMouseDownHandler(new MouseDownHandler() {
			@Override
			public void onMouseDown(MouseDownEvent event) {	// on mouse click:
				if (buildMode) {								// if in build mode:
					if (model.buildStructure(select)) {				// attempt tower construction
						buildMode = false;								// turn off build mode
						canBuild = false;								// can build out of build mode...
					}
				}
				System.out.println("Mouse Pointer At------: (" + event.getX() + ", " + event.getY() + ")");
			}
		});	

		// TIMER
	    Timer timer = new Timer() {
	      @Override
	      public void run() {
	    	  model.update();
	    	  updateForeground();
	      }
	    };
	    timer.scheduleRepeating(25);
		
		// INIT WIDGET
		initWidget(mainPanel);
		setSize(WIDTH + "px", HEIGHT + "px");
	}
	
	private void updateBackground() {
		Context2d context = background.getContext2d();			// get the context
		context.clearRect(0, 0, WIDTH, HEIGHT);					// refresh the canvas
		Terrain map[][] = model.getMap();						// get the terrain map
		for (int row = 0; row < map.length; row++) {			// loop through map
			for (int col = 0; col < map[row].length; col++) {		// ""
				switch(map[row][col]) {									// determine the terrain and change color accordingly
					case grass:
						context.setFillStyle("#00FF00");
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
				if (map[row][col] != null) {	// if there is something to draw, fill the rectangle
					context.fillRect(col * pieceWidth, row * pieceHeight, pieceWidth, pieceHeight);
				}
			}
		}
	}
	
	private void updateForeground() {
		Context2d context = foreground.getContext2d();			// get the context
		context.drawImage(background.getCanvasElement(), 0, 0);	// refresh the canvas with the background
		for (Structure struct : model.getStructs()) {			// loop through structures
			switch (struct.getType()) {							// determine color of structure based on type
				case base:
					context.setFillStyle("#FFFFFF");
					break;
				case tower:
					context.setFillStyle("#00FFFF");
					break;
				case spawner:
					context.setFillStyle("#000000");
				default:
					break;
			}
			context.fillRect(struct.tl().x(), struct.tl().y(), pieceWidth, pieceHeight);
		}
		
		// DRAW CREEPS
		context.setFillStyle("#FF0000");
		for (Creep c : model.getCreeps()) {
			context.fillRect(c.getTopLeft().x(), c.getTopLeft().y(), c.getSize(), c.getSize());
		}
		
		// DRAW BUILD OVERLAY
		if (buildMode) {
			System.out.println("buildmode activated");
			// grid
			context.setStrokeStyle("#000000");
			for (int y = 0; y < HEIGHT; y += pieceHeight) {
				context.moveTo(0, y - 0.5);  
				context.lineTo(WIDTH, y - 0.5);
				context.stroke();
			}
			for (int x = 0; x < WIDTH; x += pieceWidth) {
				context.moveTo(x - 0.5, 0);
				context.lineTo(x - 0.5, HEIGHT);
				context.stroke();
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
	
	public boolean getBuildMode() {
		return buildMode;
	}
	
	public void setBuildMode(boolean buildMode) {
		this.buildMode = buildMode;
	}
}
