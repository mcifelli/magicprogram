package edu.ycp.cs320.magicprogram.client;

import com.google.gwt.canvas.client.Canvas;
import com.google.gwt.core.client.EntryPoint;
import com.google.gwt.dom.client.Style.Unit;
import com.google.gwt.user.client.ui.LayoutPanel;
import com.google.gwt.user.client.ui.RootLayoutPanel;
import com.google.gwt.user.client.ui.TextBox;
import com.google.gwt.user.client.ui.Button;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.event.dom.client.ClickEvent;

import edu.ycp.cs320.magicprogram.shared.*;
//import com.google.gwt.user.client.ui.TreeImages;
import com.google.gwt.core.client.GWT;

/**
 * Entry point classes define <code>onModuleLoad()</code>.
 */
public class MagicprogramUI implements EntryPoint {
	/**
	 * This is the entry point method.
	 */
	
	Game game;
	/**
	 * @wbp.nonvisual location=118,99
	 */
	
	public MagicprogramUI() {
		
	}
	
	public void onModuleLoad() {
		// create a panel
		LayoutPanel panel = new LayoutPanel();
		
		game = new Game();
		game.getPath().add(new Point());
		game.getPath().add(new Point());
		game.getPath().add(new Point());
		
		GameView gameView = new GameView();
		gameView.setModel(game);
		
		
		
		
		// add your view(s) to the panel
		//panel.add(yourView);
		
		RootLayoutPanel rootLayoutPanel = RootLayoutPanel.get();
		rootLayoutPanel.add(panel);
		RootLayoutPanel.get().setWidgetLeftRight(panel, 10.0, Unit.PX, 10.0, Unit.PX);
		RootLayoutPanel.get().setWidgetTopBottom(panel, 10.0, Unit.PX, 10.0, Unit.PX);
		
		Button creepButton = new Button("add creep");
		creepButton.addClickHandler(new ClickHandler() {
			public void onClick(ClickEvent event) {
				game.addCreep();
			}
		});
		panel.add(creepButton);
		panel.setWidgetLeftWidth(creepButton, 325.0, Unit.PX, 81.0, Unit.PX);
		panel.setWidgetTopHeight(creepButton, 52.0, Unit.PX, 30.0, Unit.PX);
		
		Canvas gameViewer = Canvas.createIfSupported();
		panel.setWidgetLeftWidth(gameViewer, 325.0, Unit.PX, 81.0, Unit.PX);
		panel.setWidgetTopHeight(gameViewer, 52.0, Unit.PX, 30.0, Unit.PX);
		panel.add(gameViewer);
	}
}
