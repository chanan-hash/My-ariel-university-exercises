package Exe.Ex4.geo;

import static org.junit.Assert.*;

import org.junit.Test;

public class Polygon2DTest {

	Polygon2D polygon_test = null;
	@Test
	public void testAdd() {
		// checking if the add function works
		polygon_test = new Polygon2D(); //five places
		Point2D p1 = new Point2D(1,2);
		polygon_test.add(p1);
		Point2D[] parr = polygon_test.getPoints();
		assertEquals(1, parr.length);
		assertEquals(p1, parr[0]);

		// reset object
		polygon_test = new Polygon2D(); //five places
		Point2D[] parr2 = new Point2D[6];
		for (int i = 0; i<parr2.length;i++) {
			parr2[i] = new Point2D(i,0);
			polygon_test.add(parr2[i]);
		}
		
		parr = polygon_test.getPoints();
		assertEquals(6, parr.length);
		for (int i = 0; i<parr2.length;i++) {
			assertEquals(parr2[i], parr[i]);
		}
	}

}
