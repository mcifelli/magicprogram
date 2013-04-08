package edu.ycp.cs320.magicprogram.shared;

public class Point {
	// Fields
	double x, y;

	// Constructors
	/**
	 * Constructor
	 * 
	 * @param x The point's x value
	 * @param y The point's y value
	 */
	public Point(double x, double y) {
		setX(x);
		setY(y);
	}
	/**
	 * Empty Constructor
	 * 
	 * X-value = 0.0 
	 * Y-value = 0.0
	 */
	public Point() {
		setX(0.0);
		setY(0.0);
	}

	// Methods
	/**
	 * Calculates the distance between two points, returning seperated values.
	 * 
	 * @param b Another point
	 * @return a point (x-distance, y-distance)
	 */
	public Point distanceToXY(Point b) {
		double distanceX = this.x() - b.x();
		double distanceY = this.y() - b.y();
		return new Point(distanceX, distanceY);
	}
	/**
	 * Calculates the distance between the two points, returning one number.
	 * 
	 * @param b Another point
	 * @return the distance between the two points
	 */
	public double distanceTo(Point b) {
		Point d = distanceToXY(b);
		return Math.sqrt(d.x() * d.x() + d.y() * d.y());
	}
	/**
	 * Adds the input to the point's x-value
	 * @param plusX increase in x-value
	 */
	public void addX(double plusX) {
		this.x += plusX;
	}
	/**
	 * Adds the input to the point's y-value
	 * @param plusY increase in y-value
	 */
	public void addY(double plusY) {
		this.y += plusY;
	}
	
	// Static Methods
	/**
	 * Calculates the distance between two points, returning seperated values.
	 * 
	 * @param b Another point
	 * @return A point (x-distance, y-distance)
	 */
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
	/**
	 * Calculates the distance between the two points, returning one number.
	 * 
	 * @param b Another point
	 * @return the distance between the two points
	 */
	public static double distanceBetween(Point a, Point b) {
		Point d = distanceBetweenXY(a, b);
		return Math.sqrt(d.x() * d.x() + d.y() * d.y());
	}
	
	// Getters/Setters
	/**
	 * Get x-value
	 * @return x-value
	 */
	public double x() {
		return x;
	}
	/**
	 * Set x-value
	 * @param x the new x-value
	 */
	public void setX(double x) {
		this.x = x;
	}
	/**
	 * Get y-value
	 * @return y-value
	 */
	public double y() {
		return y;
	}
	/**
	 * Set y-value
	 * @param x the new y-value
	 */
	public void setY(double y) {
		this.y = y;
	}
	public void setXY(double x, double y) {
		this.x = x;
		this.y = y;
	}
}