package edu.ycp.cs320.magicprogram.shared;

public class Structure {
	public enum Type {
		tower,
		base,
		spawner;
	}
	
	private Type type;
	private Point topLeft;
	private int size;
	private int attackSpeed;
	private Point gridPoint;
	private int attack = 1;
	private double range = 30;
	private int spawnCounter;
	private Creep focus;
	
	public Structure(Type type, Point topLeft, int size) {
		this.setTopLeft(topLeft);
		this.setType(type);
		this.setSize(size);
		this.setGridPoint(new Point(topLeft.x() / size, topLeft.y() / size));
		setSpawnCounter(0);
		switch (type) {
		case base:
			setAttackSpeed(1);
			break;
		case tower:
			setAttackSpeed(0);
			break;
		default:
			setAttackSpeed(0);
			break;
		}
	}

	public Structure(Structure copy) {
		this.type = copy.type;
		this.topLeft = new Point(copy.topLeft);
		this.size = copy.size;
		this.attackSpeed = copy.attackSpeed;
		this.gridPoint = new Point(copy.gridPoint);
	}

	
	// METHODS
	public Point tl() {
		return this.topLeft;
	}
	public Point gp() {
		this.setGridPoint(new Point(topLeft.x() / size, topLeft.y() / size));
		return gridPoint;
	}
	public int tick() {
		this.spawnCounter++;
		if (this.spawnCounter >= 10) {
			spawnCounter = 0;
		}
		return spawnCounter;
	}
	public void attack() {
		focus.setHp(focus.getHP() - attack);
		if (getCenter().distanceTo(focus.getCenter()) > range) {
			focus = null;
		}
	}
	
	
	// GETTERS & SETTERS
	public Type getType() {
		return type;
	}
	public void setType(Type type) {
		this.type = type;
	}
	public Point getTopLeft() {
		return topLeft;
	}
	public void setTopLeft(Point topLeft) {
		this.topLeft = topLeft;
		this.setGridPoint(new Point(topLeft.x() / size, topLeft.y() / size));
	}
	public int getSize() {
		return size;
	}
	public void setSize(int size) {
		this.size = size;
		this.setGridPoint(new Point(topLeft.x() / size, topLeft.y() / size));
	}
	public int getAttackSpeed() {
		return attackSpeed;
	}
	public void setAttackSpeed(int attackSpeed) {
		this.attackSpeed = attackSpeed;
	}
	public Point getGridPoint() {
		return gridPoint;
	}
	public void setGridPoint(Point gridCoordinates) {
		this.gridPoint = gridCoordinates;
	}
	public Point getCenter() {
		Point center = new Point(topLeft.x() + (size/2), topLeft.y() + (size/2));
		return center;
	}
	public double getRange() {
		return range;
	}
	public int getAttack() {
		return attack;
	}
	public void setAttack(int attack) {
		this.attack = attack;
	}
	public int getSpawnCounter() {
		return spawnCounter;
	}
	public void setSpawnCounter(int spawnCounter) {
		this.spawnCounter = spawnCounter;
	}
	public Creep getFocus() {
		return focus;
	}
	public void setFocus(Creep newFocus) {
		focus = newFocus;	//focus
	}
}
