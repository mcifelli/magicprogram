package edu.ycp.cs320.magicprogram.shared;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Stack;

import edu.ycp.cs320.magicprogram.shared.Structure.Type;

public class Level implements Serializable {
	private static final long serialVersionUID = 1L;
	
	// CONSTANTS
	public int ROW = 25;
	public int COL = 25;
	private Point BOUNDS = new Point(500.0, 500.0);
	
	// BOARD FIELDS
	private String name;
	private Terrain[][] map;
	private Stack<Point> waypoints;
	private Stack<Stack<Creep>> waves;
	private Structure spawner;
	private ArrayList<Structure> towers;
	private Structure base;
	private int gridUnit;
	
	public Level(String name) {
		reset();
		this.name = name;
		
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
		
		waypoints.push(new Point(490, 490));
		waypoints.push(new Point(490, 110));
		waypoints.push(new Point(10, 110));
		
		spawner = new Structure(Type.spawner, new Point(), gridUnit);
		
		waves.get(0).add(new Creep(spawner.getCenter(), waypoints));
		waves.get(0).add(new Creep(spawner.getCenter(), waypoints));
		
		base = new Structure(Type.base, new Point((COL * gridUnit) - gridUnit, (ROW * gridUnit) - gridUnit), gridUnit);
	}
	
	public Level() {
		reset();
	}
	
	public void reset() {
		name = "";
		map = new Terrain[ROW][COL];
		waypoints = new Stack<Point>();
		waves = new Stack<Stack<Creep>>();
		waves.add(new Stack<Creep>());
		spawner = new Structure();
		towers = new ArrayList<Structure>();
		base = new Structure();
		gridUnit = (int)(BOUNDS.x()/ROW);
		setGridUnit((int) (BOUNDS.x() / COL));
	}
	
	public Level(Level level) {
		reset();
		this.ROW = level.getRow();
		this.COL = level.getCol();
		this.BOUNDS = level.getBounds();
		this.waypoints = level.getWaypoints();
		this.map = level.getMap();
		spawner = new Structure(level.getSpawner());
		this.towers = level.getTowers();
		this.base = level.getBase();
		this.waves = level.getWaves();
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
	public Stack<Point> getWaypoints() {
		return waypoints;
	}
	public void setWaypoints(Stack<Point> waypoints) {
		this.waypoints = waypoints;
	}
	public Structure getSpawner() {
		return spawner;
	}
	public void setSpawner(Structure spawner) {
		this.spawner = spawner;
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

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	public Stack<Stack<Creep>> getWaves() {
		return waves;
	}
}

//path.push(new Point(490, 490));
//path.push(new Point(490, 110));
//path.push(new Point(10, 110));
