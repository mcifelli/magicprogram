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
	public Canvas canvas;
	
	// Fields
	private Game model;
	private int selectionX;
	private int selectionY;
	private boolean showGrid;
	private int unitX;
	private int unitY;
	
	public GameView(Game game) {
		// GAME
		model = game;
		showGrid = true;
		
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
				selectionX = event.getX() - (event.getX() % unitX);
				selectionY = event.getY() - (event.getY() % unitY);
				System.out.print("New Selector point: (" + selectionX + ", " + selectionY);
			}
		});
		
		
		// MOUSE DOWN HANDLER
		canvas.addMouseDownHandler(new MouseDownHandler() {
			@Override
			public void onMouseDown(MouseDownEvent event) {
				model.getTowers()[selectionY / unitY][selectionX / unitX] = new Tower();
			}
		});
		
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
		
		// ----GRID
		if (showGrid) {
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
			context.fillRect(selectionX, selectionY, unitX, unitY);
		}
		
		// draw TOWERS
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
		for (Creep curr : model.getCreeps()) {
			context.fillRect(curr.getPos().getX(), curr.getPos().getY(), curr.getSize(), curr.getSize());
		}
	}
	
	public void toggleGrid() {
		showGrid = !showGrid;
	}
	
}
