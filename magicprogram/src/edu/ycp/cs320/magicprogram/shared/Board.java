package edu.ycp.cs320.magicprogram.shared;

import java.util.ArrayList;

public class Board {
	//Fields
	private ArrayList<Creep> creeps;
	private ArrayList<Tower> towers;
	private String [][] grid= new String[10][10];
	private ArrayList<Point> waypoints;

	private Rectangle goal;
	
	// Constructors 
	public Board() {
		setCreeps(new ArrayList<Creep>());
		setTowers(new ArrayList<Tower>());

		setPath(new ArrayList<Point>());
	}
	
	// Methods
	/**
	 * Removes the selected tower
	 * @param tower The tower to be removed
	 */
	public void addTower(Tower tower) {
		towers.add(tower);
	}
	/**
	 * Adds the selected tower
	 * @param tower The tower to be removed
	 */
	public void removeTower(Tower tower) {
		towers.remove(tower);
	}
	public void addCreep(Creep creep) {
		creeps.add(creep);
	}
	public void removeCreep(Creep creep) {
		creeps.remove(creep);
	}
	public void addWaypoint(Point waypoint) {
		waypoints.add(waypoint);
	}
	public void removeWaypoint(Point waypoint) {
		waypoints.remove(waypoint);
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
