package UA_exercises_and_test;
import java.util.Scanner;
public class UA_Ex5_1 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Scanner in = new Scanner(System.in);
		System.out.println("Please enter two number for the size of the 2D array: ");
		int n = in.nextInt();
		int m = in.nextInt();
		int arr2D[][] = new int[n][m];

		for(int i = 0; i<n; i++) {
			for (int j = 0; j<m; j++) {
				System.out.print(arr2D[i][j] + " ");
			}
		System.out.println();
		}
		
		in.close();
	}

}
