package edu.ycp.cs320.magicprogram.shared;

import java.util.ArrayList;
import java.util.Stack;

public class Game {
	
	public enum Events {
		
	}
	
	//fields
	private Rectangle goal;
	private int life;
	private ArrayList<Creep> creeps;
	private Tower[][] towers = new Tower[32][32];
	private ArrayList<Point> waypoints;
	
	
	public Game() {
		waypoints = new ArrayList<Point>();
		waypoints.add(new Point(50.0,0.0));
		waypoints.add(new Point(50.0,50.0));
		
		setCreeps(new ArrayList<Creep>());
		
		setPath(new ArrayList<Point>());
		
		life = 20;
	}
	
	
	
	// Methods
	/**
	 * Adds a default creep to the board. The creep is given a path to follow
	 */
	public void addCreep() {
		creeps.add(new Creep(new Point(0.0, 0.0), waypoints));
	}
	
	public void update() {
		if (life > 0) {
			for (Creep creep : creeps){
				System.out.println("moving creep");
				creep.move();
			}
		}
	}
	
	
	
	// Getters/Setters
	public ArrayList<Creep> getCreeps() {
		return creeps;
	}
	public void setCreeps(ArrayList<Creep> creeps) {
		this.creeps = creeps;
	}
	public Tower[][] getTowers() {
		return towers;
	}
	public void setTowers(Tower[][] towers) {
		this.towers = towers;
	}
	public ArrayList<Point> getPath() {
		return waypoints;
	}
	public void setPath(ArrayList<Point> waypoints) {
		this.waypoints = waypoints;
	}
	public Rectangle getGoal() {
		return goal;
	}
	public void setGoal(Rectangle goal) {
		this.goal = goal;
	}
	public ArrayList<Point> getWaypoints() {
		return waypoints;
	}
}
