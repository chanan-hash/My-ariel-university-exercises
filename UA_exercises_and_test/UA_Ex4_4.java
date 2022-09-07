package UA_exercises_and_test;

import java.util.Random;
import java.util.Scanner;
import java.util.Arrays;;

public class UA_Ex4_4 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Scanner input = new Scanner(System.in);
		Random r = new Random();

		System.out.println("Please enter your number: ");
		int N = input.nextInt();
		int[] Array = new int[N];

		for(int i = 0; i<Array.length; i++) {
			Array[i] = r.nextInt(N);
		}
		System.out.println(Arrays.toString(Array));

		for(int j = 0; j<Array.length; j++) {
		
			if (Array[j]%2==0)
				System.out.println(Array[j]);

			input.close();
		}

	}
}
