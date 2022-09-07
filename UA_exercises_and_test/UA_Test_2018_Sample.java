package UA_exercises_and_test;

import java.util.Arrays;

public class UA_Test_2018_Sample {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String s = "abfnd alkn sdlkv";
		String []a = s.split(" ");
		String []b = s.split("l");	
		System.out.println(s);
		System.out.println(Arrays.toString(a));
		System.out.println(Arrays.toString(b));

		System.out.println(longestWord("ab abdj jsk wyyyyyy h kkkkj"));

		System.out.println(isSim(new double[]{1,2,3,4,3,2,1}));     //true
		System.out.println(isSim(new double[]{1,2,3,4,4,3,2,1}));   //true
		System.out.println(isSim(new double[]{1,1,3,4,3,2,1}));     //false
		System.out.println(isSim2(new double[]{1,2,3,4,3,2,1}));    //true
		System.out.println(isSim2(new double[]{1,2,3,4,4,3,2,1}));  //true
		System.out.println(isSim2(new double[]{1,1,3,4,3,2,1}));    //false

		int c[] = {1,3,4,5,1};
		int d[] = {4,5,1,3,1};
		int e[] = {3,4,63,5,6};
		System.out.println(equal(c,d));
		System.out.println(equal2(c,d));
		System.out.println(equal(c,e));
		System.out.println(equal2(e,d));

	}

	// q2
	public static int longestWord2(String s) {
		int max = 0;
		int count = 0;
		for (int i = 0; i<s.length(); i++) {
			if (s.charAt(i) != ' ') { // we're assuming that between every word we have a space
				count++;
			}
			else {
				if(count > max) {
					max = count;
				}
				else {
					count = 0;
				}
			}
		}
		return max; // this will return the length of the longest word
	}

	public static String longestWord(String s) {
		String a[] = s.split(" "); // we are creating an array of Strings ["sdfnds", "dsjkf", "fskjf], from the original String we have split after every " " - space
		// and it taking of the place we wanted to split
		String longest = "";
		for (int i = 0; i<a.length; i++) {
			if (a[i].length() > longest.length())
				longest = new String (a[i]); // we are taking the biggest value in the array, and turning it to a String byitself
		}
		return longest;
	}

	// q5
	public static boolean isSim(double[] arr) {
		int left = 0;
		int right = arr.length-1;
		while(left<right) {
			if (arr[left] != arr[right]) // instead trying to find what is similar, we are trying to find what is not similar and if it isn't similar to return false,  
				return false;
			else 						// else it means the they are the same and continue.
				left++;
			right--;
		}
		return true; // it if the loop is finished so we can return true
	}

	// q5 their solution

	//	the same thing but doing it in a for loop
	//option 2
	private static boolean isSim2(double[] arr) {
		for (int i = 0, j=arr.length-1 ; i < j ; i++, j--)
			if(arr[i] != arr[j])
				return false;
		return true;
	}
	// another way in the same idea
	public static boolean isSim3(double[] arr) {
		for (int i = 0; i < arr.length/2 ; i++) {
			if(arr[i] != arr[arr.length-1-i])
				return false;
		}
		return true;
	}

	// 4th way
	public static boolean isSim4(double[] arr) {
		for (int i = 0; i<arr.length-1; i++) {
			if (arr[i] == arr[arr.length-i])
				continue;
			else
				return false;
		}
		return true;
	}


	// q6
	public static boolean equal(int a1[], int a2[]){
		if (a1.length != a2.length)
			return false;
		// we can first sort the arrays and the to check the equalness
		// we can do it by inbuilt functions or by ourselves
		Arrays.sort(a1);
		Arrays.sort(a2);
		return Arrays.equals(a1, a2);
	}

	// another way they did it
	// this function returns the times a given number is in the array
	private static int count(int[] a, int n) {
		int cnt = 0;
		for (int i = 0; i < a.length; i++) {
			if(a[i] == n)
				cnt++;
		}
		return cnt;
	}

	private static boolean equal2(int[] a1, int[] a2) {
		if(a1.length != a2.length) return false;
		for (int i = 0; i < a1.length; i++) {
			if(count(a1,a1[i]) != count(a2,a1[i])) // is the number in the array doesn't found the same times in the second array, it means they are not equal
				return false;
		}
		return true;
	}
}
