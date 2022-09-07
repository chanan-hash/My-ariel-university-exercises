package UA_exercises_and_test;

import java.util.Arrays;
import java.util.Random;

public class UA_Test_01_08_2018 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] a = {2,4,7,5,8,6,4,2,5,6,7,8,3};
		int[] b = {1,2,4,6,7,0,2};
		System.out.println(isEvenFromTo(a,4,7)); // true
		System.out.println(isEvenFromTo(a,5,9)); // false
		//		System.out.println(isEvenFromTo2(a,4,7));
		System.out.println(isEvenFromTo(b, 1, 3)); // true
		System.out.println(isEvenFromTo(b, 2, 6)); // false
		System.out.println(isEvenFromTo(b, 4, 6)); // false
		System.out.println(isEvenFromTo(b, 3, 3)); // true

		System.out.println();
		System.out.println(removeByChance("eyalushlevi", 4));
		//	System.out.println(removeIndex("eyal", 0));
		//	System.out.println(removeIndex("eyal", 1));
		//	System.out.println(removeIndex("eyal", 2));
		//	System.out.println(removeIndex("eyal", 4));

		int[][] c = {{1, 4, 7},
				{2, 5, 8},
				{3, 6, 9}};
		System.out.println(Arrays.deepToString(c));
		shiftRight(c);
		System.out.println(Arrays.deepToString(c));
	}

	// q1
	public static boolean isEvenFromTo (int[]arr,int from, int to) {
		if (from > to) return true; // means the loop finished itself
		for (int i= from; i<=to; i++) {
			if (arr[i]%2==1) //odd
				return false;
		}
		return	isEvenFromTo(arr,from+1,to);
	}
	// their answer
	public static boolean isEvenFromTo2(int[] a, int from, int to){
		if(from > to) // it means the input is in correct
			return false;
		if(a[from]%2 != 0 || a[to]%2 != 0) // because the start and the end are odd and not even
			return false;
		if(to - from <= 1) // ,means that the number are even
			return true;   
		else return isEvenFromTo(a, from+1, to-1); // the recursion
	}

	// another answer of them
	public static boolean isEvenFromTo3(int[] a, int from, int to){
		if(from>to)        return false; // incorrect input
		if(from==to)        return (a[from]%2==0); // true or false depending if they're odd or even
		if(a[from]%2==0)    return isEvenFromTo2(a, from+1, to); // if that place is even, so continue by recursion

		return false;
	}


	// q2
	public static String removeByChance (String str, int n) {
		Random r = new Random();
		for (int i = 0; i < n; i++) {
			int random = r.nextInt(n);
			System.out.println(random);
			str = str.replace(""+str.charAt(random), "");
		}
		return str;
	}
	// their way


	// q3
	public static void shiftRight(int[][] mat) {
		for (int i = 0; i<mat.length; i++) {
			for (int j = mat[0].length-1; j >0 ; j--) { // j running from 1, to leave the first place for swapping, and it runs till one before the end;
				/*	int temp = mat[i][0];
				mat[i][0] = mat[i][mat[0].length-1];
				mat[i][mat[0].length-1] = temp;
				 */
				swap(mat[i], j, j-1);
				//	mat[i][j] = mat[i][j-1]; // maybe to make swap function and to used it here
			}
		}
	}

	private static void swap (int[]a, int i,int j) {
		int temp = a[i];
		a[i] = a[j];
		a[j] = temp;
	}
}
