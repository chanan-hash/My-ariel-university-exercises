package Exe.Ex2;

import java.util.Arrays;

public class Ex2_check {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		double[] p1 = {2,4,5,6,8};
		double[] p2 = {2,4,5,6,8,9};
		double[] po1={2,0,3, -1,0}, po2 = {0.1,0,1, 0.1,3};
		double[] p9 = {5, 0, 10, 6};
		double[] p10 = {1, 2, 4};

		double[] p = {1,2,3}; // 3X^2+2x+1
		double[] dp1 = {2,6};
		double[] dp2 = derivative(p);

		double x121 = root(po1, 0, 10, Ex2.EPS);
		System.out.println(Ex2.EPS);
		System.out.println(Arrays.toString(po1));
		System.out.println(x121);

		double x22 = root_rec(po1,0,10,Ex2.EPS);
		System.out.println(x22);
		double [] arr = PolynomFromPoints(p,p10);

		System.out.println(Arrays.toString(arr));
		//	System.out.println(x121);

	}

	// finished
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
		return ans;
	}

	//finished
	public static double[] add(double[] p1, double[] p2) {
		// *** add your code here ***
		double [] longArray;
		double [] shortArray;
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

	//finished
	public static double[] mul(double[] p1, double[] p2) {
		// *** add your code here ***
		double [] mulArray = new double [p1.length + p2.length -1]; // because the exponent is growing

		for (int i = 0; i < p1.length; i++) {
			for (int j = 0; j < p2.length; j++) {
				mulArray[i + j] += p1[i] * p2[j];
			}
		}
		return mulArray; 

	}

	// finished
	public static double f(double[] poly, double x) {
		double ans = 0;
		// *** add your code here ***
		for (int i = 1; i<poly.length; i++) {
			ans = ans +(poly[i]*((Math.pow(x, i)))); // we are taking the value in place i, multiply by the given 'x' pwoer the index
		}
		ans += poly[0];
		// **************************
		return ans;
	}

	// finished
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


	// TODO change the negative
	public static String poly(double[] poly) {
		String ans = "";

		if(poly.length == 1) {
			return poly[0]+""; // making it to String
		}

		for (int i = poly.length-1; i > 1; i--) {
			if (poly[i] != 0) { // if the coefficient is not Zero
				if (poly[i]>0) {
					ans += String.valueOf(poly[i])+ "x^" + String.valueOf(i)+ " + ";
				}
				else {

				}
			}
		}
		if (poly[1] != 0 && poly[0] !=0) {
			return ans + poly[1]+"x + " + poly[0];
		}
		if (poly[1] == 0) {
			return ans + poly[0];
		}
		else {
			return ans;
		}
	}


	/**
	 * This function computes the array representation of a polynom from a String
	 * representation. Note:given a polynom represented as a double array,  
	 * getPolynomFromString(poly(p)) should return an array equals to p.
	 * 
	 * @param p - a String representing polynom.
	 * @return
	 */
	public static final double[] ZERO = {0};
	public static double[] getPolynomFromString(String p) {
		// *** add your code here ***

		int index = p.indexOf('^')+1;
		//TODO
		String maxDeg= "";

		while(p.charAt(index) >= '0' && p.charAt(index)<='9') {
			maxDeg += p.charAt(index); // finding the greatest degree
			index++;
		}
		double[] res = new double[Integer.parseInt(maxDeg)+1];

		String val = "";
		String deg = "";

		for (int i = 0; i < p.length(); i++) {
			while (i<p.length() && ((p.charAt(i) >= '0' && p.charAt(i)<='9') || p.charAt(i) == '.')) {
				val += p.charAt(i);
				i++;
			}
			if(i == p.length()) {
				res[0] = Double.parseDouble(val);
				return res;
			}
			if(i+1<p.length() &&  p.charAt(i+1) != '^') {
				res[1] = Double.parseDouble(val);
				i++;
			}
			else {
				i+=2;
				while (i<p.length() && ((p.charAt(i) >= '0' && p.charAt(i)<='9'))) {
					deg+= p.charAt(i);
					i++;
				}
				res[Integer.parseInt(deg)] = Double.parseDouble(val);
			}
			val = "";
			deg = "";
		}

		return res;
		// **************************
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
	// actually is to implement binary search and we need to find the x
	public static double root3(double[] p, double x1, double x2, double eps) {
		double x12 = (x1+x2)/2;

		double p_x = f(p,x12);
		if(Math.abs(p_x)<eps) {
			return x12; // this is the root of the polynom
		}
		if (Math.abs(f(p,x1)) < eps) {
			return x1;
		}

		if (Math.abs(f(p,x2)) < eps) {
			return x2;
		}

		double left = 0;
		double right = 0;
		if (x1<x2) {
			left = x1;
			right = x2;
		}
		else {
			left = x2;
			right = x1;
		}

		// checking if the p(x) is positive or negative , and according this we will go right or left
		//checking acordding to eps to be close to eps
		//going to the left side, from x12 till x2
		while(left <= right) {
			x12 = (left + right)/2;
			System.out.println(x12);
			System.out.println(right);
			System.out.println(left);

			if (Math.abs(f(p,x12))<eps) {
				return x12;
			}

			//going to the left side
			if (eps < f(p,x12)) {
				right = x12;
			}
			// going to the right side
			else {
				left = x12;
			}
			

		}
		return x12;
	}

	//

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
	 *	we have three y's and for each one an x values, from those we want to calculate a new polynom 
	 */

	public static double[] PolynomFromPoints(double[] xx, double[] yy) {
		double [] ans =  null;
		if(xx!=null && yy!=null && xx.length==3 && yy.length==3) {
			// *** add your code here ***
			double x1 = xx[0], x2 = xx[1], x3 = xx[2];
			double y1 = yy[0], y2 = yy[1], y3 = yy[2];

			double denom = (x1 - x2) * (x1 - x3) * (x2 - x3);
			double P1     = (x3 * (y2 - y1) + x2 * (y1 - y3) + x1 * (y3 - y2)) / denom;
			double P2     = (x3*x3 * (y1 - y2) + x2*x2 * (y3 - y1) + x1*x1 * (y2 - y3)) / denom;
			double P3     = (x2 * x3 * (x2 - x3) * y1 + x3 * x1 * (x3 - x1) * y2 + x1 * x2 * (x1 - x2) * y3) / denom;
			// **************************

			ans = new double [3];
			ans[0] = P1;
			ans[1] = P2;
			ans[2] = P3;

		}

		return ans;
	}


	// need to think about it but helps with the sings. maybe to use only the second function
	public static String toString(double[] pol) {
		StringBuilder sb = new StringBuilder();
		for (int i = pol.length ;i>0; i-- ){
			String cof = null;
			if(i==pol.length) {
				cof = String.format("%.4f", pol[i]);
			}
			else {
				cof = String.format("%.4f", Math.abs(pol[i]));
			}

			if(i==1) {
				sb.append(cof).append("x");
			}
			else {
				sb.append(cof).append("x^");
			}
			sb.append(getSign(pol[i-1]));
		}
		String cof = String.format("%.4f", Math.abs(pol[0]));
		sb.append(cof);
		return sb.toString();
	}

	public static String getSign(double x) {
		if (x>=0) {
			return "+";
		}
		else {
			return "-";
		}
	}


	// trying with Newton-Rapshon
	// finished can be the regular root
	public static double root(double[] p, double x1, double x2, double eps) {
		double x12 = (x1+x2)/2;

		double [] pd = derivative(p); //the derivative of the polynom
		double fpxt = f(p,x12); // will be the value of p(x)
		double fpdxt = f(pd,x12); // will be the value of derivative p(x)

		double xt = x12 - (fpxt/fpdxt);


		while(Math.abs(f(p,xt))>eps) {
			xt = xt - (f(p,xt)/(f(pd,xt)));

		}
		return xt;
	}


	//finished
	// The same way jut with recursion, we are giving the function the next values of 'x'
	public static double root_rec(double[] p, double x1, double x2, double eps) {
		double x12 = (x1+x2)/2;

		double [] pd = derivative(p); //the derivative of the polynom
		double fpxt = f(p,x12); // will be the value of p(x)
		double fpdxt = f(pd,x12); // will be the value of derivative p(x)

		double xt = x12 - (fpxt/fpdxt);
		if(Math.abs(f(p,xt))<eps) {
			return xt;
		}

		return root_rec(p,xt,xt - (f(p,xt)/(f(pd,xt))), eps);

	}


	public static double root2(double[] p, double x1, double x2, double eps) {
		double apx1 = 0;
		double apx2 = 0;
		double x12 = (x1+x2)/2;
		double apx12 = f(p,x12);

		do{
			apx1 = Math.abs(f(p,x1)); 
			if (apx1 < eps) {
				return x1;
			}

			apx2 = Math.abs(f(p,x2)); 
			if (apx2 < eps) {
				return x2;
			}

			if(apx1 < apx12) {
				if (apx2 >= apx12)//apx1<apx12<apx2
					x2 = x12;
				//else
				//throw exception due to fuction definition
			}
			else{
				if (apx2 < apx12) //apx2<apx12<apx1
					x1 = x12;
				else { //apx12<?<?{
					if (apx1 < apx2) { //apx12<pax1<pax2 
						x2 = x12;
					}
					else {  //apx12<pax2<pax1 
						x1 = x12;
					}
				}
			}

			System.out.println(apx1);
			System.out.println(apx2);
			System.out.println(apx12);

			/* if ((apx1 < apx12) && (apx2 >= apx12)) //apx1<apx12<apx2
			               x2 = x12
			           else if ((apx1 >= apx12) && (apx2 < apx12)) //apx2<apx12<apx1
			               x1 = x12
			           else if ((apx1 > apx12 ) && (apx12 < apx2)) //apx12<?<?
			                  {
			                   if (pax1 < pax2) //apx12<pax1<pax2 
			                       x2 = x12
			                   else  //apx12<pax2<pax1 
			                        x1 = x12
			                   }
			           else if ((apx1 < apx12) && (apx12> apx2))// ? < ?< apx12
			                   {
			                          //throw exception due to fuction definition
			                   }*/

		}
		while(Math.abs(f(p,x12))>eps);         
		return x12;
	}	

}