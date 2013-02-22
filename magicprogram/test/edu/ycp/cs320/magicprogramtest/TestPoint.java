package edu.ycp.cs320.magicprogramtest;

import static junit.framework.Assert.*;
import org.junit.Before;
import org.junit.Test;

import edu.ycp.cs320.magicprogram.shared.*;


public class TestPoint {
	private Point a;
	private Point b;
	
	@Before
	public void setUp() {
		a = new Point();
		b = new Point(1, 2);
	}
	
	@Test
	public void testDistanceToXY() {
		Point distance = a.distanceToXY(b);
		assertEquals(1, distance.getX());
		assertEquals(2, distance.getY());
		distance = b.distanceToXY(a);
		assertEquals(1, distance.getX());
		assertEquals(2, distance.getY());
	}
	
	@Test
	public void testDistanceBetweenXY() {
		Point distance = Point.distanceBetweenXY(a, b);
		assertEquals(1, distance.getX());
		assertEquals(2, distance.getY());
		distance = Point.distanceBetweenXY(b, a);
		assertEquals(1, distance.getX());
		assertEquals(2, distance.getY());
	}
}
