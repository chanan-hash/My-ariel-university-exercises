package UA_exercises_and_test;
import java.util.Scanner;
import java.util.Random;
import java.util.Arrays;
public class UA_Ex4_6 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Scanner input = new Scanner(System.in);
		Random rand = new Random();
	
		System.out.println("enter a number for the lenght of the array: ");
		int N = input.nextInt();
		int[] arr = new int[N];
		
		for (int i = 0; i<arr.length; i++) {
			arr[i] = rand.nextInt(N);
			//System.out.println(Arrays.toString(arr)); --> printing the array situation in every iteration
			if (arr[i]%3==0)
				System.out.println(arr[i]);
		}
		System.out.println(Arrays.toString(arr));
	input.close();
	}

}
