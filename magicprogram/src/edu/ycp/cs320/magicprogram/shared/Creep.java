package edu.ycp.cs320.magicprogram.shared;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Queue;
import java.util.Stack;

public class Creep {
	// Physical attributes
	private Point center;		// topleft point of the creep
	private int size = 5;		// height and width of the creep
	private double range = 1;	// attack range
	private double speed = 1;	// how far the creep travels in one tick
	private int hp = 10;
	private Stack<Point> path;
	private Point position;
	
	// Constructors
	public Creep(Point position, ArrayList<Point> waypoints) {
		System.out.println("making new creep");
		speed = 5;
		
		this.position = position;
		
		size = 10;
		
		for (int i = waypoints.size() - 1; i >= 0; i--) {
			System.out.println("Added waypoint");
			this.path.push(waypoints.get(i));
		}

		path.push(new Point(490, 490));
		path.push(new Point(490, 110));
		path.push(new Point(10, 110));
	}
		

	public Creep(Point center) {
		this.center = center;

		path = new Stack<Point>();
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

	public void setPos(Point pos) {
		this.position = pos;
	}


	public int getSize() {
		return this.size;
	}
	public double getSpeed() {
		return this.speed;
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

			System.out.println("next point in path: " + path.peek().x()+ ", " + path.peek().y());
			
			if (speed > position.distanceTo(path.peek())) {
				System.out.println("too close to point" + path.peek().x()+ ", " + path.peek().y());
			}

			if (speed >= center.distanceTo(path.peek())) {

				// the creep will overshoot the point
				// solution: the creep goes to the point
				center = path.pop();
			}
			else {
				// Full step needed on x-axis

				if (position.x() < path.peek().x()) {
					System.out.println("moving towards " + path.peek().x()+ ", " + path.peek().x());
					position.addX(speed);
				}
				if (center.x() < path.peek().x()) {
					center.addX(speed);

				}
				else {
					center.addX(-1 * speed);
				}
				// Full step needed on y-axis

				if (position.y() < path.peek().y()) {
					System.out.println("moving towards " + path.peek().x()+ ", " + path.peek().x());
					position.addY(speed);	
				}
				if (center.y() < path.peek().y()) {
					center.addY(speed);	

				}
				else {
					center.addY(-1 * speed);
				}
			}
		}
	}
}
