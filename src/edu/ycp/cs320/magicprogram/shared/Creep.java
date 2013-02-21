package edu.ycp.cs320.magicprogram.shared;

public class Creep {
	// Physical attributes
	private Rectangle body;
	private Circle range;
	private boolean dead;
	
	// Constructors
	public Creep(Point topLeft, double size) {
		setBody(new Rectangle(topLeft, size));
//		setRange(new Circle(getCenter()));
		dead = false;
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
	public void move(Point newPoint) {
		
	}
	
	public void kill() {
		dead = true;
	}
}
