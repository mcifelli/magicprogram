package edu.ycp.cs320.magicprogram.shared;

import java.util.ArrayList;
import java.util.Stack;

public class Game {
	

	public static final double WIDTH = 900;
	//default: 640 x 480 (w x h)
	public static final double HEIGHT = 660;
	
	public static final double CSIZE = 10;
	
	//fields
	private Rectangle goal;
	private int life;
	private ArrayList<Creep> creeps;


	private Terrain [][] grid = new Terrain[32][32];

	private Tower[][] towers = new Tower[32][32];
	
	private ArrayList<Point> waypoints;
	
	public Game() {
		waypoints = new ArrayList<Point>();
//		waypoints.add(new Point(50.0,0.0));
//		waypoints.add(new Point(50.0,50.0));
//		waypoints.add(new Point(100, 0));
//		waypoints.add(new Point(100, 100));

		setCreeps(new ArrayList<Creep>());
		
		setPath(new ArrayList<Point>());
		
		life = 20;
		
		goal = new Rectangle();
		this.goal.setTopLeft(new Point(250, 250));
	}
	
	
	// Methods
	/**
	 * Adds a default creep to the board. The creep is given a path to follow
	 */
	public void addCreep() {
		creeps.add(new Creep(new Point(0.0, 0.0), waypoints));
	}
	
	public void addWaypoints() {
		waypoints.add(new Point(50.0,0.0));
		waypoints.add(new Point(50.0,50.0));
		waypoints.add(new Point(100, 0));
		waypoints.add(new Point(100, 100));
		waypoints.add(goal.getCenter());
	}
	
	public void addCreepAt(Point pos) {
		creeps.add(new Creep(new Point(pos.getX(), pos.getY()), waypoints));
	}
	
	public void update() {
		if (life > 0) {
			for (Creep creep : creeps){
//				System.out.println("moving creep");
				creep.move();
//				creep.setPos(new Point(creep.getPos().getX() + 1, creep.getPos().getY() + 1));
//				if(creep.getPos().getX() < goal.getCenter().getX()) {
//					creep.getPos().addX(creep.getSpeed());
//				}
//				if(creep.getPos().getY() < goal.getCenter().getY()) {
//					creep.getPos().addY(creep.getSpeed());
//				}
//				if(creep.getPos().distanceTo(goal.getCenter()) == 0) {
//					creeps.remove(creep);
//				}
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
	public Terrain[][] getTerrain() {
		return grid;
	}
	public void setTerrain(int first, int second, Terrain terrain) {
		this.grid[first][second] = terrain;
	}
}
