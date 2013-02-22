package edu.ycp.cs320.magicprogramtest;

import static junit.framework.Assert.*;
import org.junit.Before;
import org.junit.Test;

import edu.ycp.cs320.magicprogram.shared.*;


public class TestCreep {
	private Creep a;
	private Creep b;
	private Rectangle testRect, setRect;
	private double range, newRange;
	private Point center, waypoint;
	
	@Before
	public void setUp() {
		testRect = new Rectangle(new Point(0, 0), 1, 1);
		setRect = new Rectangle(new Point(1, 1), 1, 1);
		a = new Creep(testRect, range, 1);
		b = new Creep(new Rectangle(new Point(5, 3), 5, 2), 2, 2);
		range = 1;
		newRange = 2;
		center = new Point(.5, .5);
		waypoint = new Point(5, 5);
	}
	
	@Test
	public void testGetBody() {
//		Rectangle ta = new Rectangle(new Point(), 1);
		assertEquals(testRect, a.getBody());
	}
	
	@Test
	public void testSetBody() {
		a.setBody(setRect);
		assertEquals(setRect, a.getBody());
	}
	
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
	public void testgetLocation() {
		assertEquals(center, a.getLocation());
	}
	
	@Test
	public void testMove() {
		
	}
}
