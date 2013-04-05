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
	public Canvas canvas;
	
	// Fields
	private Game model;
	private Point select;
	private boolean buildMode;
	private int unitX;
	private int unitY;
	
	public GameView(Game game) {
		// GAME
		model = game;
		buildMode = false;
		select = new Point(-1, -1);
		
		// Calculate UNITS
		unitX = WIDTH / model.getTowers()[0].length;
		unitY = HEIGHT / model.getTowers().length;
		
		// CANVAS
		canvas = Canvas.createIfSupported();
		canvas.setSize(WIDTH + "px", HEIGHT + "px");
		canvas.setCoordinateSpaceHeight(HEIGHT);
		canvas.setCoordinateSpaceWidth(WIDTH);
		
		// MOUSE MOVE HANDLER
		canvas.addMouseMoveHandler(new MouseMoveHandler() {
			@Override
			public void onMouseMove(MouseMoveEvent event) {
				select.setX(event.getX() - (event.getX() % unitX));
				select.setY(event.getY() - (event.getY() % unitY));
			}
		});
		
		
		// MOUSE DOWN HANDLER
		canvas.addMouseDownHandler(new MouseDownHandler() {
			@Override
			public void onMouseDown(MouseDownEvent event) {
				model.getTowers()[((int)select.getY() / unitY)][ ((int)select.getX() / unitX)] = new Tower();
				select.setXY(-1, -1);
			}
		});
		
	    // setup timer
	    Timer timer = new Timer() {
	      @Override
	      public void run() {
	    	  update();
	      }
	    };
	    timer.scheduleRepeating(25);
		
		// LAYOUT PANEL
		VerticalPanel panel = new VerticalPanel();
		panel.add(canvas);
		
		
		// INIT WIDGET
		initWidget(panel);
		setSize(WIDTH + "px", HEIGHT + "px");
	}
	
	public void setModel(Game game) {
		this.model = game;
	}
	
	public void update() {
		Context2d context = canvas.getContext2d();
		context.beginPath();
		
		// REFRESH
		context.clearRect(0, 0, WIDTH, HEIGHT);
		
		// DRAW TOWERS
				Tower towers[][] = model.getTowers();
				context.setFillStyle("#FF0000");
				for (int row = 0; row < towers.length; row++) {
					for (int col = 0; col < towers[row].length; col++) {
						if (towers[row][col] != null) {
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
			// DRAW GRID
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
