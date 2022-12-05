package Exe.EX3;

import java.awt.Color;
import java.util.Arrays;

public class Ex3_check {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		int [][] mat = new int[9][9];
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
		for (int i =0; i<mat.length;i++) {
			System.out.println(Arrays.toString(mat[i]));
		}
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
