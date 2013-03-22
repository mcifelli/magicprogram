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
	
//>>>>>>> refs/remotes/mcifelli/master
}
