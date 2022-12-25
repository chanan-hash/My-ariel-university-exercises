package Exe.Ex4.geo;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

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
			boolean isContains = c.contains(p3);
			assertEquals(true, isContains);

			double area = 81.68812686; 
			assertEquals(c.area(), area, 0.01);

			double peri = 32.039188;
			assertEquals(c.perimeter(),peri,0.01);
			
			c.scale(p1, 0.9);
			assertEquals(c.getRadius(), 4.58927563,0.01);
	}
}
