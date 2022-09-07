package UA_exercises_and_test;
import java.util.Arrays;
import java.util.Scanner;

public class UA_Ex5_6 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Scanner input = new Scanner(System.in);
		//int n = input.nextInt();				
		//int[][]arr2D = new int [n][n];
		
		int[][]arr2D = {{1,2,3},{4,5,6},{7,8,9}};
		System.out.println(Arrays.deepToString(arr2D));
		for (int i = 0; i<arr2D.length; i++) {
			for (int j = i+1; j<arr2D[0].length; j++) {
				// swap between i and j
				int temp = arr2D[i][j];
				arr2D[i][j] = arr2D[j][i];
				arr2D[j][i] = temp;
			}
		}
		
		System.out.println(Arrays.deepToString(arr2D));
		
		input.close();
	}

}
