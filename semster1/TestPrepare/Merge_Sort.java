package TestPrepare;

import java.util.Arrays;

public class Merge_Sort {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		int [] a = {0,3,5};
		int [] b = {1,2,4};

		int[] c = mergeSortAsc(a, b);
		System.out.println(Arrays.toString(c));
	}

	// merging sorted arrays 
	public static int[] mergeSortAsc(int []a, int []b) {
		int[] res = new int[a.length + b.length];
		int i = 0, j = 0;

		while (i < a.length && j<b.length) {
			if(a[i] <= b[j]) {
				res[i+j] = a[i++];
			}

			else{
				res[i+j] = b[j++];
			}
		}

		while ( i < a.length) { // copy rest of a
			res[i+j] = a[i++];
		}
		while ( j < b.length) { // copy rest of b
			res[i+j] = b[j++];
		}
		
		return res;
	}

}


