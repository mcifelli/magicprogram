package edu.ycp.cs320.magicprogram.client;

import com.google.gwt.core.client.EntryPoint;
import com.google.gwt.dom.client.Style.Unit;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.user.client.Timer;
import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.FlowPanel;
import com.google.gwt.user.client.ui.AbsolutePanel;
import com.google.gwt.user.client.ui.RootLayoutPanel;
import com.google.gwt.user.client.ui.RootPanel;

import edu.ycp.cs320.magicprogram.server.FakeDatabase;
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
	private FlowPanel flowPanel;
	private GameController controller;
//	private Button btnAddCreepTo;
	/**
	 * @wbp.nonvisual location=118,99
	 */
	
	public void onModuleLoad() {
		
		// create a panel
		game = new Game();
		game.addWaypoints();
		
		FlowPanel fpanel = new FlowPanel();

		view = new GameView(game);
		view.setModel(game);

		game = new Game(WIDTH, HEIGHT);

		game = new Game();
		
	    rootPanel = RootPanel.get();
	    
	    AbsolutePanel mainPanel = new AbsolutePanel();
	    rootPanel.add(mainPanel, 0, 0);
	    mainPanel.setSize("500px", "600px");
	    
	    flowPanel.add(view);

	    view.start();
	    view = new GameView(game);
	    mainPanel.add(view, 0, 0);
	    view.setSize(WIDTH + "px", HEIGHT + "px");
	    
//	    FakeDatabase db = new FakeDatabase();
//	    db.getLevel(1);

	    controller = new GameController(game, view);
	    mainPanel.add(controller, 0, 500);
	    controller.setSize(WIDTH + "px", "50px");
	}

}
