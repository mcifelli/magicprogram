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
	private ArrayList<Tower> towers;
	private String [][] grid = new String[10][10];
	private ArrayList<Point> waypoints;

	
	
	public Game() {
		life = 20;
		setCreeps(new ArrayList<Creep>());
		setTowers(new ArrayList<Tower>());
		setPath(new ArrayList<Point>());
		waypoints.add(new Point(50.0,0.0));
		waypoints.add(new Point(50.0,50.0));
		addCreep();
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
		//tower shooting function
		//if statement for any creep in range of tower
			//creep damage calculate function call
			//creep die
	
	
	}
	
	
	
	// Getters/Setters
	/**
	 * Gets a list of creeps
	 * @return The creeps on the board
	 */
	public ArrayList<Creep> getCreeps() {
		return creeps;
	}
	
	/**
	 * Replaces the list of creeps
	 * @param creeps A new list of creeps
	 */
	public void setCreeps(ArrayList<Creep> creeps) {
		this.creeps = creeps;
	}
	
	/**
	 * Get a list towers
	 * @return The towers on the board
	 */
	public ArrayList<Tower> getTowers() {
		return towers;
	}
	
	/**
	 * Replaces the list of towers
	 * @param creeps A new list of towers
	 */
	public void setTowers(ArrayList<Tower> towers) {
		this.towers = towers;
	}
	
	/**
	 * Get a list ordered waypoints
	 * @return A list of ordered waypoints
	 */
	public ArrayList<Point> getPath() {
		return waypoints;
	}
	
	/**
	 * Replaces the ordered list of waypoints
	 * @param path A new ordered list of waypoints
	 */
	public void setPath(ArrayList<Point> waypoints) {
		this.waypoints = waypoints;
	}
	
	/**
	 * Get the goal
	 * @return The goal
	 */
	public Rectangle getGoal() {
		return goal;
	}
	
	/**
	 * Replace the goal
	 * @param goal A new goal
	 */
	public void setGoal(Rectangle goal) {
		this.goal = goal;
	}
}
