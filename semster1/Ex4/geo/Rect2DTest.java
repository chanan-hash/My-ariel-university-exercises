package Exe.Ex4.geo;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class Rect2DTest {

	Rect2D rec = null;
	
	
	@Test
	void test() {
	Point2D p1 = new Point2D(0,5);
	Point2D p2 = new Point2D(7,0);
	
	rec = new Rect2D(p1, p2);
	
	double area = rec.area();
	double peri = rec.perimeter();
	
	Point2D pIn = new Point2D(3,4);
	boolean isIn = rec.contains(pIn);
	
	rec.move(pIn);
	
	assertEquals(35, area);
	assertEquals(24, peri);
	assertEquals(true, isIn);
	
	Point2D pmove = new Point2D(3,9);
	Point2D pMove = new Point2D(10,4);
	
	assertEquals(rec.get_p1(), pmove);
	assertEquals(rec.get_p2(), pMove);
	
	}

}
