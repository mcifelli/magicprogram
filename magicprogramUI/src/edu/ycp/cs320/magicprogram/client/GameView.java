package edu.ycp.cs320.magicprogram.client;

import com.google.gwt.dom.client.Touch;
import com.google.gwt.event.dom.client.*;
import com.google.gwt.event.shared.GwtEvent;
import com.google.gwt.event.shared.HandlerRegistration;
import com.google.gwt.canvas.client.Canvas;
import com.google.gwt.user.client.Timer;
import com.google.gwt.user.client.ui.*;

import edu.ycp.cs320.magicprogram.shared.*;

public class GameView {
//	private static final long serialVersionUID = 1L;
	private Game model;
	public Canvas canvas;
	Point mouse;
	
	public GameView(FlowPanel panel) {
		
		//set up game canvas
		canvas = Canvas.createIfSupported();
		canvas.setStyleName("h1");
		panel.add(canvas);
		canvas.setSize("500px", "500px");
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
//				drawCanvas(canvas);
			}
		};
		timer.scheduleRepeating(10);
		
		model.addCreep();
		
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
//		model.getCreeps().get(0).
	}
	
	//update UI
	public void updateGame() {
		canvas.getContext2d().restore();
		model.update();
	}
	
	public void drawBlue(Canvas canvas) {
		canvas.getContext2d().setFillStyle("Blue");
		canvas.getContext2d().fillRect(4, 4, 80, 40);
	}
	
	public void drawCanvas(Canvas canvas) {
		for(int i = 0; i < model.getCreeps().size(); i++) {
			if(model.getCreeps().size() > 0) {
				canvas.getContext2d().setFillStyle("Blue");
				canvas.getContext2d().fillRect(model.getCreeps().get(i).getPos().getX(), model.getCreeps().get(i).getPos().getY(), model.getCreeps().get(i).getSize(), model.getCreeps().get(i).getSize());
			}
		}
//		canvas.getContext2d().setFillStyle("#ff0000");
//		canvas.getContext2d().fillRect(20, 20, 80, 40);
	}

}
