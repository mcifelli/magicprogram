
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
	private int selectCol;		// selected col
	private int selectRow;		// selected row
	private int COL;			// height of the game grid
	private int ROW;			// width of the game grid
	private int pieceWIDTH;		// width of one grid piece
	private int pieceHEIGHT; 	// height of one grid piece
	private boolean buildMode;	// if true, a build overlay is displayed and a tower can be placed
	
	public GameView(Game game) {
		// GAME
		model = game;
		buildMode = false;
		selectCol = 0;
		selectRow = 0;
		COL = model.getMap().length;
		ROW = model.getMap()[0].length;
		pieceWIDTH = WIDTH / COL;
		pieceHEIGHT = HEIGHT / ROW; 
		
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
		
		// MOUSE MOVE HANDLER
		foreground.addMouseMoveHandler(new MouseMoveHandler() {
			@Override
			public void onMouseMove(MouseMoveEvent event) {					// on mouse move:
				if (buildMode) {												// if in build mode:
					selectCol = event.getX() - (event.getX() / COL);			// update selected column
					selectRow = event.getY() - (event.getY() / ROW);			// update selected row
				}
			}
		});
		
		// MOUSE DOWN HANDLER
		foreground.addMouseDownHandler(new MouseDownHandler() {
			@Override
			public void onMouseDown(MouseDownEvent event) {							// on mouse click:
				if (buildMode) {														// if in build mode:
					if (model.buildStructure(Structure.Type.tower, selectRow, selectCol)) {	// if tower is constructed
						buildMode = false;														// turn off build mode
					}
				}
			}
		});	

		// TIMER
	    Timer timer = new Timer() {
	      @Override
	      public void run() {			// on every tick:
	    	  updateForeground();			// update the foreground 
	      }
	    };
	    timer.scheduleRepeating(25);	// tick every 25 us
		
		// INIT WIDGET
		initWidget(mainPanel);			// init the widget
		setSize(WIDTH + "px", HEIGHT + "px");	// set widget size
	}
	
	public void update() {
		updateForeground();
	}
	
	private void updateBackground() {
		Context2d context = background.getContext2d();			// get the context
		
		// REFRESH
		context.clearRect(0, 0, WIDTH, HEIGHT);					// clear the canvas
		
		// DRAW TERRAIN
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
					context.fillRect( col * pieceWIDTH, row * pieceHEIGHT, pieceWIDTH, pieceHEIGHT);
				}
			}
		}
	}
	
	private void updateForeground() {
		Context2d context = foreground.getContext2d();
		context.drawImage(background.getCanvasElement(), 0, 0);
		
		// DRAW TOWERS
		for (Structure s : model.getStructs()) {
			switch (s.getType()) {
				case base:
					context.setFillStyle("#FFFFFF");
					break;
				case tower:
					context.setFillStyle("#00FFFF");
					break;
				default:
					break;
			}
			int x = (int) s.getTopLeft().x();
			int y = (int) s.getTopLeft().y();
			context.fillRect(x, y, x + pieceWIDTH, y + pieceHEIGHT);
		}
		
		// DRAW CREEPS
		context.setFillStyle("#FF0000");
		for (Creep c : model.getCreeps()) {
			int size = c.getSize();
			context.fillRect(c.getPos().getX(), c.getPos().getY(), size, size);
		}
		
		// DRAW BUILD OVERLAY
		if (buildMode) {
			System.out.println("buildmode activated");
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
		
			// selector
			if (model.canBuildStructure(new Structure(select, Structure.Type.tower))) {
				context.setFillStyle("#FF00FF");
			}
			else {
				context.setFillStyle("#000000");
			}
			context.fillRect(select.getX(), select.getY(), unitX, unitY);
		}
	}
	
	public boolean getBuildMode() {
		return buildMode;
	}
	
	public void setBuildMode(boolean buildMode) {
		this.buildMode = buildMode;
	}
}
