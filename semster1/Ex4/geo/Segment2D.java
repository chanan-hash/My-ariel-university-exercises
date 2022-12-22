package Exe.Ex4.geo;


/**
 * This class represents a 2D segment on the plane, 
 * Ex4: you should implement this class!
 * @author I2CS
 *
 */
public class Segment2D implements GeoShapeable{
	
	// the segment is built from 2 points, or x0 y0 ,x1 y1
	
	private double x0;
	private double y0;
	private double x1;
	private double y1;
	
	private Point2D p0 = new Point2D(this.x0,this.y0);
	private Point2D p1 = new Point2D(this.x1,this.y1);
	
	
	// regular constructor
	public Segment2D(Point2D p0, Point2D p1) {
		this.p0 = new Point2D(p0);
		this.p1 = new Point2D(p1);
	}
	
	public Segment2D(double x0,double y0 ,double x1 ,double y1) {
		this.x0 = x0; 
		this.y0 = y0;
		this.x1 = x1;
		this.y1 = y1;
	
	}
	
	

	@Override
	public boolean contains(Point2D ot) {
		// TODO Auto-generated method stub
		// if the distance between the points and the given point will be equals to the big distance, or less than en epsilon
		double eps = 0.0001;
		double dist = p0.distance(p1);
		boolean isContains = (p0.distance(ot) + p1.distance(ot) == dist);
		// we can also do --> double distOt= (p0.distance(ot) + p1.distance(ot)); 
		// if (Math.abs(distOt-dist)<eps)){ return true;}
		return isContains;
	}

	@Override
	public double area() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public double perimeter() {
		// TODO Auto-generated method stub
		// I think it is just the distance between the 2 points
		return p0.distance(p1);
	}

	@Override
	public void move(Point2D vec) {
		// TODO Auto-generated method stub
		p0.move(vec);
		p1.move(vec);
	}

	// Copy constructor
	@Override
	public GeoShapeable copy() {
		// TODO Auto-generated method stub
		return new Segment2D(p0, p1);
	}

	@Override
	public void scale(Point2D center, double ratio) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void rotate(Point2D center, double angleDegrees) {
		// TODO Auto-generated method stub
		
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