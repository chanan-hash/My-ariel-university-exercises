package Exe.Ex4.Tests;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import Exe.Ex4.geo.GeoShapeable;
import Exe.Ex4.geo.Point2D;
import Exe.Ex4.geo.Segment2D;

class Segment2DTest {

	Segment2D seg = null;
	@Test
	void testCointains() {

		Point2D p0 = new Point2D(1,9); 
		Point2D p1 = new Point2D(3,8); 
		Point2D p2 = new Point2D(2,8.5); // The point to be checked; 
		Point2D p3 = new Point2D(4,5);
		
		seg = new Segment2D(p0, p1);
		boolean is = seg.contains(p2);
		boolean isNot = seg.contains(p3);
		
		assertEquals(true, is);
		assertNotEquals(true, isNot);
		
		double peri = (2.236067977)*2; // sqrt of 5
		assertEquals(seg.perimeter(), peri,0.01);		
		
		//Copy
		GeoShapeable seg2 = seg.copy();
		
		assertArrayEquals(seg2.getPoints(),seg.getPoints());
		
		seg.move(p3);
		
		assertEquals(seg.getP0().x(), 5);
		assertEquals(seg.getP0().y(), 14);
		assertEquals(seg.getP1().x(), 7);
		assertEquals(seg.getP1().y(), 13);
		
		// Scale
		Point2D pscale = new Point2D(3,4);
		seg.scale(pscale, 1.1);
		
		assertEquals(seg.getP0().x(), 5.2,0.001);
		assertEquals(seg.getP0().y(), 15,0.001);
		assertEquals(seg.getP1().x(), 7.4,0.001);
		assertEquals(seg.getP1().y(), 13.9,0.001);
		
		// Rotate
		Point2D protate = new Point2D(2,1);
		double angle = p1.angleFromPoints(protate);

		seg.rotate(protate, angle);
		assertEquals(seg.getP0().x(), 5.61,0.01);
		assertEquals(seg.getP0().y(), 14.9,0.01);
		assertEquals(seg.getP1().x(), 7.79,0.01);
		assertEquals(seg.getP1().y(), 13.74,0.01);
		
	}

}
