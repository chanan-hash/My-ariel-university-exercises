package UA_exercises;

import java.util.Arrays;

public class UA_Ex5_7 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		int[][]array2D = new int [5][5];//{{1,2,3},{4,5,6},{7,8,9},{0,0,0}};
		int count = 0;		

		System.out.println(Arrays.deepToString(array2D));

		for (int i = 0; i<array2D.length; i++) {
			for (int j = i+1; j<array2D[0].length; j++) {
				if(array2D[i][j] == 0){
					count++;
				}
			}
		}
		System.out.println("The number of Zeros in the 2D array are: " + count);
	}
}