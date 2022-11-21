package Exe.Ex2;

import java.util.Arrays;

/** 
 * This class represents a set of functions on a polynom - represented as array of doubles.
 * In general, such an array {-1,2,3.1} represents the following polynom 3.1x^2+2x-1=0,
 * The index of the entry represents the power of x.
 * 
 * Your goal is to complete the functions below, see the marking: // *** add your code here ***
 *
 * @author boaz.benmoshe
 *
 */
public class Ex2 {
	/** Epsilon value for numerical computation, it serves as a "close enough" threshold. */
	public static final double EPS = 0.001; // the epsilon to be used for the root approximation.
	/** The zero polynom is represented as an array with a single (0) entry. */
	public static final double[] ZERO = {0};


	/** Two polynoms are equal if and only if the have the same coefficients - up to an epsilon (aka EPS) value.
	 * @param p1 first polynom
	 * @param p2 second polynom
	 * @return true iff p1 represents the same polynom as p2.
	 */
	//checked
	public static boolean equals(double[] p1, double[] p2) {
		boolean ans = true;
		// *** add your code here ***
		if(p1.length != p2.length) { // means that they aren't equal
			ans = false;
			return ans;
		}

		for(int i = 0; i<p1.length; i++) {
			for (int j = i; j<=i; j++) { // we want the loop to run equaly and not nested loop so 'j' ned to bee <= 'i'
				if(p1[i] != p2[j] ) { // already here we can that they are not eqaul
					ans = false; 
					return ans;
				}
			}
		}
		// **************************
		return ans;
	}
	/**
	 * Computes the f(x) value of the polynom at x.
	 * @param poly
	 * @param x
	 * @return f(x) - the polynom value at x.
	 */
	// checked
	public static double f(double[] poly, double x) {
		double ans = 0;
		// *** add your code here ***
		for (int i = 1; i<poly.length; i++) {
			ans = ans +(poly[i]*(Math.pow(x, i))); // we are taking the value in place i, multiply by the given 'x' pwoer the index
		}
		ans += poly[0];
		// **************************
		return ans;
	}
	/** 
	 * Computes a String representing the polynom.
	 * For example the array {2,0,3.1,-1.2} will be presented as the following String  "-1.2x^3 +3.1x^2 +2.0"
	 * @param poly the polynom represented as an array of doubles
	 * @return String representing the polynom: 
	 */
	// checked
	public static String poly(double[] poly) {
		String ans = "";
		if (poly.length == 0) {
			ans = null;
			return ans;
		}

		if(poly.length == 1) {
			return poly[0]+""; // making it to String
		}

		for (int i = poly.length-1; i > 0; i--) {
			if (poly[i] != 0) { 					// if the coefficient is not Zero
				ans += (poly[i]>0?"+" : "") + String.valueOf(poly[i])+  "x" + (i>1 ? "^": "") + String.valueOf(i);
			}
		}
		ans += poly[0]!=0 ? ((poly[0]>0? "+" : "") + String.valueOf(poly[0])) :"";

		if(ans.charAt(0)== '+') { //removing the plus at the beginning
			return ans.substring(1);
		}
		return ans;
	}


	/**
	 * Given a polynom (p), a range [x1,x2] and an epsilon eps. 
	 * This function computes an x value (x1<=x<=x2) for which |p(x)| < eps, 
	 * assuming p(x1)*p(x2) <= 0. 
	 * This function should be implemented iteratively (none recursive).
	 * @param p - the polynom
	 * @param x1 - minimal value of the range
	 * @param x2 - maximal value of the range
	 * @param eps - epsilon (positive small value (often 10^-3, or 10^-6).
	 * @return an x value (x1<=x<=x2) for which |p(x)| < eps.
	 */
	// checked
	// Based on Newton - Rapshon formula but in an iteratively way (by loop)
	public static double root(double[] p, double x1, double x2, double eps) {
		// *** add your code here ***
		double x12 = (x1+x2)/2;

		double [] pd = derivative(p); //the derivative of the polynom
		double fpxt = f(p,x12); // will be the value of p(x)
		double fpdxt = f(pd,x12); // will be the value of derivative p(x)

		double xt = x12 - (fpxt/fpdxt);


		while(Math.abs(f(p,xt))>eps) { //iteratively;
			xt = xt - (f(p,xt)/(f(pd,xt)));

		}
		return xt;
	}
	// **************************



	//checked
	// TODO if the to places are positive
	/** Given a polynom (p), a range [x1,x2] and an epsilon eps. 
	 * This function computes an x value (x1<=x<=x2) for which |p(x)| < eps, 
	 * assuming p(x1)*p(x2) <= 0. 
	 * This function should be implemented recursivly.
	 * @param p - the polynom
	 * @param x1 - minimal value of the range
	 * @param x2 - maximal value of the range
	 * @param eps - epsilon (positive small value (often 10^-3, or 10^-6).
	 * @return an x value (x1<=x<=x2) for which |p(x)| < eps.
	 */
	// trying with Newton-Rapshon idea, base on derivative and the slope of each point 
	// Doing it by recursion, by calling to the function but with different values of 'x' that we've calculate in the function
	public static double root_rec(double[] p, double x1, double x2, double eps) {
		double x12 = (x1+x2)/2;

		double [] pd = derivative(p); //the derivative of the polynom
		double fpxt = f(p,x12); // will be the value of p(x)
		double fpdxt = f(pd,x12); // will be the value of derivative p(x)

		double xt = x12 - (fpxt/fpdxt);
		if(Math.abs(f(p,xt))<eps) {
			return xt;
		}

		return root_rec(p,xt,xt - (f(p,xt)/(f(pd,xt))), eps); // the recursion

	}


	/**
	 * Given two polynoms (p1,p2), a range [x1,x2] and an epsilon eps. This function computes an x value (x1<=x<=x2)
	 * for which |p1(x) -p2(x)| < eps, assuming (p1(x1)-p2(x1)) * (p1(x2)-p2(x2)) <= 0.
	 * @param p1 - first polynom
	 * @param p2 - second polynom
	 * @param x1 - minimal value of the range
	 * @param x2 - maximal value of the range
	 * @param eps - epsilon (positive small value (often 10^-3, or 10^-6).
	 * @return an x value (x1<=x<=x2) for which |p1(x) -p2(x)| < eps.
	 */
	// We are finding the root of the subtraction of the two given polynoms, this is the place they meet
	public static double sameValue(double[] p1, double[] p2, double x1, double x2, double eps) {
		// *** add your code here ***
		return root(subtract(p1, p2), x1, x2, eps);
		// **************************

	}
	/**
	 * Given two polynoms (p1,p2), a range [x1,x2] and an integer representing the number of "boxes". 
	 * This function computes an approximation of the area between the polynoms within the x-range.
	 * The area is computed using Riemann's like integral (https://en.wikipedia.org/wiki/Riemann_integral)
	 * @param p1 - first polynom
	 * @param p2 - second polynom
	 * @param x1 - minimal value of the range
	 * @param x2 - maximal value of the range
	 * @param numberOfBoxes - a natural number representing the number of boxes between x1 and x2.
	 * @return the approximated area between the two polynoms within the [x1,x2] range.
	 */
	//TODO change
	public static double area(double[] p1,double[]p2, double x1, double x2, int numberOfBoxes) {
		double ans = 0;
		// *** add your code here ***
		double sum1 = polArea(p1, x1, x2, numberOfBoxes);
		double sum2 = polArea(p2, x1, x2, numberOfBoxes);

		ans = sum1 - sum2;

		return ans;
	}

	/**
	 * This function computes the array representation of a polynom from a String
	 * representation. Note:given a polynom represented as a double array,  
	 * getPolynomFromString(poly(p)) should return an array equals to p.
	 * 
	 * @param p - a String representing polynom.
	 * @return
	 */
	public static double[] getPolynomFromString(String p) {
		p=p.strip();
		String s= p.replaceAll("-", "+-"); //we want to split according to '+'
		String [] parts = s.split("\\+");
		int deg; 							//getting the degree for the length of the polynomial array
		if (parts[0].contains("x")) {
			if(parts[0].contains("^")){
				String temp = parts[0].split("\\^")[1].strip(); // taking of all the things around the number
				deg = Integer.parseInt(temp); 
			}
			else {
				deg = Integer.parseInt(parts[0].split("x")[1]); //the first 'x', the degree is One
			}
		}
		else {
			if(parts.length < 2 ) {
				return new double[] {Double.parseDouble(parts[0])}; 
			}
			else {
				return new double[] {Double.parseDouble(parts[1])}; 	
			} // we have only One number
		}

		double [] pol = new double [deg+1];
		for(String part : parts ) {
			if (part.isBlank()) {
				continue;
			}
			if (part.contains("x")) {
				if(part.contains("^")){
					String temp =part.split("\\^")[1].strip();
					deg = Integer.parseInt(temp);
				}

				else {
					deg=1;}
			}

			else {
				deg =0;
			}
			String temp =part.split("x")[0].strip();
			pol[deg] = Double.parseDouble(temp);
		}
		return pol;
	}

	// **************************

	/**
	 * This function computes the polynom which is the sum of two polynoms (p1,p2)
	 * @param p1
	 * @param p2
	 * @return
	 */
	// checked
	public static double[] add(double[] p1, double[] p2) {
		// *** add your code here ***
		double [] longArray;
		double [] shortArray;
		if ((p1.length==0)|| (p2.length == 0)) {
			longArray = null;
		}
		if (p1.length>p2.length) {
			longArray = Arrays.copyOf(p1, p1.length); // copy of the array. 
			shortArray = Arrays.copyOf(p2, p2.length); 
		}
		else {
			longArray = Arrays.copyOf(p2, p2.length); // copy of the array. 
			shortArray = Arrays.copyOf(p1, p1.length); 		
		}

		for (int i = 0; i<shortArray.length;i++) {
			longArray[i] = longArray[i] + shortArray[i];
		}
		return longArray; //return p1;
		// **************************
	}

	/**
	 * This function computes the polynom which is the multiplication of two polynoms (p1,p2)
	 * @param p1
	 * @param p2
	 * @return
	 */
	// checked
	public static double[] mul(double[] p1, double[] p2) {
		double [] mulArray = new double [p1.length + p2.length -1];

		for (int i = 0; i < p1.length; i++) {
			for (int j = 0; j < p2.length; j++) {
				mulArray[i + j] += p1[i] * p2[j];
			}
		}
		return mulArray; 

	}

	// **************************

	/**
	 * This function computes the derivative polynom of po.
	 * @param po
	 * @return
	 */
	// checked
	public static double[] derivative (double[] po) {
		// *** add your code here ***
		double[]derv = new double [po.length];
		for (int i = po.length-1 ; i>0; i--) {
			derv[i] = po[i]*i; // x^2 --> 2x
		}
		double[] finalDerv = new double [derv.length-1];
		for (int i = 0; i<derv.length-1; i++) {
			finalDerv [i] = derv[i+1]; //taking down the coefficient that equal to zero
		}
		return finalDerv;

		// **************************
	}

	/**
	 * This function computes a polynomial representation from a set of 2D points on the polynom.
	 * Note: this function only works for a set of points containing three points, else returns null.
	 * @param xx
	 * @param yy
	 * @return an array of doubles representing the coefficients of the polynom.
	 * Note: you can assume xx[0]!=xx[1]!=xx[2]
	 */
	/*
	 * this is based on try to get the polynom
	 * 	y1 = A x1^2 + B x1 + C 
	 *	y2 = A x2^2 + B x2 + C 
	 *	y3 = A x3^2 + B x3 + C
	 *
	 *	The coefficient matrix:
	 *	x1^2 x1 1 | y1
	 *	x2^2 x2 1 | y2
	 *	x3^2 x3 1 | y3
	 *
	 *	it is actually solving a matrix which the variable are A B and C
	 *	we have three y's (y1,y2,y3) and for each one an x values (x1,x2,x3), from those we want to calculate a new polynom that actually is a parabola 
	 */
	//checked in the GUI
	public static double[] PolynomFromPoints(double[] xx, double[] yy) {
		// *** add your code here ***
		double [] ans =  null;
		if(xx!=null && yy!=null && xx.length==3 && yy.length==3) {
			// *** add your code here ***
			double x1 = xx[2], x2 = xx[1], x3 = xx[0];
			double y1 = yy[2], y2 = yy[1], y3 = yy[0];

			double	divide = (x1-x2) * (x1-x3) * (x2-x3);
			double	A     = (x3 * (y2-y1) + x2 * (y1-y3) + x1 * (y3-y2)) / divide;
			double	B     = (x3*x3 * (y1-y2) + x2*x2 * (y3-y1) + x1*x1 * (y2-y3)) / divide;
			double	C     = (x2 * x3 * (x2-x3) * y1+x3 * x1 * (x3-x1) * y2+x1 * x2 * (x1-x2) * y3) / divide;


			ans = new double [3];
			ans[0] = C;
			ans[1] = B;
			ans[2] = A;
		}

		return ans;
	}



	///////////////////// Private /////////////////////
	// you can add any additional functions (private) below

	/**
	 * those two function helps us for the area function that using Reiman's integral
	 */
	// Returning us the area of a rectangle
	public static double rectArea(double w, double h) {
		return w*h;
	}

	// Computing us the area of a given polynom using Reiman's integral
	public static double polArea(double[] p, double x1, double x2, int numberOfBoxes) {
		double sum = 0;
		double width = (x2 - x1)/numberOfBoxes; //this will be the width of the rectangle, nust be a constant number
		double hight = 0;
		double rect_area;

		int i = 0; //the value of the next 'x' to put in p(x) will be x1 + i*width
		for(double j = x1; j<=x2; j = j+(width*i)) {
			hight = f(p,j);
			rect_area = rectArea(width, hight);
			sum+=rect_area;
			i++;
		}

		return sum;

	}

	// Subtract to polynoms help us in the sameValue function
	public static double[] subtract(double[] poly1, double [] poly2) {
		double [] mpoly2 = new double[poly2.length];
		for(int i=0; i<poly2.length; i++) {
			mpoly2[i] = -poly2[i];
		}
		return add(poly1, mpoly2);
	}

}
