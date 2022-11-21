package Exe.Ex2;

import java.util.Arrays;

public class Ex2_check {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		double[] po1 = {2};
		double eps = 0.02;
		double[] po2 = {-3, 0.61, 0.2};
		double [] poll = {};
		String str = Ex2.poly(po1);
		System.out.println(str);
		System.out.println(poll.length);
		String str2 = "5";
		System.out.println(str2.length());
		System.out.println(Integer.parseInt(str2));

		//		String st1 = "fffd sf er";
		//		String [] starr =  st1.split(("f"));
		//		System.out.println(Arrays.toString(starr));

		//		System.out.println(str.charAt(0));
		//		System.out.println(str.substring(1));
		//		

		//		double sameValue = sameValue(po1, po2, 0, 10, Ex2.EPS);
		//		System.out.println(sameValue);
		//
		//		double area = Ex2.area(po1,po2, 0, 10, 13);
		//		System.out.println(area);
		//		

		//		String s = "+3.1x^+2.3x-1.1";
		//		String [] st = s.split("((?>=-)|(?=-)|(?>=\\+)|(?=\\+))");


		double[] p = {-2}; // 3.1x^+2.3x-1.1
		String sp = Ex2.poly(p);
		System.out.println(sp);
		double[] p1 = toPol(sp);
		System.out.println(Arrays.toString(p1));
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
			ans = ans +(poly[i]*(Math.pow(x, i))); // we are taking the value in place i, multiply by the given 'x' pwoer the index
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


	// finished
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

			if (poly[i] != 0) { // if the coefficient is not Zero
				ans += (poly[i]>0?"+" : "") + String.valueOf(poly[i])+  "x" + (i>1 ? "^": "") + String.valueOf(i);
			}
		}
		ans += poly[0]!=0 ? ((poly[0]>0? "+" : "") + String.valueOf(poly[0])) :"";

		if(ans.charAt(0)== '+') { //removing the plus at the beginning, if exists
			return ans.substring(1);
		}
		return ans;

	}



	public static double [] toPol(String p) {
		//		if (p.length() == 3) {
		//			double [] ps = new double[1];
		//			ps[0] = Double.parseDouble(p);
		//			return ps;
		//		}

		p=p.strip();
		System.out.println(p);
		String s= p.replaceAll("-", "+-");
		//System.out.println(s);
		String [] parts = s.split("\\+");
		//System.out.println(Arrays.toString(parts));
		int deg;
		if (parts[0].contains("x")) {
			if(parts[0].contains("^")){
				String temp = parts[0].split("\\^")[1].strip();
				deg = Integer.parseInt(temp);
			}
			else {
				deg = Integer.parseInt(parts[0].split("x")[1]);
			}
		}
		else {
			System.out.println(Arrays.toString(parts));
			System.out.println(parts.length);
			if(parts.length < 2 ) {
				return new double[] {Double.parseDouble(parts[0])}; 
			}
			else {
				return new double[] {Double.parseDouble(parts[1])}; 	
			}
		}
		double [] pol = new double [deg+1];
		for(String part : parts ) { //like in python we are going over the parts array
			if (part.isBlank()) {
				continue;
			}
			if (part.contains("x")) {
				if(part.contains("^")){
					String temp =part.split("\\^")[1].strip();
					deg = Integer.parseInt(temp);
				}
				else{
					deg=1;
				}
			}
			else{
				deg =0;
			}
			String temp = part.split("x")[0].strip();
			pol[deg] = Double.parseDouble(temp); //taking in the index of the degree we're putting the number we have left
		}
		return pol;
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
	// checked
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



	//checked
	public static double root4(double[] p, double x1, double x2, double eps) {
		if (Math.abs(f(p, x1))< eps)	return x1;
		if (Math.abs(f(p, x2))< eps)	return x2;

		double pos = f(p, x1)> 0 ? x1 : x2; //positive
		double neg = f(p, x1)> 0 ? x2 : x1; // negative
		double m = (neg+pos)/2 ;

		while (Math.abs(f(p ,m))>=eps) {
			if (f(p, m)>0) {
				pos=m;
			}else {
				neg=m;
			}
			m=(neg+pos)/2;
		}
		return m;
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
	 * solving a matrix
	 *
	 *	we have three y's and for each one an x values, from those we want to calculate a new polynom 
	 */
	public static double[] PolynomFromPoints(double[] xx, double[] yy) {
		double [] ans =  null;
		if(xx!=null && yy!=null && xx.length==3 && yy.length==3) {
			// *** add your code here ***

			double x1 = xx[2], x2 = xx[1], x3 = xx[0];
			double y1 = yy[2], y2 = yy[1], y3 = yy[0];

			double	denom = (x1-x2) * (x1-x3) * (x2-x3);
			double	A     = (x3 * (y2-y1) + x2 * (y1-y3) + x1 * (y3-y2)) / denom;
			double	B     = (x3*x3 * (y1-y2) + x2*x2 * (y3-y1) + x1*x1 * (y2-y3)) / denom;
			double	C     = (x2 * x3 * (x2-x3) * y1+x3 * x1 * (x3-x1) * y2+x1 * x2 * (x1-x2) * y3) / denom;


			ans = new double [3];
			ans[0] = C;
			ans[1] = B;
			ans[2] = A;
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



	/**
	 * Given two polynoms (p1,p2), a range [x1,x2] and an integer representing the number of "boxes". 
	 * This function computes an approximation of the area between the polynoms within the x-range.
	 * The area is computed using Riemann's like integral (https://en.wikipedia.org/wiki/Riemann_integral)
	 * @param p1 - first polynom
	 * @param p2 - second polynom
	 * @param x1 - minimal value of the range
	 * @param x2 - maximal value of the range
	 * @param numberOfBoxes - a natural number representing the number of boxes between xq and x2.
	 * @return the approximated area between the two polynoms within the [x1,x2] range.
	 */
	public static double area(double[] p1,double[]p2, double x1, double x2, int numberOfBoxes) {
		double ans = 0;
		// *** add your code here ***
		double sum1 = 0, sum2 = 0;

		double width = (x2 - x1)/numberOfBoxes; //this will be the width of the rectangle, nust be a constant number
		double hight1 = 0;
		double hight2 = 0;	
		double rect_area1;
		double rect_area2;

		// calculating the area of first polynomial
		for(double i = x1; i<=x2; i++) {
			hight1 = f(p1,i);
			rect_area1 = width*hight1;
			sum1+=rect_area1;
		}

		// calculating the area of second polynomial
		for(double i = x1; i<=x2; i++) {
			hight2 = f(p2,i);
			rect_area2 = width*hight2;
			sum2+=rect_area2;
		}
		// **************************
		ans = sum1-sum2;
		return ans;
	}

	//help Function
	public static double rectArea(double w, double h) {
		return w*h;
	}

	public static double polArea(double[] p, double x1, double x2, int numberOfBoxes) {
		double sum = 0;
		double width = (x2 - x1)/numberOfBoxes; //this will be the width of the rectangle, nust be a constant number
		double currPos=x1;

		for (int i = 0; i< numberOfBoxes; i++) {
			sum += f(p, currPos);
			currPos+=width;
		}
		return sum*width;
		//need to be fixed with the i
		//			for(double j = x1; j<=x2; j = j+(width)) {
		//				hight = f(p,j);
		//				rect_area = rectArea(width, hight);
		//				sum += rect_area;
		//			}

		//		return sum;

	}

	public static double area2(double[] p1,double[]p2, double x1, double x2, int numberOfBoxes) {
		double ans = 0;
		double sum1 = polArea(p1, x1, x2, numberOfBoxes);
		double sum2 = polArea(p2, x1, x2, numberOfBoxes);

		ans = sum1 - sum2;

		return ans;
	}


	public static double[] subtruct(double[] poly1, double [] poly2) {
		double [] mpoly2 = new double[poly2.length];
		for(int i=0; i<poly2.length; i++) {
			mpoly2[i] = -poly2[i];
		}
		return add(poly1, mpoly2);
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
	public static double sameValue(double[] p1, double[] p2, double x1, double x2, double eps) {
		// *** add your code here ***
		return root4(subtruct(p1, p2), x1, x2, eps);
		// **************************
	}




}