package Exe.Ex4.gui;
import java.awt.Color;
import java.awt.event.MouseEvent;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JFileChooser;

import Exe.Ex4.Ex4_Const;
import Exe.Ex4.GUIShape;
import Exe.Ex4.GUI_Shapeable;
import Exe.Ex4.ShapeCollection;
import Exe.Ex4.ShapeCollectionable;
import Exe.Ex4.geo.Circle2D;
import Exe.Ex4.geo.GeoShapeable;
import Exe.Ex4.geo.Point2D;
import Exe.Ex4.geo.Polygon2D;
import Exe.Ex4.geo.Rect2D;
import Exe.Ex4.geo.Segment2D;
import Exe.Ex4.geo.ShapeComp;
import Exe.Ex4.geo.Triangle2D;

/**
 * 
 * This class is a simple "inter-layer" connecting (aka simplifying) the
 * StdDraw with the Map class.
 * Written for 101 java course it uses simple static functions to allow a 
 * "Singleton-like" implementation.
 * @author boaz.benmoshe
 *
 */
public class Ex4 implements Ex4_GUI{
	private  ShapeCollectionable _shapes = new ShapeCollection();
	private  GUI_Shapeable _gs;
	private  Color _color = Color.blue;
	private  boolean _fill = false;
	private  String _mode = "";
	private  Point2D _p1;
	private  Point2D _p2; // helping us to draw the triangle	

	private ArrayList<Point2D> polygon = new ArrayList<Point2D>(); // will help us to draw the polygon

	private  static Ex4 _winEx4 = null;

	private Ex4() {
		init(null);
	}
	public void init(ShapeCollectionable s) {
		if(s==null) {_shapes = new ShapeCollection();}
		else {_shapes = s.copy();}
		GUI_Shapeable _gs = null;
		Polygon2D _pp = null;
		_color = Color.blue;
		_fill = false;
		_mode = "";
		Point2D _p1 = null;
	}
	public void show(double d) {
		StdDraw_Ex4.setScale(0,d);
		StdDraw_Ex4.show();
		drawShapes();
	}
	public static Ex4 getInstance() {
		if(_winEx4 ==null) {
			_winEx4 = new Ex4();
		}
		return _winEx4;
	}

	public void drawShapes() {
		StdDraw_Ex4.clear();
		for(int i=0;i<_shapes.size();i++) {
			GUI_Shapeable sh = _shapes.get(i);

			drawShape(sh);
		}
		if(_gs!=null) {drawShape(_gs);}
		StdDraw_Ex4.show();
	}

	// here we are declaring which to to some operations like fill
	private static void drawShape(GUI_Shapeable g) {
		StdDraw_Ex4.setPenColor(g.getColor());
		if(g.isSelected()) {StdDraw_Ex4.setPenColor(Color.gray);}
		GeoShapeable gs = g.getShape();
		boolean isFill = g.isFilled();

		if(gs instanceof Circle2D) {
			Circle2D c = (Circle2D)gs;
			Point2D cen = c.getPoints()[0];
			double rad = c.getRadius();
			if(isFill) {
				StdDraw_Ex4.filledCircle(cen.x(), cen.y(), rad);
			}
			else { 
				StdDraw_Ex4.circle(cen.x(), cen.y(), rad);
			}
		}
		// Trying to draw rectangle
		if(gs instanceof Rect2D) {
			Rect2D rec = (Rect2D)gs;
			Point2D[] arr = rec.getPoints();
			Point2D p1 = arr[0];
			Point2D p2 = arr[1];
			double w = Math.abs(p1.x() - p2.x());
			double h = Math.abs(p1.y() - p2.y());
			double centerX = rec.centerOfMass().x();
			double centerY = rec.centerOfMass().y();


			if(isFill) {
				StdDraw_Ex4.filledRectangle(centerX, centerY, w/2, h/2);
			}
			else { 
				StdDraw_Ex4.rectangle(centerX, centerY, w/2, h/2);
			}		
		}

		// Trying to draw the segment
		if(gs instanceof Segment2D) {
			Segment2D seg = (Segment2D)gs;
			Point2D p0 = seg.getPoints()[0];
			Point2D p1 = seg.getPoints()[1];
			StdDraw_Ex4.line(p0.x(), p0.y(), p1.x(), p1.y());
		}

		// Based on fill polygon but with only three points
		if(gs instanceof Triangle2D) {
			Triangle2D tri = (Triangle2D)gs;

			double[] xArr = {tri.getPoints()[0].x(),tri.getPoints()[1].x(),tri.getPoints()[2].x()};
			double[] yArr = {tri.getPoints()[0].y(),tri.getPoints()[1].y(),tri.getPoints()[2].y()};

			if(isFill) {
				StdDraw_Ex4.filledPolygon(xArr, yArr);
			}
			else {
				StdDraw_Ex4.polygon(xArr, yArr);				
			}
		}

		// A polygon
		if(gs instanceof Polygon2D) {
			Polygon2D pol = (Polygon2D)gs;
			Point2D[] parr = pol.getPoints(); // initial the arr

			double[] xarr = new double[parr.length], yarr = new double[parr.length];
			for(int i = 0; i<parr.length; i++) {
				xarr[i] = parr[i].x();
				yarr[i] = parr[i].y();
			}
			if(isFill) {
				StdDraw_Ex4.filledPolygon(xarr, yarr);
			}
			else {
				StdDraw_Ex4.polygon(xarr, yarr);
			}
		}

	}

	private void setColor(Color c) {
		for(int i=0;i<_shapes.size();i++) {
			GUI_Shapeable s = _shapes.get(i);
			if(s.isSelected()) {
				s.setColor(c);
			}
		}
	}
	private void setFill() {
		for(int i=0;i<_shapes.size();i++) {
			GUI_Shapeable s = _shapes.get(i);
			if(s.isSelected()) {
				s.setFilled(_fill);
			}
		}
	}

	public void actionPerformed(String p) {
		_mode = p;
		if(p.equals("Blue")) {_color = Color.BLUE; setColor(_color);}
		if(p.equals("Red")) {_color = Color.RED; setColor(_color);}
		if(p.equals("Green")) {_color = Color.GREEN; setColor(_color);}
		if(p.equals("White")) {_color = Color.WHITE; setColor(_color);}
		if(p.equals("Black")) {_color = Color.BLACK; setColor(_color);}
		if(p.equals("Yellow")) {_color = Color.YELLOW; setColor(_color);}
		if(p.equals("Fill")) {_fill = true; setFill();}
		if(p.equals("Empty")) {_fill = false; setFill();}
		if(p.equals("Clear")) {_shapes.removeAll();}

		// Calling the sorts
		if(p.equals("ByArea")) {_shapes.sort(new ShapeComp(Ex4_Const.Sort_By_Area));}
		if(p.equals("ByAntiArea")) {_shapes.sort(new ShapeComp(Ex4_Const.Sort_By_Anti_Area));}
		if(p.equals("ByPerimeter")) {_shapes.sort(new ShapeComp(Ex4_Const.Sort_By_Perimeter));}
		if(p.equals("ByAntiPerimeter")) {_shapes.sort(new ShapeComp(Ex4_Const.Sort_By_Anti_Perimeter));}
		if(p.equals("ByTag")) {_shapes.sort(new ShapeComp(Ex4_Const.Sort_By_Tag));}
		if(p.equals("ByAntiTag")) {_shapes.sort(new ShapeComp(Ex4_Const.Sort_By_Anti_Tag));}
		if(p.equals("ByToString")) {_shapes.sort(new ShapeComp(Ex4_Const.Sort_By_toString));}
		if(p.equals("ByAntiToString")) {_shapes.sort(new ShapeComp(Ex4_Const.Sort_By_Anti_toString));}

		if(p.equals("None")) {
			for(int i=0;i<_shapes.size();i++) {
				GUI_Shapeable s = _shapes.get(i);
				s.setSelected(false);
			}
		}

		if(p.equals("All")) {
			for(int i=0;i<_shapes.size();i++) {
				GUI_Shapeable s = _shapes.get(i);
				s.setSelected(true);
			}
		}

		if(p.equals("Anti")) {
			for(int i=0;i<_shapes.size();i++) {
				GUI_Shapeable s = _shapes.get(i);
				if(s.isSelected()) {
					s.setSelected(false);
				}
				else {
					s.setSelected(true);
				}
			}

		}

		if(p.equals("Info")) {
			String str = getInfo();
			System.out.println(str);
		}

		// Save&load
		//		if(p.equals("Save")) {_shapes.save("path");}
		if(p.equals("Save")) {
			//https://www.codejava.net/java-se/swing/show-simple-open-file-dialog-using-jfilechooser
			JFileChooser fileChooser = new JFileChooser();
			fileChooser.setCurrentDirectory(new File(System.getProperty("user.dir")));
			int result = fileChooser.showSaveDialog(StdDraw_Ex4.getFrame());

			if (result == JFileChooser.APPROVE_OPTION) {

				try {
					fileChooser.getSelectedFile().getAbsoluteFile().createNewFile();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				_shapes.save(fileChooser.getSelectedFile().getPath());
			}

		}

		// will be similar to the save
		if(p.equals("Load")) {
			JFileChooser fileChooser = new JFileChooser();
			int result = fileChooser.showOpenDialog(StdDraw_Ex4.getFrame());
			if (result == JFileChooser.APPROVE_OPTION) {
				try {
					fileChooser.getSelectedFile().getAbsoluteFile().createNewFile(); // need to be fixed
				} catch (IOException e) {

					e.printStackTrace();
				}
				_shapes.load(fileChooser.getSelectedFile().getPath());
			}
		}
		drawShapes();

	}

	// Drawing the actually shape
	public void mouseClicked(Point2D p) {
		System.out.println("Mode: "+_mode+"  "+p);

		// drawing a circle
		if(_mode.equals("Circle")) {
			if(_gs==null) {
				_p1 = new Point2D(p);
			}
			else {
				_gs.setColor(_color);
				_gs.setFilled(_fill);
				_shapes.add(_gs);
				_gs = null;
				_p1 = null;
			}
		}

		// drawing a rectangle
		if(_mode.equals("Rect")) {
			if(_gs==null) {
				_p1 = new Point2D(p);
			}
			else {
				_gs.setColor(_color);
				_gs.setFilled(_fill);
				_shapes.add(_gs);
				_gs = null;
				_p1 = null;
			}

		}

		//Segment
		if(_mode.equals("Segment")) {
			if(_gs==null) {
				_p1 = new Point2D(p);
			}
			else {
				_gs.setColor(_color);
				_gs.setFilled(_fill);
				_shapes.add(_gs);
				_gs = null;
				_p1 = null;
			}

		}

		// draw triangle
		if(_mode.equals("Triangle")) {
			if(_gs==null) {
				_p1 = new Point2D(p);
			}
			else if (_p2==null) {
				_p2 = new Point2D(p);
			}
			else {
				_gs.setColor(_color);
				_gs.setFilled(_fill);
				_shapes.add(_gs);
				_gs = null;
				_p1 = null;
				_p2 = null;
			}

		}

		//Drawing a polygon adding each time the points to the array-list
		if(_mode.equals("Polygon")) {
			if(_gs==null) {
				polygon.add(p);
				_p1 = new Point2D(p);
			}
			else {
				polygon.add(p);
			}

		}

		if(_mode.equals("Move")) {
			if(_p1==null) {_p1 = new Point2D(p);}
			else {
				_p1 = new Point2D(p.x()-_p1.x(), p.y()-_p1.y());
				move();
				_p1 = null;
			}
		}

		if(_mode.equals("Point")) {
			select(p);
		}

		// Removing all the selected
		if(_mode.equals("Remove")) {
			for (int i = _shapes.size() - 1; i >= 0; --i) {  
				GUI_Shapeable s = _shapes.get(i);            
				if (s.isSelected()) {                        
					_shapes.removeElementAt(i);             
				}
			}
		}

		if(_mode.equals("Copy")) {
			_shapes.copy();
		}

		// Scale mode
		// making it smaller
		// TODO need also to move it with the scale like in the mode
		if(_mode.equals("Scale_90%")){
			_p1 = new Point2D(p);
			for(int i=0;i<_shapes.size();i++) {
				GUI_Shapeable s = _shapes.get(i);
				GeoShapeable g = s.getShape();
				if(s.isSelected() && g!=null) {
					g.scale(p, 0.9);
				}
			}
		}
		// Making it bigger
		if(_mode.equals("Scale_110%")){
			_p1 = new Point2D(p);
			for(int i=0;i<_shapes.size();i++) {
				GUI_Shapeable s = _shapes.get(i);
				GeoShapeable g = s.getShape();
				if(s.isSelected() && g!=null) {
					g.scale(p, 1.1);
				}
			}
		}

		// rotate function
		// the angle is 0.0, need to be fixed
		if(_mode.equals("Rotate")){
			_p1 = new Point2D(p);
			for(int i=0;i<_shapes.size();i++) {
				GUI_Shapeable s = _shapes.get(i);
				GeoShapeable g = s.getShape();
				if(s.isSelected() && g!=null) {
					double angleDegrees = Math.atan2(p.y() - _p1.y(), p.x() - _p1.x()) * 180.0 / Math.PI;
					g.rotate(p, angleDegrees);
				}
			}
		}
		drawShapes();
	}

	private void select(Point2D p) {
		for(int i=0;i<_shapes.size();i++) {
			GUI_Shapeable s = _shapes.get(i);
			GeoShapeable g = s.getShape();
			if(g!=null && g.contains(p)) {
				s.setSelected(!s.isSelected());
			}
		}
	}
	private void move() {
		for(int i=0;i<_shapes.size();i++) {
			GUI_Shapeable s = _shapes.get(i);
			GeoShapeable g = s.getShape();
			if(s.isSelected() && g!=null) {
				g.move(_p1);
			}
		}
	}

	
	// The right click will help us to stop the polygon
	public void mouseRightClicked(Point2D p) {
		System.out.println("right click!");
		if (_gs!=null) {
			if(_mode.equals("Polygon")) {
				_gs.setColor(_color);
				_gs.setFilled(_fill);
				_shapes.add(_gs);
				_gs = null;
				_p1 = null;
				polygon = new ArrayList<Point2D>();

				drawShapes();
			}
			if(_mode.equals("Circle") || _mode.equals("Rect" )||_mode.equals("Triangle" ) || _mode.equals("Segment")) {
				_gs = null;
				_p1 = null;
				
			}
		}
		
		
	}


	// Drawing from the second click
	// building the shape, and up is drawing
	public void mouseMoved(MouseEvent e) {
		if(_p1!=null) {
			double x1 = StdDraw_Ex4.mouseX();
			double y1 = StdDraw_Ex4.mouseY();
			GeoShapeable gs = null;
			//	System.out.println("M: "+x1+","+y1);
			Point2D p = new Point2D(x1,y1);
			if(_mode.equals("Circle")) {
				double r = _p1.distance(p);
				gs = new Circle2D(_p1,r);
			}

			// Drawing rectangle
			if(_mode.equals("Rect")) {
				gs = new Rect2D(_p1,p);
			}

			// Drawing the segment
			if(_mode.equals("Segment")) {
				gs = new Segment2D(_p1.x(),_p1.y(), p.x(),p.y());
			}

			if(_mode.equals("Triangle")) {
				// need to thing on the next click
				if(_p2 != null) {
					gs = new Triangle2D(_p1,_p2,p);
				}
				else {
					gs = new Segment2D(_p1,p);
				}
			}

			if(_mode.equals("Polygon")){	
				ArrayList<Point2D> temp = polygon;
				temp.add(p);
				gs = new Polygon2D(temp);
				temp.remove(p); // Because we don't need it more
			}

			_gs = new GUIShape(gs,false, Color.pink, 0);
			drawShapes();
		}
	}

	@Override
	public ShapeCollectionable getShape_Collection() {
		// TODO Auto-generated method stub
		return this._shapes;
	}
	@Override
	public void show() {show(Ex4_Const.DIM_SIZE); }

	// Maybe to add more qualities 
	@Override
	public String getInfo() {
		// TODO Auto-generated method stub
		String ans = "";
		for(int i=0;i<_shapes.size();i++) {
			GUI_Shapeable s = _shapes.get(i);
			ans +=s.toString()+"\n";
		}
		return ans;
	}
}
