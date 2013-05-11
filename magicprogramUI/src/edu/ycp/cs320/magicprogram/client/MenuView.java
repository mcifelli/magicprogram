package edu.ycp.cs320.magicprogram.client;

import java.util.ArrayList;
import java.util.List;

import com.google.gwt.user.client.rpc.AsyncCallback;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.AbsolutePanel;
import com.google.gwt.user.client.ui.Button;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import edu.ycp.cs320.magicprogram.shared.Game;
import edu.ycp.cs320.magicprogram.shared.Level;
import edu.ycp.cs320.magicprogram.shared.Terrain;

import com.google.gwt.user.client.ui.ListBox;
import com.google.gwt.user.client.ui.Label;
import com.google.gwt.canvas.client.Canvas;
import com.google.gwt.canvas.dom.client.Context2d;

public class MenuView extends Composite{
	private ArrayList<Level> levelList = new ArrayList<Level>();
	ListBox levelListBox = new ListBox();
	Label lblStatus = new Label("STATUS");
	Canvas preview;
	Level level;

	public MenuView() {
		AbsolutePanel absolutePanel = new AbsolutePanel();
		initWidget(absolutePanel);
		absolutePanel.setSize("569px", "437px");
		levelListBox.addClickHandler(new ClickHandler() {
			public void onClick(ClickEvent event) {
				if (levelListBox.getSelectedIndex() >= 0 && levelList.size() > 0 && levelList.get(levelListBox.getSelectedIndex()) != null) {
					level = levelList.get(levelListBox.getSelectedIndex());
					updatePreview();
				}
			}
		});

		absolutePanel.add(levelListBox, 10, 46);
		levelListBox.setSize("143px", "328px");
		levelListBox.setVisibleItemCount(5);

		absolutePanel.add(lblStatus, 10, 419);
		lblStatus.setSize("167px", "18px");

		Canvas preview = Canvas.createIfSupported();
		absolutePanel.add(preview, 159, 10);
		preview.setSize("400px", "400px");

		Button btnRefreshList = new Button("Refresh List");
		btnRefreshList.addClickHandler(new ClickHandler() {
			public void onClick(ClickEvent event) {
				refreshLevelListBox();
			}
		});
		absolutePanel.add(btnRefreshList, 10, 10);
		btnRefreshList.setSize("143px", "30px");

		Button btnLoadGame = new Button("Load Game");
		btnLoadGame.addClickHandler(new ClickHandler() {
			public void onClick(ClickEvent event) {
				loadGame();
			}
		});
		absolutePanel.add(btnLoadGame, 10, 380);
		btnLoadGame.setSize("143px", "30px");
		
		levelList.add(new Level("Sample level"));
		
		refreshLevelListBox();
	}

	private void refreshLevelListBox() {
//		RPC.levelManagementService.getLevelList(new AsyncCallback<List<Level>>() {
//			@Override
//			public void onFailure(Throwable caught) {
//				levelList = null;
//			}
//
//			@Override
//			public void onSuccess(List<Level> result) {
//				levelList = (ArrayList<Level>) result;
//			}
//		});



		levelListBox.clear();
		if (levelList != null) {
			for (Level level : levelList) {
				levelListBox.addItem(level.getName());
			}
		}
	}

	private void updatePreview() {
		Context2d context = preview.getContext2d();
		int height = preview.getCoordinateSpaceHeight();
		int width = preview.getCoordinateSpaceWidth();
		context.clearRect(0, 0, width, height);
		System.out.println("got here");
		if (level != null) {
			System.out.println(levelListBox.getSelectedIndex());
			System.out.println(levelList.size());
			Terrain map[][] = level.getMap();
			if (map != null) {
				int numRows = map.length;
				int numCols = map[0].length;
				for (int row = 0; row < numRows; row++) {
					for (int col = 0; col < numCols; col++) {
						switch(map[row][col]) {
						case grass:
							context.setFillStyle("#228B22");
							break;
						case road:
							context.setFillStyle("#C0C0C0");
							break;
						case water:
							context.setFillStyle("#0000FF");
							break;
						default:
							context.setFillStyle("#FFFFFF");
							break;
						}
						if (map[row][col] != null) {
							context.fillRect(col * width/numCols, row * height/numRows, width/numCols, height/numRows);
						}
					}
				}
			}
		}
	}

	private void loadGame() {
		if (levelListBox.getSelectedIndex() >= 0 && levelList.size() > 0 && levelList.get(levelListBox.getSelectedIndex()) != null) {
			lblStatus.setText("loading game");
			MagicprogramUI.changeView(new GameView(new Game(level)));
		}
	}
}
