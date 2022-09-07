package UA_exercises_and_test;
import java.util.Scanner;
public class UA_Ex6_8 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Scanner in = new Scanner(System.in);
		System.out.println("Enter your equation: ");
		String s = in.nextLine();
		System.out.println("Your equation is: " + s);
		
		//System.out.println(s.substring(0,1)); // giving the part of the string from a given index till end index, not include the end
		//System.out.println(s.substring(1,2));
		
		int num1 = Integer.parseInt(s.substring(0, 1));							
		
		//int num2 = Integer.parseInt(s.substring(1, 2));							
			
		int num3 = Integer.parseInt(s.substring(2, 3));							
		System.out.print("The answer is: ");
		
		if (s.substring(1, 2).equals("+"))
			System.out.println(num1+num3);
		else if (s.substring(1, 2).equals("-"))
			System.out.println(num1-num3);
		else if (s.substring(1, 2).equals("*"))
			System.out.println(num1*num3);
		else if (s.substring(1, 2).equals("/"))
			System.out.println(num1/num3);
		
		//int sum = num1 + num2 + num3;
		//System.out.println("The answer is: " + sum);
		
		//	for(int i = 0; i<s.length(); i++) {	
		//		}

		//	int num = Integer.parseInt("1234"); turning String to an integer
		//		System.out.println(num +1);

		in.close();

	}

}
