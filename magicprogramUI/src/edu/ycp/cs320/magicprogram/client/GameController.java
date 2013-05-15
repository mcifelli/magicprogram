package edu.ycp.cs320.magicprogram.client;

import com.google.gwt.user.client.Timer;
import com.google.gwt.user.client.ui.Composite;

import edu.ycp.cs320.magicprogram.shared.Game;
import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.AbsolutePanel;
import com.google.gwt.canvas.dom.client.Context2d;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.user.client.ui.Label;

public class GameController extends Composite{
	// FIELDS
	private Game model;
	private GameView view;
	private AbsolutePanel controlPanel;
	private Label lblWavesRemaining;
	private Label lblMoney;
	private Label lblKills;
	
	// CONSTRUCTOR
	public GameController(Game game, int userID) {
		// MODEL and VIEW
		this.model = game;
		this.view = new GameView(game);
		
		controlPanel = new AbsolutePanel();
		controlPanel.setSize("850px", "750px");
		
		controlPanel.add(view);
		
		// BUTTON - SEND WAVE
		Button buttonSendWave = new Button("Send Wave");
		buttonSendWave.addClickHandler(new ClickHandler() {
			public void onClick(ClickEvent event) {
				model.sendWave();
			}
		});
		controlPanel.add(buttonSendWave, 10, 510);
		buttonSendWave.setSize("100px", "30px");
		
		// BUTTON - BUILD TOWER
		Button buttonBuildTower = new Button("Build Tower");
		buttonBuildTower.addClickHandler(new ClickHandler() {
			public void onClick(ClickEvent event) {
				view.toggleBuildMode();
			}
		});
		controlPanel.add(buttonBuildTower, 116, 510);
		buttonBuildTower.setSize("100px", "30px");
		
		// BUTTON - SHOW RANGE
		Button buttonShowRange = new Button("Show Range");
		buttonShowRange.addClickHandler(new ClickHandler() {
			public void onClick(ClickEvent event) {
				view.toggleShowRange();
			}
		});
		controlPanel.add(buttonShowRange, 222, 510);
		buttonBuildTower.setSize("100px", "30px");
		
		Label lblWavesRemaining = new Label("Waves remaining:" + Integer.toString(model.wavesRemaining()));
		controlPanel.add(lblWavesRemaining, 10, 552);
		
		Label lblMoney = new Label("Money: $" + Integer.toString(model.getMoney()));
	    controlPanel.add(lblMoney, 10, 576);
	    
	    Label lblKills = new Label("Kills: " + Integer.toString(model.getKillCount()));
	    controlPanel.add(lblKills, 10, 600);
		
		// TIMER
	    Timer timer = new Timer() {
	      @Override
	      public void run() {
	    	  model.update();
	    	  view.updateForeground();
	    	  update();
	      }
	    };
	    timer.scheduleRepeating(25);
	    
	    initWidget(controlPanel);
	}
	
	public void update() {
//		int money = model.getMoney();
//		lblMoney.setText("Money: $" + money);
////		lblKills.setText("Kills: " + Integer.toString(model.getKillCount()));
//		System.out.println(model.wavesRemaining());
//		System.out.println(model.getMoney());
//		System.out.println(model.getKillCount());
		if (model.getCreeps().size() < 1 && model.creepsInWave() < 1 && model.wavesRemaining() < 1) {
			
			
		}
	}
}
