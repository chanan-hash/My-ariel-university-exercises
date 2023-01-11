package Exe.Ex4.Tests;

import static org.junit.jupiter.api.Assertions.*;

import java.awt.Color;

import org.junit.jupiter.api.Test;

import Exe.Ex4.GUIShape;
import Exe.Ex4.GUI_Shapeable;
import Exe.Ex4.ShapeCollectionable;
import Exe.Ex4.geo.Circle2D;
import Exe.Ex4.geo.GeoShapeable;
import Exe.Ex4.geo.Point2D;
import Exe.Ex4.geo.Segment2D;
import Exe.Ex4.geo.Triangle2D;
import Exe.Ex4.gui.Ex4;

/**
 * 
 * @author Michael Id - 206917908
 * @author Chanan Id -  209324102 
 *
 */


class Ex4Test {

	Ex4 object;  // The object of the class

	@Test
	void testAtionPerform() {
		object = Ex4.getInstance();
		ShapeCollectionable collection = null; 

		object.init(collection);

		collection = object.getShape_Collection();

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


		// The collection for Ex4
		collection.add(gs1);
		collection.add(gs2);
		collection.add(gs3);
		collection.add(gs4);
		collection.add(gs5);

		// Sort calling testing
		object.actionPerformed("ByArea");

		for (int i = 0; i<collection.size()-1; i++) {
			assertTrue(collection.get(i).getShape().area() <=collection.get(i+1).getShape().area() );
		}

		object.actionPerformed("ByAntiArea");
		for (int i = 0; i<collection.size()-1; i++) {
			assertTrue(collection.get(i).getShape().area() >=collection.get(i+1).getShape().area() );
		}

		object.actionPerformed("ByPerimeter");
		for (int i = 0; i<collection.size()-1; i++) {
			assertTrue(collection.get(i).getShape().perimeter() <= collection.get(i+1).getShape().perimeter());
		}

		object.actionPerformed("ByAntiPerimeter");
		for (int i = 0; i<collection.size()-1; i++) {
			assertTrue(collection.get(i).getShape().perimeter() >= collection.get(i+1).getShape().perimeter());
		}

		object.actionPerformed("ByTag");
		for (int i = 0; i<collection.size()-1; i++) {
			assertTrue(collection.get(i).getTag() <= collection.get(i+1).getTag());
		}

		object.actionPerformed("ByAntiTag");
		for (int i = 0; i<collection.size()-1; i++) {
			assertTrue(collection.get(i).getTag() >= collection.get(i+1).getTag());
		}

		
		
		// Test the None --> all shapes supposed to be isSelected = false
		object.actionPerformed("None");
		for (int i = 0; i<collection.size()-1; i++) {
			assertTrue(!collection.get(i).isSelected());
		}

		// Test the None --> all shapes supposed to be isSelected = True
		object.actionPerformed("All");
		for (int i = 0; i<collection.size()-1; i++) {
			assertTrue(collection.get(i).isSelected());
		}

		// Test info
		String str2 = object.getInfo();
		String str3 = "GUIShape,-256,true,4,Triangle2D,8.0,9.0,14.0,6.0,11.0,3.0\n"
				+ "GUIShape,-16711936,false,3,Triangle2D,15.0,6.0,8.0,3.0,7.0,2.0\n"
				+ "GUIShape,-65536,true,2,Segment2D,8.0,7.0,9.0,10.0\n"
				+ "GUIShape,-16777216,false,1,Segment2D,4.0,3.0,5.0,6.0\n"
				+ "GUIShape,-16776961,true,0,Circle2D,1.0,2.0,5.0\n";
		assertEquals(str2, str3);
		
		object.actionPerformed("Remove");
		
		//Test Remove
		// Because all shapes are selected so we will remove all so the size of the collection supposed to be 0
		
		assertEquals(0, collection.size());
		
		
	}

}
