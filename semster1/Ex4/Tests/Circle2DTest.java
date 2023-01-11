package Exe.Ex4.Tests;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

import Exe.Ex4.geo.Circle2D;
import Exe.Ex4.geo.GeoShapeable;
import Exe.Ex4.geo.Point2D;

/**
 * 
 * @author Michael Id - 206917908
 * @author Chanan Id -  209324102 
 *
 */

class Circle2DTest {

	Circle2D c = null;

	@Test
	// testing the whole class functions
	void testCircle2D() {
			Point2D p1 = new Point2D(3,4);
			Point2D p2 = new Point2D(8,5);
			double rad = p1.distance(p2);

			c = new Circle2D(p1, rad);

			Point2D p3 = new Point2D(6,3);
			System.out.println(rad);
			
			// toString
			String str = "Circle2D,3.0,4.0,5.0990195135927845";
			assertEquals(str, c.toString());

			// Copy
			GeoShapeable c2 = c.copy();
			
			assertEquals(c2.getPoints()[0],c.getPoints()[0]);
			assertEquals(c2.getPoints()[1], c.getPoints()[1]);
			
			boolean isContains = c.contains(p3);
			assertEquals(true, isContains);

			double area = 81.68812686; 
			assertEquals(c.area(), area, 0.01);

			double peri = 32.039188;
			assertEquals(c.perimeter(),peri,0.01);
			
			//Scale
			c.scale(p1, 0.9);
			assertEquals(c.getRadius(), 4.58927563,0.01);
			
			// Move
			c.move(new Point2D(2,4));
			assertEquals(c.getPoints()[0], new Point2D(5,8));
			
			//Rotate
			Point2D rot = new Point2D(4,7);
			double angle = p1.angleFromPoints(rot);
			c.rotate(rot, angle);
			
			assertEquals(c.getPoints()[0].x(), 4.97,0.01);
			assertEquals(c.getPoints()[0].y(), 8.02 ,0.01);
			
	}
}
