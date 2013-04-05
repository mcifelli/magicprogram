package edu.ycp.cs320.magicprogram.client;

import com.google.gwt.event.dom.client.*;
import com.google.gwt.canvas.client.Canvas;
//<<<<<<< HEAD
//
//import com.google.gwt.user.client.Timer;
//import com.google.gwt.user.client.ui.*;
//
//import edu.ycp.cs320.magicprogram.shared.*;
//
//public class GameView {
//
//	private Game model;
//	private Canvas canvas;
//	Point mouse;
//	
//	public GameView(FlowPanel panel) {
//		
//		//set up game canvas
//		canvas = Canvas.createIfSupported();
//		canvas.setCoordinateSpaceWidth(750);
//		canvas.setCoordinateSpaceHeight(750);
//		canvas.setStyleName("h1");
//		panel.add(canvas);
//		canvas.setSize("750px", "750px");
//		mouse = new Point(0, 0);
//	}
//	
//	public void setModel(Game game) {
//		this.model = game;
//	}
//	
//	public void start() {
//		Timer timer = new Timer() {
//			@Override
//			public void run() {
//				updateGame();
//			}
//		};
//		timer.scheduleRepeating(10);
//		
//		canvas.addMouseDownHandler(new MouseDownHandler() {
//			@Override
//			public void onMouseDown(MouseDownEvent event) {
//				// TODO Auto-generated method stub
//				clickHandle(event);
//			}
//		});	
//	}
//	
//	//mouse has been clicked
//	protected void clickHandle(MouseDownEvent event) {
//		mouse.setX(event.getClientX());
//		mouse.setY(event.getClientY());
//		model.addCreepAt(new Point(mouse.getX(), mouse.getY()));
//	}
//	
//	//update UI (Game class)
//	public void updateGame() {
//		canvas.getContext2d().clearRect(0, 0, 5000, 5000);
//		model.update();
//		drawCanvas(canvas);
//	}
//	
//	public void drawBlue(Canvas canvas) {
//		canvas.getContext2d().restore();
//		canvas.getContext2d().setFillStyle("Blue");
//		canvas.getContext2d().fillRect(mouse.getX(), mouse.getY(), 10, 10);
//	}
//	
//	public void drawCanvas(Canvas canvas) {
//		for(int i = 0; i < model.getCreeps().size(); i++) {
//			if(model.getCreeps().size() > 0) {
//				canvas.getContext2d().setFillStyle("Blue");
//				canvas.getContext2d().fillRect(model.getCreeps().get(i).getPos().getX(), model.getCreeps().get(i).getPos().getY(), 10, 10);
//			}
//		}
//	}
//=======
import com.google.gwt.canvas.dom.client.Context2d;
import com.google.gwt.user.client.Timer;
import com.google.gwt.user.client.ui.*;

import edu.ycp.cs320.magicprogram.shared.*;

public class GameView extends Composite{
	// Constants
	private final int WIDTH = 500;
	private final int HEIGHT = 500;
	
	// Widgets and Panels
	private Canvas background;
	private Canvas foreground;
	private AbsolutePanel mainPanel;
	
	// Fields
	private Game model;
	private Point select;
	private boolean buildMode;
	private int unitX;
	private int unitY;
	
	private Button btnAddCreepTo;
	
	public GameView(Game game) {
		// GAME
		model = game;
		buildMode = false;
		select = new Point(-1, -1);
		
		// Calculate UNITS

//		unitX = WIDTH / model.getTowers()[0].length;
//		unitY = HEIGHT / model.getTowers().length;
		
//		// CANVAS
//		canvas = Canvas.createIfSupported();
//		canvas.setSize(WIDTH + "px", HEIGHT + "px");
//		canvas.setCoordinateSpaceHeight(HEIGHT);
//		canvas.setCoordinateSpaceWidth(WIDTH);
		
//		// MOUSE MOVE HANDLER
//		canvas.addMouseMoveHandler(new MouseMoveHandler() {
//			@Override
//			public void onMouseMove(MouseMoveEvent event) {
//				selectionX = event.getX() - (event.getX() % unitX);	//snap selector to grid squares
//				selectionY = event.getY() - (event.getY() % unitY);
//			}
//		});
		
//		// MOUSE DOWN HANDLER
//		canvas.addMouseDownHandler(new MouseDownHandler() {
//			@Override
//			public void onMouseDown(MouseDownEvent event) {
//				model.getTowers()[selectionY / unitY][selectionX / unitX] = new Tower();
//				model.setTerrain((selectionY / unitY), (selectionX / unitX), Terrain.tower);
//			}
//		});
		
		unitX = WIDTH / model.getStructures()[0].length;
		unitY = HEIGHT / model.getStructures().length;
		
		// LAYOUT PANEL
		mainPanel = new AbsolutePanel();
		
		// FOREGROUND CANVAS
		foreground = Canvas.createIfSupported();
		foreground.setSize(WIDTH + "px", HEIGHT + "px");
		foreground.setCoordinateSpaceHeight(HEIGHT);
		foreground.setCoordinateSpaceWidth(WIDTH);
		mainPanel.add(foreground);
		
		// BACKGROUND CANVAS
		background = Canvas.createIfSupported();
		background.setSize(WIDTH + "px", HEIGHT + "px");
		background.setCoordinateSpaceHeight(HEIGHT);
		background.setCoordinateSpaceWidth(WIDTH);
		updateBackground();
		mainPanel.add(background);
		
		// MOUSE MOVE HANDLER
		foreground.addMouseMoveHandler(new MouseMoveHandler() {
			@Override
			public void onMouseMove(MouseMoveEvent event) {
				select.setX(event.getX() - (event.getX() % unitX));
				select.setY(event.getY() - (event.getY() % unitY));
			}
		});
		
		// MOUSE DOWN HANDLER
		foreground.addMouseDownHandler(new MouseDownHandler() {
			@Override
			public void onMouseDown(MouseDownEvent event) {
				if (buildMode && (select.getX() != -1) && select.getY() != -1) {
					if (model.buildStructure(Structure.tower, (int)select.getY() / unitY, (int)select.getX() / unitX)) {
						select.setXY(-1, -1);
						buildMode = false;
					}
				}
			}
		});	

		// TIMER
	    Timer timer = new Timer() {
	      @Override
	      public void run() {
	    	  update();
	      }
	    };
	    timer.scheduleRepeating(25);
		
		// INIT WIDGET
		initWidget(mainPanel);
		
		Button btnNewButton = new Button("Add a creep");
		mainPanel.add(btnNewButton);

		initWidget(mainPanel);

		setSize(WIDTH + "px", HEIGHT + "px");
	    btnNewButton.addClickHandler(new ClickHandler() {
	    	public void onClick(ClickEvent event) {
	    		model.addCreep();
	    	}
	    });
		
	}
	
	public void start() {
	    // setup timer
	    Timer timer = new Timer() {
	      @Override
	      public void run() {
	    	  model.update();
	    	  update();
	      }
	    };
	    timer.scheduleRepeating(25);
	}
	
	public void setModel(Game game) {
		this.model = game;
	}
	
	public void update() {
		updateForeground();
	}
	
	private void updateBackground() {
		Context2d context = background.getContext2d();
		
		// REFRESH
		context.clearRect(0, 0, WIDTH, HEIGHT);
		
		// DRAW TERRAIN
		Terrain map[][] = model.getMap();
		for (int row = 0; row < map.length; row++) {
			for (int col = 0; col < map[row].length; col++) {
				// choose color
				switch(map[row][col]) {
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
				
				if (map[row][col] != null) {
					context.fillRect(col * unitX, row * unitY, unitX, unitY);
				}
			}
		}
	}
	
	private void updateForeground() {
		Context2d context = foreground.getContext2d();
		context.drawImage(background.getCanvasElement(), 0, 0);
		
		// DRAW TOWERS
		Structure[][] structures = model.getStructures();
		for (int row = 0; row < structures.length; row++) {
			for (int col = 0; col < structures[row].length; col++) {
				if (structures[row][col] != null) {
					switch(structures[row][col]) {
						case base:
							context.setFillStyle("#FF00FF");
							break;
						case tower:
							context.setFillStyle("#00FFFF");
							break;
						default:
							break;
					}
					context.fillRect(col * unitX, row * unitY, unitX, unitY);
				}
			}
		}
		
		// DRAW CREEPS
		context.setFillStyle("#FF0000");
		for (Creep c : model.getCreeps()) {
			int size = c.getSize();
			context.fillRect(c.getPos().getX(), c.getPos().getY(), size, size);
		}
		
		// DRAW BUILD OVERLAY
		if (buildMode && select.getX() != -1 && select.getY() != -1) {
			// grid
			context.setStrokeStyle("#000000");
			for (int y = 0; y < HEIGHT; y += unitY) {
				context.moveTo(0, y - 0.5);  
				context.lineTo(WIDTH, y - 0.5);
				context.stroke();
			}
			for (int x = 0; x < WIDTH; x += unitX) {
				context.moveTo(x - 0.5, 0);
				context.lineTo(x - 0.5, HEIGHT);
				context.stroke();
			}
		

			// DRAW SELECTOR
			context.setFillStyle("#0000FF");
//			context.fillRect(selectionX, selectionY, unitX, unitY);
		}
		
//		// draw TOWERS
//		Tower towers[][] = model.getTowers();
//		context.setFillStyle("#FF0000");
//		for (int row = 0; row < towers.length; row++) {
//			for (int col = 0; col < towers[row].length; col++) {
//				if (towers[row][col] != null) {
//					context.fillRect(col * unitX, row * unitY, unitX, unitY);
//					
//				}
//				
//			}
//		}
		Terrain grid[][] = model.getTerrain();
		for (int row = 0; row < grid.length; row++) {
			for (int col = 0; col < grid[row].length; col++) {
//				if (grid[row][col] == Terrain.tower) {
//					context.setFillStyle("blue");
//					context.fillRect(col * unitX, row * unitY, unitX, unitY);
//				}
			// selector
				if (model.canBuildStructure(Structure.tower, (int)select.getY() / unitY, (int)select.getX() / unitX)) {
					context.setFillStyle("#FF00FF");	
				}
				else {
					context.setFillStyle("#000000");	
					
				}
				context.fillRect(select.getX(), select.getY(), unitX, unitY);
			}
		}
	}
	
	public boolean getBuildMode() {
		return buildMode;
	}
	
	public void setBuildMode(boolean buildMode) {
		this.buildMode = buildMode;
	}

}
