package UA_exercises_and_test;
import java.util.Scanner;
import java.util.Random;;

public class UA_Ex4_2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Scanner input = new Scanner(System.in);
		Random ran = new Random();
		
		System.out.println("Enter a number for the array length: ");
		int n = input.nextInt();
		int[] arr = new int [n];
		int min = 0;
		int max = 0;
		
		for (int i = 0 ; i<=arr.length; i++) {
			arr[i] = ran.nextInt(10)+20;
			System.out.print(arr[i] + ",");
			if (arr[i]<arr[i+1])
				max = arr[i+1];
				min = arr[i];
		}
		System.out.println("The min number is: " + min + " ,the max number is: " + max );
	input.close();
	}
}
