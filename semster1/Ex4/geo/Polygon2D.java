package Exe.Ex4.geo;

import java.util.ArrayList;
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


	private ArrayList<Point2D> arrayOfPoints = new ArrayList<Point2D>();

	public Polygon2D(ArrayList<Point2D> points) {
		this.arrayOfPoints = new ArrayList <Point2D>();
		for (int i=0; i<points.size(); i++) {
			this.arrayOfPoints.add(points.get(i));
		}
	}


	// Going over by loop and adding to the String the points
	@Override
	public String toString() {
		String res = "Polygon2D,";
		for (Point2D point : arrayOfPoints) {
			res += "," + point;
		}
		return res;
	}

	@Override
	public boolean contains(Point2D ot) {
		// checking first if it colsetoeqauls to the points array
		//		for(int i = 0; i<pointsAmt;i++) {
		//			if (points[i].close2equals(ot, 0.001)) {
		//				return true;
		//			}			
		//			//return false;
		//		}
		//		// ray casting algorithm
		////		return false;
		//		return checkInside(points,pointsAmt, ot);	
		return false;
	}

	@Override
	public double area() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public double perimeter() {
		// calculating the dist between every points and adding it to a perimeter sum
		double peri = 0;
		for (int i = 0; i < arrayOfPoints.size() - 1; i++) {
			peri += arrayOfPoints.get(i).distance(arrayOfPoints.get(i + 1));
		}
		peri += arrayOfPoints.get(arrayOfPoints.size() - 1).distance(arrayOfPoints.get(0));
		return peri;
		
		/*
		 * double ans = 0;

		if (kodkod==null || kodkod.size()==1) {return 0;}

		Point2D p1, p2;

		for (int i=0; i<kodkod.size()-1; i++) {
			p1 = new Point2D(kodkod.get(i));
			p2 = new Point2D(kodkod.get(i+1));
			double dist = p1.distance(p2);
			ans += dist;
		}

		p1 = kodkod.getFirst();
		p2 = kodkod.getLast();
		double dist = p1.distance(p2);
		ans += dist;

		return ans;
		 */
	}

	@Override
	public void move(Point2D vec) {

		for (Point2D point : arrayOfPoints) {
			point.move(vec);
		}
	}

	@Override
	public GeoShapeable copy() {
		return new Polygon2D(this.arrayOfPoints);
	}

	@Override
	public void scale(Point2D center, double ratio) {
		for (Point2D point : arrayOfPoints) {
			point.scale(center, ratio);
		}
	}

	@Override
	public void rotate(Point2D center, double angleDegrees) {
		// TODO Auto-generated method stub
		for (Point2D point : arrayOfPoints) {
			point.scale(center, angleDegrees);
		}
	}

	@Override
	public Point2D[] getPoints() {
		Point2D[] arr = new Point2D[this.arrayOfPoints.size()];
		arr = arrayOfPoints.toArray(arr);
		return arr;
	}

}
