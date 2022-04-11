package UA_exercises;

import java.util.Scanner;
import java.util.Random;;

public class UA_Ex4 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Scanner in = new Scanner(System.in);

		System.out.println("Please enter a number for the length of the array: ");
		int N = in.nextInt();
		int []array = new int [N];
		int	Zeroes = ZeroCount(array,N);

		//System.out.println("The array looks like: " + array);
		System.out.println("The array has " + Zeroes + " Zeroes!");

		in.close();

	}

	
	
	public static int ZeroCount(int[]array, int N) {

		int count = 0;
		Random r = new Random();
		for (int i = 0; i<array.length; i++) {
			//System.out.println(r.nextInt(N));
			array[i] = r.nextInt(N); // throwing in the array number between 0 to N
			System.out.print(array[i] + ",");
			if (array[i] == 0) 
				count ++;
		}
		return count;

	}
}
