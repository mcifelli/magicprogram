package edu.ycp.cs320.magicprogram.shared;

import java.util.ArrayList;

public class Board {
	private ArrayList<Creep> creeps;
	private ArrayList<Tower> towers;
	private Rectangle goal;
	
	public Board() {
		setCreeps(new ArrayList<Creep>());
		setTowers(new ArrayList<Tower>());
	}

	public ArrayList<Creep> getCreeps() {
		return creeps;
	}

	public void setCreeps(ArrayList<Creep> creeps) {
		this.creeps = creeps;
	}

	public ArrayList<Tower> getTowers() {
		return towers;
	}

	public void setTowers(ArrayList<Tower> towers) {
		this.towers = towers;
	}


	public Rectangle getGoal() {
		return goal;
	}

	public void setGoal(Rectangle goal) {
		this.goal = goal;
	}
}
