package edu.ycp.cs320.magicprogram.shared;


public class Point {
	// Fields
	double x, y;

	// Constructors
	public Point(double x, double y) {
		setX(x);
		setY(y);
	}
	
	
	public Point() {
		setX(0.0);
		setY(0.0);
	}

	// Methods
	public Point distanceToXY(Point b) {
		double distanceX = this.getX() - b.getX();
		double distanceY = this.getY() - b.getY();
		return new Point(distanceX, distanceY);
	}
	
	public double distanceTo(Point b) {
		Point d = distanceToXY(b);
		return Math.sqrt(d.getX() * d.getX() + d.getY() * d.getY());
	}
	
	// Static Methods
	public static Point distanceBetweenXY(Point a, Point b) {
		double distanceX = a.getX() - b.getX();
		double distanceY = a.getY() - b.getY();
		return new Point(distanceX, distanceY);
	}
	
	public static double distanceBetween(Point a, Point b) {
		Point d = distanceBetweenXY(a, b);
		return Math.sqrt(d.getX() * d.getX() + d.getY() * d.getY());
	}
	
	// Getters/Setters
	public double getX() {
		return x;
	}
	public void setX(double x) {
		this.x = x;
	}
	public double getY() {
		return y;
	}
	public void setY(double y) {
		this.y = y;
	}
}
