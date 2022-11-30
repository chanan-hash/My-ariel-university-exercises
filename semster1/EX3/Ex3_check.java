package Exe.EX3;

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
}
