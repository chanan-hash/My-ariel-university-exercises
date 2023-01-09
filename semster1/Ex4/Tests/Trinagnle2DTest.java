package Exe.Ex4.Tests;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import Exe.Ex4.geo.GeoShapeable;
import Exe.Ex4.geo.Point2D;
import Exe.Ex4.geo.Triangle2D;

class Trinagnle2DTest {

	Triangle2D tri = null;
	
	@Test
	void test() {
		Point2D p1 = new Point2D(0,3);
		Point2D p2 = new Point2D(4,0);
		Point2D p3 = new Point2D(0,0);
		
		Triangle2D tri = new Triangle2D(p1, p2, p3);
		
		double area = tri.area();
		double peri = tri.perimeter();
		
		double dist1 = p1.distance(p2);
		
		assertEquals(6, area);
		assertEquals(12, peri);
		assertEquals(5, dist1);
		
		// Contains
		Point2D pIn = new Point2D(2,1);
		boolean isIn = tri.contains(pIn);
	
		assertEquals(true, isIn);
		
		// Move
		Point2D pmove = new Point2D(2,5);
		tri.move(pmove);
		
		assertEquals(tri.getPoints()[0], new Point2D(2,8));
		assertEquals(tri.getPoints()[1], new Point2D(6,5));
		assertEquals(tri.getPoints()[2], new Point2D(2,5));
		
		// Copy
		GeoShapeable tri2 = tri.copy();
		assertEquals(tri2.getPoints()[0], new Point2D(2,8));
		assertEquals(tri2.getPoints()[1], new Point2D(6,5));
		assertEquals(tri2.getPoints()[2], new Point2D(2,5));
		
		// Scale
		
		Point2D pscale = new Point2D(3,6);
		
		tri.scale(pscale, 0.9);
		
		assertEquals(tri.getPoints()[0], new Point2D(2.1,7.8));
		assertEquals(tri.getPoints()[1], new Point2D(5.7,5.1));
		assertEquals(tri.getPoints()[2], new Point2D(2.1,5.1));
		
		// Rotate
		Point2D protate = new Point2D(2,1);
		double angle = p1.angleFromPoints(protate);   // So we won't have a negative degree

		tri.rotate(protate, angle);
		
		assertEquals(tri.getPoints()[0].x(), 2.2,0.01);
		assertEquals(tri.getPoints()[0].y(), 7.8, 0.01);
		
		assertEquals(tri.getPoints()[1].x(), 5.75, 0.01);
		assertEquals(tri.getPoints()[1].y(), 5.04, 0.01);
		
		assertEquals(tri.getPoints()[2].x(), 2.15, 0.01);
		assertEquals(tri.getPoints()[2].y(), 5.1, 0.01);
	}

}
