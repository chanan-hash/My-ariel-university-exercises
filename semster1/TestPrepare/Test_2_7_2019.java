package TestPrepare;

import java.util.Arrays;

public class Test_2_7_2019 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] a = {3,4,5,-6,1,-2,-3,-4,6,-2};
		System.out.println(Arrays.toString(a)); // here its before operation the function on a
	
		int[] b = mystery(a,9);
		System.out.println(Arrays.toString(a));
		System.out.println(Arrays.toString(b));
	}

	
	
	public static int[] mystery(int a[], int n) {
		if (n == 1)
			return a;  // The changes is happening also on 'a' itself, because we'ren't creating a new array,
					   // just pointing to the same one 
		if (a[n - 1] > 0 && a[n - 2] < 0) {
			int temp = a[n - 1];
			a[n - 1] = a[n - 2];
			a[n - 2] = temp;
			return mystery(a, n - 1);
		}
		return mystery(a, n - 1);
	}

}
