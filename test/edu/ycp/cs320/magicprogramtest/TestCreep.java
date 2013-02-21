package edu.ycp.cs320.magicprogramtest;

import static junit.framework.Assert.*;
import org.junit.Before;
import org.junit.Test;

import edu.ycp.cs320.magicprogram.shared.*;


public class TestCreep {
	private Creep a;
	private Creep b;
	
	@Before
	public void setUp() {
		a = new Creep(new Point(), 1, 1);
		b = new Creep(new Point(5, 3), 5, 2);
	}
	
	@Test
	public void testGetBody() {
		Rectangle ta = new Rectangle(new Point(), 1);
		assertEquals(0.0, );
	}
}
