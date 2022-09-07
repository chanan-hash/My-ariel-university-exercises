package UA_exercises_and_test;
// UA Test 2018 sample

public class Parabula {

	private double a;
	private double b;
	private double c;

	public Parabula(double a, double b, double c) { // it means that when we are creatnig an object from the class we will be able to give it our parameters 
		this.a = a;
		this.b = b;
		this.c = c;
	}

	public Parabula (Parabula p) { // this methods means that we can create an object be giving it another object from the same class, and it will know to put the given object values in the new one
		p.a = a;
		p.b = b;
		p.c = c;
	}

	// how they did it
	/*
	private double a,b,c;

    public Parabula(double a, double b, double c) {
        this.a = a;
        this.b = b;
        this.c = c;
    }
    public Parabula(Parabula other) {
        this(other.a, other.b, other.c);
    }

	 */

	public double function (double x) { // giving the y value in the function
		return a*Math.pow(x, 2) + b*x + c;
		//	return a*x*x + b*x + c; with out using Math class
	}

	// we need the Point class

	/*	 public boolean above(Point p){
	        return p.y() > f(p.x()); // we are checking the y value, if the point is bigger the the y we getting from the previous method
	    }
	 */

	// Getters and Setters

	void setA(double a) {
		this.a = a;
	}

	double getA() {
		return a;
	}

	double getB() {
		return b;
	}

	void setB(double b) {
		this.b = b;
	}

	double getC() {
		return c;
	}

	void setC(double c) {
		this.c = c;
	}

	@Override
	public String toString() {
		return "Parabula [a=" + a + ", b=" + b + ", c=" + c + "]";
	}

}
