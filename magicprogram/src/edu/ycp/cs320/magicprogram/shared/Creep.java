package edu.ycp.cs320.magicprogram.shared;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Stack;

public class Creep {
	// Physical attributes
	private Rectangle body;
	private double range = 1;
	private double speed = 1;
	private int hp = 10;
	private Stack<Point> path;
	
	// Constructors
	public Creep(ArrayList<Point> path) {
		this.path = new Stack();
		Collections.reverse(path);
		for (Point waypoint : path) {
			this.path.push(waypoint);
		}
		Collections.reverse(path);
		this.body = new Rectangle(this.path.pop(), 1, 1);
	}
	
	// Getters/Setters
	public double getRange() {
		return range;
	}
	public void setRange(double range) {
		this.range = range;
	}
	public Point getCenter() {
		return body.getCenter();
	}
	public int getHP() {
		return hp;
	}
	public void setHp(int hp) {
		this.hp = hp;
	}
	public Rectangle getBody() {
		return body;
	}
	
	//Methods
	/**
	 * Move towards the next waypoint
	 */
	public void move() {
		if (!path.isEmpty()) {
			Point distance = Point.distanceBetweenXY(getCenter(), path.peek());
			
			if (speed > Math.abs(distance.getX()) && speed > Math.abs(distance.getY())) {
				// the creep will overshoot the point
				// solution: the creep goes to the point
				body.setTopLeft(path.pop());
			}
			else {
				// Full step needed on x-axis
				if (body.getCenter().getX() < path.peek().getX()) {
					body.getTopLeft().addX(speed);
				}
				else {
					body.getTopLeft().addX(-1 * speed);
				}
				// Full step needed on y-axis
				if (body.getCenter().getY() < path.peek().getY()) {
					body.getTopLeft().addY(speed);	
				}
				else {
					body.getTopLeft().addY(-1 * speed);
				}
			}
		}
	}
	
	public void kill() {
		this.hp = 0;
	}
}
