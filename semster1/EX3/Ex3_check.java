package Exe.EX3;

import java.awt.Color;
import java.util.Arrays;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Queue;

public class Ex3_check {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
//		Map2D _map_test = null;
//		_map_test.init(9, 9);
//		int [][] mat = new int[9][9];
//		for (int i = 0; i < _map_test.getHeight(); i++) {
//			for (int j = 0; j < _map_test.getWidth(); j++)  {
//				mat[i][j] = _map_test.getPixel(i, j);  // deep copy for the color num
//			}
//		}

		//		mat[9/2][9/2] = 1;
		//		int center = mat[9/2][9/2];
		//		
		//		int rad = 5;
		//		for (int i = 0; i<mat.length; i++) {
		//			for(int j = 0; j<mat[0].length; j++) {
		//				if (Math.abs(mat[i][j] - center) <5) {
		//					mat[i][j] = 1;
		//				}
		//			}
		//		}
		//		for(int i = 0; i<mat.length;i++) {
		//			for (int j = 0; j<mat[0].length;j++) {
		//					mat[i][j] = 1;
		//				}
		//			}

		drawCircle(8);


		// helping for testing segment, rect, and circle
//		for (int i =0; i<mat.length;i++) {
//			System.out.println(Arrays.toString(mat[i]));
//		}


// for אקלר to cpp
		double[] a = {1,2,3,4,5};
		System.out.println(isDiff(a, a.length));

	}
	public static boolean isDiff(double[]a, int size) {
		boolean b = true;
		for(int i = 0; i<size-1; i++) {
			for(int j = i+1; j<size;j++) {
				if(a[i] == a[j]) {
					b = false;
					return b;
				}
			}
		}
		return b;
	}


	static void drawCircle(int r)
	{
		// Consider a rectangle of size N*N
		int N = (2*r+1);

		int x, y; // Coordinates inside the rectangle

		// Draw a square of size N*N.
		for (int i = 0; i < N; i++)
		{
			for (int j = 0; j < N; j++)
			{
				// Start from the left most corner point
				x = i-r;
				y = j-r;

				// If this point is inside the circle, print it
				if (x*x + y*y <= r*r+1 )
					System.out.print(".");
				else // If outside the circle, print space
					System.out.print(" ");
				System.out.print(" ");
			}
			System.out.println();
		}
	}
	/*	
	public void nextGenGol() {
		int[][] tmp = mapCopy();

		for (int i = 0; i < tmp.length; i++) {
			for (int j = 0; j < tmp[i].length; j++) {

				boolean is_currently_alive = tmp[i][j] != Color.WHITE.getRGB();
				int num = 0;							// counter of neighbors
				num = numOfNeighborsAlive(tmp, i, j, num);

				updatePixel(i, j, is_currently_alive, num);
			}
		}
	}

	private void updatePixel(int row, int col, boolean is_currently_alive, int numOfAliveNeib) {
		if (isNeedToDraw(is_currently_alive, numOfAliveNeib)) { 
			setPixel(row, col, Color.BLACK.getRGB());
		}
		else {
			setPixel(row, col, Color.WHITE.getRGB());
		}
	}

	private int numOfNeighborsAlive(int[][] map, int row, int col, int num) {
		for(int x = -1; x < 2; x++) {
			for (int y = -1; y < 2; y++) { 	//searching the point near the One we're checking
				if(x!=0 || y!=0) { 		// if they are both equal to 0, so we're in the middle
					if(isAlive(map, x+row, y+col)){ // checking the place according to the point
						num += 1;
					}
				}
			}
		}
		return num;
	}

	private boolean isNeedToDraw(boolean is_currently_alive, int num) {
		return (is_currently_alive && (num == 2 || num == 3)) 
				|| (!is_currently_alive && num == 3);
	}

	protected int[][] mapCopy(){
		int[][] tmp = new int[_map.length][_map[0].length];
		for (int i = 0; i < _map.length; i++) {
			for (int j = 0; j < _map[i].length; j++)  {
				tmp[i][j] = _map[i][j];
			}
		}
		return tmp;
	}

	private boolean isAlive(int[][] map ,int row, int col) {
		return row>=0 || row<=map.length || col>=0 || col<=map[row].length || map[row][col] != Color.WHITE.getRGB();
	}


	 */
}
	
	
	/**
	 * 
	 * this I added for checking need to think how to draw it
	 * @param p1
	 * @param p2
	 * @param c
	 
	public void drawShortestPath(Point2D p1, Point2D p2,int c);
	
	
	
	
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

	//drawing the shortest path
	public void drawShortestPath(Point2D p1, Point2D p2,int c) {
		Point2D[] path = shortestPath(p1, p2);	
		if (path !=null) {
			for (Point2D point : path) {
				setPixel(point, c);
			}
		}
	}

	
	
	
	
	
	
	
	Eithan's idea for shortest path
	public Point2D[] shortestPath2(Point2D p1, Point2D p2) {
		// we are interestead in every vertex that sent us to the next vertex
		int current_col = getPixel(p1); //the first color
		Queue<Point2D> qu = new LinkedList<>();
		LinkedList<Point2D> linked = new LinkedList<>(); // for checking the end
		qu.add(p2); 	
		HashMap<Point2D, Point2D> hash = new HashMap<>(); // the obj that we are searching returnnig also if we have visited or not, and help us to get back to the starting point
		while(!qu.isEmpty()) {			
			Point2D pCurrent = qu.poll();	
			if(pCurrent.close2equals(p2, 0.0001)) {
				break;
			}
			checkNeighbors(qu, hash, pCurrent);
		}
		// we have the hash with the point to get
		// we can also check if hash contains p2
		if(!hash.containsKey(p2)) {
			return null;
		}

		linked.addFirst(p2); //putting it in thew beggining
		while(!linked.getFirst().equals(p1)) {
			linked.addFirst(hash.get(linked.getFirst())); //took the linked list, checking to what equal in the hash map, and adding it to the linkedlist 
		}
		return (Point2D[]) linked.toArray(); //casting
	}



	// adding all relevant neighbors
	public void checkNeighbors(Queue<Point2D> qu, HashMap<Point2D, Point2D> hash, Point2D p) {
		int current_color = getPixel(p);
		if(!isOutSideTheMap(p.ix(),p.iy()) && getPixel(p) == current_color && !hash.containsKey(p)) { // if it not contains so add, for every key we are getting the value
			Point2D x1= new Point2D(p.ix()+1, p.iy());
			Point2D x2= new Point2D(p.ix()-1, p.iy());
			Point2D x3= new Point2D(p.ix(), p.iy()+1);
			Point2D x4= new Point2D(p.ix(), p.iy()-1);

			qu.add(x1);
			qu.add(x2);
			qu.add(x3);
			qu.add(x4);

			// updating to be "visited"
			hash.put(x1, p);
			hash.put(x2, p);
			hash.put(x3, p);
			hash.put(x4, p);

		}

	}
	
	
	
	
	
	
	
	*/


