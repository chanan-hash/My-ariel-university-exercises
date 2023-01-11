package Exe.Ex4.gui;
import java.awt.Color;
import java.awt.FileDialog;
import java.awt.event.MouseEvent;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

import javax.swing.JFrame;

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
 * @author Michael Id - 206917908
 * @author Chanan Id -  209324102 
 */
public class Ex4 implements Ex4_GUI{
	private  ShapeCollectionable _shapes = new ShapeCollection();
	private  GUI_Shapeable _gs;
	private  Color _color = Color.blue;
	private  boolean _fill = false;
	private  String _mode = "";
	private  Point2D _p1;
	private  Point2D _p2; // helping us to draw the triangle, and for the rotate function	
	private int tag_count = 0;
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

	/**
	 * This function is actually getting the points and draw the shapes from all its qualities --> kind of shape, filled, color, etc...
	 *	All of the drawing is according to stddraw class
	 */
	private static void drawShape(GUI_Shapeable g) {
		StdDraw_Ex4.setPenColor(g.getColor());
		if(g.isSelected()) {StdDraw_Ex4.setPenColor(Color.gray);}
		GeoShapeable gs = g.getShape(); // The shape
		boolean isFill = g.isFilled();

		// Drawing circle
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

		// Drawing rectangle
		if(gs instanceof Rect2D) {
			Rect2D rec = (Rect2D)gs;

			// We are Drawing the rectangle like a polygon so we can rotate it normally
			double[] xArr = new double[] { rec.get_p1().x(), rec.get_p2().x(), rec.get_p3().x(), rec.get_p4().x() };
			double[] yArr = new double[] { rec.get_p1().y(), rec.get_p2().y(), rec.get_p3().y(), rec.get_p4().y() };
			if (isFill) {
				StdDraw_Ex4.filledPolygon(xArr, yArr);
			} else {
				StdDraw_Ex4.polygon(xArr, yArr);
			}
		}

		// Drawing segment
		if(gs instanceof Segment2D) {
			Segment2D seg = (Segment2D)gs;
			Point2D p0 = seg.getPoints()[0];
			Point2D p1 = seg.getPoints()[1];
			StdDraw_Ex4.line(p0.x(), p0.y(), p1.x(), p1.y());
		}

		//Drawing triangle. Based on polygon but with only three points
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

		// Drawing polygon polygon
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

	/**
	 * The action performed like color and sorting
	 */
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
		if(p.equals("Clear")) {_shapes.removeAll(); tag_count = 0;} 		// Reseting the count_tag to 0

		// Calling the sorts
		if(p.equals("ByArea")) {_shapes.sort(new ShapeComp(Ex4_Const.Sort_By_Area));}
		if(p.equals("ByAntiArea")) {_shapes.sort(new ShapeComp(Ex4_Const.Sort_By_Anti_Area));}
		if(p.equals("ByPerimeter")) {_shapes.sort(new ShapeComp(Ex4_Const.Sort_By_Perimeter));}
		if(p.equals("ByAntiPerimeter")) {_shapes.sort(new ShapeComp(Ex4_Const.Sort_By_Anti_Perimeter));}
		if(p.equals("ByTag")) {_shapes.sort(new ShapeComp(Ex4_Const.Sort_By_Tag));}
		if(p.equals("ByAntiTag")) {_shapes.sort(new ShapeComp(Ex4_Const.Sort_By_Anti_Tag));}
		if(p.equals("ByToString")) {_shapes.sort(new ShapeComp(Ex4_Const.Sort_By_toString));}
		if(p.equals("ByAntiToString")) {_shapes.sort(new ShapeComp(Ex4_Const.Sort_By_Anti_toString));}

		// Making all the shapes that are has been drawn to be unselected
		if(p.equals("None")) {
			for(int i=0;i<_shapes.size();i++) {
				GUI_Shapeable s = _shapes.get(i);
				s.setSelected(false);
			}
		}

		// Making all the shapes that are has been drawn to be selected
		if(p.equals("All")) {
			for(int i=0;i<_shapes.size();i++) {
				GUI_Shapeable s = _shapes.get(i);
				s.setSelected(true);
			}
		}

		// Making all the shapes that are has been drawn to be unselected if they are selected now, and the opposite
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

		// Removing all the selected shapes
		if(_mode.equals("Remove")) {
			for (int i = _shapes.size() - 1; i >= 0; i--) {  
				GUI_Shapeable s = _shapes.get(i);            
				if (s.isSelected()) {                        
					_shapes.removeElementAt(i);             
				}
			}
		}


		// Getting all the info about the shape (name, color, isFilled, point values) .That info we are using for saving
		if(p.equals("Info")) {
			String str = getInfo();
			System.out.println(str);
		}

		/**
		 * The save&load are using the stddDrawFrame and fileChooser to select the place were to save/read the file
		 * and calling save and load function that we've built
		 * Save - saving the toString
		 * Load - reading the toString and deciding how to create the shape 
		 */
		// Save&load

		if(p.equals("Save")) {

			FileDialog chooser = new FileDialog(new JFrame(),"Use a .png or .jpg extension", FileDialog.SAVE);
			chooser.setVisible(true);
			String filename = chooser.getFile();
			if(filename != null) {
				_shapes.save(chooser.getDirectory() + File.separator + chooser.getFile());
			}
		}

		if (p.equals("Load")) {
			FileDialog chooser = new FileDialog(new JFrame(),"Use a .png or .jpg extension", FileDialog.LOAD);
			chooser.setVisible(true);
			String filename = chooser.getFile();
			if(filename != null) {
				_shapes.load(chooser.getDirectory() + File.separator + chooser.getFile());
			}
		}

		// Save&Load with another JFrame
		//		if(p.equals("Save")) {
		//		//https://www.codejava.net/java-se/swing/show-simple-open-file-dialog-using-jfilechooser
		//		JFileChooser fileChooser = new JFileChooser();
		//		fileChooser.setCurrentDirectory(new File(System.getProperty("user.dir")));
		//		int result = fileChooser.showSaveDialog(StdDraw_Ex4.getFrame());
		//
		//		if (result == JFileChooser.APPROVE_OPTION) {
		//
		//			try {
		//				fileChooser.getSelectedFile().getAbsoluteFile().createNewFile();
		//			} 
		//			catch (IOException e) {
		//				e.printStackTrace();
		//			}
		//			_shapes.save(fileChooser.getSelectedFile().getPath());
		//		}
		//
		//	}
		//
		//	// Similar to the save
		//	if(p.equals("Load")) {
		//		JFileChooser fileChooser = new JFileChooser();
		//		int result = fileChooser.showOpenDialog(StdDraw_Ex4.getFrame());
		//		if (result == JFileChooser.APPROVE_OPTION) {
		//			try {
		//				fileChooser.getSelectedFile().getAbsoluteFile().createNewFile();
		//			} catch (IOException e) {
		//
		//				e.printStackTrace();
		//			}
		//			_shapes.load(fileChooser.getSelectedFile().getPath());
		//		}
		//	}


		drawShapes(); // Drawing them actually

	}

	/**
	 *  The first mouse clicking that starting to draw the shape
	 */
	public void mouseClicked(Point2D p) {
		System.out.println("Mode: "+_mode+"  "+p);

		// Drawing a circle
		if(_mode.equals("Circle")) {
			if(_gs==null) {
				_p1 = new Point2D(p);
			}
			else {
				_gs.setColor(_color);
				_gs.setFilled(_fill);
				_shapes.add(_gs);
				tag_count++; 		// Incrementing the tag 
				_gs = null;
				_p1 = null;
			}
		}

		// Drawing a rectangle
		if(_mode.equals("Rect")) {
			if(_gs==null) {
				_p1 = new Point2D(p);
			}
			else {
				_gs.setColor(_color);
				_gs.setFilled(_fill);
				_shapes.add(_gs);
				tag_count++; 		// Incrementing the tag 
				_gs = null;
				_p1 = null;
			}

		}

		// Drawing a Segment
		if(_mode.equals("Segment")) {
			if(_gs==null) {
				_p1 = new Point2D(p);
			}
			else {
				_gs.setColor(_color);
				_gs.setFilled(_fill);
				_shapes.add(_gs);
				tag_count++; 		// Incrementing the tag 
				_gs = null;
				_p1 = null;
			}

		}

		// Drawing a triangle
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
				tag_count++; 		// Incrementing the tag 
				_gs = null;
				_p1 = null;
				_p2 = null;
			}

		}

		// Drawing a polygon adding each time the points to the array-list
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


		// Copying the shape according to a place we want to copy it
		if(_mode.equals("Copy")) {
			if (_p1== null) {
				_p1= new Point2D(p);
			}

			else{

				Point2D moveVector = new Point2D(p.x() - _p1.x(), p.y() - _p1.y()); // The place where to copy it
				for (int i = 0; i < _shapes.size(); i++) {
					GUI_Shapeable s = _shapes.get(i);
					GeoShapeable g = s.getShape();
					if (s.isSelected() && g != null) {
						GUI_Shapeable copy = s.copy();
						copy.getShape().move(moveVector);
						copy.setTag(tag_count++); 			// Setting the tag to a new shape, so it won't copy the old tag 
						_shapes.add(copy);
					}

					_p1 = null;
				}
			}
		}

		// Scale mode
		// making it smaller
		if(_mode.equals("Scale_90%")){
			_p1 = new Point2D(p);
			for(int i=0;i<_shapes.size();i++) {
				GUI_Shapeable s = _shapes.get(i);
				GeoShapeable g = s.getShape();
				if(s.isSelected() && g!=null) {
					g.scale(_p1, 0.9);
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
					g.scale(_p1, 1.1);
				}
			}
		}

		// Rotate function
		if (_mode.equals("Rotate")) {
			if (_p1 == null) {
				_p1 = new Point2D(p);
			} 
			else {
				_p2 = new Point2D(p);

				for (int i = 0; i < _shapes.size(); i++) {
					GUI_Shapeable s = _shapes.get(i);
					GeoShapeable g = s.getShape();
					if (s.isSelected() && g != null) {
						g.rotate(_p1, Math.toDegrees(_p1.angleFromPoints(_p2)));
					}
				}
				_p1 = null;
				_p2 = null;
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
				//polygon = new ArrayList<Point2D>();
				Polygon2D polygon2 = new Polygon2D(polygon); 
				_gs = new GUIShape(polygon2, _fill, _color, tag_count); // Creating a new polygon so we won't save and remember the right click
				_gs.setColor(_color);
				_gs.setFilled(_fill);
				_shapes.add(_gs);
				tag_count++; 		// Incrementing the tag ,here it after we're creating the polygon 
				_gs = null;
				_p1 = null;
				polygon.clear();
				drawShapes();
			}
			if(_mode.equals("Circle") || _mode.equals("Rect" )||_mode.equals("Triangle" ) || _mode.equals("Segment")) {
				_gs = null;
				_p1 = null;
				_p2 = null;
				drawShapes();  // Drawing "nothing" so we can cancel the shape  
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

			// We are doing it by four points so we will draw a polygon that will be a rectangle
			// Drawing rectangle
			if(_mode.equals("Rect")) {
				Point2D p2 = new Point2D(p.x(), _p1.y());
				Point2D p4 = new Point2D(_p1.x(), p.y());
				gs = new Rect2D(_p1,p2,p,p4);
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

			_gs = new GUIShape(gs,false, Color.pink, tag_count); // Changing the tag to the count
			drawShapes();
		}
	}

	@Override
	public ShapeCollectionable getShape_Collection() {
		return this._shapes;
	}
	
	@Override
	public void show() {show(Ex4_Const.DIM_SIZE); }

	// Returning the info about the shape. It helps us to save to the file
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

