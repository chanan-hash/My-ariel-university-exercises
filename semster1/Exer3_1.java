package semster1;

import java.util.Scanner;

public class Exer3_1 {
	//arrays and functions

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in); 
		
		final int arrLength = 10;
		double[] arr = new double [arrLength];
		double avg = 0;
		double max = 0;
		
		for (int i =0; i<arr.length;i++) {
			System.out.println("Enter a number: ");
			arr[i] = sc.nextInt();
			avg += arr[i];
			if(arr[i]>max) {
				max = arr[i];
			}
		}
		double res = avg/arr.length;
		System.out.println("The avg is: " + res);
		System.out.println("the max salary is: " + max);
		sc.close();

	}

}
