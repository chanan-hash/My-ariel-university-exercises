package UA_exercises;

import java.util.Scanner;
import java.util.Arrays;
public class UA_Ex4_3 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Scanner in = new Scanner(System.in);
		System.out.println("Enter a number for the array length: ");
		int n = in.nextInt();
		int[] arr ;
		arr = new int[n];

		int[] arr2 = new int[n];

		for(int i = 0; i<arr.length; i++) {
			arr[i] = i;
		}	System.out.println("arr: " + Arrays.toString(arr));
		
		
		for(int j = n-1; j>=0; j--) {
			arr2[j] = j;
		} System.out.println("arr2: " + Arrays.toString(arr2));

		
		in.close();

	}

}
