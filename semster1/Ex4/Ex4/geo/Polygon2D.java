package Exe.Ex4.geo;
import java.awt.geom.*;
import java.util.Arrays;

/**
 * This class represents a 2D polygon, as in https://en.wikipedia.org/wiki/Polygon
 * This polygon can be assumed to be simple in terms of area and contains.
 * 
 * You should update this class!
 * @author boaz.benmoshe
 *
 */
public class Polygon2D implements GeoShapeable{
	static final int INCREASE_SIZE = 5;  

	private Point2D[] points;
	int pointsAmt = 0;

	public Polygon2D(Point2D p) {
		// polygon must have at list 3 points --> triangle
		this.points = new Point2D[INCREASE_SIZE];
		this.points[pointsAmt++] = new Point2D(p);

	}

	// adding to the points array
	public void add(Point2D p) {
		if (pointsAmt == points.length) {
			resize();
		}
		points[pointsAmt++] = new Point2D(p);
	}

	private void resize() {
		Point2D[] pointsArrayTmp = new Point2D[points.length + INCREASE_SIZE];
		for (int i=0;i<points.length;i++) {
			pointsArrayTmp[i] = points[i];
		}
		points = pointsArrayTmp;
	}


	@Override
	public boolean contains(Point2D ot) {
		// checking first if it colsetoeqauls to the points array
		for(int i = 0; i<pointsAmt;i++) {
			if (points[i].close2equals(ot, 0.001)) {
				return true;
			}			
			//return false;
		}
		// ray casting algorithm
//		return false;
		return checkInside(points,pointsAmt, ot);	
	}

	@Override
	public double area() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public double perimeter() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public void move(Point2D vec) {
		// TODO Auto-generated method stub
		// loop on the point array and move func'
	}

	@Override
	public GeoShapeable copy() {
		// TODO Auto-generated method stub
		return null;
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
		// TODO Auto-generated method stub
		// test imeadatly
		return Arrays.copyOfRange(points, 0, pointsAmt);
	}



	int direction(Point2D a, Point2D b, Point2D c)
	{

		double val = (b.y() - a.y()) * (c.x() - b.x()) - (b.x() - a.x()) * (c.y() - b.y());
		if (val == 0) {
			// Colinear
			return 0;}

		else if (val < 0) {
			// Anti-clockwise direction
			return 2;}

		// Clockwise direction
		return 1;
	}



	public boolean isIntersect(Segment2D l1, Segment2D l2){ 

		// Four direction for two lines and points of other line

		double dir1 = direction(l1.getP0(), l1.getP1(), l2.getP0());

		double dir2 = direction(l1.getP0(), l1.getP1(), l2.getP1());
		double dir3 = direction(l2.getP0(), l2.getP1(), l2.getP0());

		double dir4 = direction(l2.getP0(), l2.getP1(), l2.getP1());	 
		// When intersecting

		if (dir1 != dir2 && dir3 != dir4) {
			return true;
		}

		// When p2 of line2 are on the line1
		if (dir1 == 0 && l1.contains(l2.getP0())) {
			return true;
		}

		// When p1 of line2 are on the line1
		if (dir2 == 0 && l1.contains(l2.getP1())) {
			return true;
		}	 

		// When p2 of line1 are on the line2
		if (dir3 == 0 && l2.contains(l1.getP0())) {
			return true;
		}
		// When p1 of line1 are on the line2
		if (dir4 == 0 && l2.contains(l1.getP1())) {
			return true;
		}	 

		return false;
	}


	public boolean checkInside(Point2D poly[], int n, Point2D p){
		// When polygon has less than 3 edge, it is not polygon
		if (n < 3) {
			return false;
	}

		// Create a point at infinity, y is same as point p
		Segment2D exline =new Segment2D(p, new Point2D(9999,p.y())) ;
		int count = 0;
		int i = 0;
		do {
			// Forming a line from two consecutive points of

			// poly

			Segment2D side = new Segment2D(poly[i],poly[(i + 1) % n] );
			
			if (isIntersect(side, exline)) {
				// If side is intersects exline

				if (direction(side.getP0(), p, side.getP1()) == 0) {
					return side.contains(p);
					}
				count++;

			}

			i = (i + 1) % n;

		} while (i != 0);
		// When count is odd
		return (count%2==1);
	}



}
