package Exe.EX3;

import java.awt.Color;
import java.util.Arrays;

/*** This class is a simple "inter-layer" connecting (aka simplifing) the
 * StdDraw_Ex3 with the Map2D interface.
 * Written for 101 java course it uses simple static functions to allow a 
 * "Singleton-like" implementation.
 * You should change this class!
 * 
 * @author Chanan && Liat
 * ID1: 212736417 - Liat
 * ID2: 209324102 - Chanan
 *
 */
public class Ex3 {
	private static  Map2D _map = null;
	private static Color _color = Color.blue;
	private static String _mode = "";
	public static final int WHITE = Color.WHITE.getRGB();
	public static final int BLACK = Color.BLACK.getRGB();

	public static void main(String[] args) {
		int dim = 10;  // init matrix (map) 10*10
		init(dim);
	}
	private static void init(int x) {
		StdDraw_Ex3.clear();
		_map = new MyMap2D(x);
		StdDraw_Ex3.setScale(-0.5, _map.getHeight()-0.5);
		StdDraw_Ex3.enableDoubleBuffering();
		_map.fill(WHITE);
		drawArray(_map);		
	}

	public static void drawGrid(Map2D map) {
		int w = map.getWidth();
		int h = map.getHeight();
		for(int i=0;i<w;i++) {
			StdDraw_Ex3.line(i, 0, i, h);
		}
		for(int i=0;i<h;i++) {
			StdDraw_Ex3.line(0, i, w, i);
		}
	}
	static public void drawArray(Map2D a) {
		StdDraw_Ex3.clear();
		StdDraw_Ex3.setPenColor(Color.gray);
		drawGrid(_map);
		for(int y=0;y<a.getWidth();y++) {
			for(int x=0;x<a.getHeight();x++) {
				int c = a.getPixel(x, y);
				StdDraw_Ex3.setPenColor(new Color(c));
				drawPixel(x,y);
			}
		}		
		StdDraw_Ex3.show();
	}

	// Adding colors
	public static void actionPerformed(String p) {
		_mode = p;
		if(p.equals("Blue")) {_color = Color.BLUE; }
		if(p.equals("White")) {_color = Color.WHITE; }
		if(p.equals("Black")) {_color = Color.BLACK; }
		if(p.equals("Green")) {_color = Color.GREEN; }
		if(p.equals("Red")) {_color = Color.RED; }
		if(p.equals("Yellow")) {_color = Color.YELLOW; }
		if(p.equals("Clear")) {_map.fill(Color.WHITE.getRGB());} // Adding to clear option for the map

		// Adding sizes
		if(p.equals("20x20")) {init(20);}
		if(p.equals("40x40")) {init(40);}
		if(p.equals("80x80")) {init(80);}
		if(p.equals("160x160")) {init(160);}
		p = null;
		drawArray(_map);

	}

	static Point2D prev_point = null; // Will save points for every next drawing 

	/**
	 * This this is the drawing in the map. 
	 * Except from "Gol" in every function we're doing "mode" = "none", as the example jar file
	 */
	public static void mouseClicked(Point2D p) {
		System.out.println(p);
		int col = _color.getRGB();
		if(_mode.equals("Point")) {
			_map.setPixel(p,col );
		}

		// Rectangle
		else if (_mode.equals("Rect")) {
			
			if (prev_point == null) { 		// Previous point 
				prev_point = p;
			} 
			else {
				_map.drawRect(prev_point, p, col);
				prev_point = null; 					// So we can draw from the beginning and not to continue the rectangle
				_mode = "none";
			}
		}

		// Segment
		else if (_mode.equals("Segment")) {
			if (prev_point == null) {
				prev_point = p;
			}
			else {
				_map.drawSegment(prev_point, p, col);
				prev_point = null;
				_mode = "none";
			}
		}

		// Circle
		else if (_mode.equals("Circle")) {
			if (prev_point == null) {
				prev_point = p;
			}
			else {
				_map.drawCircle(prev_point, (int)prev_point.distance(p), col);
				prev_point = null;
				_mode = "none";
			}
		}

		//Shortest path
		else if (_mode.equals("ShortestPath")) {
			if (prev_point == null) {
				prev_point = p;
			}
			else {
				Point2D[] shortestPath = _map.shortestPath(prev_point, p);
				System.out.println(Arrays.toString(shortestPath));
				if(shortestPath == null) {			
					prev_point = null; 		// If there is no path, so restart the clicking point 
				}
				else {
					int dist = _map.shortestPathDist(prev_point, p);
					for(int i = 0 ; i<dist; i++) {
						_map.setPixel(shortestPath[i], col);
					}
					prev_point = null;
					_mode = "none";
				}
			}
		}

		// Fill
		if(_mode.equals("Fill")) {
			_map.fill(p, col);
			_mode = "none";
		}

		// Game Of Life
		if(_mode.equals("Gol")) {
			_map.nextGenGol();	
		}
		drawArray(_map);
	}


	static private void drawPixel(int x, int y) {
		StdDraw_Ex3.filledCircle(x, y, 0.3);
	}
}
