package edu.ycp.cs320.magicprogram;

/**
 * Class whose instances represent points in the x/y plane.
 * Note that Point objects are immutable: once created,
 * their x and y values may not be changed.
 * 
 * @author David Hovemeyer
 */
public class Point {
	double dx, dy, distance;

	/**
	 * Constructor.
	 * 
	 * @param x  the Point's x coordinate value
	 * @param y  the Point's y coordinate value
	 */
	public Point(double x, double y) {
		dx = x;
		dy = y;
	
	}
	
	/**
	 * Return the point's x coordinate value.
	 * 
	 * @return the point's x coordinate value
	 */
	public double getX() {
		return dx;
	}
	
	/**
	 * Return the point's y coordinate value
	 * 
	 * @return the point's y coordinate value
	 */
	public double getY() {
		return dy;
	}

	/*public void setY(double y) {
		dy=y;
	}
	
	public void setX(double x) {
		dx=x;
	}*/
	/**
	 * Return the geometric distance between this point and
	 * the point given as the parameter.
	 * 
	 * @param other another Point object
	 * @return the geometric distance between this point and the other point
	 */
	public double distanceTo(Point other) {
		double a=other.getX();
		double b=other.getY();
		distance = Math.sqrt(Math.pow(a-dx, 2)+Math.pow(b-dy,2));
		return distance;
	}
}
