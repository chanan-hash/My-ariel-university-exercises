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
	private Point2D _p3;
	private Point2D _p4;
	
	//	 Regular constructor
	public Rect2D(Point2D p1, Point2D p2) {
		// We don't want a pointer to the object, but rather to create a new object as the given point
		this._p1 = new Point2D(p1);
		this._p2 = new Point2D(p2);
		this._p3 = new Point2D(p1.x(), p2.y());
		this._p4 = new Point2D(p2.x(), p1.y());
	}

	public double getWidth() {
		double minX = Math.min(_p1.x(), _p2.x()); // Minimum x 
		double maxX = Math.max(_p1.x(), _p2.x()); // Minimum x 
		
		return Math.abs(maxX - minX); 
	}

	public double getHeight() {
		double minY = Math.min(_p1.y(), _p2.y()); // Minimum y 
		double maxY = Math.max(_p1.y(), _p2.y()); // Minimum y 
		
		return Math.abs(maxY - minY); 
	}

// adding who is p Min and who is p Max for the function underneath	
	@Override
	public boolean contains(Point2D ot) {
		
		double minX = Math.min(_p1.x(), _p2.x()); // Minimum x 
		double minY = Math.min(_p1.y(), _p2.y()); // Minimum y 
		
		double maxX = Math.max(_p1.x(), _p2.x()); // Minimum x 
		double maxY = Math.max(_p1.y(), _p2.y()); // Minimum y 
		
		return ((ot.x() >= minX && ot.x() <= maxX && ot.y() >= minY && ot.y() <=maxY));

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
		return "Rect2D," + this._p1 + "," + this._p2 + "," + this._p3 + "," + this._p4;
	}

	@Override
	public void scale(Point2D center, double ratio) {
		this._p1.scale(center,ratio);
		this._p2.scale(center,ratio);
		//	double width = getWidth()*ratio;
		//double height = getHeight()*ratio;
	}

	@Override
	public void rotate(Point2D center, double angleDegrees) {
		// TODO Auto-generated method stub
		for (int i = 0; i < getPoints().length; i++) {
			this.getPoints()[i].rotate(this.getPoints()[i],angleDegrees);
		}
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

	public Point2D get_p3() {
		return _p3;
	}

	public void set_p3(Point2D _p3) {
		this._p3 = new Point2D(_p3);
	}

	public Point2D get_p4() {
		return _p4;
	}

	public void set_p4(Point2D _p4) {
		this._p4 = new Point2D(_p4);
	}


}
