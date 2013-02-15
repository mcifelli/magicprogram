package edu.ycp.cs320.magicprogram;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.IOException;
import javax.swing.JPanel;
import javax.swing.Timer;

public class castleview extends JPanel {
	
	private static final long serialVersionUID = 1L;

	private static final Color BACKGROUND_COLOR = new Color(0, 127, 0);
	Font font = new Font("Serif", Font.BOLD, 48);
	private game game;
	private int x, y;
	private Point mouse;
	
	public castleview(game game) {
		this.game = game;
		setBackground(BACKGROUND_COLOR);
		setPreferredSize(new Dimension((int)game.WIDTH, (int)game.HEIGHT));
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
		
		// Add a listener for mouse motion.
		// Each time the mouse is moved, the handleMouseMove method
		// will be called.
		addMouseListener(new MouseAdapter() {
			@Override
			public void mouseMoved(MouseEvent e) {
				handleMouseMove(e);
			}
			
			@Override
			public void mouseClicked(MouseEvent e) {
				handleMouseClick(e);
			}
		});
	}
	
	protected void handleTimerEvent() throws IOException {
		// You should not need to change this method.
		game.timerTick();
		repaint();
	}
	
	protected void handleMouseMove(MouseEvent e) {
		//if mouse is moved but not clicked
//		x = e.getX();
//		y = e.getY();
//		mouse.x = x;
//		mouse.y = y;
		repaint();
	}
	
	protected void handleMouseClick(MouseEvent e) {
		//if mouse is clicked, this happens
		x = e.getX();
		y = e.getY();
		game.creep.add(new Rectangle(new Point(x, y), 10, 10));
		System.out.printf("mouse click %f %f\nsize: %d\n", mouse.x, mouse.y, game.creep.size());
		repaint();
	}
	
	@Override
	protected void paintComponent(Graphics g) {
		//fill background
		g.setColor(BACKGROUND_COLOR);
		g.fillRect(0, 0, (int)game.WIDTH, (int)game.HEIGHT);
		
		g.setColor(Color.MAGENTA);
		g.fillRect((int)game.goal.topLeft.x, (int)game.goal.topLeft.y, (int)game.goal.width, (int)game.goal.height);
		
		for(int i = 0; i < game.creep.size(); i++) {
			g.setColor(Color.BLACK);
			g.fillRect((int)game.creep.get(i).topLeft.x, (int)game.creep.get(i).topLeft.y, 10, 10);
		}
		
		g.setColor(Color.WHITE);
		g.setFont(font);
		g.drawString("" + game.life, 600, 100);

		
		if(game.life==0){
			g.setColor(Color.WHITE);
			font = new Font("Serif", Font.BOLD, 55);
			g.setFont(font);
			g.drawString("GameOver", 180, 240);
		}
		
	}
	
}
