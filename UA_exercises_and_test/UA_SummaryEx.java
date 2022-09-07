package UA_exercises_and_test;

// import java.util.Arrays;
import java.util.Random;
import java.util.Arrays;
public class UA_SummaryEx {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		int arr[] = {2,5,4,6,1};
		for(int j = 0; j<arr.length-1;j++ ) {	
			for (int i = 0; i<arr.length-1; i++) { // this is doing only once swap, do to it sorted we probably need nested loop
				if (arr[i]>arr[i+1]) {				// the nested loop is checking doing another iteration till it is sorted, recommended to do debugging to see it
					int temp = arr[i];
					arr[i] = arr[i+1];
					arr[i+1] = temp;
				}
			}
			System.out.println(Arrays.toString(arr));

		}
		System.out.println(Arrays.toString(arr));
	}

	// q1
	public static int[] marr(int n){
		Random r = new Random();
		if (n>10 || n< 0)
			return null;
		System.out.println("Try number between 0 and 10");
		int[]arr = new int [n];
		for (int i = 0 ; i < arr.length; i++) {
			arr [i] = r.nextInt(10);
		}
		// arr = Arrays.parallelSort(arr);
		//		arr = Arrays.sort(arr);

		for (int j = 0; j < arr.length-1; j++) {
			if (arr[j]>arr[j+1]) {
				int temp = arr[j];
				arr[j] = arr[j+1];
				arr[j+1] = temp;
			}
		}
		return arr;
	}

	// q2 a
	public static boolean ifContains(String word, char ch) {
		for (int i = 0; i< word.length(); i++) {
			if (word.charAt(i)== ch)
				return true;
		}
		return false;
	}

	// q2 b
	public static int numLetter(String word, char ch) {
		int count = 0;
		for (int i = 0; i<word.length(); i++) {
			if(word.charAt(i) == ch)
				count++;
		}
		return count;
	}
	
	// q2 c
	public static String intersect(String s1, String s2) {
		String s3 = "";
		for (int i = 0; i<s1.length(); i++) {
			for (int j = 0; j<s2.length(); j++) {
				if(s1.charAt(i) == s2.charAt(j))
					s3 += s1.charAt(i);
			}
		}
		return s3;
	}
	
	// q3
	
}
