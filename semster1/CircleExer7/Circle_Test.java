package CircleExer7;

import static org.junit.Assert.*;
import org.junit.Test;

public class Circle_Test {
	Circle c = new Circle();
	Circle c2 = new Circle(6);
	Circle c3 = new Circle(7,"blue");
	DoubleCircle dc = new DoubleCircle(c,c2);
	DoubleCircle dc2 = new DoubleCircle(c2,c3);
	
	@Test
	public void test_constructors() {
		double r = c.getRadius();
		double r2 = c2.getRadius();
		c3.setRadius(5);
		assertEquals(r, 1.0,0);
		assertEquals(r2, 6,0);
		assertNotEquals(r2, 1,0);
		assertNotEquals(c, c2);
		boolean b = r>0; 		// the radius is not negative
		assertEquals(b, true);
		assertEquals(c3.getRadius(), 5,0);

	}
	
	// test for area
	@Test
	public void testArea() {
	double area = c.getArea();
	double area2 = c2.getArea();
	assertEquals(area, Math.PI,0);
	assertEquals(area2, 6*6*Math.PI,0);
	assertNotEquals(area, area2);
	}
	
	@Test
	public void testNewConstructor() {
	String s = c.getColor();
	String st = c3.getColor();
	assertEquals(s, "red");
	assertEquals(st, "blue");
	c2.setColor("green");
	System.out.println(c2.getColor());
	assertEquals(c2.getColor(), "green");
	}	
	
	@Test 
	public void testDoubleCircle() {
		double bigR = dc.bigR();
		assertEquals(bigR, 2,0);
		assertNotEquals(bigR, 1,0);
		boolean b = dc.isColorEqual();
		boolean b2 = dc2.isColorEqual();
		System.out.println(c.getColor() +" ," + c2.getColor()); // it didn't change the color of c2 from the previous test because every test is separate memory
		assertEquals(b, true);
		assertNotEquals(b, false);
		assertEquals(b2,false);
	
	}
	
}
