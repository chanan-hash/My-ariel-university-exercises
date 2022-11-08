package semster1;

import java.util.Scanner;

public class Exer3_3 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Scanner in = new Scanner(System.in);
		boolean bool[] = new boolean[26];
		System.out.println("Enter a letter: ");
		String s = in.next();
		
		while(s!="!") {
			
			// the same way of the cupon algorithm go over this from the Matzeget
			
			System.out.println("Enter a nother letter: ");
			String s2 = in.next();
			s = s2;
		}

		in.close();

	}
}


