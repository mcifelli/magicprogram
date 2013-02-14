package edu.ycp.cs320.magicprogram;

import java.util.ArrayList;

public class game {
	
	/**
	 * Width of the gameplay field.
	 */
	public static final double WIDTH = 900;
	//default: 640 x 480 (w x h)
	/**
	 * Height of the gameplay field.
	 */
	public static final double HEIGHT = 660;
	
	//fields
	Rectangle goal;
	ArrayList<Rectangle> creep;
	
	/**
	 * Constructor: initialize the game state. 
	 */
	public game() {
		goal = new Rectangle(new Point(430, 300), 50, 50);
		creep = new ArrayList<Rectangle>();
	}
	
	/**
	 * This method is called approximately 60 times per second.
	 */
	public void timerTick() {
		
	}
}
