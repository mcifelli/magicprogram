package edu.ycp.cs320.magicprogram.client;

import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.AbsolutePanel;
import com.google.gwt.user.client.ui.Grid;

public class AdminView extends Composite{
	Grid grid;
	
	public AdminView() {
		AbsolutePanel absolutePanel = new AbsolutePanel();
		initWidget(absolutePanel);
		absolutePanel.setSize("686px", "614px");
		
		grid = new Grid(1, 4);
		absolutePanel.add(grid, 0, 0);
		grid.setSize("400px", "250px");
	}
	
	private void update() {
		int row = 0;
		while (true) {
			grid.setText(row, 0, id);
			grid.setText(row, 0, username);
			grid.setText(row, 0, password);
			grid.setText(row, 0, score);
		}
	}
}
