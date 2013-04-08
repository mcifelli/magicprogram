package edu.ycp.cs320.magicprogram.shared;

public class Structure {
	public enum Type {
		tower,
		base;
	}
	
	private Type type;
	private Point topLeft;
	private int size;
	private int attackSpeed;
	private Point gridPoint;
	
	public Structure(Type type, Point topLeft, Point gridPoint) {
		this.setTopLeft(topLeft);
		this.setType(type);
		this.setGridPoint(gridPoint);
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
}
