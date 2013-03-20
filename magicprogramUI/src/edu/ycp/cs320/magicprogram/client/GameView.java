package edu.ycp.cs320.magicprogram.client;

import com.google.gwt.event.dom.client.*;
import com.google.gwt.canvas.client.Canvas;
import com.google.gwt.canvas.dom.client.Context2d;
import com.google.gwt.user.client.ui.*;

import edu.ycp.cs320.magicprogram.shared.*;

public class GameView extends Composite implements MouseMoveHandler{
	// Widgets and Panels
	public Canvas canvas;
	MouseMoveHandler mouseAdapterMOVE;
	
	// Fields
	private Game model;
	private int mouseX;
	private int mouseY;
	public boolean showGrid;
	private final int WIDTH = 500;
	private final int HEIGHT = 500;
	
	public GameView(Game game) {
		// GAME
		model = game;
		showGrid = false;
		
		// CANVAS
		canvas = Canvas.createIfSupported();
		canvas.setSize(WIDTH + "px", HEIGHT + "px");
		canvas.setCoordinateSpaceHeight(HEIGHT);
		canvas.setCoordinateSpaceWidth(WIDTH);
		
		// LAYOUT PANEL
		VerticalPanel panel = new VerticalPanel();
		panel.add(canvas);}
		
		
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
		
		// DRAW BOARD
		String[][] board = model.getBoard();
		if (board != null) {
			int unitX = WIDTH / board[0].length;
			int unitY = HEIGHT / board.length;
			// ----PIECES
//			for (int row = 0; row < board.length; row++) {
//				for (int col = 0; col < board.length; col++) {
//					context.setFillStyle("#000000");
//					context.fillRect(col * unitX, row * unitY, unitX, unitY);
//				}
//			}
			
			// ----GRID
			if (showGrid) {
				context.setStrokeStyle("#000000");
				for (int y = 0; y < HEIGHT; y += unitY) {
					context.moveTo(0, y);
					context.lineTo(WIDTH, y);
					context.stroke();
				}
				for (int x = 0; x < WIDTH; x += unitX) {
					context.moveTo(x, 0);
					context.lineTo(x, HEIGHT);
					context.stroke();
				}
			}
			// DRAW SELECTOR
			context.setFillStyle("#0000FF");
			context.fillRect(mouseX / unitX, mouseY / unitY, unitX, unitY);
		}
		// DRAW CREEPS
		context.setFillStyle("#0000FF");
		for (Creep curr : model.getCreeps()) {
			context.fillRect(curr.getPos().getX(), curr.getPos().getY(), curr.getSize(), curr.getSize());
		}
	}
	
	public void toggleGrid() {
		showGrid = !showGrid;
	}

	@Override
	public void onMouseMove(MouseMoveEvent event) {
		mouseX = event.getRelativeX(null);
		mouseY = event.getRelativeY(null);
		update();
	}
	
}
