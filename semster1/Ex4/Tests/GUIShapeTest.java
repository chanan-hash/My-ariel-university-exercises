package Exe.Ex4.Tests;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.awt.Color;
import java.util.ArrayList;

import org.junit.jupiter.api.Test;

import Exe.Ex4.GUIShape;
import Exe.Ex4.geo.Circle2D;
import Exe.Ex4.geo.GeoShapeable;
import Exe.Ex4.geo.Point2D;
import Exe.Ex4.geo.Polygon2D;
import Exe.Ex4.geo.Segment2D;

class GUIShapeTest {

	private ArrayList<Point2D> arrayOfPoints = new ArrayList<Point2D>();
	GeoShapeable _g = null;
	GUIShape gs = null;
	
	/**
	 *	We are checking here few shapes   
	 */
	
	@Test
	public void testInit() {
		
		// Test Circle
		String str = "GUIShape,-16777216,true,1,Circle2D,3.0,4.0,2.0"; // A circle data 
		String [] ww = str.split(",");
		
		assertEquals(ww[2], "true");
		gs = new GUIShape(str);
		
		Circle2D c = new Circle2D(new Point2D(3,4),2);
		
		assertEquals(gs.getShape().getPoints()[0], c.getPoints()[0]);
		assertEquals(gs.getColor().getRGB(),Color.BLACK.getRGB());	
		
		// Test Segment
		String str1 = "GUIShape,-16777216,true,1,Segment2D,3.0,3.0,7.0,7.0"; // A segment data 
		String [] ww1 = str.split(",");
		assertEquals(ww1[2], "true");
		gs = new GUIShape(str1);
		
		Segment2D s = new Segment2D(new Point2D(3,3),new Point2D(7,7));
		
		assertEquals(gs.getShape().getPoints()[0], s.getPoints()[0]);
		assertEquals(gs.getColor().getRGB(),Color.BLACK.getRGB());	
	
		// Polygon test
		String str2 = "GUIShape,-16777216,true,2,Polygon2D,1,2,2.0,7.0,7.0,7.0,4.0,4.0,8.0,4.0"; // A polygon data 
		String [] ww2 = str.split(",");
		assertEquals(ww2[2], "true");
		
		gs = new GUIShape(str2);
		
		arrayOfPoints.add(new Point2D(1,2));
		arrayOfPoints.add(new Point2D(2,7));
		arrayOfPoints.add(new Point2D(7,7));
		arrayOfPoints.add(new Point2D(4,4));		
		arrayOfPoints.add(new Point2D(8,4));
		
		Polygon2D p = new Polygon2D(arrayOfPoints);
		for (int i = 0; i<arrayOfPoints.size(); i++) {
			assertEquals(gs.getShape().getPoints()[0],p.getPoints()[0]);
		}
		assertEquals(gs.getColor().getRGB(),Color.BLACK.getRGB());	
				
	}
}
