package edu.ycp.cs320.magicprogram.shared;

import java.util.Stack;

public class Creep {
	// Physical attributes
	private Point center;		// topleft point of the creep
	private int size = 5;		// height and width of the creep
	private double range = 1;	// attack range
	private double speed = 1;	// how far the creep travels in one tick
	private int hp = 10;
	private Stack<Point> path;
	
	public Creep(){
		this.center = new Point();
		this.path = new Stack<Point>();
	}
	
	// Constructors
	public Creep(Point center, Stack<Point> path) {
		this.center = new Point(center);
		this.path = path;
	}
	
	// Getters/Setters
	public Point getTopLeft() {
		return new Point(center.x() - (size/2), center.y() - (size/2));
	}
	public double getRange() {
		return range;
	}
	public void setRange(double range) {
		this.range = range;
	}
	public int getHP() {
		return hp;
	}
	public void setHp(int hp) {
		this.hp = hp;
	}
	public Point getCenter() {
		return center;
	}
	public int getSize() {
		return size;
	}
	public void setSize(int size) {
		this.size = size; 
	}
	//comment
	//Methods
	/**
	 * Move towards the next waypoint
	 */
	public void move() {
		if (!path.isEmpty()) {
			if (speed >= center.distanceTo(path.peek())) {
				// the creep will overshoot the point
				// solution: the creep goes to the point
				center = path.pop();
			}
			else {
				// Full step needed on x-axis
				if (center.x() < path.peek().x()) {
					center.addX(speed);
				}
				else {
					center.addX(-1 * speed);
				}
				// Full step needed on y-axis
				if (center.y() < path.peek().y()) {
					center.addY(speed);	
				}
				else {
					center.addY(-1 * speed);
				}
			}
		}
	}

	public void setCenter(Point center) {
		this.center = new Point(center);
	}
}
