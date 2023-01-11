package Exe.Ex4.Tests;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import Exe.Ex4.geo.GeoShapeable;
import Exe.Ex4.geo.Point2D;
import Exe.Ex4.geo.Rect2D;

/**
 * 
 * @author Michael Id - 206917908
 * @author Chanan Id -  209324102 
 *
 */


class Rect2DTest {

	Rect2D rec = null;
	
	
	@Test
	void testRect2D() {
	
	// Like a Polygon the order of the point is important so we won't get a intersect polygon
	Point2D p1 = new Point2D(0,0);
	Point2D p2 = new Point2D(0,5);
	Point2D p3 = new Point2D(5,5);
	Point2D p4 = new Point2D(5,0);
	
	rec = new Rect2D(p1, p2,p3,p4);
	
	double area = 25;
	double perimeter = 20;
	
	// Area & Perimeter
	assertEquals(area, rec.area(), 0.01);
	assertEquals(20, rec.perimeter(),0.01);
	
	// Contains
	Point2D pIn = new Point2D(2,2.5);
	boolean isin = rec.contains(pIn);
	assertTrue(isin);
	
	// toString
	String str ="Rect2D,0.0,0.0,0.0,5.0,5.0,5.0,5.0,0.0";
	assertEquals(str, rec.toString());
	
	
	// Move
	rec.move(new Point2D(2,6));
	
	assertEquals(rec.getPoints()[0], new Point2D(2,6));
	assertEquals(rec.getPoints()[1], new Point2D(2,11));
	assertEquals(rec.getPoints()[2], new Point2D(7,11));
	assertEquals(rec.getPoints()[3], new Point2D(7,6));
	
	// Copy
	GeoShapeable retc2 = rec.copy();
	assertEquals(retc2.getPoints()[0], new Point2D(2,6));
	assertEquals(retc2.getPoints()[1], new Point2D(2,11));
	assertEquals(retc2.getPoints()[2], new Point2D(7,11));
	assertEquals(retc2.getPoints()[3], new Point2D(7,6));
	
	// Scale
	Point2D pscale = new Point2D(4,8);
	rec.scale(pscale, 1.1);
	
	assertEquals(rec.getPoints()[0].x(), 1.8,0.01);
	assertEquals(rec.getPoints()[0].y(), 5.8,0.01);
	assertEquals(rec.getPoints()[1].x(), 1.8,0.01);
	assertEquals(rec.getPoints()[1].y(), 11.3,0.01);
	assertEquals(rec.getPoints()[2].x(), 7.3,0.01);
	assertEquals(rec.getPoints()[2].y(), 11.3,0.01);
	assertEquals(rec.getPoints()[3].x(), 7.3,0.01);
	assertEquals(rec.getPoints()[3].y(), 5.8,0.01);	          
		     

	// Rotate
	Point2D protate = new Point2D(2,1);
	double angle = p1.angleFromPoints(protate);

	rec.rotate(protate, angle);
	
	assertEquals(rec.getPoints()[0].x(), 1.76,0.01);
	assertEquals(rec.getPoints()[0].y(), 5.8,0.01);
	assertEquals(rec.getPoints()[1].x(), 1.71,0.01);
	assertEquals(rec.getPoints()[1].y(), 11.3,0.01);
	assertEquals(rec.getPoints()[2].x(), 7.21,0.01);
	assertEquals(rec.getPoints()[2].y(), 11.35,0.01);
	assertEquals(rec.getPoints()[3].x(), 7.26,0.01);
	assertEquals(rec.getPoints()[3].y(), 5.85,0.01);	      
	}

}
