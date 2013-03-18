package edu.ycp.cs320.magicprogram.shared;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Stack;

public class Creep {
	// Physical attributes
	private Point position;
	private int size;
	private double range = 1;
	private double speed = 1;
	private int hp = 10;
	private Stack<Point> path;
	
	// Constructors
	public Creep(Point position, ArrayList<Point> waypoints) {
		System.out.println("making new creep");
		speed = 5;
		
		this.position = position;
		
		size = 50;
		
		path = new Stack<Point>();
		Collections.reverse(waypoints);
		for (Point waypoint : waypoints) {
			System.out.println("Added waypoint");
			path.push(waypoint);
		}
		Collections.reverse(waypoints);
	}

	// Getters/Setters
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
	public Point getPos() {
		return position;
	}
	public void setPos(Point pos) {
		this.position = pos;
	}
	public int getSize() {
		return size;
	}

	public void setSize(int size) {
		this.size = size;
	}

	//Methods
	/**
	 * Move towards the next waypoint
	 */
	public void move() {
		if (!path.isEmpty()) {
			System.out.println("next point in path: " + path.peek().getX()+ ", " + path.peek().getY());
			
			if (speed > position.distanceTo(path.peek())) {
				System.out.println("too close to point" + path.peek().getX()+ ", " + path.peek().getY());
				// the creep will overshoot the point
				// solution: the creep goes to the point
				position = path.pop();
			}
			else {
//				 Full step needed on x-axis
				if (position.getX() < path.peek().getX()) {
					System.out.println("moving towards " + path.peek().getX()+ ", " + path.peek().getY());
					position.addX(speed);
				}
				else {
					position.addX(-1 * speed);
				}
				// Full step needed on y-axis
				if (position.getY() < path.peek().getY()) {
					System.out.println("moving towards " + path.peek().getX()+ ", " + path.peek().getY());
					position.addY(speed);	
				}
				else {
					position.addY(-1 * speed);
				}
			}
		}
		else {
			System.out.println("Path is empty");
			
		}
	}
	
	public void kill() {
		this.hp = 0;
	}
}
