package edu.ycp.cs320.magicprogram.client;

import com.google.gwt.canvas.client.Canvas;
import com.google.gwt.user.client.ui.*;

import edu.ycp.cs320.magicprogram.shared.*;

import com.google.gwt.dom.client.Style.Unit;

public class GameView extends Composite implements ISubscriber {
	
	private Game model;
	
//	private Canvas canvas;
//	private Canvas canvas_1;
	
	public GameView() {
		
		LayoutPanel layoutPanel = new LayoutPanel();
		initWidget(layoutPanel);
		
		
		
		
	}
	
	public void setModel(Game game) {
		this.model = game;
	}
	
	//update UI
	public void updateGame() {
		
	}

	@Override
	public void eventOccurred(Object key, IPublisher publisher, Object hint) {
		// TODO Auto-generated method stub
		
	}
}
