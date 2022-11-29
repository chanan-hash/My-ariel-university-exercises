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

/**'
 *  In every documentation here I added my documentation with explanation on every function
 *  Chanan
 *
 */


public class Ex2 {
	/** Epsilon value for numerical computation, it serves as a "close enough" threshold. */
	public static final double EPS = 0.001; // the epsilon to be used for the root approximation.
	/** The zero polynom is represented as an array with a single (0) entry. */
	public static final double[] ZERO = {0};


	/**
	 * Two polynoms are equal if and only if the have the same coefficients - up to an epsilon (aka EPS) value.
	 * @param p1 first polynom
	 * @param p2 second polynom
	 * @return true if p1 represents the same polynom as p2.
	 *	*******************************************
	 *
	 * The function first check if the length of the polynoms are not equal.
	 * If not, then we can say they won't have the same coefficients
	 * 
	 * If they have the same length: 
	 * let assume they are equal (ans=true)
	 * we are checking if in each index the coefficient is not eqaul, if not we can stop the loop and return false
	 * if the loop has finished we know nothing changed and they are equal
	 *
	 * Chanan
	 */
	public static boolean equals(double[] p1, double[] p2) {
		boolean ans = true;

		if(p1.length != p2.length) { 			// means that they aren't equal
			ans = false;
			return ans;
		}

		for(int i = 0; i<p1.length; i++) { 		// because we know the arrays in the same length we can use only one loop
			if(p1[i] != p2[i] ) { 				// already here we can that they are not equal
				ans = false; 
				return ans;
			}
		}

		return ans;
	}


	/**
	 * Computes the f(x) value of the polynom at x.
	 * @param poly
	 * @param x
	 * @return f(x) - the polynom value at x.
	 * ***************************************
	 * 
	 * To find the f(x) value, we are multiply the coefficient in the index with x power the index place which means the degree oh the x 
	 * then we're adding in the and the the coefficient with x^0, not to forget him, because he doesn't been multiply by x
	 *
	 * Chanan
	 */
	public static double f(double[] poly, double x) {
		double ans = 0;

		for (int i = 1; i<poly.length; i++) {
			ans = ans +(poly[i]*(Math.pow(x, i))); // we are taking the value in place i, multiply by the given 'x' power the index
		}
		ans += poly[0];

		return ans;
	}


	/** 
	 * Computes a String representing the polynom.
	 * For example the array {2,0,3.1,-1.2} will be presented as the following String  "-1.2x^3 +3.1x^2 +2.0"
	 * @param poly the polynom represented as an array of doubles
	 * @return String representing the polynom: 
	 *	*********************************
	 *
	 *	First we are checking if the input is correct and we have values in the polynom.
	 *	If not - return null.
	 *
	 *	Then the function concatenate to the String the values of the polynom power the index they are -1 (because index = 0, dosen't have really a degree).
	 *	the function skips on the coefficients that are equal to zero
	 *	
	 * Chanan
	 */
	public static String poly(double[] poly) {
		String ans = "";
		if (poly.length == 0) {					// checking if the polynom is empty, then return null
			ans = null;
			return ans;
		}

		if(poly.length == 1) {						// dealing with the case we don't have any 'x' multiplication  
			return poly[0]+""; 						// making it to String
		}

		for (int i = poly.length-1; i > 0; i--) {
			if (poly[i] != 0) { 					// if the coefficient is not Zero
				ans += (poly[i]>0?"+" : "") + String.valueOf(poly[i]) +  "x" + (i>1 ? "^": "") + String.valueOf(i);
			}
		}
		ans += poly[0]!=0 ? ((poly[0]>0? "+" : "") + String.valueOf(poly[0])) :""; // adding the first index coefficient after checking if it not equal to Zero

		ans = ans.replace("x1","x"); 				//taking the degree off from x^1 --> x

		if(ans.charAt(0) == '+') { 					//removing the plus at the beginning
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
	 * *********************************************
	 * 
	 *  This function is based on Newton - Rapshon's formula for finding root of a polynom, but in an iteratively way (by loop).
	 *  This idea is the base to the more accurate ways to find roots of a polynomial  
	 *  The way to do it is by every next 'x' (n+1) value is equals to the current 'x' (n) minus the f(x) divided by the derivative of the same point f'(x)
	 *  This id the formula:
	 *  x(n+1) = x(n) - f(xn)/f'(xn) --> which n represent the index
	 *  
	 *  This idea is related to limits and the slope of f(x) in every x
	 *  
	 * Chanan
	 */
	public static double root(double[] p, double x1, double x2, double eps) {

		double x12 = (x1+x2)/2;				// our first 'x' value we want to check and from there to get going. 
		// the reason to start from the middle is related to the concept of binary search

		double [] pd = derivative(p); 		// the derivative of the polynom
		double fpxt = f(p,x12); 			// will be the value of p(x)
		double fpdxt = f(pd,x12); 			// will be the value of derivative p(x)

		double xt = x12 - (fpxt/fpdxt);


		while(Math.abs(f(p,xt))>eps) { 			//iteratively;
			xt = xt - (f(p,xt)/(f(pd,xt)));
		}

		return xt;
	}

	/** 
	 *	Given a polynom (p), a range [x1,x2] and an epsilon eps. 
	 * This function computes an x value (x1<=x<=x2) for which |p(x)| < eps, 
	 * assuming p(x1)*p(x2) <= 0. 
	 * This function should be implemented recursivly.
	 * @param p - the polynom
	 * @param x1 - minimal value of the range
	 * @param x2 - maximal value of the range
	 * @param eps - epsilon (positive small value (often 10^-3, or 10^-6).
	 * @return an x value (x1<=x<=x2) for which |p(x)| < eps.
	 * ****************************************************
	 * 
	 * This function is based on the sane idea of the previous function but this works by recursion 
	 * Using Newton-Rapshon's idea, base on derivative and the slope of each point 
	 * 
	 * The way to do it in recursion, is by calling to the function  itself but with different values of 'x' that we've calculate in the function
	 * 
	 * Chanan
	 */
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
	 * 
	 * ****************************************
	 * The function here finding the 'x' value the two polynoms are meeting by to steps
	 *  1. We are finding the polynom which is the subtraction of the two polynoms, by out side function we've built
	 *  2. By using the root function, we are finding the place the sub polynom is meetnig the x's axis. 
	 *  
	 *  If the two given polynoms are empty we are returning -0.0 
	 * 
	 * Chanan
	 */
	public static double sameValue(double[] p1, double[] p2, double x1, double x2, double eps) {
		if ((p1.length == 0) && (p2.length == 0)){
			double polynull = -0.00000000000000; //means they are empty polynoms
			return polynull;
		}
		return root(subtract(p1, p2), x1, x2, eps);
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
	 * 
	 * ****************************************************
	 * This function finding the area between two polynoms by few steps:
	 * 1. We have an outside function which gives us the area of a standard rectangle (width*height)
	 * 2. We have another outside function that calculate the area of One polynom in the range we want
	 * 3. By using those two functions, we finding the subtraction of the two areas
	 * 
	 * Riemann's integral is the base for the whole idea of area under the polynom with integrals.
	 * Those two functions you can find here in the end
	 * 
	 * Chanan
	 */
	public static double area(double[] p1,double[]p2, double x1, double x2, int numberOfBoxes) {
		double ans = 0;

		// Finding the area of each polynom
		double sum1 = polArea(p1, x1, x2, numberOfBoxes); 
		double sum2 = polArea(p2, x1, x2, numberOfBoxes);

		ans = (sum1 - sum2)*2; 			// Calculate the final area. Notice: area in integral can be negative - means the area is under the graph

		return ans;
	}

	/**
	 * This function computes the array representation of a polynom from a String
	 * representation. Note:given a polynom represented as a double array,  
	 * getPolynomFromString(poly(p)) should return an array equals to p.
	 * 
	 * @param p - a String representing polynom.
	 * @return
	 * 
	 * *************************************
	 * The hard thing in this function is to break up and to extract form the String the numbers.
	 * 1. First we need to find the degree of the function by finding the first x^n, and the value of n, +1 will be the length of the arrays
	 * 2. After we've found the degree, we are creating the array, and going over the String and extracting the value of the coefficients  
	 * 
	 * We are assuming That the high degree in the beginning and the after it we can have lower degree before high degree but not the highest   
	 * 
	 * Chanan
	 */
	public static double[] getPolynomFromString(String p) {
		if (p.equals("")) {
			return null;						// Dealing the case if the input is empty
		}
		p = p.replaceAll("-", "+-");			// To split according to '+'
		if (p.startsWith("+-")) {
			p = p.substring(1);					// removing the + if the String start with +-, so we can turn it to a negative number 
		}
		String[] parts = p.split("\\+");
		int deg = 0;							// Getting the degree to know the length of the array

		if (parts[0].contains("x")) {
			if (parts[0].contains("^")) {
				deg = Integer.parseInt(parts[0].split("\\^")[1]);
			} 
			else {
				deg = 1; 						// if there isn't any degree on the x, it means that the degree is One (2x+4)
			}
		} 
		else {
			return new double[]{Double.parseDouble(parts[0])}; // There isn't any degree, we can return the array with the number itself  
		}

		double[] pol = new double[deg + 1];

		for (String part : parts) {
			if (part.isBlank()) {
				continue;
			}
			if (part.contains("x")) {
				if (part.contains("^")) {
					deg = Integer.parseInt(part.split("\\^")[1]); // Trying to get the decree of the other numbers to know where to put them in the array
				}
				else {
					deg = 1;
				}
			} 
			else {
				deg = 0;
			}

			if (part.startsWith("x")) { 					// Dealing with the case the x jasn't any coefficient
				pol[deg] = 1;
			} else if (part.startsWith("-x")) {
				pol[deg] = -1;
			} else {
				pol[deg] = Double.parseDouble(part.split("x")[0]); // Putting the number into the array according to the degree 
			}
		}

		return pol;
	}

	/**
	 * This function computes the polynom which is the sum of two polynoms (p1,p2)
	 * @param p1
	 * @param p2
	 * @return
	 * 
	 *  *************************
	 *  The important thing here is to notice we aren't chnching any given array so it won't affect us after it
	 *  We are creating two new arrays:
	 *  1. The first is a long array which will be a copy of the longest between the two given arrays  
	 *  2. The second is a pointer for the shorter array
	 *  
	 *  Then we are running on the short array an adding every value in to the same value in the same index in the longer array
	 * 
	 * Chanan
	 */
	public static double[] add(double[] p1, double[] p2) {
		double [] longArray;
		double [] shortArray;
		if ((p1.length==0)|| (p2.length == 0)) {
			longArray = null;
		}
		if (p1.length>p2.length) {
			longArray = Arrays.copyOf(p1, p1.length); // copy of the longer array. 
			shortArray = Arrays.copyOf(p2, p2.length); // pointer to the shorter array
		}
		else {
			longArray = Arrays.copyOf(p2, p2.length); // copy of the longer array. 
			shortArray = Arrays.copyOf(p1, p1.length); // pointer to the shorter array		
		}

		for (int i = 0; i<shortArray.length;i++) {
			longArray[i] = longArray[i] + shortArray[i]; // running on the shorter array and adding to the longer array in the same index
		}
		return longArray; 
	}

	/**
	 * This function computes the polynom which is the multiplication of two polynoms (p1,p2)
	 * @param p1
	 * @param p2
	 * @return
	 * 
	 * This function is working on the idea of opening brackets
	 * exmp = (x-2)*(x-3) = x^2 -3x - 2x + 6 = x^2-5x+6
	 * 
	 * We are creating a new polynom which is in the length of both two polynom -1, it will represent the degree of the new polynom
	 * In every place the value will be p1[i] * p2[j]. But i and j aren't running in the same values.
	 * And in that way we are covering that we've multiplied all values in one each other
	 * 
	 * Chanan
	 */
	public static double[] mul(double[] p1, double[] p2) {
		double [] mulArray = new double [p1.length + p2.length -1]; // A new array the length of the two given arrays

		for (int i = 0; i < p1.length; i++) {
			for (int j = 0; j < p2.length; j++) {
				mulArray[i + j] += p1[i] * p2[j];
			}
		}
		return mulArray; 

	}

	/**
	 * This function computes the derivative polynom of po.
	 * @param po
	 * @return
	 * 
	 *	********************************** 
	 *	The derivative pf a polynom is based on this formula:
	 *	f(x) = x^n --> f'(x) = n*x^(n-1)
	 *	Another thing we need to notice is that its getting shorter then you derivative it. exmp' f(x) = 2 --> f'(x) = n*x^(n-1) = 0
	 *	
	 *	The function is creating a new polynom so we won't affect the given polynom. 
	 *	This new polynom will be the derivative of the given polynom working by the formula above
	 *
	 *	Then we are creating a new polynom that will take down the place that equal to Zero
	 *	
	 * Chanan
	 */
	public static double[] derivative (double[] po) {

		double[]derv = new double [po.length];
		for (int i = po.length-1 ; i>0; i--) {
			derv[i] = po[i]*i; 				// x^2 --> 2x
		}
		double[] finalDerv = new double [derv.length-1];
		for (int i = 0; i<derv.length-1; i++) {
			finalDerv [i] = derv[i+1]; 			//taking down the coefficient that equal to zero
		}

		return finalDerv;
	}


	/**
	 * This function computes a polynomial representation from a set of 2D points on the polynom.
	 * Note: this function only works for a set of points containing three points, else returns null.
	 * @param xx
	 * @param yy
	 * @return an array of doubles representing the coefficients of the polynom.
	 * Note: you can assume xx[0]!=xx[1]!=xx[2]
	 *
	 * *******************************
	 * We have three y's (y1,y2,y3) and for each one an x values (x1,x2,x3).
	 * From those, we want to calculate a new polynom that actually is a parabola 
	 *	 
	 * 	y1 = A x1^2 + B x1 + C 
	 *	y2 = A x2^2 + B x2 + C 
	 *	y3 = A x3^2 + B x3 + C
	 *
	 * This function works as a solution of this matrix, which:
	 * 	1. A,B and C are the variables.
	 *  2. x1,x2,x3 are the arguments.
	 *  3. y1,y2,y3 are the constant column and they are also arguments
	 *
	 *	The coefficients matrix:
	 *	x1^2 x1 1 | y1
	 *	x2^2 x2 1 | y2
	 *	x3^2 x3 1 | y3
	 *
	 * was based on a solution from http://chris35wills.github.io/parabola_python/ but was suitable to us
	 * In the GUI we can see the new polynom from the given point
	 * 
	 * Chanan	
	 */	
	public static double[] PolynomFromPoints(double[] xx, double[] yy) {
		double [] ans =  null;
		if(xx!=null && yy!=null && xx.length==3 && yy.length==3) {
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
	 * Those two first function helps us for the area function that using Reiman's integral
	 *
	 *	1. Returning us the area of a rectangle
	 *
	 *	2. calculating an area of a given polynom in a certain range by Reimn's integral 
	 *
	 *	Chanan
	 */ 
	public static double rectArea(double w, double h) {
		return w*h;
	}

	// Computing us the area of a given polynom using Reiman's integral
	public static double polArea(double[] p, double x1, double x2, int numberOfBoxes) {
		double sum = 0;
		double width = (x2 - x1)/numberOfBoxes; //this will be the width of the rectangle, must be a constant number
		double hight = 0;
		double rect_area;

		int i = 0; 								//the value of the next 'x' to put in p(x) will be x1 = i*width
		for(double j = x1; j<=x2; j = (width*i)) {
			hight = f(p,j);
			rect_area = rectArea(width, hight);
			sum += rect_area;
			i++;
		}

		return sum;

	}

	/**
	 * This function help us in sameValue function.
	 * To find when to polynoms are meeting we are first subtracting the to given polynoms.
	 * Then up their in the function itself, we are finding the root of the subtracted polynom 
	 *
	 * It doing it by add function the minus of one of the polynoms 
	 * 
	 * Chanan
	 */
	public static double[] subtract(double[] poly1, double [] poly2) {
		double [] mpoly2 = new double[poly2.length];
		for(int i=0; i<poly2.length; i++) {
			mpoly2[i] = -poly2[i];
		}
		return add(poly1, mpoly2);
	}

}
