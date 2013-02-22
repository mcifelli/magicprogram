package edu.ycp.cs320.magicprogram.shared;

public class Creep {
	// Physical attributes
	private Rectangle body;
	private double range;
	private boolean dead;
	private double speed;
	private Point waypoint;
	
	
	// Constructors
	public Creep(Rectangle body, double range, double speed, Point waypoint) {
		setBody(body);
		setRange(range);
		setDead(false);
		this.speed = speed;
		this.setWaypoint(waypoint);
	}
	
	
	// Getters/Setters
	public Rectangle getBody() {
		return body;
	}
	public void setBody(Rectangle body) {
		this.body = body;
	}
	public double getRange() {
		return range;
	}
	public void setRange(double range) {
		this.range = range;
	}
	public Point getCenter() {
		return body.getCenter();
	}
	public Point getWaypoint() {
		return waypoint;
	}
	public void setWaypoint(Point waypoint) {
		this.waypoint = waypoint;
	}
	

	//Methods
	/**
	 * Move towards the waypoint
	 * @param wayPoint
	 */
	public void move(Point wayPoint) {
		double newX = body.getTopLeft().getX();
		double newY = body.getTopLeft().getY();
		if (body.getCenter().getX() < wayPoint.getX()) {
			newX += speed;			
		}
		else {
			newX -= speed;
		}
		if (body.getCenter().getY() < wayPoint.getY()) {
			newY += speed;		
		}
		else {
			newY -= speed;
		}
		body.setTopLeft(new Point(newX, newY));
	}
	
	public void kill() {
		setDead(true);
	}

	public boolean isDead() {
		return dead;
	}

	public void setDead(boolean dead) {
		this.dead = dead;
	}
}
