package edu.ycp.cs320.magicprogram;


public class Point {
	double x, y, distance;



	public Point(double x, double y) {
		this.x = x;
		this.y = y;
	
	}
	


	public double getX() {
		return x;
	}
	

	public double getY() {
		return y;
	}


	public double distanceTo(Point other) {
		double a=other.getX();
		double b=other.getY();
		distance = Math.sqrt(Math.pow(a-x, 2)+Math.pow(b-y,2));
		return distance;
	}
}
