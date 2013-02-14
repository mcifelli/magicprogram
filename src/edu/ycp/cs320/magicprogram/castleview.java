package edu.ycp.cs320.magicprogram;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.io.IOException;
import javax.swing.JPanel;
import javax.swing.Timer;

public class castleview extends JPanel {
	
	private static final long serialVersionUID = 1L;

	private static final Color BACKGROUND_COLOR = new Color(0, 127, 0);
	
	private game game;
	private int x, y;
	private Point mouse;
	
	public castleview(game game) {
		this.game = game;
		setBackground(BACKGROUND_COLOR);
		setPreferredSize(new Dimension(640, 480));
		mouse = new Point(0, 0);
	}
	
	public void startGame() {
		// Create the animation timer.
		// It will fire an event about 60 times per second.
		// Every time a timer event fires the handleTimerEvent method
		// will be called.
		Timer timer = new Timer(1000 / 60, new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				try {
					handleTimerEvent();
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
		timer.start();
	}
	
	protected void handleTimerEvent() throws IOException {
		// You should not need to change this method.
		game.timerTick();
		repaint();
	}
	
	protected void handleMouseMove(MouseEvent e) {
		// TODO: handle mouse movement
			x = e.getX();
			y = e.getY();
			mouse.x = x;
			mouse.y = y;
			repaint();
	}
	
	@Override
	protected void paintComponent(Graphics g) {
		g.setColor(BACKGROUND_COLOR);
		g.fillRect(0, 0, 640, 480);
	}
	
}
