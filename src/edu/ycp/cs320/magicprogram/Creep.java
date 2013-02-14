package edu.ycp.cs320.magicprogram;

public class Creep {
	// TODO: add fields
	//Circle myCircle;
	Point corner;
	double size;
	
	
	public Creep(Point center, double size) {
		this.corner = center;
		this.size = size;
	}
	
	
	
	
	public Point getCorner() {
		Point center = this.corner;
		return center;
	}
	
	
	
	
	public void setCorner(Point corner) {
		this.corner = corner;
	}

	
	
	
	public double getSize() {
		double size = this.size;
		return size;
	}

	
	
	
	public void setSize(double size) {
		this.size = size;
	}
}
