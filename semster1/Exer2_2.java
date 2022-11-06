package semster1;

import java.util.Scanner;

// need to Fix

public class Exer2_2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter if your relationship with the couple \n1 - close friends \n2- family \n3 - none ");

		// it is better to use number as an input instead of letters because it just works better for the condition and the program
		
		int ans = sc.nextInt();
		int sum = 0;
		
		if(ans == 1) {
			sum = 500;

			System.out.println("How long do you know them?");
			int time = sc.nextInt();
			if (time >=3) {
				sum = sum + 50;
			}

			System.out.println("How long topk the journy? (answer in number of houers):");
			int ride = sc.nextInt();
			if (ride >= 1) {
				sum = sum - 50;
			}
		}

		else if (ans == 2) {
			sum = 1000;
		}

		else if (ans == 3) {
			sum = 250;

			System.out.println("How long do you know them?");
			int time = sc.nextInt();
			if (time >=3) {
				sum += 50;
			}

			System.out.println("How long topk the journy? (answer in number of houers):");
			int ride = sc.nextInt();
			if (ride >= 1) {
				sum = sum - 50;
			}
		}
		
		System.out.println("The number of money to put for the couple is: " + sum);
		sc.close();

	}
}