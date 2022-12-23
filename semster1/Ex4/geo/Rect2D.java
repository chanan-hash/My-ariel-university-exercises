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

//	private double x;
//	private double y;
//	private double Width;
//	private double Height;
//
//	private Point2D p = new Point2D(x,y);

		private Point2D _p1;
		private Point2D _p2;

		// TODO get width, get height
		
//	 Regular constructor
		public Rect2D(Point2D p1, Point2D p2) {
			// We don't want a pointer to the object, but rather to create a new object as the given point
			this._p1 = new Point2D(p1);
			this._p2 = new Point2D(p2);
		}

//	public Rect2D(double x, double y, double Width, double Height) {
//		this.x = x;
//		this.y = y;
//		this.Width = Width;
//		this.Height = Height;
//	}
		
		/*public Rect2D(double x0,double y0 ,double x1 ,double y1) {
			this._p1 = new Point2D(x0,y0);
			this._p2 = new Point2D(x1,y1);
		}*/
		
		public Rect2D(double x0, double y0, double width, double height) {
			this._p1 = new Point2D(x0, y0);
			this._p2 = new Point2D(x0 + width, y0 +height);
		}
		

	@Override
	public boolean contains(Point2D ot) {
		// Two way, or to put it in a Point2D array and to do binary search, or loop and regular search
		// mabye if a rectangle woth new point, is area is smaller

		// Starting from the regular  
		return false;
	}

	@Override
	public double area() {
		// TODO Auto-generated method stub

				double width = Math.abs(_p1.x() - _p2.x()); 				// Need to figure how to get it
				double height = Math.abs(_p1.y() - _p2.y()); 			// Need to figure how to get it

//		double width = this.Width;
//		double height = this.Height;

		return width*height;
	}

	@Override
	public double perimeter() {
		// TODO Auto-generated method stub
				double width = Math.abs(_p1.x() - _p2.x()); 				// Need to figure how to get it
				double height = Math.abs(_p1.y() + _p2.y());; 			// Need to figure how to get it
//		double width = this.Width;
//		double height = this.Height;

		double peri = 2*width + 2*height;
		return peri;
	}

	@Override
	public void move(Point2D vec) {
		// TODO Auto-generated method stub

		// A loop and setting all the point inside the rect to by moved by the vector
		// the question is how to create the rectangle

		// or moving on;y the two point/ four points
				_p1.move(vec);
				_p2.move(vec);
//		p.move(vec);
	}


	// Returning the points that created the rectangle



	@Override
	// copy constructor
	public GeoShapeable copy() {
		// TODO Auto-generated method stub
		//return null;
		return new Rect2D(_p1,_p2);
	}

	@Override
	public String toString() {
		return "Rect2D [_p1=" + _p1 + ", _p2=" + _p2 + "]";
	}

	@Override
	public void scale(Point2D center, double ratio) {
		// TODO Auto-generated method stub

	}

	@Override
	public void rotate(Point2D center, double angleDegrees) {
		// TODO Auto-generated method stub

	}

	// helps draw; 
	@Override
	public Point2D[] getPoints() {
		Point2D[] ans = {new Point2D(_p1), new Point2D(_p2)};
		return ans;
	}

	public Point2D get_p1() {
		return _p1;
	}

	public void set_p1(Point2D _p1) {
		this._p1 = _p1;
	}

	public Point2D get_p2() {
		return _p2;
	}

	public void set_p2(Point2D _p2) {
		this._p2 = _p2;
	}

	// Getters and setters
	

}
