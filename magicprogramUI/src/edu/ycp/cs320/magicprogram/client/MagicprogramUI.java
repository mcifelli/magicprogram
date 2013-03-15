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
	
	Game game;
	/**
	 * @wbp.nonvisual location=118,99
	 */
	
	public void onModuleLoad() {
		// create a panel
		FlowPanel fpanel = new FlowPanel();
//		LayoutPanel panel = new LayoutPanel();
		
//		game = new Game();
//		game.getPath().add(new Point());
//		game.getPath().add(new Point());
//		game.getPath().add(new Point());
		
		GameView gameView = new GameView(fpanel);
		gameView.setModel(game);
		
		
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
		
//<<<<<<< HEAD
//=======
//		Button creepButton = new Button("add creep");
//		creepButton.addClickHandler(new ClickHandler() {
//			public void onClick(ClickEvent event) {
//				game.addCreep();
//			}
//		});
//		panel.add(creepButton);
//		panel.setWidgetLeftWidth(creepButton, 325.0, Unit.PX, 81.0, Unit.PX);
//		panel.setWidgetTopHeight(creepButton, 52.0, Unit.PX, 30.0, Unit.PX);
//		
//		Canvas gameViewer = Canvas.createIfSupported();
//		panel.setWidgetLeftWidth(gameViewer, 325.0, Unit.PX, 81.0, Unit.PX);
//		panel.setWidgetTopHeight(gameViewer, 52.0, Unit.PX, 30.0, Unit.PX);
//		panel.add(gameViewer);
//>>>>>>> mcifelli/master
	}

}
