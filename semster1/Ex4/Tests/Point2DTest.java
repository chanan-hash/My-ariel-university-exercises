package Exe.Ex4.Tests;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

import Exe.Ex4.geo.Point2D;

class Point2DTest {

/**
 * This test will check rotate an sale function for Point2D calss 	
 */
	
	@Test
	void testScale_Rotate() {
		Point2D p1 = new Point2D (1,6);
		Point2D p2 = new Point2D (5,7);
		Point2D cen = new Point2D (2,3); 
		
		p1.scale(cen, 0.9); // Ratio 0.9
		p2.scale(cen, 1.1); // Ratio 1.1
		
		assertEquals(p1.x(), 1.1, 0.001);
		assertEquals(p1.y(), 5.7, 0.001);
		
		assertEquals(p2.x(), 5.3, 0.001);
		assertEquals(p2.y(), 7.4, 0.001);
		
		
		Point2D p3 = new Point2D (1,6);
		Point2D p4 = new Point2D (5,7);
		Point2D center = new Point2D (2,3); 
		
		double angle = p3.angleFromPoints(center);
		double angle2 = p4.angleFromPoints(center);
		
		p3.rotate(center, angle);
		p4.rotate(center, angle2);
		
		assertEquals(p3.x(), 1.06, 0.01);
		assertEquals(p3.y(), 6.02, 0.01);
		
		assertEquals(p4.x(), 5.15, 0.01);
		assertEquals(p4.y(), 6.88, 0.01);
		                     
	}

}
