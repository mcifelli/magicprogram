package edu.ycp.cs320.magicprogram.client;

import com.google.gwt.user.client.ui.Composite;

import edu.ycp.cs320.magicprogram.shared.Game;
import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.AbsolutePanel;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.event.dom.client.ClickEvent;

public class GameController extends Composite{
	// FIELDS
	private Game model;
	private GameView view;
	private AbsolutePanel mainPanel;
	
	// CONSTRUCTOR
	public GameController(Game game, GameView gameView) {
		mainPanel = new AbsolutePanel();
		initWidget(mainPanel);
		mainPanel.setSize("500px", "50px");
		
		// BUTTON - SEND WAVE
		Button buttonSendWave = new Button("Send Wave");
		buttonSendWave.addClickHandler(new ClickHandler() {
			public void onClick(ClickEvent event) {
				// TODO add code here
			}
		});
		mainPanel.add(buttonSendWave, 10, 10);
		buttonSendWave.setSize("100px", "30px");
		
		// BUTTON - BUILD TOWER
		Button buttonBuildTower = new Button("Build Tower");
		buttonBuildTower.addClickHandler(new ClickHandler() {
			public void onClick(ClickEvent event) {
				if (!view.getBuildMode()) {
					view.setBuildMode(true);					
				}
			}
		});
		mainPanel.add(buttonBuildTower, 116, 10);
		buttonBuildTower.setSize("100px", "30px");
		// MODEL and VIEW
		model = game;
		view = gameView;
	}
}