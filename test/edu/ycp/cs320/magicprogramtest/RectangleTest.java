package edu.ycp.cs320.magicprogramtest;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import edu.ycp.cs320.magicprogram.shared.*;

public class RectangleTest {
	// When comparing floating point values for equality, allow
	// a small "fudge factor" to account for the fact that floating
	// point arithmetic is not exact
	private static final double DELTA = 0.00001;
	
	// TODO: fields for test fixture objects
	private Rectangle fiveByFourAtOrigin;
	private Rectangle rectangle2;
	private Point offset;
	
	@Before
	public void setUp() {
		// TODO: create test fixture objects
		fiveByFourAtOrigin = new Rectangle(new Point(0.0, 0.0), 5.0, 4.0);
		rectangle2 = new Rectangle(new Point(1.0, 2.0), 3.0, 4.0);
		offset = new Point(1,1);
	}
	
	@Test
	public void testGetWidth() {
		assertEquals(5.0, fiveByFourAtOrigin.getWidth(), DELTA);
		assertEquals(3.0, rectangle2.getWidth(), DELTA);
	}
	
	@Test
	public void testGetHeight() {
		assertEquals(4.0, fiveByFourAtOrigin.getHeight(), DELTA);
		assertEquals(4.0, rectangle2.getHeight(), DELTA);
	}
	
	@Test
	public void testGetTopLeft() {
//		x and y cases for 5x4
		assertEquals(0, fiveByFourAtOrigin.getTopLeft().x, DELTA);
		assertEquals(0, fiveByFourAtOrigin.getTopLeft().y, DELTA);
//		x and y cases for rectangle2
		assertEquals(1, rectangle2.getTopLeft().x, DELTA);
		assertEquals(2, rectangle2.getTopLeft().y, DELTA);
	}
	
	@Test
	public void testSetWidth() throws Exception {
		rectangle2.setWidth(10);
		assertEquals(10, rectangle2.getWidth(), DELTA);
		fiveByFourAtOrigin.setWidth(20);
		assertEquals(20, fiveByFourAtOrigin.getWidth(), DELTA);
	}
	
	@Test
	public void testSetHeight() throws Exception {
		rectangle2.setHeight(20);
		assertEquals(20, rectangle2.getHeight(), DELTA);
		fiveByFourAtOrigin.setHeight(10);
		assertEquals(10, fiveByFourAtOrigin.getHeight(), DELTA);
	}
	
	@Test
	public void testSetTopLeft() throws Exception {
		rectangle2.setTopLeft(offset);
		assertEquals(1, rectangle2.getTopLeft().x, DELTA);
		assertEquals(1, rectangle2.getTopLeft().y, DELTA);
		fiveByFourAtOrigin.setTopLeft(offset);
		assertEquals(1, fiveByFourAtOrigin.getTopLeft().x, DELTA);
		assertEquals(1, fiveByFourAtOrigin.getTopLeft().y, DELTA);
	}
	
	@Test
	public void testOverlapsEasyCases() throws Exception {
		Circle doesOverlap = new Circle(new Point(3.0, -0.8), 1.0);
		Circle doesNotOverlap = new Circle(new Point(-1.2, 2.0), 1.0);
		
		assertTrue(fiveByFourAtOrigin.overlaps(doesOverlap));
		assertFalse(fiveByFourAtOrigin.overlaps(doesNotOverlap));
	}
	
	@Test
	public void testOverlapsHardCase() throws Exception {
		Circle doesNotOverlap = new Circle(new Point(-0.9, -0.9), 1.0);
		
		assertFalse(fiveByFourAtOrigin.overlaps(doesNotOverlap));
	}
}
