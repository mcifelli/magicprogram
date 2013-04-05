package edu.ycp.cs320.magicprogram.shared;

import java.util.ArrayList;
import java.util.Stack;

public class Game {
	// CONSTANTS
	private final int ROW = 25;
	private final int COL = 25;
	
	// FIELDS
	private Rectangle goal;
	private int life = 10;
	private ArrayList<Creep> creeps;
	private Structure[][] structures = new Structure[ROW][COL];
	private Terrain[][] map = new Terrain[ROW][COL];
	private ArrayList<Point> waypoints;
	private Point bounds;
	
	public Game(double boundX, double boundY) {
		// WAYPOINTS
		waypoints = new ArrayList<Point>();
		waypoints.add(new Point(50.0,0.0));
		waypoints.add(new Point(50.0,50.0));
		
		// CREEPS
		setCreeps(new ArrayList<Creep>());
		setPath(new ArrayList<Point>());
		setBounds(new Point(boundX, boundY));
		
		// TERRAIN
		for (int row = 0; row < map.length; row++) {
			for (int col = 0; col < map[row].length; col++) {
				map[row][col] = Terrain.grass;
			}
		}
		map[0][0] = Terrain.road;
		map[1][0] = Terrain.road;
		map[2][0] = Terrain.road;
		map[3][0] = Terrain.road;
		map[4][0] = Terrain.road;
		map[5][0] = Terrain.road;
		map[5][0] = Terrain.road;
		map[5][0] = Terrain.road;
		map[5][1] = Terrain.road;
		map[5][2] = Terrain.road;
		map[5][3] = Terrain.road;
		map[5][4] = Terrain.road;
		map[5][5] = Terrain.road;
		map[5][6] = Terrain.road;
		map[5][7] = Terrain.road;
		map[5][8] = Terrain.road;
		map[5][9] = Terrain.road;
		map[5][10] = Terrain.road;
		map[5][11] = Terrain.road;
		map[5][12] = Terrain.road;
		map[5][13] = Terrain.road;
		map[5][14] = Terrain.road;
		map[5][15] = Terrain.road;
		map[5][16] = Terrain.road;
		map[5][17] = Terrain.road;
		map[5][18] = Terrain.road;
		map[5][19] = Terrain.road;
		map[5][20] = Terrain.road;
		map[5][21] = Terrain.road;
		map[5][22] = Terrain.road;
		map[5][23] = Terrain.road;
		map[5][24] = Terrain.road;
		map[6][24] = Terrain.road;
		map[7][24] = Terrain.road;
		map[8][24] = Terrain.road;
		map[9][24] = Terrain.road;
		map[10][24] = Terrain.road;
		map[11][24] = Terrain.road;
		map[12][24] = Terrain.road;
		map[13][24] = Terrain.road;
		map[14][24] = Terrain.road;
		map[15][24] = Terrain.road;
		map[16][24] = Terrain.road;
		map[17][24] = Terrain.road;
		map[18][24] = Terrain.road;
		map[19][24] = Terrain.road;
		map[20][24] = Terrain.road;
		map[21][24] = Terrain.road;
		map[22][24] = Terrain.road;
		map[23][24] = Terrain.road;
		map[24][24] = Terrain.road;
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
	
	public boolean buildStructure(Structure structure, int row, int col) {
		if (canBuildStructure(structure, col, col)) {
			structures[row][col] = structure;
			return true;
		}
		return false;
	}
	
	public boolean canBuildStructure(Structure structure, int row, int col) {
		return (structures[row][col] == null && map[row][col] == Terrain.grass);
	}
	
	// Getters/Setters
	public ArrayList<Creep> getCreeps() {
		return creeps;
	}
	public void setCreeps(ArrayList<Creep> creeps) {
		this.creeps = creeps;
	}
	public Structure[][] getStructures() {
		return structures;
	}
	public void setStructures(Structure[][] structures) {
		this.structures = structures;
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
	public Point getBounds() {
		return bounds;
	}
	public void setBounds(Point bounds) {
		this.bounds = bounds;
	}
	public Terrain[][] getMap() {
		return map;
	}
	public void setMap(Terrain[][] map) {
		this.map = map;
	}
}
