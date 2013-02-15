package edu.ycp.cs320.magicprogram;


public class Rectangle {
	double width, height, centerx, centery;
	Point topLeft, topRight, botRight, botLeft;
	
	

	public Rectangle(Point topLeft, double width, double height) {
		this.width = width;
		this.height = height;
		this.topLeft = topLeft;
		this.topRight = new Point(this.topLeft.getX()+this.width,this.topLeft.getY());
		this.botRight = new Point(this.topLeft.getX()+this.width,this.topLeft.getY()+this.height);
		this.botLeft = new Point(this.topLeft.getX(),this.topLeft.getY()+this.height);
	}
	
	

	public Point getTopLeft() {
		return topLeft;
	}
	public Point getTopRight() {
		return topRight;
	}
	public Point getBotLeft() {
		return botRight;
	}
	public Point getBotRight() {
		return botLeft;
	}
	
	

	public void setTopLeft(Point topLeft) {
		this.topLeft = topLeft;
	}
	
	

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

	

	public boolean overlaps(Rectangle rect) {
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
			
	}
}
