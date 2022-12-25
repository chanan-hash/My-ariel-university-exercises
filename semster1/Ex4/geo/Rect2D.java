package Exe.Ex4.geo;

/**
 * This class represents a 2D rectangle (NOT necessarily axis parallel - this shape can be rotated!)
 * Ex4: you should implement this class!
 * @author I2CS
 *
 */
public class Rect2D implements GeoShapeable {

	// Like Ex3 the creation of the rectangle will be by axis
	// maybe like is stdDraw
	// public static void rectangle(double x, double y, double halfWidth, double halfHeight) {

	// need to have min and max points
	private Point2D _p1;
	private Point2D _p2;

	//	 Regular constructor
	public Rect2D(Point2D p1, Point2D p2) {
		// We don't want a pointer to the object, but rather to create a new object as the given point
		this._p1 = new Point2D(p1);
		this._p2 = new Point2D(p2);
	}

	public Rect2D(double x0, double y0, double width, double height) {
		this._p1 = new Point2D(x0, y0);
		this._p2 = new Point2D(x0 + width, y0 +height);
	}

	public double getWidth() {
		return Math.abs(this._p1.x() - this._p2.x()); 
	}

	public double getHeight() {
		return Math.abs(this._p1.y() - this._p2.y()); 
	}

// adding who is p Min and who is p Max for the function underneath	
	@Override
	public boolean contains(Point2D ot) {
		// Two way, or to put it in a Point2D array and to do binary search, or loop and regular search
		// mabye if a rectangle woth new point, is area is smaller

		if (ot.x() >= this._p1.x() && ot.x() <= this._p2.x() && ot.y() >= this._p1.y() && ot.y() <= this._p2.y()) { 
			return true;
		}
		return false;		
		// Starting from the regular  
	}

	@Override
	public double area() {
		// TODO Auto-generated method stub

		double width = getWidth();
		double height = getHeight();

		return width*height;
	}

	@Override
	public double perimeter() {
		// TODO Auto-generated method stub

		double width = getWidth();
		double height = getHeight();

		double peri = 2*width + 2*height;
		return peri;
	}

	@Override
	public void move(Point2D vec) {
		// TODO Auto-generated method stub
		_p1.move(vec);
		_p2.move(vec);
	}


	@Override
	// A copy constructor
	public GeoShapeable copy() {
		// TODO Auto-generated method stub
		return new Rect2D(_p1,_p2);
	}

	@Override
	public String toString() {
		return "Rect2D [_p1=" + this._p1 + ", _p2=" + this._p2 + "]";
	}

	@Override
	public void scale(Point2D center, double ratio) {
		// TODO Auto-generated method stub
		// the width and height are effecting the size
		if(this.contains(center)) {
			double width = getWidth();
			double height = getHeight();

			width *= ratio;
			height *= ratio;

		}
	}

	@Override
	public void rotate(Point2D center, double angleDegrees) {
		// TODO Auto-generated method stub

	}

	// Getters and setters
	@Override
	public Point2D[] getPoints() {
		Point2D[] ans = {new Point2D(this._p1), new Point2D(this._p2)};
		return ans;
	}

	/**
	 * Computes the center of mass of this shape, this will helps us to draw the Rect'
	 */
	public Point2D centerOfMass() {
		return new Point2D(Math.abs(((this._p1.x()+this._p2.x())/2)),Math.abs((this._p1.y()+this._p2.y())/2));
	}

	public Point2D get_p1() {
		return _p1;
	}

	public void set_p1(Point2D _p1) {
		this._p1 = new Point2D(_p1);
	}

	public Point2D get_p2() {
		return _p2;
	}

	public void set_p2(Point2D _p2) {
		this._p2 = new Point2D(_p2);
	}

}
