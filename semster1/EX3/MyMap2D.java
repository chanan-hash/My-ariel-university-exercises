package Exe.EX3;
/**
 * This class implements the Map2D interface.
 * You should change (implement) this class as part of Ex3. */
public class MyMap2D implements Map2D{
	private int[][] _map;

	public MyMap2D(int w, int h) {init(w,h);}
	public MyMap2D(int size) {this(size,size);}

	public MyMap2D(int[][] data) { 
		this(data.length, data[0].length);
		init(data);
	}
	@Override
	public void init(int w, int h) {
		_map = new int[w][h];

	}
	@Override
	public void init(int[][] arr) {
		init(arr.length,arr[0].length);
		for(int x = 0;x<this.getWidth()&& x<arr.length;x++) {
			for(int y=0;y<this.getHeight()&& y<arr[0].length;y++) {
				this.setPixel(x, y, arr[x][y]);
			}
		}
	}
	@Override
	public int getWidth() {return _map.length;}
	@Override
	public int getHeight() {return _map[0].length;}
	@Override
	public int getPixel(int x, int y) { return _map[x][y];}
	@Override
	public int getPixel(Point2D p) { 
		return this.getPixel(p.ix(),p.iy());
	}

	public void setPixel(int x, int y, int v) {_map[x][y] = v;}
	public void setPixel(Point2D p, int v) { 
		setPixel(p.ix(), p.iy(), v);
	}

	@Override
	/**
	 * For my self 2D Point class giving us an object of double values (x,y)
	 *based on Bresenham's line idea.
	 */
	// This function is getting (x1,y1) (x2,y2) and a vector
	public void drawSegment(Point2D p1, Point2D p2, int v) {

//		// case 1 p1.iy = p2.iy --> we will run on x and color every point -- line
//		if(p1.iy() == p2.iy()) {
//			int minX = Math.min(p1.ix(), p2.ix());
//			int distX = (int)Math.abs(p1.ix() - p2.ix());
//			for (int i = 0; i<=distX; i++) {
//				setPixel(i + minX,p1.iy(), v);
//			}
//		}
//
//		// case 2 p1.ix = p2.ix --> we will run on y and color every point -- line
//		if(p1.ix() == p2.ix()) {
//			int distY = (int)Math.abs(p1.iy() - p2.iy());
//			int minY = Math.min(p1.iy(), p2.iy());
//			for(int i = 0; i<=distY; i++) {
//				setPixel(p1.ix(),i+minY,v);
//			}
//		}
		
		// add the source from the internet
		int distX = (int)Math.abs(p1.ix() - p2.ix());
		int distY = (int)Math.abs(p1.iy() - p2.iy());
		
		int sx = p2.x() < p1.x() ? 1 : -1;
		int sy = p2.y() < p1.y() ? 1 : -1;
		
		int x0 = p2.ix();
		int y0 = p2.iy();
		int x1 = p1.ix();
		int y1 = p1.iy();
		
		int err = distX - distY;
		int e2;
	
		while(true) {
			setPixel(x0,y0,v);
			if(x0 == x1 && y0== y1) {
				break;
			}
			
			e2 = 2*err;
			if(e2>-distY) {
				err = err-distY;
				x0 = x0 + sx;
 			}
			if(e2<distX) {
				err = err + distX;
				y0 = y0 +sy;
			}
		}
	
	
	
	}



	@Override
	/**
	 * we will build a matrix from the point sub in abs 
	 * those will be the matrix that will represent the rectangle 
	 */
	public void drawRect(Point2D p1, Point2D p2, int col) {
		// TODO Auto-generated method stub
		int minX = Math.min(p1.ix(), p2.ix());
		int minY = Math.min(p1.iy(), p2.iy());


		int width = Math.abs((p1.ix() - p2.ix())); // the width of the
		int hight = Math.abs((p1.iy() - p2.iy()));

		for (int i = 0; i <= hight; i++) {
			for (int j = 0; j <= width; j++) {
				setPixel(j + minX, i + minY, col);
			}
		}
	}

	@Override
	/**
	 * This by dist function in {@link Point2D} class we will find the radius
	 * each point in the nestend loop every point that is equal or less from the radius we will set this pixel
	 *	we may need to create a new point in every loop
	 *
	 *	In math, every circle we can μηρεν it in a square, so we will use this square to open the matrix we want
	 *	we need to find the top-left corner og the square, and the down-right corner.
	 *	then to check every point if the distance between the current point from the center is smaller then the radius
	 *	if it is so we will color this pixel
	 */
	public void drawCircle(Point2D p, double rad, int col) {
		// TODO Auto-generated method stub

		Point2D topLeft = new Point2D(p.x()-rad,p.y()+rad); //going with x backwards, and with y upwards
		Point2D downRight= new Point2D(p.x()+rad,p.y()-rad); //going with x forward, and with y downwards

		for (double i = topLeft.y(); i>= downRight.y(); i--) {
			for (double j = topLeft.x(); j<= downRight.x(); j++) {  //with x going up, and with y going down
				Point2D pmid= new Point2D(j,i); 					//setting new point for checking if to color it
				if (p.distance(pmid)<rad) { 						// we don't want the top of the square 
					setPixel((int)j,(int)i, col);
				}
			}			
		}
	}

	@Override
	// all the attached points in the same color, draw in a new color
	// Polygon
	// if new_v != get.color --> set pixel(p,new_v)
	public int fill(Point2D p, int new_v) {
		// TODO Auto-generated method stub

		return 0;
	}

	@Override
	public int fill(int x, int y, int new_v) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public Point2D[] shortestPath(Point2D p1, Point2D p2) {
		// TODO Auto-generated method stub
		return null;
		
		
	}

	@Override
	public int shortestPathDist(Point2D p1, Point2D p2) {
		// TODO Auto-generated method stub
		int count = 0;
		
		
		return 0;
	}

	@Override
	public void nextGenGol() {
		// TODO Auto-generated method stub

	}
	@Override
	public void fill(int c) {
		for(int x = 0;x<this.getWidth();x++) {
			for(int y = 0;y<this.getHeight();y++) {
				this.setPixel(x, y, c);
			}
		}

	}

}
