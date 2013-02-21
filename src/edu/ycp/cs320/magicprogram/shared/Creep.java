package edu.ycp.cs320.magicprogram.shared;

public class Creep {
	// Physical attributes
	private Rectangle body;
	private Circle range;
	private boolean dead;
	private double speed;
	
	// Constructors
	public Creep(Point topLeft, double size, double speed) {
		setBody(new Rectangle(topLeft, size));
		setRange(new Circle());
		setDead(false);
		setSpeed(speed);
	}
	
	// Getters/Setters
	public Rectangle getBody() {
		return body;
	}
	public void setBody(Rectangle body) {
		this.body = body;
	}
	public Circle getRange() {
		return range;
	}
	public void setRange(Circle range) {
		this.range = range;
	}
	public Point getLocation() {
		return body.getLocation();
	}
	
	//Methods
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
