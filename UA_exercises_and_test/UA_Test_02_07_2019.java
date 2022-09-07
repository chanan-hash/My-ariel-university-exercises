package UA_exercises_and_test;

import java.util.Arrays;

public class UA_Test_02_07_2019 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	// q1
	public static long sortDigits(long num){
		long t = 0;
		int[] a = new int[10];
		while(num>0) {
			a[(int)(num%10)]++; // creating an array with the long digits. dividing by 10/modulu giving us every time the Ones digit
			num/=10; // like modulu 10 with num num%10
		}
		for (int i = 1; i<10; i++) {
			for (int j = 1; j<a[i];j++) {
				t*=10; // adding the Ones digit to the number
				t+=i;
			}
		}
		return t;
	}

	// option 2
	public static long sortDigits2(long num){
		long n = 0;
		char a[] = Long.toString(num).toCharArray(); // turning the long number to string, and then turning the string to array of charts.
		Arrays.sort(a); // sorting the chars array

		for (int i = 0; i< a.length; i++) {
			if(a[i]!= '0') // to take out the Zeroes
				n*=10; // adding it to the number, every time we multiple by 10, it is adding the number to the last place from the right side, it is the way to add a digit ti the number. we're creating a new number which have the digit we want in the end of it 
			n+=a[i]-'0';
		}
		return n;
	}

	// q2
	public static boolean isSymmetricX(String s, int x){
		if (x == 0) return true;
		if (s.charAt(0) == s.charAt(s.length()-1)) // if the last char equals to the first char
			return isSymmetricX(s.substring(1,s.length()-1), x-1); // shorting the string by making it to a substring from the beginning till the end, and the recursion is on x, that become shorter every run of the function
		return false;
	}

	// q3
	public static void switchDiags(int[][] arr) {
		// The parameter for the main diagonal is when the number of the row and column are equal,
		// and the parameter for the secondary diagonal is when the number of the row and column equal to the length of the array

		int l = arr.length-1;
		for(int i = 0; i<l; i++) {
			int temp = arr[i][i];
			arr[i][i] = arr[i][l-i]; // a[i][l-i]  this is the part of the secondary diagonal
			arr[i][l-i] = temp;
		}
	}
	// option2
	/*	public static void switchDiags2(int[][] arr) {
		for (int i = 0; i<arr.length; i++) {
			for(int j = 0 ; j <arr[0].length; j++) {
				if (i==j && i+j==arr.length-1)
					int temp = arr[i][j];
			}
		}
	}
	 */
}
