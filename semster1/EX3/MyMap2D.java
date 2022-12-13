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
	// all the attached points in the same color, draw in a new color
	// Polygon
	// if new_v != get.color --> set pixel(p,new_v)
	// like the One below just from the point
	public int fill(Point2D p, int new_v) {
		return fill(p.ix(),p.iy(),new_v);
	}
	
	@Override
	public int fill(int x, int y, int new_v) {
		int initColor = getPixel(x,y); 			// getting the color of the current pixel
		boolean[][] visited = new boolean[getWidth()][getHeight()]; // boolean matrix to know if we've visited that pixel
		Queue<int[]> q = new LinkedList<int[]>();	// creating the queue for to store the points/ each place will be an array with x and y, that represent the point
		q.add(new int[]{x,y});						// adding the first point
		while(!q.isEmpty()) {						// if the queue is empty --> means that we've finished
			int [] current = q.poll();				// taking out the specific point
			int currX = current[0];
			int currY = current[1];
			if (isOutSideTheMap(currX, currY) || visited[currX][currY] || getPixel(currX, currY) != initColor) { // don't need to be colored
				continue;
			}
			visited[currX][currY] = true;			// updating the place to be true, means we've visited there
			if (_map[currX][currY] == initColor) {	// checking if it needs to be colored
				setPixel(currX,currY, new_v);		// adding the neighbors
				q.add(new int[]{currX+1, currY});
				q.add(new int[]{currX-1, currY});
				q.add(new int[]{currX, currY+1});
				q.add(new int[]{currX, currY-1});				
			}
		}

		return 0;
	}

	protected void addPixelsToQue(Queue<int[]> que, int row, int col) {
		for(int x = -1; x < 2; x++) {
			for (int y = -1; y < 2; y++) { 	//searching the point near the One we're checking
				if(x!=0 || y!=0 || (x!=-1 && y!=-1)||(x!=1 && y!=1)||(x!=-1 && y!=1)||(x!=1 && y!=-1)) { 		// if they are both equal to 0, so we're in the middle
					if(!isOutSideTheMap(row + x, col + y)) {
						que.add(new int[]{row+x, col+y});
					}
				}
			}
		}
	}


	/**
	 * This function works a little same like fill function. 
	 * BUT!!! here we have some interest in the points we've gone through, so we can find the shortest path
	 */
	public Point2D[] shortestPath(Point2D p1, Point2D p2) {

		int src_color = getPixel(p1); //Source color, getting the color of the points to know where we can go through
		int dst_color = getPixel(p2);

		// Checking if the point are not in the same color 
		if(src_color != dst_color) {
			return null;
		}

		// Checking if there is a distance at all
		if(p1.close2equals(p2)) {
			return new Point2D[]{p1};
		}

		// A boolean array to know if we've visited in that point
		boolean[][] visited = new boolean[getWidth()][getHeight()];

		//creating a queue from Point2D type, and this will be an linked list so we can go back over from where we've come
		Queue<Point2D[]> qu = new LinkedList<Point2D[]>(); // each array represent the path
		Point2D[] p_array = {p1}; // An Point2D array that will be the first point that will be add to the queue
		qu.add(p_array);

		while(!qu.isEmpty()) { //means we chave still point to go threw to till the end

			// creating the path array
			Point2D[] path = qu.poll(); // the current point from the queue, that is an array of Point2D, 
			Point2D curren_point = path[path.length-1]; // the last place in the arrays we were in it
			// we don't need to create a new point because POint2D class has a constructor that can copy a given point

			if(visited[curren_point.ix()][curren_point.iy()] == true) {
				continue; 				//means we've already been there
			}
			if(getPixel(curren_point) != src_color) { // if the neighbor is not in the same color, of p1.
				continue;							  // means we can't go throughS there 
			}

			visited[curren_point.ix()][curren_point.iy()] = true; // updating it to be visited
			if (curren_point.ix() == p2.ix() && curren_point.iy() == p2.iy()) {
				return path; 							// means we've got to the end
			}

			//going over the neighbors, to search which to put them
			for(int row = -1; row <= 1; row++) {
				for (int col = -1; col <= 1; col++) { 	//searching the point near the One we're checking
					if(row!=0 || col!=0 && (row!=-1 && col!=-1)||(row!=1 && col!=1)&&(row!=-1 && col!=1)&&(row!=1 && col!=-1)) {  //checking that we aren't going form the diagonal and not out of the map
						int x = curren_point.ix() + row;
						int y = curren_point.iy() + col;
						if (x>=0 && x<getWidth() && y>=0 && y<getHeight()) {
							qu.add(copy_array_value(path,new Point2D(x,y))); //earasing the old path and adding the new array with the new point that we can go with
																			// we couldn't keep going we need a new path
						}
					}	
				}
			}
		}
		return null; // we didn't have any path to go through
	}
	
	
	// Creating a new array with the new point we can go there, that will represent the path
	// Like add function in Arkady's lesson
	private Point2D[] copy_array_value(Point2D[] origin_p_arr, Point2D newPval) { // getting the old path and the new point to add
		//Point2D[] temp = new Point2D[origin_p_arr.length + 1];
		// deep copy of the old array
		Point2D[] temp = Arrays.copyOf(origin_p_arr, origin_p_arr.length + 1);
		
		// adding the new point in the end of the array
		temp[origin_p_arr.length] = newPval;
		return temp;
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


	// Checking if the point is out side of the map, helps us for some of the function here
	private boolean isOutSideTheMap(int x, int y) {
		return x<0 || x>=getWidth() || y<0 || y>=getHeight();
	}

}