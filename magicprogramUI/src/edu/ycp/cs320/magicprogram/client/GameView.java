package edu.ycp.cs320.magicprogram.client;

import com.google.gwt.event.dom.client.*;
import com.google.gwt.event.shared.GwtEvent;
import com.google.gwt.canvas.client.Canvas;
import com.google.gwt.user.client.Timer;
import com.google.gwt.user.client.ui.*;

import edu.ycp.cs320.magicprogram.shared.*;

public class GameView {
//	private static final long serialVersionUID = 1L;
	private Game model;
	public Canvas canvas;
	
	public GameView(FlowPanel panel) {
		
		//set up game canvas
		canvas = Canvas.createIfSupported();
		canvas.setStyleName("h1");
		panel.add(canvas);
		canvas.setSize("500px", "500px");
		
	}
	
	public void setModel(Game game) {
		this.model = game;
	}
	
	public void start() {
		Timer timer = new Timer() {
			@Override
			public void run() {
				updateGame();
				drawCanvas(canvas);
			}
		};
		timer.scheduleRepeating(10);
		
		MouseDownHandler mouseDown;
		HasAllMouseHandlers handler;
		handler.addMouseDownHandler(mouseDown);
		
		
	}
	
	//update UI
	public void updateGame() {
		model.update();
	}
	
	public void drawCanvas(Canvas canvas) {
		for(int i = 0; i < model.getBoard().getCreeps().size(); i++) {
			canvas.getContext2d().fillRect(model.getBoard().getCreeps().get(i).getCenter().getX(), model.getBoard().getCreeps().get(i).getCenter().getY(), model.getBoard().getCreeps().get(i).getBody().getWidth(), model.getBoard().getCreeps().get(i).getBody().getHeight());
		}
		canvas.getContext2d().setFillStyle("#ff0000");
		canvas.getContext2d().fillRect(20, 20, 80, 40);
	}

}
