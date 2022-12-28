package Exe.Ex4.geo;

/**
 * This class represents a 2D rectangle (NOT necessarily axis parallel - this shape can be rotated!)
 * Ex4: you should implement this class!
 * @author I2CS
 *
 */
public class Rect2D implements GeoShapeable {
	// need to have min and max points
	private Point2D _p1;
	private Point2D _p2;

	//	 Regular constructor
	public Rect2D(Point2D p1, Point2D p2) {
		// We don't want a pointer to the object, but rather to create a new object as the given point
		this._p1 = new Point2D(p1);
		this._p2 = new Point2D(p2);
	}

	/**
	 * 	public Rect2D(Point2D p1, Point2D p2) {
		// We don't want a pointer to the object, but rather to create a new object as the given point
//		this.topRight = new Point2D(p1);
//		this._bottomLeft = new Point2D(p2);
		this.setCorners(p1, p2);
	
	}

	private void setCorners(Point2D p1, Point2D p2) {
		if(p1.y()> p2.y()) {
			this.topRight = new Point2D(p1);
			this._bottomLeft = new Point2D(p2);
		}
		else {
			this.topRight = new Point2D(p2);
			this._bottomLeft = new Point2D(p1);
		}
	}
	 * @return
	 */
	
	public double getWidth() {
		return Math.abs(this._p1.x() - this._p2.x()); 
	}

	public double getHeight() {
		return Math.abs(this._p1.y() - this._p2.y()); 
	}

// adding who is p Min and who is p Max for the function underneath	
	@Override
	public boolean contains(Point2D ot) {
		
		int minX = Math.min(_p1.ix(), _p2.ix()); // Minimum x 
		int minY = Math.min(_p1.iy(), _p2.iy()); // Minimum y 
		
		int maxX = Math.max(_p1.ix(), _p2.ix()); // Minimum x 
		int maxY = Math.max(_p1.iy(), _p2.iy()); // Minimum y 
		
		return (ot.x() >= minX && ot.x() <= maxX && ot.y() >= minY && ot.y() <=maxY);

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
	 * Computes the center of mass of this shape, this will helps us to draw the Rect' with StdDraw
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
