package edu.ycp.cs320.magicprogram.client;

import com.google.gwt.canvas.client.Canvas;
import com.google.gwt.user.client.ui.Composite;

import edu.ycp.cs320.magicprogram.shared.Game;
import com.google.gwt.user.client.ui.FlowPanel;
import com.google.gwt.user.client.ui.DockPanel;
import com.google.gwt.user.client.ui.Button;

public class TowerView extends Composite{
	private Game model;
	
	public TowerView() {
		FlowPanel flowPanel = new FlowPanel();
		initWidget(flowPanel);
		
		DockPanel dockPanel = new DockPanel();
		flowPanel.add(dockPanel);
		dockPanel.setHeight("300px");
		
		Button btnSendCreep = new Button("Send Creep");
		dockPanel.add(btnSendCreep, DockPanel.NORTH);
		
		Canvas canvas = Canvas.createIfSupported();
		
	}
	
	public void setModel(Game model) {
		this.model = model;
	}
	
	public void update() {
		// TODO: add code
	}
}
