package Exe.EX3;

import java.awt.Color;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

import javax.management.RuntimeErrorException;


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
		//		double eps = 0.0001;
		//		int m = (p2.iy()-p1.iy())/(p2.ix()-p1.ix()); //the slope 
		//		int minX = Math.min(p1.ix(), p2.ix());
		//		int maxX = Math.max(p1.ix(), p2.ix());
		//		int minY = Math.min(p1.iy(), p2.iy());
		//		int maxY = Math.max(p1.iy(), p2.iy());
		//
		//		for(int i = 0; i<maxY; i++) {
		//			for (int j = 0; j<maxX; j++) {
		//				Point2D pm = new Point2D(j+minX,i+minY);
		//				if(p2.iy()-pm.iy() == m*(p2.ix() - pm.ix())) {
		//					setPixel(j+minX, i+minY,v);
		//				}
		//			}
		//		}

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
		int e2 = 0;

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
	 */
	public void drawRect(Point2D p1, Point2D p2, int col) {
		//TODO use range method link from Dovi
		int minX = Math.min(p1.ix(), p2.ix());
		int minY = Math.min(p1.iy(), p2.iy());

		int width = Math.abs((p1.ix() - p2.ix())); // the width of the
		int hight = Math.abs((p1.iy() - p2.iy()));

		for (int i = 0; i <= hight; i++) {
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


		//TODO change to int
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
	// maybe to change for a queue of points and not of ints
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

	// Checking if the point is out side of the map 
	private boolean isOutSideTheMap(int x, int y) {
		return x<0 || x>=getWidth() || y<0 || y>=getHeight();
	}

	public void updateNeighbors(int[][]visited, int i, int j, int distance) {
		if(i>0) {
			if(visited[i-1][j] == -1) {
				visited[i-1][j] = distance;
			}
		}
		if(i<visited.length-1) {
			if(visited[i+1][j] == -1) {
				visited[i+1][j] = distance;
			}
		}
		if(j>0) {
			if(visited[i][j-1] == -1) {
				visited[i][j-1] = distance;
			}
		}
		if(j<visited[i].length-1) {
			if(visited[i][j+1] == -1) {
				visited[i][j+1] = distance;
			}
		}


	}

	// connected to linked lists and Nodes
	// BFS
	@Override
	public Point2D[] shortestPath(Point2D p1, Point2D p2) {
		int src_color = getPixel(p1);
		int dst_color = getPixel(p2);
		if(src_color!=dst_color) {
			return null;
		}

		// interface of a list
		//List<Point2D> path = new ArrayList<Point2D>();

		if(p1.close2equals(p2)) {
			return new Point2D[0];
		}

		int[][] visited = new int[getWidth()][getHeight()];
		for(int i = 0; i<visited.length; i++ ) {
			for(int j = 0; j<visited[i].length; j++ ) {
				if(getPixel(i,j) == src_color) {	
					visited[i][j] = -1 ;
				} 
				else {
					visited[i][j] = -2 ; //can't go over
				}	
			}
		}

		visited[p1.ix()][p1.iy()] = 0; // start
		int index = 0;
		boolean isDone = false;
		boolean isFound = false;
		while(!isDone) {
			for(int i = 0; i<visited.length; i++ ) {
				for(int j = 0; j<visited[i].length; j++ ) {
					if(visited[i][j] == index) {
						updateNeighbors(visited, i,j,index+1);
						isFound = true;
					}
				}
			}

			if(!isFound) {
				isDone = true;
			}

			if(visited[p2.ix()][p2.iy()] !=-1) {
				isDone = true;	
			}
			index++; //going to the next distance
			isFound = false; // for the next iteration
		}

		if(visited[p2.ix()][p2.iy()] ==-1) { //we coulnd't get to p2	
			return null;
		}

		Point2D[] shortestPath = new Point2D[index]; //this is the length of the path
		buildPath(visited, p2.ix(), p2.iy(), shortestPath);
		return shortestPath;

	}

	public void buildPath(int visited[][], int i, int j, Point2D[] shortestPath) {
		for(int x = 0; x<shortestPath.length; x++) {	
			Point2D point = new Point2D(i,j);
			shortestPath[shortestPath.length-1-x] = point;
			Point2D neighbor = nextNeighbor(visited, i, j);
			i = neighbor.ix();
			j =	neighbor.iy();	
		}
	}

	public Point2D nextNeighbor(int visited[][],int i, int j) {
		if(i>0) {
			if(visited[i][j] - visited[i-1][j] == 1 ) {
				return new Point2D(i-1,j);
			}
		}
		if(i<visited.length-1) {
			if(visited[i][j] - visited[i+1][j] == 1 ) {
				return new Point2D(i+1,j);
			}
		}
		if(j>0) {
			if(visited[i][j] - visited[i][j-1] == 1 ) {
				return new Point2D(i,j-1);
			}
		}
		if(j<visited[i].length-1) {
			if(visited[i][j] - visited[i][j+1] == 1 ) {
				return new Point2D(i,j+1);
			}
		}
		throw new RuntimeException("Should not be here");
	}

	//drawing the 
	public void drawShortestPath(Point2D p1, Point2D p2,int c) {
		Point2D[] path = shortestPath(p1, p2);	
		if (path !=null) {
			for (Point2D point : path) {
				setPixel(point, c);
			}
		}
	}
	
	@Override
	// This function returns us the number of moves we had to do, to go from one point to another 
	public int shortestPathDist(Point2D p1, Point2D p2) {
		// checking if there is no distance between the points

		//return the length from above

		return -1;


		//		//checking if they are in different colors
		//		if(getPixel(p1) != getPixel(p2)) {
		//			return -1;
		//		}
		//
		//		// initialized some variables for the checking
		//		int moveCount = 0;
		//		int nodes_left_in_layer = 1;
		//		int nodes_in_next_layer = 0;
		//
		//		boolean[][] visited = new boolean[getWidth()][getHeight()]; // boolean matrix to know if we've visited that pixel
		//		Queue<int[]> qx= new LinkedList<int[]>(); //the queue will be an array of int of x value
		//		Queue<int[]> qy= new LinkedList<int[]>(); //the queue will be an array of int of y value
		//
		//		// adding to every queue the first values of x & y from point 1
		//		qx.add(new int[]{p1.ix()}); 
		//		qy.add(new int[]{p1.iy()});
		//
		//		boolean reachedEnd = false;		// because it hadn't get to the end yet
		//
		//		while(!qx.isEmpty()) { 			// we can say while (qx.size > 0)
		//			int[] currX = qx.poll();
		//			int[] currY = qy.poll();
		//
		//			int x = currX[0]; 		//getting the x & y values
		//			int y = currY[0];
		//
		//			if (_map[x][y] == _map[p2.ix()][p2.iy()]) { //we've got to the other point
		//				reachedEnd = true;
		//				break;
		//			}
		//
		//			//exploreNeighbors(visited,x,y);
		//			int [] vrx = {-1,1,0,0}; //vector direction for rows/x
		//			int [] vcy = {0,0,1,-1}; //vector direction for columns/y
		//			int vr = 0;
		//			int vc = 0;
		//
		//			//checking the neighbors
		//			for (int i = 0; i<4; i++) {
		//				vr = x + vrx[i];
		//				vc = y + vcy[i];
		//
		//				// checking the bounds
		//				if (vr <0 || vc<0) {
		//					continue;
		//				}
		//				if (visited[vr][vc] ) {
		//					continue;
		//				}
		//				if (getPixel(vr, vc) != color) { //means that is blocked
		//					continue;
		//				}
		//
		//				// adding the four directions
		//				qx.add(new int[]{vr});
		//				qy.add(new int[]{vc});
		//				visited[vr][vc] = true; // means we are visited the neighbors
		//				nodes_in_next_layer++;
		//			}
		//
		//			nodes_left_in_layer--;
		//			if (nodes_left_in_layer == 0) {
		//				nodes_left_in_layer = nodes_in_next_layer;
		//				nodes_in_next_layer = 0;
		//				moveCount++;
		//			}
		//		}
		//		if (reachedEnd) { //if it is true
		//			return moveCount;
		//		}
		//
		//		return -1; // we couln't reached the end


		/*
	private void exploreNeighbors(boolean[][]visited,int row, int col) {
		int [] vrx = {-1,1,0,0}; //vector direction for rows/x
		int [] vcy = {0,0,1,-1}; //vector direction for columns/y
		int vr = 0;
		int vc = 0;

		//chming the neighbors
		for (int i = 0; i<4; i++) {
			vr = row + vrx[i];
			vc = col + vcy[i];

			// checking hte bounds
			if (vr <0 || vc<0) {
				continue;
			}
			if (visited[vr][vc] ) {
				continue;
			}
			if (getPixel(vr, vc) != Color.WHITE.getRGB()) { //means that is blocked
				continue;
			}

			//TODO the rest of the function

		}
	}
		 */
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
					for (int y = -1; y < 2; y++) { 	//searching the point near the One we're checking
						if( x!=0 || y!=0) { 		// if they are both equal to 0, so we're in the middle
							if(x+i > 0 && x+i < tmp.length && y+j > 0 && y+j < tmp[i].length &&
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



}
