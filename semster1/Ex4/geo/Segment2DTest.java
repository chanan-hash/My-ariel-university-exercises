package Exe.Ex4.geo;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

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
		
		seg.move(p3);
		
		assertEquals(seg.getP0().x(), 5);
		assertEquals(seg.getP0().y(), 14);
		assertEquals(seg.getP1().x(), 7);
		assertEquals(seg.getP1().y(), 13);
		
		
	}

}
