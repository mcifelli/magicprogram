package edu.ycp.cs320.magicprogram.client;

import com.google.gwt.core.client.EntryPoint;
import com.google.gwt.dom.client.Style.Unit;
import com.google.gwt.user.client.ui.LayoutPanel;
import com.google.gwt.user.client.ui.RootLayoutPanel;
import com.google.gwt.user.client.ui.TextBox;
import com.google.gwt.user.client.ui.Button;

/**
 * Entry point classes define <code>onModuleLoad()</code>.
 */
public class MagicprogramUI implements EntryPoint {
	/**
	 * This is the entry point method.
	 */
	public void onModuleLoad() {
		// create a panel
		LayoutPanel panel = new LayoutPanel();
		
		// add your view(s) to the panel
		//panel.add(yourView);
		
		RootLayoutPanel.get().add(panel);
		RootLayoutPanel.get().setWidgetLeftRight(panel, 10.0, Unit.PX, 10.0, Unit.PX);
		RootLayoutPanel.get().setWidgetTopBottom(panel, 10.0, Unit.PX, 10.0, Unit.PX);
		
		Button btnNewButton = new Button("New button");
		btnNewButton.setText("add creep");
		panel.add(btnNewButton);
		panel.setWidgetLeftWidth(btnNewButton, 325.0, Unit.PX, 81.0, Unit.PX);
		panel.setWidgetTopHeight(btnNewButton, 52.0, Unit.PX, 30.0, Unit.PX);
	}
}
