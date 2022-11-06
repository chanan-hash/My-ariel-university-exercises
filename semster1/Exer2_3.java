package semster1;

import java.util.Scanner;
// Reverse number
public class Exer2_3 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Scanner in = new Scanner(System.in);
		System.out.println("Enter a number to reverse: ");
		
		int num = in.nextInt();
		int newNum = 0;
		while(num>0) {
			newNum *= 10;
			newNum += num%10;
			num /=10;
		}
		System.out.println(newNum);
		in.close();
	}

}
