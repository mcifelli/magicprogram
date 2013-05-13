package edu.ycp.cs320.magicprogram.shared;

import java.util.ArrayList;
import java.util.Stack;

public class Game {
	// GAME FIELDS
	private int life;
	private ArrayList<Creep> creeps;
	private Stack<Creep> currentWave;
	private int killCount;
	private int money;
	
	// BOARD FIELDS
	private Level state;
	private Level initialLevel;
	
	public Game() {
		this.initialLevel = new Level();
		reset();
	}
	public Game(Level level) {
		// COPY LEVEL
		this.initialLevel = new Level(level);
		reset();
		
//		creeps.add(new Creep(new Point(), level.getWaypoints()));
	}
	
	public void reset() {
		this.state = new Level(this.initialLevel);
		this.creeps = new ArrayList<Creep>();
		this.currentWave = new Stack<Creep>();
		this.life = 10;
		this.killCount = 0;
		this.money = 0;
	}
	
	public boolean buildTower(Structure newTower) {
		if (canBuildTower(newTower)) {
			state.getTowers().add(new Structure(newTower));
			state.getMap()[(int)newTower.gp().y()][(int)newTower.gp().x()] = Terrain.structure;
			return true;
		}
		return false;
	}
	
	public boolean canBuildTower(Structure newTower) {
		// get the map from the level
		Terrain[][] map = state.getMap();
		
		// check if the terrain is buildable
		switch(map[(int)newTower.gp().y()][(int)newTower.gp().x()]) {
			case grass:
				return true;
			case road:
				return false;
			case structure:
				return false;
			case water:
				return false;
			default:
				return false;
		}
	}
	
	// Methods
	public void update() {
		Structure base = state.getBase();
		Structure spawner = state.getSpawner();
		ArrayList<Structure> towers = state.getTowers();
		
		// ===== MOVE CREEPS ===========
		for (int i = 0; i < creeps.size(); i++) {
			creeps.get(i).move();
			if (base.getCenter().distanceTo(creeps.get(i).getCenter()) <= (base.getSize() / 2)) {
				creeps.remove(i);
				i--;
				life--;
			}
		}
		// ===== SPAWN CREEPS ===========
		if (spawner.tick() == 0) {
			if (!currentWave.isEmpty()) {
				Creep creep = currentWave.pop();
				creep.setCenter(spawner.getCenter());
				creeps.add(creep);
			}
		}
		
		// ===== FIRE/UPDATE TOWERS =====
		for (Structure tower : towers) {
			if (tower.getFocus() == null) {
				for (Creep creep : creeps) {
					if (tower.getCenter().distanceTo(creep.getCenter()) <= tower.getRange()) {
						tower.setFocus(creep);
					}
				}
			}
			else {
				tower.attack();
				if (tower.getFocus().getHP() <= 0) {
					creeps.remove(tower.getFocus());
					tower.setFocus(null);
					killCount++; //counts creep dead
					money += 20;
				}
			}
		}
	}
	
	public void sendWave() {
		if (currentWave.isEmpty() && !state.getWaves().isEmpty()) {
			currentWave = state.getWaves().pop();
			state.getSpawner().setSpawnCounter(0);
		}
	}
	
	// Getters/Setters
	public ArrayList<Creep> getCreeps() {
		return creeps;
	}
	public void setCreeps(ArrayList<Creep> creeps) {
		this.creeps = creeps;
	}
	public int getKillCount() {
		return killCount;
	}
	public void setKillCount(int killCount) {
		this.killCount = killCount;
	}
	public int getMoney() {
		return money;
	}
	public void setMoney(int money) {
		this.money = money;
	}
	public int getLife() {
		return life;
	}
	public void setLife(int life) {
		this.life = life;
	}
	public Level getState() {
		return this.state;
	}
	public int creepsInWave() {
		return currentWave.size();
	}
	public int wavesRemaining() {
		return state.getWaves().size();
	}
}