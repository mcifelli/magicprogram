package edu.ycp.cs320.magicprogram.shared;


public class Point {
	// Fields
	private double x, y;

	
	// Constructors
	public Point(double x, double y) {
		setX(x);
		setY(y);
	}
	public Point() {
		setX(0.0);
		setY(0.0);
	}
	public Point(Point copy) {
		this.x = copy.x;
		this.y = copy.y;
	}
	
	
	// Methods
	public Point distanceToXY(Point b) {
		double distanceX = this.x() - b.x();
		double distanceY = this.y() - b.y();
		return new Point(distanceX, distanceY);
	}
	public double distanceTo(Point b) {
		Point d = distanceToXY(b);
		return Math.sqrt(d.x() * d.x() + d.y() * d.y());
	}
	public void addX(double plusX) {
		this.x += plusX;
	}
	public void addY(double plusY) {
		this.y += plusY;
	}
	public boolean equalTo(Point other) {
		return (this.x == other.x && this.y == other.y);
	}
	
	
	// Static Methods
	public static Point distanceBetweenXY(Point a, Point b) {
		Point distance = new Point();
		
		if (a.x() < b.x()) {
			distance.setX(b.x() - a.x());	
		}
		else {
			distance.setX(a.x() - b.x());
		}
		if (a.y() < b.y()) {
			distance.setX(b.y() - a.y());	
		}
		else {
			distance.setX(a.y() - b.y());
		}
		return distance;
	}

	public static double distanceBetween(Point a, Point b) {
		Point d = distanceBetweenXY(a, b);
		return Math.sqrt(d.x() * d.x() + d.y() * d.y());
	}
	
	
	// Getters & Setters
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
	public void setXY(double x, double y) {
		this.x = x;
		this.y = y;
	}
	public double x() {
		return x;
	}
	public double y() {
		return y;
	}
}
