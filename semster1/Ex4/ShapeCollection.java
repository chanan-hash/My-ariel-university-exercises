package Exe.Ex4;

import java.awt.Color;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.Scanner;

import Exe.Ex4.geo.Circle2D;
import Exe.Ex4.geo.GeoShapeable;
import Exe.Ex4.geo.Point2D;
import Exe.Ex4.geo.Rect2D;
import Exe.Ex4.geo.Segment2D;
import Exe.Ex4.geo.Triangle2D;
import Exe.Ex4.geo.Polygon2D;


/**
 * This class represents a collection of GUI_Shape.
 * Ex4: you should implement this class!
 * @author I2CS
 *
 */
public class ShapeCollection implements ShapeCollectionable{
	private ArrayList<GUI_Shapeable> _shapes;

	public ShapeCollection() {
		_shapes = new ArrayList<GUI_Shapeable>();
	}
	@Override
	public GUI_Shapeable get(int i) {
		return _shapes.get(i);
	}

	@Override
	public int size() {
		return _shapes.size();
	}

	@Override
	public GUI_Shapeable removeElementAt(int i) {
		//////////add your code below ///////////
		// using remove from array list
		// maybe need contains
		return _shapes.remove(i); 
		//////////////////////////////////////////
	}

	@Override
	public void addAt(GUI_Shapeable s, int i) {
		//////////add your code below ///////////
		_shapes.add(i, s); // From arrays list functions

		//////////////////////////////////////////
	}
	@Override
	public void add(GUI_Shapeable s) {
		if(s!=null && s.getShape()!=null) {
			_shapes.add(s);
		}
	}

	@Override
	public ShapeCollectionable copy() {
		//////////add your code below ///////////
		// Based on deep copy but according to the conditions of the classes

		ShapeCollection copy_shapes= new ShapeCollection();
		for (int i = 0; i<_shapes.size()-1; i++) {
			// to put it put in another variable --> _shapes.get(i);

			GeoShapeable g = _shapes.get(i).getShape().copy(); // copying the shapes qualities
			GUIShape guiSh = new GUIShape(g,_shapes.get(i).isFilled(),_shapes.get(i).getColor(), _shapes.get(i).getTag());
			copy_shapes.add(guiSh);
		}

		return copy_shapes;
		//////////////////////////////////////////
	}

	@Override
	public void sort(Comparator<GUI_Shapeable> comp) {
		//////////add your code below ///////////
		_shapes.sort(comp);
		//////////////////////////////////////////
	}

	@Override
	public void removeAll() {
		//////////add your code below ///////////
		_shapes.removeAll(_shapes); // using remove from arrayslist
		//////////////////////////////////////////
	}

	@Override
	public void save(String file) {
		//////////add your code below ///////////

		// to think if we need to write that is a txt file
		try {
			FileWriter	file_Write = new FileWriter(file); 	
			for(int i = 0; i<_shapes.size(); i++) {
				file_Write.write((_shapes.get(i).toString()+ "\n"));
			}	
			file_Write.close();

		}catch(Exception e) {
			e.printStackTrace();
		}
		//////////////////////////////////////////
	}

	// TODO to check how the info is save --> what is the order

	@Override
	public void load(String file) {
		////////// add your code below ///////////
		// maybe to thry with Buffers
		_shapes.clear(); // maybe to do a new one empty in the same size
		File _file =  new File(file);
		try {
			Scanner sc = new Scanner(_file);
			while(sc.hasNextLine()) {
				String[] info = sc.nextLine().split(","); // to get every info in saperate

				Color color = new Color(Integer.parseInt(info[1])) ; // maybe we will need get color and then parse int
				boolean fill = Boolean.parseBoolean(info[2]);		// as above with get fill
				int tag = Integer.parseInt(info[3]);

				GeoShapeable gs = null;
				Point2D p =new Point2D(0,0); // the files is saves by little pixel aka points. by this point we will represent the objects

				if(info[4].compareTo("Point2D") == 0) {
					p = new Point2D(Double.parseDouble(info[5]),Double.parseDouble(info[6])); // parse to the x,y values
				}

				else if (info[4].compareTo("Circle2D") == 0) {
					double x = 0, y = 0;
					x = Double.parseDouble(info[5]);
					y = Double.parseDouble(info[6]);
					Point2D center = new Point2D(x,y);
					double radius = Double.parseDouble(info[7]);
					gs = new Circle2D(center,radius);
				}

				else if (info[4].compareTo("Rect2D") == 0) {
					double x1 = 0, y1 = 0, x2 = 0, y2 = 0;

					x1=Double.parseDouble(info[5]);
					y1=Double.parseDouble(info[6]);
					x2=Double.parseDouble(info[7]);
					y2=Double.parseDouble(info[8]);

					Point2D p1,p2;
					p1 =new Point2D(x1,y1);
					p2 = new Point2D(x2,y2);
					gs = new Rect2D(p1, p2);
				}
				
				else if (info[4].compareTo("Segment") == 0) {
					double x1 = 0, y1 = 0, x2 = 0, y2 = 0;

					x1=Double.parseDouble(info[5]);
					y1=Double.parseDouble(info[6]);
					x2=Double.parseDouble(info[7]);
					y2=Double.parseDouble(info[8]);

					Point2D p1,p2;
					p1 =new Point2D(x1,y1);
					p2 = new Point2D(x2,y2);
					gs = new Segment2D(p1, p2);

					
				}



			}


		}
		// notice maybe there are another exception such as trying to read uncorrect file
		catch(FileNotFoundException e){

		}

		//////////////////////////////////////////
	}
	@Override
	public Rect2D getBoundingBox() {
		Rect2D ans = null;
		//////////add your code below ///////////
//		ArrayList<Double> xies = new ArrayList<Double>();//for the x
//		ArrayList<Double> yies = new ArrayList<Double>();////for the y
//		for (int i = 0; i < gui.size()-1; i++) {
//			GeoShape shape = gui.get(i).getShape();
//			if(shape instanceof Circle2D) {
//				double rad = ((Circle2D) shape).getRadius();//all the 4 points
//				xies.add(shape.centerOfMass().x()+rad);
//				xies.add(shape.centerOfMass().x()-rad);
//				yies.add(shape.centerOfMass().y()+rad);
//				yies.add(shape.centerOfMass().y()-rad);
//			}
//			else {
//				Point2D[] points =new Point2D[3]; //contain all the points of the shapes
//				points =shape.getPoints();
//				for (int j = 0; j < points.length; j++) {
//					xies.add(points[j].x());
//					yies.add(points[j].y());
//				}
//			}
//		}
//		Collectionss.sort(xies);
//		Collections.sort(yies);
//		Point2D min = new Point2D(xies.get(0), yies.get(0));//min point
//		Point2D max = new Point2D(xies.get(xies.size()-1), yies.get(yies.size()-1));//max point
//		Rect2D rectBB =new Rect2D(min, max);
//		return rectBB;//the BoundingBox

		//////////////////////////////////////////
		return ans;
	}
	@Override
	public String toString() {
		String ans = "";
		for(int i=0;i<size();i=i+1) {
			ans += this.get(i);
		}
		return ans;
	}


}
