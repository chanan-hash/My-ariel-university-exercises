package UA_exercises;
import java.util.Scanner;
public class UA_Ex5_2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Scanner input = new Scanner(System.in);
		System.out.println("Please enter two number for the size of the 2D array: ");
		int n = input.nextInt();
		int m = input.nextInt();
		int arr2D[][] = new int[n][m];
		int sum = 0;

		for(int i = 0; i<n; i++) {
			for (int j = 0; j<m; j++) {
				sum += arr2D[i][j];
				System.out.print(arr2D[i][j] + " ");
			}
			System.out.println();
		}
		System.out.println("\r\nThe sum of all the matrix is: " + sum);
		input.close();
	}
}
