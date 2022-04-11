package UA_exercises;

import java.util.Arrays;

public class UA_Ex5_4 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		int[][] array2D = new int [6][6];
		int sum = 0;
		System.out.println(Arrays.deepToString(array2D).replace("], ", "]\n"));

		for(int i = 0; i<6 ;i++) {
			for (int j = 0; j<6; j++) {
				if ((i+j) == (6-1)) { // The idea of the secondary diagonal is that i+j == to the row/width number if it is a square
					array2D[i][j] = 1; /* here in every iteration the condition look which i & j will give 5, first row is i=0 j =5 (we are counting from zero so 5 is the 6'th index)
						second row is i=2 & j=3 (j=3 means 4'th index)
						middle row is i =3, j = 2
						etc...
						last row is i = 5 & j = 0
					 */
					sum += array2D[i][j];
				}
			}
		}
		System.out.println("\r\n" + Arrays.deepToString(array2D).replace("], ", "]\n"));
		System.out.println("\r\nThe sum of the secondary diagonal is: " + sum);
	}

}
