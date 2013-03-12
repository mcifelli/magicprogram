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

	/**
	 * @wbp.nonvisual location=118,99
	 */
	
	public void onModuleLoad() {
		// create a panel
		FlowPanel fpanel = new FlowPanel();
		
		
		Game game = new Game();
		
		GameView view = new GameView(fpanel);
		view.setModel(game);
		
		// add your view(s) to the panel
		//panel.add(yourView);
		
		RootLayoutPanel rootLayoutPanel = RootLayoutPanel.get();
		rootLayoutPanel.add(fpanel);
		RootLayoutPanel.get().setWidgetLeftRight(fpanel, 100.0, Unit.PX, 100.0, Unit.PX);
		RootLayoutPanel.get().setWidgetTopBottom(fpanel, 100.0, Unit.PX, 100.0, Unit.PX);
		
		view.start();
		
	}

}
