package edu.ycp.cs320.magicprogram.shared;

public class Circle {
	// Fields
	Point center;
	double radius;
	
	// Constructors
	public Circle() {
		setCenter(new Point());
		setRadius(0.0);
	}
	
	public Circle(Point center) {
		setCenter(center);
		setRadius(0.0);
	}
	
	public Circle(Point center, double radius) {
		setCenter(center);
		setRadius(radius);
	}
	
	// Getters/Setters
	public Point getCenter() {
		return this.center;
	}
	public void setCenter(Point center) {
		this.center = center;
	}
	public double getRadius() {
		double radius = this.radius;
		return radius;
	}
	public void setRadius(double radius) {
		this.radius = radius;
	}
	
	// Methods
}
