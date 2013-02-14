package edu.ycp.cs320.magicprogram;

import javax.swing.JFrame;
import javax.swing.SwingUtilities;

public class dyc {
	public static void main(String[] args) {
		SwingUtilities.invokeLater(new Runnable() {
			@Override
			public void run() {
				// Create the Game object that represents the game state
				game mygame = null;
				mygame = new game();
				
				// Create the sbview that will visualize the game state
				castleview view = new castleview(mygame);

				// Create a frame (top-level window) to enclose the sbview
				JFrame frame = new JFrame();
				frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
				frame.setTitle("Defend Your Castle!");
				frame.setContentPane(view);
				frame.pack();
				
				// Start the game!
				view.startGame();
				
				// Make the frame visible
				frame.setVisible(true);
			}
		});
	}
}
