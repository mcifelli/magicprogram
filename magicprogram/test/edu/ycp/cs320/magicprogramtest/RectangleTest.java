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
		assertEquals(0, fiveByFourAtOrigin.getTopLeft().getX(), DELTA);
		assertEquals(0, fiveByFourAtOrigin.getTopLeft().getY(), DELTA);
//		x and y cases for rectangle2
		assertEquals(1, rectangle2.getTopLeft().getX(), DELTA);
		assertEquals(2, rectangle2.getTopLeft().getY(), DELTA);
	}
	
	@Test
	public void testGetBotRight() {
//		x and y cases for 5x4
		assertEquals(5, fiveByFourAtOrigin.getBotRight().getX(), DELTA);
		assertEquals(4, fiveByFourAtOrigin.getBotRight().getY(), DELTA);
//		x and y cases for rectangle2
		assertEquals(4, rectangle2.getBotRight().getX(), DELTA);
		assertEquals(6, rectangle2.getBotRight().getY(), DELTA);
	}
	
	@Test
	public void testGetTopRight() {
//		x and y cases for 5x4
		assertEquals(5, fiveByFourAtOrigin.getTopRight().getX(), DELTA);
		assertEquals(0, fiveByFourAtOrigin.getTopRight().getY(), DELTA);
//		x and y cases for rectangle2
		assertEquals(4, rectangle2.getTopRight().getX(), DELTA);
		assertEquals(2, rectangle2.getTopRight().getY(), DELTA);
	}
	
	@Test
	public void testGetBotLeft() {
//		x and y cases for 5x4
		assertEquals(0, fiveByFourAtOrigin.getBotLeft().getX(), DELTA);
		assertEquals(4, fiveByFourAtOrigin.getBotLeft().getY(), DELTA);
//		x and y cases for rectangle2
		assertEquals(1, rectangle2.getBotLeft().getX(), DELTA);
		assertEquals(6, rectangle2.getBotLeft().getY(), DELTA);
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
		assertEquals(1, rectangle2.getTopLeft().getX(), DELTA);
		assertEquals(1, rectangle2.getTopLeft().getY(), DELTA);
		fiveByFourAtOrigin.setTopLeft(offset);
		assertEquals(1, fiveByFourAtOrigin.getTopLeft().getX(), DELTA);
		assertEquals(1, fiveByFourAtOrigin.getTopLeft().getY(), DELTA);
	}
	
	@Test
	public void testOverlapsCaseA() throws Exception {
		Rectangle doesOverlapA = new Rectangle(new Point(3, 3), 4, 4);

		assertTrue(fiveByFourAtOrigin.overlaps(doesOverlapA));
	}
	
	@Test
	public void testOverlapsCaseB() throws Exception {
		Rectangle doesOverlapB = new Rectangle(new Point(-4, -4), 4, 4);

		assertTrue(fiveByFourAtOrigin.overlaps(doesOverlapB));
	}
	
	@Test
	public void testOverlapsCaseC() throws Exception {
		Rectangle doesOverlapC = new Rectangle(new Point(-4, 3), 4, 4);

		assertTrue(fiveByFourAtOrigin.overlaps(doesOverlapC));
	}
	
	@Test
	public void testOverlapsCaseD() throws Exception {
		Rectangle doesOverlapD = new Rectangle(new Point(3, -4), 4, 4);

		assertTrue(fiveByFourAtOrigin.overlaps(doesOverlapD));
	}
	
	@Test
	public void testOverlapsNot() throws Exception {
		Rectangle doesNotOverlap = new Rectangle(new Point(6, 3), 4, 4);
	
		assertFalse(fiveByFourAtOrigin.overlaps(doesNotOverlap));
	}
	
	@Test
	public void testOverlapsHardCase() throws Exception {
		Rectangle doesOverlap = new Rectangle(new Point(5, 4), 1.0);
		
		assertTrue(fiveByFourAtOrigin.overlaps(doesOverlap));
	}
}
