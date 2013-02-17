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
	public int life;

	/**
	 * Constructor: initialize the game state. 
	 */
	public game() {
		goal = new Rectangle(new Point(430, 300), 50, 50);
		creep = new ArrayList<Rectangle>();
		life=20;
	}
	
	/**
	 * This method is called approximately 60 times per second.
	 */
	public void timerTick() {

		if(life>0){
			for(int i = 0; i < creep.size(); i++) {
				if(creep.get(i).topLeft.x < goal.topLeft.x + goal.getWidth()/2) {
					creep.get(i).topLeft.x++;
				} else {
					creep.get(i).topLeft.x--;
				}
				
				if(creep.get(i).topLeft.y < goal.topLeft.y + goal.getHeight()/2) {
					creep.get(i).topLeft.y++;
				} else {
					creep.get(i).topLeft.y--;
				}
				if(creep.get(i).overlaps(goal)){
					creep.remove(i);
					life=life-1;
				}
			}
		}
	}
}
