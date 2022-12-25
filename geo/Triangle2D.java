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
	
	@Override
	public boolean contains(Point2D ot) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public double area() {
		// TODO Auto-generated method stub
		return 0;
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
		
	}

	@Override
	public void rotate(Point2D center, double angleDegrees) {
		// TODO Auto-generated method stub
		
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
