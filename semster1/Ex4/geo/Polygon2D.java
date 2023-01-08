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
			this.arrayOfPoints.add(new Point2D(points.get(i))); // Adding a copy of the Point and not a the refe rence of it
		}
	}


	// Going over by loop and adding to the String the points
	@Override
	public String toString() {
		String res = "Polygon2D";
		for (Point2D point : arrayOfPoints) {
			res += "," + point;
		}
		return res;
	}

	/**
	 * This function is based on rat's casting algorithm.
	 * 1. You take a point, and "draw" a line from it to the right as much as we can/
	 * 2. If it intersects the polygon in odd number --> means it inside
	 * 3. Else if it intersects the polygon in even number --> means it outside
	 */
	@Override
	public boolean contains(Point2D ot) {
		int i, j;
		boolean result = false;
		for (i = 0, j = arrayOfPoints.size() - 1; i < arrayOfPoints.size(); j = i++) {
			if ((arrayOfPoints.get(i).y() > ot.y()) != (arrayOfPoints.get(j).y() > ot.y()) &&
					(ot.x() < (arrayOfPoints.get(j).x() - arrayOfPoints.get(i).x()) * (ot.y() - arrayOfPoints.get(i).y()) / (arrayOfPoints.get(j).y() - arrayOfPoints.get(i).y()) + arrayOfPoints.get(i).x())) {
				result = !result;
			}
		}
		return result;
	
	}

	/**
	 * As Boaz wrote we're working on a simple polygon, and not an intersection one 
	 */
	@Override
	public double area() {
		double area = 0;
		for (int i = 0; i < arrayOfPoints.size(); i++) {
			Point2D p1 = arrayOfPoints.get(i);
			Point2D p2 = arrayOfPoints.get((i + 1) % arrayOfPoints.size());
			area += (p1.x() * p2.y()) - (p1.y() * p2.x());
		}
		return Math.abs(area / 2);

	}

	/**
	 * The method is checking the distance between each point in the polygon and add them to the perimeter variable.
	 */
	@Override
	public double perimeter() {
		// calculating the dist between every points and adding it to a perimeter sum
		// The order of inserting the points is important
		double perimeter = 0;
		for (int i = 0; i < arrayOfPoints.size(); i++) {
			Point2D p1 = arrayOfPoints.get(i);
			Point2D p2 = arrayOfPoints.get((i + 1) % arrayOfPoints.size());
			perimeter += p1.distance(p2);
		}
		return perimeter;
	}
	
	/**
	 * Based on move function from Point2D class 
	 */
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
	
	/**
	 * The scale and the rotate here are based on those function in Point2D class
	 */
	@Override
	public void scale(Point2D center, double ratio) {
		for (Point2D point : arrayOfPoints) {
			point.scale(center, ratio);
		}
	}

	@Override
	public void rotate(Point2D center, double angleDegrees) {
		for (Point2D point : arrayOfPoints) {
			point.rotate(center, angleDegrees);
		}
	}

	@Override
	public Point2D[] getPoints() {
		Point2D[] arr = new Point2D[this.arrayOfPoints.size()];
		arr = arrayOfPoints.toArray(arr);
		return arr;
	}

}
