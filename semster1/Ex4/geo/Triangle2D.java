package Exe.Ex4.geo;

/**
 * This class represents a 2D Triangle in the plane.
 * Ex4: you should implement this class!
 * @author I2CS
 *
 */
public class Triangle2D implements GeoShapeable{

	// I think we need 3 point, and to draw a segment from eac point to another, or the dist between them
	private Point2D p1; 
	private Point2D p2; 
	private Point2D p3; 

	// we can create a polygon with three point

	//maybe to do a constructor from every point

	// Copy constructor
	public Triangle2D(Point2D p1,Point2D p2, Point2D p3) {
		this.p1 = new Point2D(p1);
		this.p2 = new Point2D(p2);
		this.p3 = new Point2D(p3);
	}

	/**
	 * We are dividing the triangle to three triangle and according to the given point.
	 * Then we will check if the new 3  little tri's areas are completing it to the big one
	 *
	 * We will check it also according to an epsilon, because of accuration
	 */
	@Override
	public boolean contains(Point2D ot) {
		double eps = 0.01; 
		Triangle2D t1, t2, t3;
		t1 = new Triangle2D(this.p1,this.p2,ot);
		t2 = new Triangle2D(ot,this.p2,this.p3);
		t3 = new Triangle2D(this.p1,ot,this.p3);
		double all_of_tri = t1.area() + t2.area() + t3.area();

		if(Math.abs(this.area() - all_of_tri)<=eps) {
			return true; 
		} //true if the point falls with in this shape (as a closed shape).
		return false;
	}

	@Override
	public double area() {
		// TODO Auto-generated method stub
		double side1 = p1.distance(p2);
		double side2 = p2.distance(p3);
		double side3 = p1.distance(p3);
		double d = perimeter()/2;
		return  Math.sqrt(d* (d - side1) * (d - side2) * (d - side3));
	}

	@Override
	public double perimeter() {
		// TODO Auto-generated method stub
		double peri = p1.distance(p2) + p1.distance(p3) + p2.distance(p3);

		return peri;
	}

	@Override
	public void move(Point2D vec) {
		p1.move(vec);
		p2.move(vec);
		p3.move(vec);
	}

	// A copy constructor
	@Override
	public GeoShapeable copy() {
		// TODO Auto-generated method stub
		return new Triangle2D(p1,p2,p3);
	}

	@Override
	public String toString() {
		return "Triangle2D [p1=" + p1 + ", p2=" + p2 + ", p3=" + p3 + "]";
	}

	@Override
	public void scale(Point2D center, double ratio) {
		// TODO Auto-generated method stub
		this.p1.scale(center,ratio);
		this.p2.scale(center,ratio);
		this.p3.scale(center,ratio);
	}

	@Override
	public void rotate(Point2D center, double angleDegrees) {
		// TODO Auto-generated method stub
		for (int i = 0; i < getPoints().length; i++) {
			this.getPoints()[i].rotate(this.getPoints()[i],angleDegrees);
		}
	}

	@Override
	public Point2D[] getPoints() {
		Point2D[] tri = new Point2D[3]; 
		tri[0] = new Point2D(this.p1);
		tri[1] = new Point2D(this.p2);
		tri[2] = new Point2D(this.p3);
		return tri;
	}

	// getters and setters
	public Point2D getP1() {
		return p1;
	}

	public void setP1(Point2D p1) {
		this.p1 = new Point2D(p1);
	}

	public Point2D getP2() {
		return p2;
	}

	public void setP2(Point2D p2) {
		this.p2 = new Point2D(p2);
	}

	public Point2D getP3() {
		return p3;
	}

	public void setP3(Point2D p3) {
		this.p3 = new Point2D(p3);
	}

}
