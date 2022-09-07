package UA_exercises_and_test;
import java.util.Arrays;
public class UA_Ex5_3 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		int[][]arr2D = new int [5][5];
		int sum = 0;
		System.out.println(Arrays.deepToString(arr2D).replace("], ", "]\n"));
		for (int i = 0 ; i< 5;i++) {
			for (int j = 0; j<5; j++) {
				if(i == j) {
					sum += arr2D[i][j];
				}
				
			}
		}
		System.out.println("\r\nThe sum of the main diagonal is: " + sum);
	}
}
