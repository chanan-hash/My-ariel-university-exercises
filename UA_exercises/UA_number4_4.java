// Practice number 4.4, Ariel University - arrays

package A;

import java.util.Random;
import java.util.Scanner;

public class UA_number4_4 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Scanner input = new Scanner(System.in);

		Random r = new Random();

		System.out.println("Enter a Number: ");
		int N = input.nextInt();		

		int [] array = new int [N];

		int count = 0;
		
		for (int i = 0; i<array.length; i++) {	

			System.out.println(r.nextInt(N));

			if (array[i] % 2 == 0) {
				count ++;
				System.out.println(array[i]);
				System.out.println(count);
			}
		}
		input.close();
	}
}
