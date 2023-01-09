package Exe.Ex4.Tests;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;

import org.junit.jupiter.api.Test;

import Exe.Ex4.geo.GeoShapeable;
import Exe.Ex4.geo.Point2D;
import Exe.Ex4.geo.Polygon2D;

class Polygon2DTest {

	ArrayList<Point2D> parr = new ArrayList<Point2D>();
	
	@Test
	void testPolygon() {
		
		// Creating a simple polygon
		Point2D p1 = new Point2D (0,0);  
		Point2D p2 = new Point2D (0,5);  
		Point2D p3 = new Point2D (5,5);  
		Point2D p4 = new Point2D (5,0);  
		
		parr.add(p1);
		parr.add(p2);
		parr.add(p3);
		parr.add(p4);
		
		Polygon2D poly = new Polygon2D(parr);
		double peri = poly.perimeter();
		
		assertEquals(20, peri, 0.01);
	
		double area = poly.area();
		assertEquals(25, area);
		
		Point2D p5 = new Point2D(2.5,2.5);
		boolean isIn = poly.contains(p5);
		assertEquals(true, isIn);
		
		// Copy
		GeoShapeable pol2 = poly.copy();
		// Checking if the point are equal;
		for (int i = 0; i< parr.size(); i++) {
			assertEquals(pol2.getPoints()[i], poly.getPoints()[i]);
		}
		
		// Changing the order of the points, that will create another polygon
		parr.removeAll(parr);
		parr.add(p1);
		parr.add(p2);
		parr.add(p4);
		parr.add(p3);
		
		System.out.println(parr);
		Polygon2D poly2 = new Polygon2D(parr);
		
		Point2D p6 = new Point2D(2.5,1);
		Point2D p7 = new Point2D(4,3);
		
		boolean isIn2 = poly2.contains(p6);
		
		assertEquals(false, isIn2);
		assertEquals(true, poly2.contains(p7));
	
		//Scale - we will check few points to see if the scale worked
		Point2D cen = new Point2D (2,3);
		poly.scale(cen, 0.9);
		
		Point2D p0 = poly.getPoints()[0];
		Point2D p0_1 = new Point2D(0.2,0.3);
		
		Point2D p3_1 = poly.getPoints()[3];
		Point2D p3_2 = new Point2D(4.7,0.3);
		
		
		assertEquals(p0.x(),p0_1.x(),0.01);
		assertEquals(p0.y(),p0_1.y(),0.01);
		
		assertEquals(p3_1.x(),p3_2.x(),0.01);
		assertEquals(p3_1.y(),p3_2.y(),0.01);
		
		
		//Rotate - we will check few points to see if the scale worked
		Point2D protate = new Point2D(2,1);
		double angle = p1.angleFromPoints(protate);
		poly.scale(protate, angle);
		
		Point2D p1_1 = new Point2D(poly.getPoints()[1]);
		Point2D p1_2 = new Point2D(1.16,2.76);
		
		Point2D p2_1 = new Point2D(poly.getPoints()[2]);
		Point2D p2_2 = new Point2D(3.25,2.76);
	
		assertEquals(p1_1.x(),p1_2.x(),0.01);
		assertEquals(p1_1.y(),p1_2.y(),0.01);
		
		assertEquals(p2_1.x(),p2_2.x(),0.01);
		assertEquals(p2_1.y(),p2_2.y(),0.01);
		
	}

}
