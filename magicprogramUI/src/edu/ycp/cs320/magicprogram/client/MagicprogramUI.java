package edu.ycp.cs320.magicprogram.client;

import com.google.gwt.core.client.EntryPoint;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.RootPanel;

import edu.ycp.cs320.magicprogram.shared.*;

/**
 * Entry point classes define <code>onModuleLoad()</code>.
 */
public class MagicprogramUI implements EntryPoint {
	private static Composite view;
	public void onModuleLoad() {
		// get root panel to add elements to
	    
	    // init game and view
//		game = new Game(new Level());
//		view = new GameView(game);
//		view = new GameController(new Game(new Level("Sample")));
		view = new LoginView();
		RootPanel.get().add(view);
//	    
//	    controller = new GameController(game, view);
//	    
////	    // add login to main panel
//	    mainPanel.add(view, 0, 0);
////	    mainPanel.add(new LoginView());
//	    view.setSize(WIDTH + "px", HEIGHT + "px");
//	    mainPanel.add(controller, 0, 500);
//	    controller.setSize(WIDTH + "px", "50px");
	}
	
	public static void changeView(Composite newView) {
		RootPanel.get().remove(view);
		RootPanel.get().add(newView);
		view = newView;
	}
}
