package edu.ycp.cs320.magicprogram.shared;

import java.io.Serializable;
import java.util.ArrayList;

import edu.ycp.cs320.magicprogram.shared.Structure.Type;

public class Level implements Serializable {
	private static final long serialVersionUID = 1L;
	
	// CONSTANTS
	public int ROW = 25;
	public int COL = 25;
	private Point BOUNDS = new Point(500.0, 500.0);
	
	// BOARD FIELDS
	private Terrain[][] map = new Terrain[ROW][COL];
	private ArrayList<Point> waypoints;
	private ArrayList<Structure> spawners;
	private ArrayList<Structure> towers;
	private Structure base;
	private int gridUnit = (int)(BOUNDS.x()/ROW);
	
	public Level() {
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
		
		spawners = new ArrayList<Structure>();
		towers = new ArrayList<Structure>();
		base = new Structure(Type.base, new Point((COL * gridUnit) - gridUnit, (ROW * gridUnit) - gridUnit), gridUnit);
		
		this.spawners.add(new Structure(Type.spawner, new Point(), gridUnit));
		
		setGridUnit((int) (BOUNDS.x() / COL));
	}
	
	public Level(Level level) {
		this.ROW = level.getRow();
		this.COL = level.getCol();
		this.BOUNDS = level.getBounds();
		this.waypoints = level.getWaypoints();
		this.map = level.getMap();
		this.spawners = level.getSpawners();
		this.towers = level.getTowers();
		this.base = level.getBase();
	}

	// GETTERS & SETTERS
	public int getRow() {
		return ROW;
	}
	public int getCol() {
		return COL;
	}
	public Point getBounds() {
		return BOUNDS;
	}
	public ArrayList<Point> getWaypoints() {
		return waypoints;
	}
	public void setWaypoints(ArrayList<Point> waypoints) {
		this.waypoints = waypoints;
	}
	public ArrayList<Structure> getSpawners() {
		return spawners;
	}
	public void setSpawners(ArrayList<Structure> spawners) {
		this.spawners = spawners;
	}
	public ArrayList<Structure> getTowers() {
		return towers;
	}
	public void setTowers(ArrayList<Structure> towers) {
		this.towers = towers;
	}
	public Structure getBase() {
		return base;
	}
	public void setBase(Structure base) {
		this.base = base;
	}
	public int getGridUnit() {
		return gridUnit;
	}
	public void setGridUnit(int gridUnit) {
		this.gridUnit = gridUnit;
	}
	public Terrain[][] getMap() {
		return map;
	}
	public void setMap(Terrain[][] map) {
		this.map = map;
	}
	
}
