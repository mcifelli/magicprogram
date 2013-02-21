package edu.ycp.cs320.magicprogram.shared;

import java.util.ArrayList;

public class Path {
	private ArrayList<Point> waypoints;
	
	public Path() {
		waypoints = new ArrayList<Point>();
	}
	
	public void addWaypoint(Point point) {
		waypoints.add(point);
	}
}
