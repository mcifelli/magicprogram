package edu.ycp.cs320.magicprogram.client;

import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.LayoutPanel;
import com.google.gwt.user.client.ui.InlineLabel;
import com.google.gwt.dom.client.Style.Unit;
import com.google.gwt.user.client.ui.ListBox;

import edu.ycp.cs320.magicprogram.shared.*;
import com.google.gwt.user.client.ui.Grid;
import com.google.gwt.user.client.ui.Button;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.event.dom.client.ClickEvent;

public class TDView extends Composite {
	private Game model;
	private LayoutPanel layoutPanel;
	private Grid grid;
	private Button btnAddCreep;
	
	public TDView() {
		
		layoutPanel = new LayoutPanel();
		layoutPanel.setPixelSize(500, 500);
		initWidget(layoutPanel);
		
		grid = new Grid(1, 1);
		grid.resize(20, 20);
		grid.setPixelSize(400, 400);
		layoutPanel.add(grid);
		layoutPanel.setWidgetLeftWidth(grid, 0.0, Unit.PX, 200.0, Unit.PX);
		layoutPanel.setWidgetTopHeight(grid, 0.0, Unit.PX, 222.0, Unit.PX);
		
		btnAddCreep = new Button("add creep");
//		btnAddCreep.addClickHandler(new ClickHandler() {
//			public void onClick(ClickEvent event) {
//				model.getBoard().addCreep(new Creep(new Rectangle(new Point(0, 0), 10, 10), 10, 5));
//			}
//		});
		layoutPanel.add(btnAddCreep);
		layoutPanel.setWidgetLeftWidth(btnAddCreep, 35.0, Unit.PX, 81.0, Unit.PX);
		layoutPanel.setWidgetTopHeight(btnAddCreep, 448.0, Unit.PX, 30.0, Unit.PX);
		
	}
	
	public void setModel(Game model) {
		this.model = model;
	}
	
	public void update() {
		btnAddCreep.addClickHandler(new ClickHandler() {
			public void onClick(ClickEvent event) {
				model.getBoard().addCreep(new Creep(new Rectangle(new Point(0, 0), 10, 10), 10, 5));
			}
		});
	}
}
