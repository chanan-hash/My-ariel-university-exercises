package semster1;
import java.util.Scanner;
public class Exer1_1 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		// A program to calculate the Taxs

		double Taxs = 0.17; //we are putting the taxs value in a separate value so if it changes we need only to change the variable

		Scanner in = new Scanner(System.in);
		System.out.println("Enter your price:");
		double price = in.nextDouble();

		double new_price = price *(1+Taxs);
		System.out.println("your final price after taxs is: " + new_price);
		in.close();

	}

}
