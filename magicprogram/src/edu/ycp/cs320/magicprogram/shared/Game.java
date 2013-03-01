package edu.ycp.cs320.magicprogram.shared;

import java.util.ArrayList;

public class Game {
	
	public enum Events {
		
	}
	
	public static final double WIDTH = 900;
	//default: 640 x 480 (w x h)
	public static final double HEIGHT = 660;
	
	//fields
	private Rectangle goal;
	private Board board;
	private int life;

	public Game() {
		goal = new Rectangle(new Point(430, 300), 50, 50);
		board = new Board();
		life = 20;
	}
	
	public void update() {
		if (life > 0) {
			for (Creep creep : board.getCreeps()){
				
				creep.move(board.getGoal().getCenter());
				
				if(creep.getBody().overlaps(goal)){
					board.getCreeps().remove(creep);
					life=life-1;
				}
			}
		}
		//tower shooting function
		//if statement for any creep in range of tower
			//creep damage calculate function call
			//creep die
	
	
	}
	
	
	
	public Board getBoard(){
		return board;
	}
}
