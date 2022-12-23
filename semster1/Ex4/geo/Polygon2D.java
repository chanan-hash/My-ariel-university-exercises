package Exe.Ex4.geo;

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
	int selected_point = 0;
	
	public Polygon2D() {
		// polygon must have at list 3 points --> triangle
		this.points = new Point2D[5];
	}
	
	// adding to the points array
	public void add(Point2D p) {
		if (selected_point  == points.length) {
			resize();
		}
		points[selected_point++] = p;
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
		return 0;
	}

	@Override
	public void move(Point2D vec) {
		// TODO Auto-generated method stub
		
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
		return Arrays.copyOfRange(points, 0, selected_point);
	}
	
}
