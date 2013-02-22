package edu.ycp.cs320.magicprogramtest;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import edu.ycp.cs320.magicprogram.shared.*;

public class PointTest {
	// When comparing floating point values for equality, allow
	// a small "fudge factor" to account for the fact that floating
	// point arithmetic is not exact
	private static final double DELTA = 0.00001;
	
	// test fixture objects
	private Point origin;
	private Point p2;
	private Point p3;
	
	@Before
	public void setUp() {
		// create test fixture objects
		origin = new Point(0.0, 0.0);
		p2 = new Point(3.0, 4.0);
		p3 = new Point(-5.0, -12.0);
	}
	
	@Test
	public void testGetX() throws Exception {
		assertEquals(0.0, origin.getX(), DELTA);
		assertEquals(3.0, p2.getX(), DELTA);
		assertEquals(-5.0, p3.getX(), DELTA);
	}
	
	@Test
	public void testGetY() throws Exception {
		assertEquals(0.0, origin.getY(), DELTA);
		assertEquals(4.0, p2.getY(), DELTA);
		assertEquals(-12.0, p3.getY(), DELTA);
	}
	
	@Test
	public void testDistanceTo() throws Exception {
		assertEquals(5.0, origin.distanceTo(p2), DELTA);
		assertEquals(5.0, p2.distanceTo(origin), DELTA);
		assertEquals(13.0, origin.distanceTo(p3), DELTA);
		assertEquals(13.0, p3.distanceTo(origin), DELTA);
	}
}
