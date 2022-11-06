package semster1;

import java.util.Scanner;

public class Exer2_6 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);

		System.out.println("Enter first number: ");
		int x = sc.nextInt();
		System.out.println("Enter second number: ");
		int y = sc.nextInt();

		int z = x;
		int length = 0;
		while (z>0) {
			length++;
			z=z/10;
		}
		System.out.println("z= " + z + ", length= " + length);

		int count = 0;

		for (int i = 1; i<=length; i++){
			System.out.println("count= " + count);
			System.out.println("x= " + x + ", y= " + y);
			for (int j = i; j==i; j++){
				System.out.println("(x%10)= " + (x%10) + " (y%10)= " + (y%10));
				if ((x%10) == (y%10)) {
					count++;
				}				
			}
			x /= 10;
			y = y/10;
		}
		System.out.println("count= " + count);
		sc.close();
	}

}
