package edu.ycp.cs320.magicprogram.client;

import com.google.gwt.canvas.client.Canvas;
import com.google.gwt.user.client.Timer;
import com.google.gwt.user.client.ui.*;

import edu.ycp.cs320.magicprogram.shared.*;

public class GameView extends Composite {
	
	private Game model;
	public Canvas canvas;
	
	public GameView(FlowPanel panel) {
		
//		LayoutPanel layoutPanel = new LayoutPanel();
//		initWidget(layoutPanel);
		
		canvas = Canvas.createIfSupported();
		canvas.setStyleName("h1");
		panel.add(canvas);
		canvas.setSize("500px", "500px");
//		RootLayoutPanel rootLayoutPanel_1 = RootLayoutPanel.get();
		
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
	}
	
	//update UI
	public void updateGame() {
		model.update();
	}
	
	public void drawCanvas(Canvas canvas) {
		canvas.getContext2d().setFillStyle("#ff0000");
		canvas.getContext2d().fillRect(20, 20, 80, 40);
	}

}
