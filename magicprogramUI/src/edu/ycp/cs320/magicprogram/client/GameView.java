package edu.ycp.cs320.magicprogram.client;

import com.google.gwt.event.dom.client.*;
import com.google.gwt.canvas.client.Canvas;
import com.google.gwt.user.client.Timer;
import com.google.gwt.user.client.ui.*;

import edu.ycp.cs320.magicprogram.shared.*;

public class GameView {

	private Game model;
	private Canvas canvas;
	Point mouse;
	
	public GameView(FlowPanel panel) {
		
		//set up game canvas
		canvas = Canvas.createIfSupported();
		canvas.setCoordinateSpaceWidth(750);
		canvas.setCoordinateSpaceHeight(750);
		canvas.setStyleName("h1");
		panel.add(canvas);
		canvas.setSize("750px", "750px");
		mouse = new Point(0, 0);
	}
	
	public void setModel(Game game) {
		this.model = game;
	}
	
	public void start() {
		Timer timer = new Timer() {
			@Override
			public void run() {
				updateGame();
			}
		};
		timer.scheduleRepeating(10);
		
		canvas.addMouseDownHandler(new MouseDownHandler() {
			@Override
			public void onMouseDown(MouseDownEvent event) {
				// TODO Auto-generated method stub
				clickHandle(event);
			}
		});	
	}
	
	//mouse has been clicked
	protected void clickHandle(MouseDownEvent event) {
		mouse.setX(event.getClientX());
		mouse.setY(event.getClientY());
		model.addCreepAt(new Point(mouse.getX(), mouse.getY()));
	}
	
	//update UI (Game class)
	public void updateGame() {
		canvas.getContext2d().clearRect(0, 0, 5000, 5000);
		model.update();
		drawCanvas(canvas);
	}
	
	public void drawBlue(Canvas canvas) {
		canvas.getContext2d().restore();
		canvas.getContext2d().setFillStyle("Blue");
		canvas.getContext2d().fillRect(mouse.getX(), mouse.getY(), 10, 10);
	}
	
	public void drawCanvas(Canvas canvas) {
		for(int i = 0; i < model.getCreeps().size(); i++) {
			if(model.getCreeps().size() > 0) {
				canvas.getContext2d().setFillStyle("Blue");
				canvas.getContext2d().fillRect(model.getCreeps().get(i).getPos().getX(), model.getCreeps().get(i).getPos().getY(), 10, 10);
			}
		}
	}

}
