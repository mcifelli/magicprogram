package edu.ycp.cs320.magicprogramtest;

import static junit.framework.Assert.*;

import java.util.ArrayList;

import org.junit.Before;
import org.junit.Test;

import edu.ycp.cs320.magicprogram.shared.*;


public class TestCreep {
	private Creep a;
	private Creep b;

	private double range, newRange;
	private Point center, waypoint, fixpoint;
	private ArrayList<Point> waypoints;
	
	@Before
	public void setUp() {
		range = 1;
		newRange = 2;
		center = new Point(.5, .5);
		waypoint = new Point(5, 5);

		fixpoint = new Point(2,2);
		waypoints.add(new Point(1, 1));
		waypoints.add(new Point(2, 2));



		a = new Creep(center, waypoints);
		b = new Creep(center, waypoints);

		//a = new Creep(testRect, range, 1, center);
		//b = new Creep(fixRect, newRange, 1, fixpoint);

		//a = new Creep(testRect, range, 1, center);
		//b = new Creep(fixRect, newRange, 1, fixpoint);

	}
	
	@Test
	public void testGetPos() {
//		Rectangle ta = new Rectangle(new Point(), 1);
		assertEquals(center, a.getPos());
	}
	
	@Test

	public void testSetPos() {
		a.setPos(waypoint);
		assertEquals(waypoint, a.getPos());
	}

//	public void testSetBody() {
//		//a.setBody(setRect);
//		assertEquals(setRect, a.getBody());
//	}
	
	@Test
	public void testgetRange() {
		assertEquals(range, a.getRange());
	}
	
	@Test
	public void testsetRange() {
		a.setRange(newRange);
		assertEquals(newRange, a.getRange());
	}
	
	@Test
	public void testgetSize() {
		assertEquals(center, a.getSize());
	}


	@Test
	public void testMove() {
		
	}
}
