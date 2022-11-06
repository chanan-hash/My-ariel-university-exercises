package semster1;

import java.util.Scanner;

public class Exer1_3 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);

		System.out.println("Enter a value for x:");
		double x = sc.nextDouble();
		
		double polinom = (x*x) - (6*x) + 8;
		double polinom2 = Math.pow(x, 2) - (6*x) + 8;
		
		System.out.println("the ans is: " + polinom);
		System.out.println("f(x) = x^2 - 6x + 8");
		System.out.println("f("+x+") = "+ polinom2);
		sc.close();
	}

}
