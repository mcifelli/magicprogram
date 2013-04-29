package edu.ycp.cs320.magicprogram.client;

import com.google.gwt.core.client.EntryPoint;
import com.google.gwt.user.client.ui.FlowPanel;
import com.google.gwt.user.client.ui.AbsolutePanel;
import com.google.gwt.user.client.ui.RootPanel;

import edu.ycp.cs320.magicprogram.shared.*;

/**
 * Entry point classes define <code>onModuleLoad()</code>.
 */
public class MagicprogramUI implements EntryPoint {
	public static final double WIDTH = 1000;
	private static final double HEIGHT = 1000;
	
	private Game game;
	private GameView view;
	private RootPanel rootPanel;
	private AbsolutePanel mainPanel;
	private GameController controller;
	/**
	 * @wbp.nonvisual location=118,99
	 */
	
	public void onModuleLoad() {
		// init game and view
		game = new Game();
		view = new GameView(game);
		
		// get root panel to add elements to
	    rootPanel = RootPanel.get();
	    
	    // init the main panel as an absolute panel and add to root
	    mainPanel = new AbsolutePanel();
	    mainPanel.setSize(WIDTH + "px", HEIGHT + "px");
	    rootPanel.add(mainPanel, 0, 0);

	    // add gameview to main panel
	    mainPanel.add(view, 0, 0);
	    view.setSize(WIDTH + "px", HEIGHT + "px");

	    controller = new GameController(game, view);
	    mainPanel.add(controller, 0, 500);
	    controller.setSize(WIDTH + "px", "50px");
	    
	}

}
