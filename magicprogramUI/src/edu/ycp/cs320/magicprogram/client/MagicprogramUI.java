package edu.ycp.cs320.magicprogram.client;

import com.google.gwt.core.client.EntryPoint;
import com.google.gwt.dom.client.Style.Unit;
import com.google.gwt.user.client.ui.FlowPanel;
import com.google.gwt.user.client.ui.RootLayoutPanel;

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
	/**
	 * @wbp.nonvisual location=118,99
	 */
	
	public void onModuleLoad() {

		// create a panel
		game = new Game();

		FlowPanel fpanel = new FlowPanel();
		
		GameView view = new GameView(fpanel);
		view.setModel(game);
		
		RootLayoutPanel rootLayoutPanel = RootLayoutPanel.get();
		rootLayoutPanel.setSize(WIDTH + "px", HEIGHT + "px");
		rootLayoutPanel.add(fpanel);
		rootLayoutPanel.setWidgetLeftWidth(fpanel, 0.0, Unit.PX, WIDTH, Unit.PX);
		rootLayoutPanel.setWidgetTopHeight(fpanel, 0.0, Unit.PX, HEIGHT, Unit.PX);
		
		view.start();

	}

}
