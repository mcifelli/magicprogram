package edu.ycp.cs320.magicprogram.shared;

import java.util.ArrayList;

public class Game {
	// GAME FIELDS
	private int life;
	private ArrayList<Creep> creeps = new ArrayList<Creep>();
	private int killCount;
	private int money;
	
	// BOARD FIELDS
	private Level level;
	
	
	public Game(Level level) {
		// COPY LEVEL
		this.level = new Level(level);
		
		// RESET GAME VALUES
		this.setLife(10);
		this.creeps = new ArrayList<Creep>();
		this.killCount = 0;
		this.money = 0;
	}
	
	public boolean buildTower(Structure newTower) {
		if (canBuildTower(newTower)) {
			level.getTowers().add(new Structure(newTower));
			level.getMap()[(int)newTower.gp().y()][(int)newTower.gp().x()] = Terrain.structure;
			return true;
		}
		return false;
	}
	
	public boolean canBuildTower(Structure newTower) {
		// get the map from the level
		Terrain[][] map = level.getMap();
		
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
		Structure base = level.getBase();
		ArrayList<Structure> spawners = level.getSpawners();
		ArrayList<Structure> towers = level.getTowers();
		for (int i = 0; i < creeps.size(); i++) {
			creeps.get(i).move();
			if (base.getCenter().distanceTo(creeps.get(i).getCenter()) <= (base.getSize() / 2)) {
				creeps.remove(i);
				i--;
			}
		}
		for (Structure spawner : spawners) {
			if (spawner.tick() == 0) {
				creeps.add(new Creep(spawner.getCenter()));
			}
		}
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
	public Level getLevel() {
		return this.level;
	}
}
