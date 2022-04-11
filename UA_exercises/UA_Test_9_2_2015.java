package A;

import java.util.Arrays;

public class UA_Test_9_2_2015 {
	// First semester test 1, Q1-Q3, Q6
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		String s = "ngjkdfnfsvmnsldkgmdflg";
		String s2 = s.substring(0,5) + s.substring(5,8);
		char c = s.charAt(6);
		System.out.println(s2);
		System.out.println(c);
		System.out.println(firstNonRepeated(s));
		System.out.println(s.chars().count()); // StringName.chars().count() --> says how many characters in the String 


		// Q2
		int a[][] = {{1,2,3},{4,5,6},{7,8,9}};
		System.out.println(Arrays.deepToString(a));
		transpose(a);
		System.out.println(Arrays.deepToString(a));

		// Q3
		int arr[] = {1,0,0,0,1,0,0,1,1,0};
		System.out.println(subSeqOfZeros(arr));
		System.out.println(subSeqOfZeros2(arr));

		double b[] = {1.1, 2.5, 63.9, 1.12,  3.45, -4.4};
		System.out.println(smallestDistance(b));
		System.out.println(smallestDistance2(b));
	}

	// Answers in - https://github.com/LeviEyal/JAVACourse-TestsSolutions/tree/main/T_2015_02_09
	public static char firstNonRepeated(String s) {
		for (int i = 0; i<s.length(); i++) {
			char c = s.charAt(i);
			String t = s.substring(0, i) + s.substring(i+1);
			if(t.contains(""+c) == false) {
				return c;
			}

		}
		return '?';
	}

	// Second way of solving Q1

	public static char firstNonRepeated2(String s){
		for(int i=0; i<s.length(); i++){
			char c = s.charAt(i);
			String t = s.replace(""+c, ""); // New string without character c (depend on how many times c was in s string)
			if(s.length() - t.length() == 1) // it says that this character is found only once in the previous String ('s' )
				return c; // The moment the function returns c, the loop stops, so it so c will be the first character the is showing only once in the string
			// the moment it returns something, is the moment it found the first thing to return, and the function doesn't need to return more
		}
		return '?';
	}

	// Q2 answer
	public static void transpose(int[][]mat) {
		for(int row = 0; row < mat.length; row++){
			for(int column = row+1; column < mat[0].length; column++){

				// swap
				int temp = mat[row][column];
				mat[row][column] = mat[column][row];
				mat[column][row] = temp;
			}
		}
	}

	/* The same answer just with i & j, instead of row & column
	    public static void transpose(int[][]mat){
        for (int i = 0; i < mat.length; i++) {
            for (int j = i+1; j < mat[0].length; j++) {
                //swap:
                int t = mat[i][j];
                mat[i][j] = mat[j][i];
                mat[j][i] = t;
            }
        }        
    } 
	 */


	// Q3 answer
	public static int subSeqOfZeros(int arr[]) {
		int max = 0, count = 0;
		for(int i=0; i<arr.length; i++){
			if (arr[i] ==1) {
				count = 0; // every time we find 1, we are  reseting count, it is going the other way,
				//  instead looking when the arr[i] is equal to zero, we are looking when it not zero.
				//  as long as it zero the loop continues
			}
			else count ++;
			if (count > max)  max = count; // such how in every iteration max is the highest count we've got 

		}
		return max; 
	}
	public static int subSeqOfZeros2(int arr[]){
		int max = 0;
		String s = "";
		for(int i=0; i<arr.length; i++)
			s += ""+arr[i];
		String[] zeros = s.split("1");
		for (int i = 0; i < zeros.length; i++) {
			int current_length = zeros[i].length();
			if(current_length > max)
				max = current_length;

		}return max;

	}

	// Q6 answer 
	public static double smallestDistance(double []arr) {
		double min = Double.MAX_VALUE;
		for (int i = 0; i<arr.length; i++) {
			for (int j = i+1; j<arr.length; j++) {
				double sub = Math.abs(arr[i] - arr[j]);
				if (sub < min) {
					min = sub;
				}
			}
		}
		return min;
	} // because we have here 2 loop the complexity will be O(n^2)


	public static double smallestDistance2(double []array) {
		Arrays.sort(array);
		double min = Double.MAX_VALUE;
		for (int i = 0; i<array.length-1; i++) {
			double sub = Math.abs(array[i]-array[i+1]);
			if (sub < min)
				min = sub;
		}
		return min;
	}
	// here we have only one loop so it is only depends one time on the length of the array, so the complexity will be O(n) [although we are using sort method, so it can be sometimes another loop or two and then the complexity is still O(n^2) or maybe O(n),
	// and sometimes even less like "bubble sort" and then the complexity is O(log n) and + O(n) it's O(n)
}
