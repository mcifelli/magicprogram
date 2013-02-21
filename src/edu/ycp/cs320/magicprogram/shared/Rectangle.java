package edu.ycp.cs320.magicprogram.shared;


public class Rectangle {
	// Fields
	double width, height;
	Point topLeft;
	
	// Constructors
	/**
	 * Empty constructor. Height and Width are set to 0, Top Left is set to (0, 0)
	 */
	public Rectangle() {
		setWidth(0.0);
		setHeight(0.0);
		setTopLeft(new Point());
	}
	/**
	 * Consructor
	 * @param topLeft The top left corner of the rectangle.
	 * @param width	  The width of the rectangle
	 * @param height  The height of the rectangle
	 */
	public Rectangle(Point topLeft, double width, double height) {
		setWidth(width);
		setHeight(height);
		setTopLeft(topLeft);
	}
	/**
	 * Square Consructor
	 * @param topLeft The top left corner of the rectangle
	 * @param size	  The width and height of the rectangle
	 */
	public Rectangle(Point topLeft, double size) {
		setWidth(size);
		setHeight(size);
		setTopLeft(topLeft);
	}

	// Getters/Setters
	/**
	 * Get the height of the rectangle
	 * @return The width of the rectangle
	 */
	public double getWidth() {
		return this.width;
	}
	/**
	 * Set the width of the rectangle
	 * @param width A new width
	 */
	public void setWidth(double width) {
		this.width = width;
	}
	/**
	 * Get the height of the rectangle
	 * @return The height of the rectangle
	 */
	public double getHeight() {
		return this.height;
	}
	/**
	 * Set the height of the rectangle
	 * @param height A new height
	 */
	public void setHeight(double height) {
		this.height = height;
	}
	/**
	 * Get the top left corner of the rectangle
	 * @return The top left corner of the rectangle
	 */
	public Point getTopLeft() {
		return topLeft;
	}
	/**
	 * Set the width of the rectangle
	 * @param topLeft A new point for the top left of the rectangle
	 */
	public void setTopLeft(Point topLeft) {
		this.topLeft = topLeft;
	}
	/**
	 * Gets the bottom right corner
	 * @return the bottom right corner
	 */
	public Point getBotRight() {
		return new Point(topLeft.getX() + width, topLeft.getY() + height);
	}
	/**
	 * Sets the bottom left corner without changing the top left.
	 * This will expand the rectangle by recalculating its height and width.
	 * Will only work if the new point is to the right/below the top left corner.
	 * @param newBotRight a new bottom right 
	 * @return true if the new point is to the right/below the top left corner
	 */
	public boolean setBotRight(Point newBotRight) {
		if (newBotRight.getX() > topLeft.getX() && newBotRight.getY() > topLeft.getY()) {
			width = newBotRight.getX() - topLeft.getX();
			height = newBotRight.getY() - topLeft.getY();
			return true;
		}
		return false;
	}
	/**
	 * Gets the top right corner
	 * @return the top right corner
	 */
	public Point getTopRight() {
		return new Point(topLeft.getX() + width, topLeft.getY());
	}
	/**
	 * Gets the bottom left corner
	 * @return the bottom left corner
	 */
	public Point getBotLeft() {
		return new Point(topLeft.getX(), topLeft.getY() + height);
	}
	/**
	 * Gets the calculated center
	 * @return the center point
	 */
	public Point getCenter() {
		return new Point(topLeft.getX() + width/2, topLeft.getY() + height/2);
	}

	// Methods
	/**
	 * Determines whether another rectangle overlaps this one 
	 * @param b Another rectangle
	 * @return true if the rectangles overlap
	 */
	public boolean overlaps(Rectangle b) {
		// if the leftmost point of a is to the right of b, or vice versa, the rectangles do not overlap on the x-axis
		if (this.getTopLeft().getX() > b.getTopRight().getX() || this.getTopRight().getX() < b.getTopLeft().getX()) {
			return false;
		}	// if the rectangles overlap on the x-axis, we must check if they overlap in the y
			// if the topmost point of a is lower than the bottommost point of b, they do not overlap on the y-axis
		else if (this.getTopLeft().getY() > b.getBotLeft().getY() || this.getBotLeft().getY() < b.getTopLeft().getY()) {
			return false;
		}
		return true;
	}
	/**
	 * Determines whether two rectangles overlaps one another 
	 * @param b A rectangle
	 * @param b Another rectangle
	 * @return true if the rectangles overlap
	 */
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
