package Exe.Ex4.geo;

/** 
 * This class represents a 2D circle in the plane. 
 * Please make sure you update it according to the GeoShape interface.
 * Ex4: you should update this class!
 * @author boaz.benmoshe
 *
 */
public class Circle2D implements GeoShapeable{
	private Point2D _center;
	private double _radius;

	public Circle2D(Point2D cen, double rad) {
		this._center = new Point2D(cen);	// So 
		this._radius = rad;
	}
	public double getRadius() {return this._radius;}
	
//	@Override
//	public String toString()
//	{ return _center.toString()+", "+_radius;}
	
	
	
	@Override
	public boolean contains(Point2D ot) {
		double dist = ot.distance(this._center);
		return dist<=this._radius;
	}

	@Override
	public String toString() {
		return "Circle2D [_center=" + _center + ", _radius=" + _radius + "]";
	}
	
	@Override
	public double area() {
		double ans = Math.PI * Math.pow(this._radius, 2);
		return ans;
	}
	@Override
	public double perimeter() {
		double ans = Math.PI * 2 * this._radius;
		return ans;
	}
	@Override
	public void move(Point2D vec) {
		_center.move(vec);
	}
	@Override
	public GeoShapeable copy() {			// Like a copy constructor
		return new Circle2D(_center, _radius);
	}
	@Override
	public Point2D[] getPoints() {
		Point2D[] ans = new Point2D[2];
		ans[0] = new Point2D(this._center);
		ans[1] = new Point2D(ans[0].x(), ans[0].y()+this._radius);
		return ans;
	}
	@Override
	public void scale(Point2D center, double ratio) {
		//////////add your code below ///////////
		// if the object contains the center point --> if it is a circle
		if(this.contains(center)) {
			this._radius *= ratio; // we are changing the radius, so we will make the circle big or small
		}
		//////////////////////////////////////////
	}

	// need to be checked
	@Override
	public void rotate(Point2D center, double angleDegrees) {
		//////////add your code below ///////////
		// Calculate the sine and cosine of the rotation angle 
		if(this.contains(center)) {
			double cosAngle = Math.cos(angleDegrees * Math.PI / 180.0);
			double sinAngle = Math.sin(angleDegrees * Math.PI / 180.0);

			// Calculate the rotated center point
			double x = center.x() + (this._center.x() - center.x()) * cosAngle - (this._center.y() - center.y()) * sinAngle;
			double y = center.y() + (this._center.x() - center.x()) * sinAngle + (this._center.y() - center.y()) * cosAngle;
			Point2D rotatedCenterPoint = new Point2D(x, y);

			// Set the rotated center point and keep the radius unchanged
			this._center = rotatedCenterPoint;
		}
	}
	//////////////////////////////////////////
}


