package edu.ycp.cs320.SHARED;

public class Tower {
	// Physical attributes
	private Rectangle body;
	private Circle range;
	// 
	
	public Tower(Point topLeft, double size) {
		setBody(new Rectangle(topLeft, size));
		setRange(new Circle(getCenter()));
	}
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
	public Point getCenter() {
		return body.getCenter();
	}
}
