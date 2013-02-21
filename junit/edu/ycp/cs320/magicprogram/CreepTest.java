package edu.ycp.cs320.magicprogram;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;

import java.util.Arrays;

import org.junit.Before;
import org.junit.Test;

import edu.ycp.cs320.SHARED.Creep;
import edu.ycp.cs320.SHARED.Point;
import edu.ycp.cs320.SHARED.Rectangle;

public class CreepTest {

	Rectangle testBody;
	Creep myCreep;
	
	public void setUp() {
		testBody = new Rectangle(new Point(1,1), 5);
		myCreep = new Creep(testBody.getTopLeft(), 5);
	}
	
	@Test
	public void testgetBody() throws Exception {
		Rectangle body = myCreep.getBody();
		assertEquals(testBody, body);
	}
	
}
