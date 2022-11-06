package semster1;

import java.util.Scanner;

public class Exer2_11 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner input = new Scanner(System.in);
		System.out.println("Enter a number: ");
		int tri = input.nextInt();
		// we will keep every digit in separate variable

		int ones = tri % 10; // giving us the one's digit
		
		int tens = ((tri/10)%10); // giving us the ten's digit (if tri is 567, tri/10 =56, 56 % 10 =6)
		
		int hundred = (tri/100); // giving us the hundred digit (if tri is 567, tri/100 =5, 5 % 10 =5)
		
		System.out.println(hundred +" " + tens + " " + ones);

		if ((hundred + 1 == tens) && (tens + 1 == ones)) {
			System.out.println("this number is good");
		}
		else {
			System.out.println("this number is not good");
		}
		input.close();
	}

}
