package Exe.Ex4.geo;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

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
		
		Point2D pIn = new Point2D(2,1);
		boolean isIn = tri.contains(pIn);
	
		assertEquals(true, isIn);
	}

}
