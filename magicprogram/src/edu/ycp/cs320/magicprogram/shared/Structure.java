package edu.ycp.cs320.magicprogram.shared;

public class Structure {
	public enum Type {
		tower,
		base, spawner;
	}
	
	private Type type;
	private Point topLeft;
	private int size;
	private int attackSpeed;
	private int damage;
	private Point gridPoint;
	private double range = 30;
	
	public Structure(Type type, Point topLeft, int size) {
		this.setTopLeft(topLeft);
		this.setType(type);
		this.setSize(size);
		this.setGridPoint(new Point(topLeft.x() / size, topLeft.y() / size));
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
		this.topLeft = copy.topLeft;
		this.size = copy.size;
		this.attackSpeed = copy.attackSpeed;
		this.gridPoint = copy.gridPoint;
	}

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

	/**
	 * @return the size
	 */
	public int getSize() {
		return size;
	}

	/**
	 * @param size the size to set
	 */
	public void setSize(int size) {
		this.size = size;
		this.setGridPoint(new Point(topLeft.x() / size, topLeft.y() / size));
	}

	/**
	 * @return the attackSpeed
	 */
	public int getAttackSpeed() {
		return attackSpeed;
	}

	/**
	 * @param attackSpeed the attackSpeed to set
	 */
	public void setAttackSpeed(int attackSpeed) {
		this.attackSpeed = attackSpeed;
	}

	/**
	 * @return the gridCoordinates
	 */
	public Point getGridPoint() {
		return gridPoint;
	}

	/**
	 * @param gridCoordinates the gridCoordinates to set
	 */
	public void setGridPoint(Point gridCoordinates) {
		this.gridPoint = gridCoordinates;
	}
	public Point tl() {
		return this.topLeft;
	}
	public Point gp() {
		this.setGridPoint(new Point(topLeft.x() / size, topLeft.y() / size));
		return gridPoint;
	}
	public Point getCenter() {
		Point center = new Point(topLeft.x() - (size/2), topLeft.y() - (size/2));
		return center;
	}

	public double getRange() {
		return range;
	}

	public int getDamage() {
		return damage;
	}

}
