package Exe.Ex4.Tests;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.awt.Color;
import java.io.File;
import java.util.ArrayList;

import org.junit.jupiter.api.Test;

import Exe.Ex4.Ex4_Const;
import Exe.Ex4.GUIShape;
import Exe.Ex4.GUI_Shapeable;
import Exe.Ex4.ShapeCollection;
import Exe.Ex4.geo.Circle2D;
import Exe.Ex4.geo.GeoShapeable;
import Exe.Ex4.geo.Point2D;
import Exe.Ex4.geo.Rect2D;
import Exe.Ex4.geo.Segment2D;
import Exe.Ex4.geo.ShapeComp;
import Exe.Ex4.geo.Triangle2D;

/**
 * 
 * @author Michael Id - 206917908
 * @author Chanan Id -  209324102 
 *
 */


class ShapeCollectionTest {

	private ArrayList <GUI_Shapeable> shapes = new ArrayList<GUI_Shapeable>();

	/*
	 * We will create shapes and add them to arrayList
	 */

	@Test
	void test() {

		// For the Circle
		Point2D p1 = new Point2D(1,2);

		// For the Segment
		Point2D p2 = new Point2D(4,3);
		Point2D p3 = new Point2D(5,6);
		Point2D p4 = new Point2D(8,7);
		Point2D p5 = new Point2D(9,10);

		// For the Triangle
		Point2D p6 = new Point2D(15,6);
		Point2D p7 = new Point2D(8,3);
		Point2D p8 = new Point2D(7,2);
		Point2D p9 = new Point2D(8,9);
		Point2D p10 = new Point2D(14,6);
		Point2D p11 = new Point2D(11,3);

		double rad = 5;

		GeoShapeable c = new Circle2D(p1, rad);

		GeoShapeable seg = new Segment2D(p2,p3);
		GeoShapeable seg2 = new Segment2D(p4,p5);

		GeoShapeable tri = new Triangle2D(p6,p7,p8);
		GeoShapeable tri2 = new Triangle2D(p9,p10,p11);


		GUI_Shapeable gs1 = new GUIShape(c,true,Color.BLUE,0);
		GUI_Shapeable gs2 = new GUIShape(seg,false,Color.BLACK,1);
		GUI_Shapeable gs3 = new GUIShape(seg2,true,Color.RED,2);
		GUI_Shapeable gs4 = new GUIShape(tri,false,Color.GREEN,3);
		GUI_Shapeable gs5 = new GUIShape(tri2,true,Color.YELLOW,4);

		shapes.add(gs1);
		shapes.add(gs2);
		shapes.add(gs3);
		shapes.add(gs4);
		shapes.add(gs5);


		ShapeCollection coll = new ShapeCollection();

		coll.add(gs1);
		coll.add(gs2);
		coll.add(gs3);
		coll.add(gs4);
		coll.add(gs5);

		ShapeCollection coll2 = (ShapeCollection) coll.copy();
		assertEquals(coll2.size(),coll.size());

		for (int i = 0; i<coll.size(); i++) {
			// Checking some of the qualities
			assertEquals(coll.get(i).getShape().getPoints()[0], coll2.get(i).getShape().getPoints()[0]);
			assertEquals(coll.get(i).getShape().area(), coll2.get(i).getShape().area());
			assertEquals(coll.get(i).getShape().perimeter(), coll2.get(i).getShape().perimeter());
		}
		
		// Test area sort comp
		shapes.sort(new ShapeComp(Ex4_Const.Sort_By_Area));
		for (int i = 0; i<coll.size()-1; i++) {
			boolean big = (shapes.get(i).getShape().area()) <= (shapes.get(i+1).getShape().area());
			assertTrue(big);
		}

		// Test anti area sort comp		
		shapes.sort(new ShapeComp(Ex4_Const.Sort_By_Anti_Area));
		for (int i = 0; i<coll.size()-1; i++) {
			boolean small = (shapes.get(i).getShape().area()) >= (shapes.get(i+1).getShape().area());
			assertTrue(small);
		}

		// Test tag sort comp		
		shapes.sort(new ShapeComp(Ex4_Const.Sort_By_Tag));
		for (int i = 0; i<coll.size()-1; i++) {
			boolean bigtag = (shapes.get(i).getTag()) <= (shapes.get(i+1).getTag());
			assertTrue(bigtag);
		}

		// Test anti tag sort comp		
		shapes.sort(new ShapeComp(Ex4_Const.Sort_By_Anti_Tag));
		for (int i = 0; i<coll.size()-1; i++) {
			boolean smalltag = (shapes.get(i).getTag()>= (shapes.get(i+1).getTag()));
			assertTrue(smalltag);
		}

		// Test perimeter sort comp		
		shapes.sort(new ShapeComp(Ex4_Const.Sort_By_Perimeter));
		for (int i = 0; i<coll.size()-1; i++) {
			boolean bigperi = (shapes.get(i).getShape().perimeter()) <= (shapes.get(i+1).getShape().perimeter());
			assertTrue(bigperi);
		}

		// Test anti perimeter sort comp		
		shapes.sort(new ShapeComp(Ex4_Const.Sort_By_Anti_Perimeter));
		for (int i = 0; i<coll.size()-1; i++) {
			boolean smallperi = (shapes.get(i).getShape().perimeter()) >= (shapes.get(i+1).getShape().perimeter());
			assertTrue(smallperi);
		}

		
		
		//Save&Load test

		// 2 \\ means directory 1 / means the file name
		coll.save("C:\\Users\\חנן\\Desktop/a6");

		//Removing all its elements
		coll.removeAll();

		// Now loading it back to the collection, and checking if the copy collection is equals to the first one
		coll.load("C:\\Users\\חנן\\Desktop/a6");
		assertEquals(coll.size(), coll2.size());
		
		// As above checking few of the qualities to see it it had been load
        for (int i = 0; i < coll.size(); ++i) {
        	assertEquals(coll.get(i).getShape().getPoints()[1], coll2.get(i).getShape().getPoints()[1]);
			assertEquals(coll.get(i).getShape().area(), coll2.get(i).getShape().area());
			assertEquals(coll.get(i).getShape().perimeter(), coll2.get(i).getShape().perimeter());
			assertEquals(coll.get(i).getTag(), coll2.get(i).getTag());
        }
        
        // Deleting the File after checking it
        new File("C:\\Users\\חנן\\Desktop/a6").delete();

       
		// BoundBox
		Rect2D boundBox = coll.getBoundingBox();
		for (int i = 0; i < coll.size(); i++) {
			GUI_Shapeable gs = coll.get(i);
			Point2D[] parr = gs.getShape().getPoints();

			for (Point2D p : parr) {
				assertEquals(false,boundBox.contains(p));
			}
		}
		
		
		//Checking the toString, we will do it as comparing the copy toString (coll2) to the Origin (coll)
		for (int i = 0; i < coll.size(); ++i) {
			assertEquals(coll.get(i).getShape().toString(), coll2.get(i).getShape().toString());			
		}
	}


}
