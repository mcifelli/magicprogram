package edu.ycp.cs320.magicprogram.shared;

import java.util.ArrayList;

public class Game {
	public static final double WIDTH = 900;
	//default: 640 x 480 (w x h)
	public static final double HEIGHT = 660;
	
	//fields
	private Rectangle goal;
	private Board board;
	private int life;
	public ArrayList<Rectangle> creep = new ArrayList<Rectangle>();

	public Game() {
		goal = new Rectangle(new Point(430, 300), 50, 50);
		board = new Board();
		life = 20;
	}
	
	public void update() {
		if (life > 0) {
			for (Creep creep : board.getCreeps()) {
				if (creep.getLocation().getX() < board.getGoal().getTopLeft().getX()) {
					creep.move(board.getGoal().getLocation());
				} else {
					creep.topLeft.x--;
				}
				
				if (creep.getCenter().getY() < goal.topLeft.y + goal.getHeight()/2) {
					creep.topLeft.y++;
				} else {
					creep.topLeft.y--;
				}
				if (creep.getBody().overlaps(goal)) {
					board.getCreeps().remove(creep);
					life=life-1;
				}
			}
		}
	}
}
