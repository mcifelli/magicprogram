package edu.ycp.cs320.magicprogram.shared;

import java.util.ArrayList;

public class Board {
	private ArrayList<Creep> creeps;
	private ArrayList<Tower> towers;
	private Path path;
	private Rectangle goal;
	
	public Board() {
		setCreeps(new ArrayList<Creep>());
		setTowers(new ArrayList<Tower>());
		setPath(new Path());
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

	public Path getPath() {
		return path;
	}

	public void setPath(Path path) {
		this.path = path;
	}

	public Rectangle getGoal() {
		return goal;
	}

	public void setGoal(Rectangle goal) {
		this.goal = goal;
	}
	
	public void addCreep(Creep toAdd) {
		creeps.add(toAdd);
	}
}
