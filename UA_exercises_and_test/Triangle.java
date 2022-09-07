package UA_exercises_and_test;
// UA_Test 10/02/2013, Q4

public class Triangle {

	// One of the triangle angle is equal to 90 degrees 
	// The triangle perpendicular 
	private double a;
	private double b;

	public Triangle (double a, double b) {
		this.a = a;
		this.b = b;
	}

	public Triangle(Triangle other) {
		other.a = a;
		other.b = b;
	}

	public double Area() {
		return (a*b)/2;
	}

	public boolean isEqual(Triangle T1, Triangle T2) {
		if (T1.a == T2.a && T1.b == T2.b)
			return true;
		return false;
	}

	double getA() {
		return a;
	}

	void setA(double a) {
		this.a = a;
	}
	
	double getB() {
		return b;
	}

	void setB(double b) {
		this.b = b;
	}

	@Override
	public String toString() {
		return "Triangle [a=" + a + ", b=" + b + "]";
	}

}
