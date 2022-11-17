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

	// my test for equals
	@Test
	void testIsEqual() {
		double[] pl1 = {2,4,5,6,8};
		double[] pl2 = {2,4,5,6,8};
		boolean ans = Ex2.equals(po2, po1);
		boolean ans2 = Ex2.equals(pl1, pl2);
		assertEquals(ans, false);
		assertEquals(ans2, true);

	}

	// my test for poly
	@Test
	void testToString() {
		String str = "-1.0x^3 + 3.0x^2 + 2.0";
		String st = "3.0x^4 + 0.1x^3 + 1.0x^2 + 0.1";
		String ex2 = Ex2.poly(po1);
		String ex22 = Ex2.poly(po2);		
		assertEquals(str, ex2);
		assertEquals(st, ex22);
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
	
	// my test from polynom from sets of points
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

	@Test
	// my test for root_rec
	void testRoot_rec() {
		double x12 = Ex2.root_rec(po1, 0, 10, Ex2.EPS);
		assertEquals(x12, 3.1958, Ex2.EPS);
	}


	@Test
	void testRoot() {
		double x12 = Ex2.root(po1, 0, 10, Ex2.EPS);
		assertEquals(x12, 3.1958, Ex2.EPS);
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
		double[] p = {1,2,3}; // 3X^2+2x+1
		double[] dp1 = {2,6}; // 6x+2
		double[] dp2 = Ex2.derivative(p);
		assertEquals(dp1[0], dp2[0],Ex2.EPS);
		assertEquals(dp1[1], dp2[1],Ex2.EPS);
		assertEquals(dp1.length, dp2.length);
	}
	//			@Test
	//	public void testFromString() {
	//		double[] p = {-1.1,2.3,3.1}; // 3.1X^+2.3x-1.1
	//		String sp = Ex2.poly(p);
	//		double[] p1 = Ex2.getPolynomFromString(sp);
	//		boolean isSame = Ex2.equals(p1, p);
	//		if(!isSame) {fail();}
	//		assertEquals(sp, Ex2.poly(p1));
	//	}


}

