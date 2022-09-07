package UA_exercises_and_test;
//UA_Test 30/1/18, Q4

public class Line {

	private int x1;
	private int y1;
	private int x2;
	private int y2;

	public Line (int x1, int y1, int x2, int y2) {
		this.x1 = x1;
		this.y1 = y1;
		this.x2 = x2;
		this.y2 = y2;
	}
	public Line (Line other) {
		other.x1 = x1;
		other.y1 = y1;
		other.x2 = x2;
		other.y2 = y2;
	}
	public double length() {
		return Math.sqrt(Math.pow(x1-x2, 2) + Math.pow(y1-y2, 2)); // distance between dots formula
		//return Math.sqrt((x1-x2)*(x1-x2) + (y1-y2)*(y1-y2));
		
	}

	public boolean on (int x, int y) { // getting the x and y values of the point
		double m = (y1-y2)/(x1-x2); // calculating the incline of the linear line/function
		return y-y1==m*(x-x1); // checking if the given point is on the linear line
	}
	
}
