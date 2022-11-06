package semster1;

import java.util.Scanner;

public class Exer1_2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner input = new Scanner (System.in);

		System.out.println("Enter number of pizzas:");
		int pizza = input.nextInt();

		System.out.println("Enter number of pineapple topics:");
		int pine = input.nextInt();

		System.out.println("Enter number of another topics:");
		int top = input.nextInt();
		
		int final_price = (pizza*30) + (pine*7) + (top*5);
		
		System.out.println("your finale price is: " + (int)((pizza*30) + (pine *7)+ (top *5)) );
		System.out.println(final_price);
		
		input.close();
	}

}
