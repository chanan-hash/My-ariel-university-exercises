package Exe.Ex2;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;
/**
 * This JUnit class represents a very simple unit testing for Ex2.
 * This class should be improved and generalized significantly.
 * Make sure you add documentations to this Tesing class.
 * @author boaz.ben-moshe
 *
 */

class Ex2Test {
	static double[] po1={2,0,3, -1,0}, po2 = {0.1,0,1, 0.1,3};

	/**My test for equals
	 *  checking if two arrays of polynom coefficient are eqaul
	 */
	@Test
	void testIsEqual() {
		double[] pl1 = {2,4,5,6,8};
		double[] pl2 = {2,4,5,6,8};
		boolean ans = Ex2.equals(po2, po1);
		boolean ans2 = Ex2.equals(pl1, pl2);
		assertEquals(ans, false);
		assertEquals(ans2, true);
	}

	/** My test for poly
	 *  Testing a given array of coefficient to a String
	 *  expm = [1,3,4] --> 4x^2+3x+1
	 */
	@Test
	void testToString() {
		String str = "-1.0x^3+3.0x^2+2.0";
		String st = "3.0x^4+0.1x^3+1.0x^2+0.1";
		String ex2 = Ex2.poly(po1);
		String ex22 = Ex2.poly(po2);		
		double [] poll = {};
		String may_null= Ex2.poly(poll);
		assertEquals(str, ex2);
		assertEquals(st, ex22);
		assertEquals(may_null, null);
	}


	@Test
	void testF() {
		double fx0 = Ex2.f(po1, 0);
		double fx1 = Ex2.f(po1, 1);
		double fx2 = Ex2.f(po1, 2);
		assertEquals(fx0,2);
		assertEquals(fx1,4);
		assertEquals(fx2,6);
	}

	/** My test from polynom from sets of points.
	 *  Creating a parabola by using the solution of the matrix, from 3 points.
	 *  The test is also based in the GUI where we can see a visual drawing of the function
	 */
	@Test
	void testPolynomFromPoints() {
		double[] p10 = {1, 2, 4};
		double[] p11 = {1, 2, 3};
		double[] p12 = Ex2.PolynomFromPoints(p11,p10);
		double[] p13 = {1.0, -0.5, 0.5}; 
		double[] p14 = {3,5,7,8};
		double[] p15 = Ex2.PolynomFromPoints(p14,p10);
		assertArrayEquals(p12, p13);
		assertArrayEquals(p15, null);		
	}

	/** My test for sameValue.
	 * Checking if the to given polynom are meeting in the same point 
	 * This Test is also includes the check of subtract function (and root) because it based of this
	 */
	@Test
	void testSameValue() {
		double[] po11 = {2,1,-0.7, -0.02,0.02};
		double[] po22 = {-3, 0.61, 0.2};
		double [] poll = {10,-2};
		double [] poll1 = {-3,3};
		double same = Ex2.sameValue(po11,po22, 0, 10, Ex2.EPS);
		double same2 = Ex2.sameValue(poll, poll1, 0, 10, Ex2.EPS);
		assertEquals(same,-5.93763473003502); //there are few point the polynomial are meeting, 2.7484130859375 is also a point 
		assertEquals(same2, 2.6);
	}

	/**
	 * This test is based in the GUI to see if we are getting the same area they had calculate
	 */
	@Test
	void testArea() {
		double[] po11 = {2,1,-0.7, -0.02,0.02};
		double[] po22 = {-3, 0.61, 0.2};
		double[] po12 = {0,3};
		double[] po21 = {0,0,1};
		double area = Ex2.area(po11,po22, 0, 10, 13);
		double area2 = Ex2.area(po12,po21, 0, 3, 13);
		assertEquals(area,324.4410909982146,Ex2.EPS);
		assertEquals(area2,9,0.1);						// 0.1 For accurate
		
	}

	@Test
	/** my test for root_rec
	 *  the same test as root, but using the recursion function, expecting the same value
	 */
	void testRoot_rec() {
		double[] parbola = {-4,0,1}; // parabola x^2-4
		double x12 = Ex2.root_rec(po1, 0, 10, Ex2.EPS);
		double x_parb = Ex2.root(parbola, 0, 10, Ex2.EPS);
		assertEquals(x12, 3.1958, Ex2.EPS);
		assertEquals(x_parb, 2,Ex2.EPS);
	}

	@Test
	void testRoot() {
		double[] parb = {-4,0,1}; // parabola x^2-4
		double x12 = Ex2.root(po1, 0, 10, Ex2.EPS);
		double x_parb = Ex2.root(parb, 0, 10, Ex2.EPS);
		assertEquals(x12, 3.1958, Ex2.EPS);
		assertEquals(x_parb, 2,Ex2.EPS);
	}

	@Test
	void testAdd() {
		double[] p12 = Ex2.add(po1, po2);
		double[] minus1 = {-1};
		double[] pp2 = Ex2.mul(po2, minus1);
		double[] p1 = Ex2.add(p12, pp2);
		assertEquals(Ex2.poly(po1), Ex2.poly(p1));
	}

	@Test
	void testMulDoubleArrayDoubleArray() {
		double[] p12 = Ex2.add(po1, po2);
		double dd = Ex2.f(p12, 5);
		assertEquals(dd, 1864.6, Ex2.EPS);
	}

	@Test
	void testDerivativeArrayDoubleArray() {
		double[] p = {1,2,3}; // 3x^2+2x+1
		double[] dp1 = {2,6}; // 6x+2
		double[] dp2 = Ex2.derivative(p);
		assertEquals(dp1[0], dp2[0],Ex2.EPS);
		assertEquals(dp1[1], dp2[1],Ex2.EPS);
		assertEquals(dp1.length, dp2.length);
	}

	/**
	 * The test is built from mixed test
	 * 1. Some making a polynom to string and then turning them back to a polynom by the function and checking is they are equals 
	 * 2. Checking all kinds of cases which 
	 */
	@Test
	public void testFromString() {
		double[] p = {-1.1,2.3,3.1}; // 3.1x^+2.3x-1.1
		double[] pp = {-1.1}; 		// only one number, negative
		double [] pp3 = {2};		// only one number, positive

		String sp = Ex2.poly(p);
		String spp = Ex2.poly(pp);
		String spp3 = Ex2.poly(pp3);

		double[] p1 = Ex2.getPolynomFromString(sp);
		double[] pp2 = Ex2.getPolynomFromString(spp);
		double[] p3p = Ex2.getPolynomFromString(spp3);
		double[] pool = Ex2.getPolynomFromString("");		// Checking the case of an empty String
		double[] pool1 = Ex2.getPolynomFromString("2x-2");	// Checking the case of degree One
		double[] pool2 = Ex2.getPolynomFromString("x-2");	// Checking the case of x with out coefficient 
		double[] pll3 = {-2.0,2.0};
		double[] pll4 = {-2.0,1};

		assertEquals(sp, Ex2.poly(p1));
		assertEquals(spp, Ex2.poly(pp2));
		assertEquals(spp3, Ex2.poly(p3p));
		assertEquals(pool, null);
		assertArrayEquals(pool1, pll3);
		assertArrayEquals(pool2, pll4);
	}

	/**
	 * This test is for an external function I've built to help with area function 
	 */
	@Test
	public void testPolArea() {
		double [] po99 = {0,1}; //A linear equation y=x
		double [] po10 = {-4,0,1};
		double po_area = Ex2.polArea(po99, 0, 10, 100);
		double po10_area = Ex2.polArea(po10, 0, 10, (int)po_area);
		assertEquals(po_area, 50.5);
		assertEquals(po10_area, 302.6,Ex2.EPS);
	}

}

