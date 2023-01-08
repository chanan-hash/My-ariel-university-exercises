package Exe.Ex4.geo;


/**
 * This class represents a 2D segment on the plane, 
 * Ex4: you should implement this class!
 * @author I2CS
 *
 */
public class Segment2D implements GeoShapeable{

	// the segment is built from 2 points, or x0 y0 ,x1 y1
	private Point2D p0; 
	private Point2D p1; 
	private double m;	// the slope
	private double n;  	// y = mx + n


	public Point2D getP0() {
		return p0;
	}

	// getters and setters
	public void setP0(Point2D p0) {
		this.p0 = new Point2D(p0);
	}

	public Point2D getP1() {
		return p1;
	}

	public void setP1(Point2D p1) {
		this.p1 = new Point2D(p1);
	}

	@Override
	public String toString() {
		return "Segment2D," + p0 + "," + p1;
	}


	// regular constructor
	public Segment2D(Point2D p0, Point2D p1) {
		this.p0 = new Point2D(p0);
		this.p1 = new Point2D(p1);
		this.m = (p1.y()-p0.y())/(p1.x()-p0.x()); // the slope

		this.n =-m * p1.x() + p1.y();
	}

	public Segment2D(double x0,double y0 ,double x1 ,double y1) {
		this.p0 = new Point2D(x0,y0);
		this.p1 = new Point2D(x1,y1);
		this.m = (p1.y()-p0.y())/(p1.x()-p0.x()); // the slope
		this.n =-m * p1.x() + p1.y();
	}

	/**
	 * If the distance between the points and the given point will be equals to the big distance, or less than en epsilon	
	 */
	@Override
	public boolean contains(Point2D ot) {
		double eps = 0.001;
		double dist = p0.distance(p1);

		double distOt= (p0.distance(ot) + p1.distance(ot)); 
		return Math.abs(distOt-dist)<eps;
	}

	// Line dosen't have area
	@Override
	public double area() {
		return 0;
	}

	// Because we can surround the segment from both sides, its perimeter is the dist*2 
	@Override
	public double perimeter() {
		return p0.distance(p1)*2;
	}

	/**
	 * Based on the the function from Point2D class
	 */
	@Override
	public void move(Point2D vec) {
		p0.move(vec);
		p1.move(vec);
	}

	@Override
	public GeoShapeable copy() {
		return new Segment2D(p0, p1);
	}
	
	/**
	 * The scale and the rotate here are based on those function in Point2D class
	 */
	@Override
	public void scale(Point2D center, double ratio) {
		this.p0.scale(center, ratio);
		this.p1.scale(center, ratio);		
	}

	@Override
	public void rotate(Point2D center, double angleDegrees) {
		this.p0.rotate(center, angleDegrees);
		this.p1.rotate(center, angleDegrees);		
	}

	// The points that helps as to draw
	@Override
	public Point2D[] getPoints() {
		Point2D[] ans = new Point2D[2];
		ans[0] = new Point2D(this.p0);
		ans[1] = new Point2D(this.p1);
		return ans;
	}
	
}