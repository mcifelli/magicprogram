package edu.ycp.cs320.magicprogram.client;

import com.google.gwt.core.client.EntryPoint;
import com.google.gwt.user.client.ui.AbsolutePanel;
import com.google.gwt.user.client.ui.RootLayoutPanel;
import com.google.gwt.user.client.ui.RootPanel;

import edu.ycp.cs320.magicprogram.shared.*;
//import com.google.gwt.user.client.ui.TreeImages;
import com.google.gwt.core.client.GWT;
import com.google.gwt.user.client.ui.FlowPanel;
import com.google.gwt.user.client.ui.Label;

/**
 * Entry point classes define <code>onModuleLoad()</code>.
 */
public class MagicprogramUI implements EntryPoint {
	// Statics
	private final int WIDTH = 500;
	private final int HEIGHT = 500;
	
	// Fields
	private Game game;
	private GameView view;
	private GameController controller;
	private RootPanel rootPanel;
	private AbsolutePanel mainPanel;
	
	/**
	 * This is the entry point method.
	 */
	public void onModuleLoad() {
		game = new Game();
		
	    rootPanel = RootPanel.get();
	    
	    mainPanel = new AbsolutePanel();
	    rootPanel.add(mainPanel, 0, 0);
	    mainPanel.setSize("500px", "600px");
	    
	    view = new GameView(game);
	    mainPanel.add(view, 0, 0);
	    view.setSize(WIDTH + "px", HEIGHT + "px");
	    
	    controller = new GameController(game, view);
	    mainPanel.add(controller, 0, 500);
	    controller.setSize(WIDTH + "px", "50px");
	}
}
