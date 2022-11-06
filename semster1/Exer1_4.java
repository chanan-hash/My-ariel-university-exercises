package semster1;

import java.util.Scanner;

public class Exer1_4 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scan = new Scanner(System.in);

		System.out.println("Enter a value for the radius:");
		double r = scan.nextDouble();
		double A = Math.pow(r, 2) * 3.141592654;
		double A1 = r*r * Math.PI;
		
		System.out.println("the A is: " + A);
		System.out.println("the A is: " + A1);
		//System.out.println(Math.E);
		//System.out.println(Math.TAU);
		scan.close();
	}

}
