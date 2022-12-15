package Exe.EX3;

import java.awt.Color;
import java.util.Arrays;
import java.util.HashMap;
import java.util.LinkedList;

import java.util.Queue;



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

	/**
	 * for the testing I added a getters to get back the array of the map
	 */
	// getting the array of the map
	public int[][] getMap(){
		return this._map;		
	} 

	public void setPixel(int x, int y, int v) {_map[x][y] = v;}
	public void setPixel(Point2D p, int v) { 
		setPixel(p.ix(), p.iy(), v);
	}

	@Override
	/**
	 * For my self 2D Point class giving us an object of double values (x,y)
	 *based on Bresenham's line idea.
	 *
	 * Was Based from https://www.sanfoundry.com/java-program-bresenham-line-algorithm/
	 */
	// This function is getting (x1,y1) (x2,y2) and a vector
	public void drawSegment(Point2D p1, Point2D p2, int v) {

		//		TODO add the source from the internet
		int distX = (int)Math.abs(p1.ix() - p2.ix());
		int distY = (int)Math.abs(p1.iy() - p2.iy());

		int sx = p2.x() < p1.x() ? 1 : -1;  // the stairs for going to the next point
		int sy = p2.y() < p1.y() ? 1 : -1;

		int x0 = p2.ix();
		int y0 = p2.iy();
		int x1 = p1.ix();
		int y1 = p1.iy();

		int err = distX - distY; // the substract between the height and width giving us the diagonal in like a vector
		int e2 = 0;				// fixing slop error

		while(true) {
			setPixel(x0,y0,v);	// drawing the first point
			if(x0 == x1 && y0== y1) {  // we got from one point to another
				break;
			}

			e2 = 2*err;    //  
			if(e2 > -distY) {
				err = err-distY;
				x0 = x0 + sx; 
			}
			if(e2 < distX) {
				err = err + distX;
				y0 = y0 + sy;
			}
		}

	}

	@Override
	/**
	 * we will build a matrix from the point sub in abs 
	 * those will be the matrix that will represent the rectangle 
	 * 
	 */
	public void drawRect(Point2D p1, Point2D p2, int col) {
		//TODO use range method link from Dovi
		int minX = Math.min(p1.ix(), p2.ix());
		int minY = Math.min(p1.iy(), p2.iy());

		int width = Math.abs((p1.ix() - p2.ix())); // the width of the rectangle
		int height = Math.abs((p1.iy() - p2.iy())); // the height of the rectangle

		for (int i = 0; i <= height; i++) {
			for (int j = 0; j <= width; j++) {
				if(i>=0 && i<getHeight()&& j>=0 &&j<getWidth()) { //to see we aren't going over the bounds
					setPixel(j + minX, i + minY, col);
				}
			}
		}
	}

	@Override
	/**
	 *	In math, every circle we can block in a square, so we will use this square to open the matrix we want
	 *	we need to find the top-left corner og the square, and the down-right corner.
	 *	then to check every point if the distance between the current point from the center is smaller then the radius
	 *	if it is so we will color this pixel
	 */
	public void drawCircle(Point2D p, double rad, int col) {
		// TODO Auto-generated method stub
		// add condition
		Point2D topLeft = new Point2D(p.x()-rad,p.y()+rad); //going with x backwards, and with y upwards
		Point2D downRight= new Point2D(p.x()+rad,p.y()-rad); //going with x forward, and with y downwards

		for (double i = topLeft.y(); i>= downRight.y(); i--) {
			for (double j = topLeft.x(); j<= downRight.x(); j++) {  //with x going up, and with y going down
				Point2D pmid= new Point2D(j,i); 					//setting new point for checking if to color it
				// we don't want the top of the square so only < radius, and not && <=
				if (p.distance(pmid)<rad && i>0 && j>0 && (int)j<_map.length && i<_map[(int)j].length) { 	// write on the conditions, checking the bounds
					setPixel((int)j,(int)i, col);
				}
			}			
		}
	}

	@Override
	/**
	 * This function works like fill(x,y,v) but if can take point.
	 * Actually it calling the other function and giving in the _x & _y values of the point
	 */
	public int fill(Point2D p, int new_v) {
		return fill(p.ix(),p.iy(),new_v);
	}

	/**
	 * This function is actually "fill polygon".
	 * we need to fill in new color all the attached points in the same color, from 4 directions.
	 * 
	 * 1. First we will get the current color to check which point we can color
	 * 2. After it we will create a boolean 2D matrix the size of the map.
	 * 	  This will help us to check if we have visited that point already, to reduce the function actions.
	 * 3. Then we will start adding all the neighbors for the given point to a queue.
	 * 4. Then we will check each x & y values, that represent the point, in the queue if standing in the conditions to be colored 
	 * 		a. yes --> so it will be colored in the new color
	 * 		b. no --> continue to the next iteration
	 */
	@Override
	public int fill(int x, int y, int new_v) {
		
		int initColor = getPixel(x,y); 			// Getting the color of the current pixel.
		
		boolean[][] visited = new boolean[getWidth()][getHeight()]; // Boolean matrix to know if we've visited that pixel.
		
		Queue<int[]> q = new LinkedList<int[]>();	// Creating a queue to store the points. 
													// Each place will be an array with x and y, that represent the point.
		q.add(new int[]{x,y});						// Adding the first point
		
		while(!q.isEmpty()) {						// If the queue is empty --> means that we've finished
			int [] current = q.poll();				// Taking out the specific point.
			int currX = current[0];
			int currY = current[1];
													// Checking if it not needs to be colored
													// 1. Out of bound, 2. were visited, 3. Or in another color. That order is important!! 
			if (isOutSideTheMap(currX, currY) || visited[currX][currY] || getPixel(currX, currY) != initColor) { 
				continue;
			}
			
			visited[currX][currY] = true;			// Updating the place to be true, means we've visited there
			if (_map[currX][currY] == initColor) {	// Checking if it needs to be colored
				setPixel(currX,currY, new_v);		// Adding the neighbors, to be checked in the next iteration
				q.add(new int[]{currX+1, currY});
				q.add(new int[]{currX-1, currY});
				q.add(new int[]{currX, currY+1});
				q.add(new int[]{currX, currY-1});				
			}
		}

		return 0;
	}

	/**
	 * This function works a little same like fill function. 
	 * BUT!!! here we have some interest in the points we've gone through, so we can find the shortest path
	 */
	public Point2D[] shortestPath(Point2D p1, Point2D p2) {
		int src_color = getPixel(p1.ix(),p1.iy()); //Source color, getting the color of the points to know where we can go through
		int dst_color = getPixel(p2.ix(),p2.iy());


		// Checking if the point are not in the same color 
		if(src_color != dst_color) {
			return null;
		}

		// Checking if there is a distance at all, so return array with point itself
		if(p1.close2equals(p2)) {
			return new Point2D[]{p1};
		}

		// mean that there is path and the point in the same color
		boolean[][] visited = new boolean[getWidth()][getHeight()]; // A boolean array to know if we've visited in that point
		
		Queue<Point2D[]> poqu = new LinkedList<Point2D[]>(); //poqu - point queue. A queue that will hold array of points that represent the path
		Point2D [] arr = {p1};								// Creating a points array with the first point to start with 
		poqu.add(arr);										// Adding it to the queue
		
		// creating the path array
		while(!poqu.isEmpty()) {						// Means while we still have point to add 
			Point2D[] path = poqu.poll();				// The current point from the queue, that is an array of Point2D and represent the path till now 	
			Point2D cp = path[path.length - 1];			// Current point, the point that we will check itself and his neighbors if we can add it to the path
			
			if (visited[cp.ix()][cp.iy()]) { 			// If its true 
				continue;								// Means we've already been there and continue to the next iteration.
			}
			if(getPixel(cp) != src_color) { // If the neighbor is not in the same color, of p1.
				continue;					 // means we can't go throughS there 
			}
			
			visited[cp.ix()][cp.iy()] = true;		// updating that we visited the current point
			if (cp.ix() == p2.ix() && cp.iy()==p2.iy()) {	// if it equals to p2, mean we've got to the end, and can return the path
				return path;								// Function equals/colseToEqual is not enough accurate for us here so we need to do it by ourselves
			}
			
			//going over the neighbors, to search which to put them
			for(int row = -1; row <=1; row++) {
				for(int col=-1; col <=1; col++) {
					if ((row != 0 || col != 0) && (Math.abs(row) + Math.abs(col) < 2)) {// if we are not the middle of the grid, and not the diagonal neighbors.
						int x = cp.ix() + row;
						int y = cp.iy() + col;
						if (x >= 0 && x < getWidth() && y >=0 && y < getHeight()) {
							poqu.add(addToPath(path,new Point2D(x,y)));		// the new path with the new points, to the queue.
							//In the next iteration we will check the point and see if we need to create new path without it or to keep it
						}
					}
				}
			}
		}
		return null; 		//We didn't have any path to go through
	}

	// Creating a new array with the new point we can go there, that will represent the path
	// Like add function in Arkady's lesson
	private Point2D[] addToPath(Point2D[] oldPath, Point2D np) { // Getting the old path and, new point to add
		Point2D[] temp = Arrays.copyOf(oldPath, oldPath.length+1);
		temp[oldPath.length] = np; // we can make the oldPath to be a pointer to the temp array and return the oldPath with the added point 										
		return temp;				//oldPath = temp; return oldPath
	}
	


	@Override
	// This function returns us the number of moves we had to do, to go from one point to another 
	public int shortestPathDist(Point2D p1, Point2D p2) {
		Point2D[] path = shortestPath(p1, p2);
		// checking if there is a path length;
		if(path.length>-1) {
			return path.length; //return the length from above
		}
		return -1;
	}


	
	/**
	 * A little explanation on "Game of life":
	 * The game goes only on white or black colors, black = alive, white = not alive.
	 *
	 * Over grid of 3X3 to know what will be in the next generation we have few rules:
	 * 1. If you have less then 2 colored neighbors, you die from loneliness 
	 * 2. If you have 2 colored neighbors, you are not changing. Doesn't matter if you are black or white
	 * 3. IF you have 3 colored neighbors: 
	 * 		a. If you are alive(=colored) so you stay as your self.
	 * 		b. If you are not-alive(=uncolored) so you are being revived.
	 * 4. If you have more then 3 colored neighbors you die from density
	 * 
	 * Explanation on the function:
	 * 1. First we are copying the map to a temporary map, there we will check every point, not to affect the regular map
	 * 2. Then we will go over the temp map, and check for every pixel the neighbors around him and count them
	 * 3. Then according to the living neighbors and to the pixel it self (if he is colored or not), 
	 * 	  in the original map, we will set this pixel with the right color.   
	 */
	
	@Override
	public void nextGenGol() {
		// deep copy of the map, maybe to do it in another function
		int[][] tmp = new int[_map.length][_map[0].length];
		for (int i = 0; i < _map.length; i++) {
			for (int j = 0; j < _map[i].length; j++)  {
				tmp[i][j] = _map[i][j];
			}
		}

		// going over the copy map
		for (int i = 0; i < tmp.length; i++) {
			for (int j = 0; j < tmp[i].length; j++) {

				boolean is_currently_alive = tmp[i][j] != Color.WHITE.getRGB(); // if the point is not white
				int num = 0;													// counter for the neighbors
				for(int x = -1; x < 2; x++) {									// the grid around the point
					for (int y = -1; y < 2; y++) { 								//searching the point near the One we're checking
						if(x!=0 || y!=0) { 									// if they are both equal to 0, so we're in the middle
							if(x+i >= 0 && x+i < tmp.length && y+j >= 0 && y+j < tmp[i].length &&
									tmp[x+i][y+j] != Color.WHITE.getRGB()) { 		// checking the place according to the point
								num += 1;											// we have a colored neighbor
							}
						}
					}
				}

				// checking if it need to be alive or stay in the same color
				if ((is_currently_alive && (num == 2 || num == 3)) || (!is_currently_alive && num == 3) ) {
					setPixel(i, j, Color.BLACK.getRGB());
				}
				else {
					setPixel(i, j, Color.WHITE.getRGB()); // the point dies from loneliness or from density
				}
			}
		}
	}

	@Override
	public void fill(int c) {
		for(int x = 0;x<this.getWidth();x++) {
			for(int y = 0;y<this.getHeight();y++) {
				this.setPixel(x, y, c);
			}
		}

	}


	/**
	 * This function helps us to check if a point is out of the map bounds, helps us for some of the function here. 
	 */
	private boolean isOutSideTheMap(int x, int y) {
		return x<0 || x>=getWidth() || y<0 || y>=getHeight();
	}

}