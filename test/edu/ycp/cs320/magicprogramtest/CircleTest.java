package edu.ycp.cs320.magicprogramtest;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import edu.ycp.cs320.magicprogram.shared.*;

public class CircleTest {
	// When comparing floating point values for equality, allow
	// a small "fudge factor" to account for the fact that floating
	// point arithmetic is not exact
	private static final double DELTA = 0.00001;
	
	// TODO: fields for text fixture objects
	private Circle atOrigin;
	private Point offset;
	
	@Before
	public void setUp() {
		// TODO: create test fixture objects
		atOrigin = new Circle(new Point(0, 0), 10.0);
		offset = new Point(1, 1);
	}
	
	// TODO: test methods
	
	@Test
	public void testGetRadius() throws Exception {
		assertEquals(10.0, atOrigin.getRadius(), DELTA);
	} 
	
	@Test
	public void testSetRadius() throws Exception {
		atOrigin.setRadius(20.0);
		assertEquals(20.0, atOrigin.getRadius(), DELTA);
	}
	
	@Test
	public void testGetCenter() throws Exception {
		assertEquals(0, atOrigin.getCenter().getX(), DELTA);
		assertEquals(0, atOrigin.getCenter().getY(), DELTA);
	}
	
	@Test
	public void setRadius()throws Exception {
		atOrigin.setCenter(offset);
		assertEquals(1, atOrigin.getCenter().getX(), DELTA);
		assertEquals(1, atOrigin.getCenter().getY(), DELTA);
	}
}
