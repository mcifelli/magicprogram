package edu.ycp.cs320.magicprogram;


public class Rectangle {
	// Fields
	double width, height;
	Point topLeft;
	
	// Constructors
	public Rectangle(Point topLeft, double width, double height) {
		this.width = width;
		this.height = height;
		this.topLeft = topLeft;
	}
	
	// Getters/Setters
	public double getWidth() {
		return this.width;
	}
	public void setWidth(double width) {
		this.width = width;
	}
	public double getHeight() {
		return this.height;
	}
	public void setHeight(double height) {
		this.height = height;
	}
	public Point getTopLeft() {
		return topLeft;
	}
	public void setTopLeft(Point topLeft) {
		this.topLeft = topLeft;
	}
	public Point getBotRight() {
		return new Point(topLeft.getX() + width, topLeft.getY() + height);
	}
	public boolean setBotRight(Point newBotRight) {
		if (newBotRight.getX() > topLeft.getX() && newBotRight.getY() > topLeft.getY()) {
			width = newBotRight.getX() - topLeft.getX();
			height = newBotRight.getY() - topLeft.getY();
			return true;
		}
		return false;
	}
	public Point getTopRight() {
		return new Point(topLeft.getX() + width, topLeft.getY());
	}
	public Point getBotLeft() {
		return new Point(topLeft.getX(), topLeft.getY() + height);
	}

	// Methods
	public boolean overlaps(Rectangle b) {
		/* 
		if(topLeft.getY() > rect.getTopLeft().getY() & topLeft.getY() < rect.getBotLeft().getY() 
				& topLeft.getX() > rect.getTopLeft().getX() & topLeft.getX() < rect.getTopRight().getX()
		){
			return true;
		}
		if(topRight.getY() > rect.getTopLeft().getY() & topRight.getY() < rect.getBotLeft().getY() 
				& topRight.getX() > rect.getTopLeft().getX() & topRight.getX() < rect.getTopRight().getX()
		){
			return true;
		}
		if(botLeft.getY() > rect.getTopLeft().getY() & botLeft.getY() < rect.getBotLeft().getY() 
				& botLeft.getX() > rect.getTopLeft().getX() & botLeft.getX() < rect.getTopRight().getX()
		){
			return true;
		}
		if(botRight.getY() > rect.getTopLeft().getY() & botRight.getY() < rect.getBotLeft().getY() 
				& botRight.getX() > rect.getTopLeft().getX() & botRight.getX() < rect.getTopRight().getX()
		){
			return true;
		}
		else{
			return false;
		}
		*/
		
		// if the leftmost point of a is to the right of b, or vice versa, the rectangles do not overlap on the x-axis
		if (this.getTopLeft().getX() > b.getTopRight().getX() || this.getTopRight().getX() < b.getTopLeft().getX()) {
			return false;
		}	// if the rectangles overlap on the x-axis, we must check if they overlap in the y
			// if the topmost point of a is lower than the bottommost point of b, they do not overlap on the y-axis
		else if (this.getTopLeft().getY() < b.getBotLeft().getY() || this.getBotLeft().getY() > b.getTopLeft().getY()) {
			return false;
		}
		return true;
	}
	
	public static boolean overlap(Rectangle a, Rectangle b) {
		if (a.getTopLeft().getX() > b.getTopRight().getX() || a.getTopRight().getX() < b.getTopLeft().getX()) {
			return false;
		}
		else if (a.getTopLeft().getY() < b.getBotLeft().getY() || a.getBotLeft().getY() > b.getTopLeft().getY()) {
			return false;
		}
		return true;
		
	} 
}
