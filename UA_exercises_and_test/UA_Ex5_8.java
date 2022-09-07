package UA_exercises_and_test;

import java.util.Arrays;

public class UA_Ex5_8 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		int N = 3;
		int[][] arr2D = new int[N][];

		arr2D[0] = new int[0];

		for (int i = 0; i<arr2D.length; i++) { // in every iteration we're creating a new 1D array with the length of i that runs till N; 
			arr2D[i] = new int[i]; // first iteration i = 0, next i = 1 (two places because we're counting from 0), next i = 2.		
			// then we want to change the content in the array to "*".
		}
		System.out.println(Arrays.deepToString(arr2D));
	}
}
