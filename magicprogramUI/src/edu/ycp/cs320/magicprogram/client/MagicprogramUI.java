package edu.ycp.cs320.magicprogram.client;

import com.google.gwt.core.client.EntryPoint;
import com.google.gwt.dom.client.Style.Unit;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.user.client.Timer;
import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.FlowPanel;
import com.google.gwt.user.client.ui.RootLayoutPanel;
import com.google.gwt.user.client.ui.RootPanel;

import edu.ycp.cs320.magicprogram.shared.*;


/**
 * Entry point classes define <code>onModuleLoad()</code>.
 */
public class MagicprogramUI implements EntryPoint {
	/**
	 * This is the entry point method.
	 */
	public static final double WIDTH = 1000;
	private static final double HEIGHT = 1000;
	
	private Game game;
	private GameView gameView;
	private RootPanel rootPanel;
	private FlowPanel flowPanel;
//	private Button btnAddCreepTo;
	/**
	 * @wbp.nonvisual location=118,99
	 */
	
	public void onModuleLoad() {

		// create a panel
		game = new Game();
//<<<<<<< HEAD

		FlowPanel fpanel = new FlowPanel();
//=======
		gameView = new GameView(game);
		gameView.setModel(game);
	    rootPanel = RootPanel.get();
	    
	    flowPanel = new FlowPanel();
	    rootPanel.add(flowPanel, 0, 0);
	    
	    flowPanel.add(gameView);
	    
//	    btnAddCreepTo = new Button("Send Creep");
//	    btnAddCreepTo.addClickHandler(new ClickHandler() {
//	    	public void onClick(ClickEvent event) {
//	    		game.getCreeps().add(new Creep(new Point(), game.getWaypoints()));
//	    	}
//	    });
//	    flowPanel.add(btnAddCreepTo);
	    
//>>>>>>> refs/remotes/mcifelli/master

	    gameView.start();
		
//		GameView view = new GameView(fpanel);
//		view.setModel(game);
//		
//		RootLayoutPanel rootLayoutPanel = RootLayoutPanel.get();
//		rootLayoutPanel.setSize(WIDTH + "px", HEIGHT + "px");
//		rootLayoutPanel.add(fpanel);
//		rootLayoutPanel.setWidgetLeftWidth(fpanel, 0.0, Unit.PX, WIDTH, Unit.PX);
//		rootLayoutPanel.setWidgetTopHeight(fpanel, 0.0, Unit.PX, HEIGHT, Unit.PX);
//		
//		view.start();

	}

}
