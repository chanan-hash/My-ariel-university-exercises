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
	 *based on
	 */
	// This function is getting (x1,y1) (x2,y2) and a vector
	public void drawSegment(Point2D p1, Point2D p2, int v) {
				int minX = Math.min(p1.ix(), p2.ix());
				int minY = Math.min(p1.iy(), p2.iy());
				int maxX = Math.max(p1.ix(), p2.ix());
				int maxY = Math.max(p1.iy(), p2.iy());
				
				
				int width = Math.abs((p1.ix() - p2.ix())); // the width of the
				int hight = Math.abs((p1.iy() - p2.iy()));
		
				setPixel(p1,v);
				setPixel(p2,v);
				
				Point2D vector = new Point2D(1,1);
				
				for (int i = minX; i <= maxX; i++) {
					for (int j = minX; j <= maxY; j++) {
						p1.move(vector);
							setPixel(j, i, v);
						}
					}
				
		// let say p1 (x0,y0), p2(x1,y1)
//
//		int distx = p2.ix()-p1.ix();
//		int disty = p2.iy()-p1.iy();
//
//		int p = 2*disty-distx;
//
//		int x = p1.ix();
//		int y = p1.iy();
//
//		while (x<p2.ix());
//		if(p>=0) {
//			setPixel(x, y,v);
//			y++;
//			p = p+2*disty-distx;
//		}
//		else {
//			setPixel(x,y,v);  
//			p=p+2*disty; 
//			x++;  
//		}


		
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
	 */
	public void drawCircle(Point2D p, double rad, int col) {
		// TODO Auto-generated method stub
		int radi = (int)rad; 
		int N = 2*radi+1;
		for (int i = 0; i < N; i++){
	        for (int j = 0; j < N; j++){
	            // Start from the left most corner point
	        	Point2D pr = new Point2D (i-radi,j-radi);
	        	if (p.ix()*pr.ix() + p.iy()*pr.iy() <= radi*radi+1 ) {
	        		setPixel(pr, col);
	        	}
	        }
		}
//		Point2D topLeft = new Point2D(p.x()-rad,p.y()+rad);
//		Point2D downRight= new Point2D(p.x()+rad,p.y()-rad);
//
//		for (int i = topLeft.iy(); i<= downRight.iy(); i++) {
//			for (int j = topLeft.ix(); j<= downRight.ix(); j++) {
//				Point2D pmid= new Point2D(j,i);
//				if (p.distance(pmid)<=rad) {
//					setPixel(pmid, col);
//				}
//			}			
//		}
	}

	@Override
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
