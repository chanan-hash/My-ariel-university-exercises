package Exe.EX3;

import java.awt.Color;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;



/**
 * This class implements the Map2D interface.
 * You should change (implement) this class as part of Ex3. 
 * 
 * @author Chanan && Liat
 * ID1: 212736417 - Liat
 * ID2: 209324102 - Chanan
 * 
 * */
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
	 * Based on Bresenham's line idea.
	 * This algorithm is calculating the line step by step.
	 * In each iteration we are checking which is the next pixel to go to.
	 * And that how we draw the line
	 *
	 * The algorithm finds the closest point to the liner equation, so they will be the points to color
	 * 
	 * The main idea is each iteration to check if we need to move the point right or left, or up or down, 
	 * depending on how far is from the slope of the big equation.
	 * 
	 * Was Based from https://www.sanfoundry.com/java-program-bresenham-line-algorithm/
	 * A visual explanation of the algorithm https://www.youtube.com/watch?v=IDFB5CDpLDE&t=236s
	 */
	public void drawSegment(Point2D p1, Point2D p2, int v) {

		int distX = (int)Math.abs(p1.ix() - p2.ix()); // Delta X
		int distY = (int)Math.abs(p1.iy() - p2.iy()); // Delta Y

		// Checking if to go right or left, up or down
		int sx = p2.x() < p1.x() ? 1 : -1;  // X slope according to which point is higher
		int sy = p2.y() < p1.y() ? 1 : -1;  // Y slope according to which point is higher

		int x0 = p2.ix();
		int y0 = p2.iy();
		int x1 = p1.ix();
		int y1 = p1.iy();

		int err = distX - distY; 
		int e2 = 0;				// Decision variable, based on 2*(DeltaX - DeltaY), that will fix the slope error

		while(true) {
			setPixel(x0,y0,v);	// Drawing the points
			if(x0 == x1 && y0== y1) {  // Means we've got to the end point.
				break;
			}

			e2 = 2*err;      
			if(e2 > -distY) { 		// Going right or left
				err = err-distY;
				x0 = x0 + sx; 
			}
			if(e2 < distX) {		// Going up or down
				err = err + distX;
				y0 = y0 + sy;
			}
		}

	}

	@Override
	/**
	 * To create a rectangle in a matrix we need only 2 point. 
	 * The to point will give us the width and height of the rectangle 
	 * 
	 * 1. We will find the minimum x & y values to know the times we need to run on the matrix.
	 * 	  We won't run from point to point (in the end yes but in a different way).
	 * 
	 * 2. We will find the width and height of the rectangle.
	 * 3. Then we will run from 0 till the width and height, and every point will add the min' values we've found.
	 * 	  That how we will gwt the point we need, and color it
	 */
	public void drawRect(Point2D p1, Point2D p2, int col) {

		int minX = Math.min(p1.ix(), p2.ix()); // Minimum x 
		int minY = Math.min(p1.iy(), p2.iy()); // Minimum y 

		int width = Math.abs((p1.ix() - p2.ix())); // The width of the rectangle
		int height = Math.abs((p1.iy() - p2.iy())); // The height of the rectangle

		for (int i = 0; i <= width ; i++) {
			for (int j = 0; j <= height; j++) {
				if(i>=0 && i<getWidth() && j>=0 &&j<getHeight()) { //Checking we aren't going over the map bounds
					setPixel(i + minX, j + minY, col);
				}
			}
		}
	}

	@Override
	/**
	 *	In math, every circle we can block in a square.
	 *  We will use this square to open the matrix we want to run on.
	 * 1. We need to find the top-left corner of the square, and the down-right corner.
	 * 2. Top left = x-radius, y+radius.
	 * 3. Down-right = x+radius, y-radius
	 * 4. Then we'll run from top-left to down-right points, 
	 *    and checking every point if the distance between it from the center is smaller then the radius.
	 *    notation: not smaller-equal (<=), because then we will get a less nice circle
	 *	5. If it is, we will color this pixel
	 */
	public void drawCircle(Point2D p, double rad, int col) {

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
	 *
	 * 1. We will do first checking to know if there is a path
	 * 2. We will check the colors of the to point, if there not equal, means the is no path
	 * 3. Then we will check if there is a distance at all, maybe this is the same point
	 *
	 * Now we know that there maybe a path, so lets try to find it,
	 * 
	 * 4. We will create a boolean matrix to check if we've visited in that point already, to reduce checking
	 * 5. Then we'll create a queue that will contains a 2DPoint array, and it will be a linked list type
	 * 6. We'll add the first point (in 2DPoint array format) to the queue
	 * 7. We'll create an array of points that will represent the path.
	 * 8. While we have still point to check (means the queue is not empty) the loop will  run
	 * 9. We'll poll from the queue, and check is last point if is suitable to put in the path
	 * 10. Not suitable = have been visited, and not in the same color of the first point (means it is a "rock"/block)
	 * 11. If it is equal to p2, we can return the path, because it means we've got to our point
	 * 12. Else we will check the neighbors and add them to the old path till now and then to the queue
	 * 
	 * Notice: In every iteration we are destroying and creating new array,  
	 * to change their size and to add points that we can/might go with them till we'll get to the end.
	 * 
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