package UA_exercises_and_test;
import java.util.Scanner;
public class UA_Ex4_8 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Scanner input = new Scanner(System.in);
		System.out.println("Enter a number: ");
		int num = input.nextInt();	
		int sum = 0;
		int newnum = num;
		for (int i = 0; i<=newnum; i++) {
			sum += newnum%10;
			newnum /=10;
		}
	System.out.println("The digit sum of " + num + " is " + sum);
	input.close();
	}

}
