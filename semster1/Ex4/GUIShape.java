package Exe.Ex4;
/**
 * This class implements the GUI_shape.
 * Ex4: you should implement this class!
 * @author I2CS
 */
import java.awt.Color;
import java.util.ArrayList;

import Exe.Ex4.geo.Circle2D;
import Exe.Ex4.geo.GeoShapeable;
import Exe.Ex4.geo.Point2D;
import Exe.Ex4.geo.Polygon2D;
import Exe.Ex4.geo.Rect2D;
import Exe.Ex4.geo.Segment2D;
import Exe.Ex4.geo.Triangle2D;


public class GUIShape implements GUI_Shapeable{
	private GeoShapeable _g = null;
	private boolean _fill;
	private Color _color;
	private int _tag;
	private boolean _isSelected;
	
	public GUIShape(GeoShapeable g, boolean f, Color c, int t) {
		_g = null;
		if (g!=null) {_g = g.copy();}
		_fill= f;
		_color = c;
		_tag = t;
		_isSelected = false;
	}
	public GUIShape(GUIShape ot) {
		this(ot._g, ot._fill, ot._color, ot._tag);
	}
	
	/**
	 *  Will help for loading state, to know to create a shape from String
	 */
	public GUIShape(String str) {
		init(str.split(","));
	} 
	
	@Override
	public GeoShapeable getShape() {
		return _g;
	}

	@Override
	public boolean isFilled() {
		return _fill;
	}

	@Override
	public void setFilled(boolean filled) {
		_fill = filled;
	}

	@Override
	public Color getColor() {
		return _color;
	}

	@Override
	public void setColor(Color cl) {
		_color = cl;
	}

	@Override
	public int getTag() {
		return _tag;
	}

	@Override
	public void setTag(int tag) {
		_tag = tag;
		
	}

	@Override
	public GUI_Shapeable copy() {
		GUI_Shapeable cp = new GUIShape(this);
		return cp;
	}
	
	/**
	 *  Help us for loading.
	 *  When we're saving the file, of going according the toString of the shape.
	 *  So when we want to load we will read this toString it a arrays of strings, in every index in the array it represent something else on the shape
	 * ww[0] = GUISahpe
	 * ww[1] = color
	 * ww[2] = is filled
	 * ww[3] = tag, that is an Integer
	 * ww[4] = the info of the shape --> the name
	 * ww[5....and] --> the points, their x and y values, or also the radius if it a circle
	 */
	private void init(String[] ww) {
		_color = new Color(Integer.parseInt(ww[1]));
		_fill = Boolean.parseBoolean(ww[2]);
		_tag = Integer.parseInt(ww[3]);
		String info = ww[4];
		
		Point2D p =new Point2D(0,0); // the files is saves by little pixel aka points. by this point we will represent the objects
		
		if(info.compareTo("Point2D") == 0) {
			p = new Point2D(Double.parseDouble(ww[5]),Double.parseDouble(ww[6])); // parse to the x,y values
		}

		else if (info.compareTo("Circle2D") == 0) {
			double x = 0, y = 0;
			x = Double.parseDouble(ww[5]);
			y = Double.parseDouble(ww[6]);
			Point2D center = new Point2D(x,y);
			double radius = Double.parseDouble(ww[7]);
			_g = new Circle2D(center,radius);
		}

		else if (info.compareTo("Rect2D") == 0) {
			
			double x1 = 0, y1 = 0, x2 = 0, y2 = 0, x3 = 0, y3 = 0, x4 = 0, y4= 0;

			x1=Double.parseDouble(ww[5]);
			y1=Double.parseDouble(ww[6]);
			x2=Double.parseDouble(ww[7]);
			y2=Double.parseDouble(ww[8]);
			x3=Double.parseDouble(ww[9]);
			y3=Double.parseDouble(ww[10]);
			x4=Double.parseDouble(ww[11]);
			y4=Double.parseDouble(ww[12]);
			
			Point2D p1,p2,p3,p4;
			p1 = new Point2D(x1,y1);
			p2 = new Point2D(x2,y2);
			p3 = new Point2D(x3,y3);
			p4 = new Point2D(x4,y4);
			
			ArrayList<Point2D> rectPoints = new ArrayList<Point2D>();
			rectPoints.add(p1);
			rectPoints.add(p2);
			rectPoints.add(p3);
			rectPoints.add(p4);
		
			_g = new Polygon2D(rectPoints);
			
			// to think on the conversion between the rect and the polygon
			// to see how boaz saved the rectangle
		}

		else if (info.compareTo("Segment2D") == 0) {
			double x1 = 0, y1 = 0, x2 = 0, y2 = 0;

			x1=Double.parseDouble(ww[5]);
			y1=Double.parseDouble(ww[6]);
			x2=Double.parseDouble(ww[7]);
			y2=Double.parseDouble(ww[8]);

			Point2D p1,p2;
			p1 = new Point2D(x1,y1);
			p2 = new Point2D(x2,y2);
			_g = new Segment2D(p1, p2);
		}
		else if (info.compareTo("Triangle2D") == 0) {
			double x1 = 0, y1 = 0, x2 = 0, y2 = 0, x3 = 0, y3 = 0;
			x1=Double.parseDouble(ww[5]);
			y1=Double.parseDouble(ww[6]);
			x2=Double.parseDouble(ww[7]);
			y2=Double.parseDouble(ww[8]);
			x3=Double.parseDouble(ww[9]);
			y3=Double.parseDouble(ww[10]);

			Point2D p1, p2, p3;
			p1 =new Point2D(x1,y1);
			p2 = new Point2D(x2,y2);
			p3 = new Point2D(x3,y3);

			_g = new Triangle2D(p1, p2, p3);
		}
		
		else if (info.compareTo("Polygon2D") == 0) {
			ArrayList<Point2D> polyPoints = new ArrayList<Point2D>();
			for (int i = 5; i<ww.length; i = i+2) {
				Point2D pol = new Point2D(Double.parseDouble(ww[i]),Double.parseDouble(ww[i+1]));
				polyPoints.add(pol);
			}
			_g = new Polygon2D(polyPoints);
		}
	}
	
	@Override
	public String toString() {
		return "GUIShape," + _color.getRGB() +"," + _fill + "," + _tag + "," +_g;
	}
	
	@Override
	public boolean isSelected() {
		return this._isSelected;
	}
	@Override
	public void setSelected(boolean s) {
		this._isSelected = s;
	}
	
	@Override
	public void setShape(GeoShapeable g) {
		if(g instanceof Rect2D) {
			this._g = (Rect2D)g;
		}
		if(g instanceof Circle2D) {
			this._g = (Circle2D)g;	
		}
		if(g instanceof Polygon2D) {
			this._g = (Polygon2D)g;
		}
		if(g instanceof Triangle2D) {
			this._g = (Triangle2D)g;			
		}
		if(g instanceof Segment2D) {
			this._g = (Segment2D)g;
		}
	}
}
