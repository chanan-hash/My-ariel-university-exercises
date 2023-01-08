package Exe.Ex4.geo;

import Exe.Ex4.Ex4_Const;

/**
 * This class represents a 2D rectangle (NOT necessarily axis parallel - this shape can be rotated!)
 * Ex4: you should implement this class!
 * @author I2CS
 *
 */
public class Rect2D implements GeoShapeable {
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

	public Rect2D(Point2D p1, Point2D p2, Point2D p3, Point2D p4) {
		this._p1 = new Point2D(p1);
		this._p2 = new Point2D(p2);
		this._p3 = new Point2D(p3);
		this._p4 = new Point2D(p4);	
	}
	
	/**
	 * The width and height going according to the min and max x&y values
	 */
	
	public double getWidth() {
		return _p1.distance(_p2); 
	}

	public double getHeight() {
		return _p2.distance(_p3);
	}

// adding who is p Min and who is p Max for the function underneath
	/**
	 * Because we are creating the rectangle from polygon, so if we're rotating it we'll need another we to check if a point is inside it
	 * This will be similar to check if a point is contains inside a triangle
	 * 1. We will divide the rectangle to 4 triangle, that is built from the given point 'ot', and the other points
	 * 2. then we will add the sum of the areas of the triangle and check if it equal to the rectangle area
	 */
	@Override
	public boolean contains(Point2D ot) {
		Triangle2D tri1 = new Triangle2D(ot, _p1, _p2);
		Triangle2D tri2 = new Triangle2D(ot, _p2, _p3);
		Triangle2D tri3 = new Triangle2D(ot, _p3, _p4);
		Triangle2D tri4 = new Triangle2D(ot, _p4, _p1);
		double trisArea= tri1.area()+tri2.area()+tri3.area()+tri4.area();
		
		return (Math.abs(this.area() - trisArea) <= Ex4_Const.EPS);
	}

	/**
	 * The area and the perimeter are based on the regular math formula for them
	 */
	@Override
	public double area() {
		double width = getWidth();
		double height = getHeight();

		return width*height;
	}

	@Override
	public double perimeter() {
		double width = getWidth();
		double height = getHeight();

		double peri = 2*width + 2*height;
		return peri;
	}

	/**
	 * Based on move function from Point2D class 
	 */
	@Override
	public void move(Point2D vec) {
		// TODO Auto-generated method stub
		_p1.move(vec);
		_p2.move(vec);		
		_p3.move(vec);		
		_p4.move(vec);		
		
	}

	@Override
	public GeoShapeable copy() {
		return new Rect2D(_p1,_p2,_p3,_p4);
	}

	@Override
	public String toString() {
		return "Rect2D," + this._p1 + "," + this._p2 + "," + this._p3 + "," + this._p4;
	}

	/**
	 * The scale and the rotate here are based on those function in Point2D class
	 */
	@Override
	public void scale(Point2D center, double ratio) {
		this._p1.scale(center,ratio);
		this._p2.scale(center,ratio);
		this._p3.scale(center, ratio);
		this._p4.scale(center, ratio);
		
	}

	//TODO - fix it
	@Override
	public void rotate(Point2D center, double angleDegrees) {
		this._p1.rotate(center, angleDegrees);
		this._p2.rotate(center, angleDegrees);
		this._p3.rotate(center, angleDegrees);
		this._p4.rotate(center, angleDegrees);
	}

	
	@Override
	public Point2D[] getPoints() {
		Point2D[] ans = {new Point2D(this._p1), new Point2D(this._p2),new Point2D(this._p3),new Point2D(this._p4) };
		return ans;
	}

	/**
	 * Computes the center of mass of this shape, this will helps us to draw the Rect' with StdDraw
	 */
	public Point2D centerOfMass() {
		return new Point2D(Math.abs(((this._p1.x()+this._p2.x())/2)),Math.abs((this._p1.y()+this._p2.y())/2));
	}

	
	//Getters & Setters
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
