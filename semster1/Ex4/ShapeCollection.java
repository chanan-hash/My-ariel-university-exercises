package Exe.Ex4;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Comparator;

import Exe.Ex4.geo.Circle2D;
import Exe.Ex4.geo.GeoShapeable;
import Exe.Ex4.geo.Point2D;
import Exe.Ex4.geo.Rect2D;


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
		// using remove from array list
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
		// Based on deep copy but according to the conditions of the classes

		ShapeCollection copy_shapes= new ShapeCollection();
		for (int i = 0; i<_shapes.size()-1; i++) {
			GeoShapeable g = _shapes.get(i).getShape().copy(); // copying the shapes qualities
			GUIShape guiSh = new GUIShape(g,_shapes.get(i).isFilled(),_shapes.get(i).getColor(), _shapes.get(i).getTag());
			copy_shapes.add(guiSh);
		}

		return copy_shapes;
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

	/**
	 * This function works by using IO library, and saving the info of the shapes by their toString
	 */
	@Override
	public void save(String file_path) {
		try {
			FileWriter file_Write = new FileWriter(file_path);
			for(int i = 0; i<_shapes.size(); i++) {
				file_Write.write((_shapes.get(i).toString()+ "\n")); 
			}	
			file_Write.close();
		}
		catch(IOException e) {
			e.printStackTrace();
		}

	}


	/**
	 * This function is reading the toString and making them to the shapes according to this order
	 * 0. GUIShape
	 * 1. color
	 * 2. is filled
	 * 3. tag
	 * 4. Geoshapeble
	 * 5. the info - point and radius, etc
	 */

	@Override
	public void load(String file) {
		_shapes.clear(); // maybe to do a new one empty in the same size
		try {
			// Open the file
			FileReader reader = new FileReader(file); // getting the file path
			BufferedReader bufferedReader = new BufferedReader(reader); 

			// Read the file
			String line;
			while ((line = bufferedReader.readLine()) != null) {
				_shapes.add(new GUIShape(line));
			}

			// Close the file
			bufferedReader.close();
		}
		catch (IOException e) {
			e.printStackTrace();
		}
	}

	/**
	 * This function gives us the rectangle that surround the shape it self
	 */
	@Override
	public Rect2D getBoundingBox() {
		Rect2D ans = null;
		if (_shapes.size() < 1) {
			return null; // means there no shape in the collection
		}
		double minX = Ex4_Const.DIM_SIZE; // IF the shape is on the edge
		double maxX = 0;
		double minY = Ex4_Const.DIM_SIZE; // IF the shape is on the edge
		double maxY = 0;

		// For reach loop on the shape collection 
		for (GUI_Shapeable gs : _shapes) {
			GeoShapeable g = gs.getShape();
			if (g instanceof Circle2D) {
				Circle2D circle = (Circle2D) g; // casting to make it really a circle
				double r = circle.getRadius();
				Point2D c = circle.getPoints()[0];
				double cx = c.x(); 
				double cy = c.y();

				// deciding if to change the min and max x & y values
				if (cx - r < minX) {
					minX = cx - r;
				}
				if (cx + r > maxX) {
					maxX = cx + r;
				}
				if (cy - r < minY) {
					minY = cy - r;
				}
				if (cy + r > maxY) {
					maxY = cy + r;
				}	
			}
			// means --> it a shape the built up only from points
			else {
				Point2D[] points = g.getPoints();
				for (Point2D point : points) {
					// doing as same at the circle
					if (point.x() < minX) {
						minX = point.x();
					}
					if (point.x() > maxX) {
						maxX = point.x();
					}
					if (point.y() < minY) {
						minY = point.y();
					}
					if (point.y() > maxY) {
						maxY = point.y();
					}
				}
			}
		}
		// Creating the rectangle that surround the shape
		Point2D p1 = new Point2D(minX, minY);
		Point2D p2 = new Point2D(maxX, maxY);
		ans = new Rect2D(p1, p2);
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

	/**
	 * File _file =  new File(file);
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

				else if (info[4].compareTo("Segment2D") == 0) {
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
				else if (info[4].compareTo("Triangle2D") == 0) {
					double x1 = 0, y1 = 0, x2 = 0, y2 = 0, x3 = 0, y3 = 0;
					x1=Double.parseDouble(info[5]);
					y1=Double.parseDouble(info[6]);
					x2=Double.parseDouble(info[7]);
					y2=Double.parseDouble(info[8]);
					x3=Double.parseDouble(info[9]);
					y3=Double.parseDouble(info[10]);

					Point2D p1, p2, p3;
					p1 =new Point2D(x1,y1);
					p2 = new Point2D(x2,y2);
					p3 = new Point2D(x3,y3);

					gs = new Triangle2D(p1, p2, p3);
				}

			}
		}
		// notice maybe there are another exception such as trying to read uncorrect file
		catch(IOException e){

		}

		//////////////////////////////////////////

	 */
}
