package edu.ycp.cs320.magicprogram.client;

import com.google.gwt.core.client.EntryPoint;
import com.google.gwt.dom.client.Style.Unit;
import com.google.gwt.user.client.ui.FlowPanel;
import com.google.gwt.user.client.ui.RootLayoutPanel;

import edu.ycp.cs320.magicprogram.shared.*;

/**
 * Entry point classes define <code>onModuleLoad()</code>.
 */
public class TDApp implements EntryPoint {
	/**
	 * This is the entry point method.
	 */
	public void onModuleLoad() {
		FlowPanel panel = new FlowPanel();
		
		TDView tdView = new TDView();
		
		panel.add(tdView);
		Game model = new Game();
//		model.setSize(Game.LARGE);
		tdView.setModel(model);
		tdView.update();
		
		RootLayoutPanel.get().add(panel);
		RootLayoutPanel.get().setWidgetTopBottom(panel, 10.0, Unit.PX, 10.0, Unit.PX);
		RootLayoutPanel.get().setWidgetLeftRight(panel, 10.0, Unit.PX, 10.0, Unit.PX);
	}
}
