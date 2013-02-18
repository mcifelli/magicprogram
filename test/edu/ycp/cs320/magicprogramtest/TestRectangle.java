package edu.ycp.cs320.magicprogramtest;

import static junit.framework.Assert.*;
import org.junit.Before;
import org.junit.Test;

import edu.ycp.cs320.magicprogram.Point;
import edu.ycp.cs320.magicprogram.Rectangle;


public class TestRectangle {
	private Rectangle a;
	private Rectangle b;
	
	@Before
	public void setUp() {
		a = new Rectangle(new Point(), 1, 2);
		b = new Rectangle(new Point(3, 4), 5, 6);
	}
	
	@Test
	public void testGetTopLeft() {
		
	}
}
