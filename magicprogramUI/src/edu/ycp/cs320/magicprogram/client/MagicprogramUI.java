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
		view = new LoginView();
		RootPanel.get().add(view);
	}
	
	public static void changeView(Composite newView) {
		RootPanel.get().remove(view);
		RootPanel.get().add(newView);
		view = newView;
	}
}