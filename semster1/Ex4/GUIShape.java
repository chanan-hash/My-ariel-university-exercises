package Exe.Ex4;
/**
 * This class implements the GUI_shape.
 * Ex4: you should implement this class!
 * @author I2CS
 */
import java.awt.Color;

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
	
	// maybe to add the whole class to string
//	@Override
//	public String toString() {
//		return _g.toString();
//	}
	
	// maybe will help for saving 
	private void init(String[] ww) {

	}
	@Override
	public String toString() {
		return "GUIShape [_g=" + _g + ", _fill=" + _fill + ", _color=" + _color.getRGB() + ", _tag=" + _tag + ", _isSelected="
				+ _isSelected + "]";
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
		// TODO Auto-generated method stub
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
