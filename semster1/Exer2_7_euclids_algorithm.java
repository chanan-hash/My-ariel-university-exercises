package semster1;

import java.util.Scanner;

// euclid's algorithm for finding gcd

public class Exer2_7_euclids_algorithm {	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Scanner input = new Scanner(System.in);
		System.out.println("Enter a first number:");
		long num1 = input.nextLong();

		System.out.println("Enter a second number: ");
		long num2 = input.nextLong();
		/*
		long r = num1%num2;
		while (r!=0) {
			num1 = num2;
			num2 = r;
			r = num1%num2;

		}
		 */
		while(num1!=num2) {
			if(num1>num2) {
				num1 = num1 -num2;
			}
			else {
				num2 = num2-num1;
			}
		}
		System.out.println(num2);
		input.close();
	}

}
