package semster1;

import java.util.Scanner;

public class Exer2_5 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scan = new Scanner(System.in);
		//System.out.println("Enter a number: ");
		int num = 0;
		do	{
			System.out.println("Enter a number bigger than 0:  ");
			num = scan.nextInt();
		}
		while(num<0);{
		}
		
		System.out.println("Enter a digit: ");
		int digt = scan.nextInt();
		int count = 0;
		int num2 = num;
		for (int i = num2; i>=0; i--) {
			if(digt == (num2%10)) {
				count++;
			}
			num2 = num2 /10;
		}
		System.out.println("the digit " + digt + " is in " + num + ", " + count + " times." );
		scan.close();
	}

}
