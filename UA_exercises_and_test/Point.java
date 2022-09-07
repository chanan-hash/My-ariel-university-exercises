package UA_exercises_and_test;
// this class is used in some of the tests during the year

public class Point {

	// the x & y values of the dot
	private double _x;
	private double _y; 


	// constructor
	public Point(double x1, double y1) {
		this._x = x1;
		this._y = y1;
	}

	public Point (Point p) {
		p._x = _x;
		p._y = _y;
	}

	// getters and setters

	double getX() {
		return _x;	
	}

	void setX (double x) {
		this._x = x;
	}

	public double getY() {
		return _y;
	}
	void setY(double y) {
		this._y = y;
	}

	@Override
	public String toString() {
		return "Point [_x=" + _x + ", _y=" + _y + "]";
	}

	// distance
	public double distance (Point p){
		double dist = Math.pow(p._x - _x, 2) + Math.pow(p._y - _y, 2);
		return Math.sqrt(dist);
		// we can also do it in the same row
		// return = Math.sqrt(Math.pow(p._x - _x, 2) + Math.pow(p._y - _y, 2));
		// with out 'Math class = 	double dist = ((p._x - _x)*(p._x - _x)) + (p._y - _y)*(p._y - _y);		
	}
	/*
	 * this how they did it:
	 *      public double distance (Point p){
            double temp = Math.pow (p.x() - _x, 2) + Math.pow (p.y() - _y, 2);
            return Math.sqrt (temp);
        }
	 */

}
