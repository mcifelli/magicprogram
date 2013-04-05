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
	
	public Structure(Point topLeft, Type type) {
		this.setTopLeft(topLeft);
		this.setType(type);
		switch (type) {
		case base:
			attackSpeed = 1;
			break;
		case tower:
			attackSpeed = 0;
			break;
		default:
			attackSpeed = 0;
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
}
