package UA_exercises_and_test;

import java.util.Arrays;

public class UA_EX5_Functios {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] arr = {1,2,3,4,5};
		System.out.println(Arrays.toString(arr));
		System.out.println(arraySum(arr));
		System.out.println(arrayMean(arr));
		System.out.println(arrayStdev(arr));
		swap(2, 3, arr);
		System.out.println(Arrays.toString(arr));

		int[] arr2 = {1,2,3,2,1};
		System.out.println(palindrom(arr2));

		reverse(arr);
		//evenOddSort(arr);
	}

	// ex1 sum of array
	public static double arraySum(int [] arr) {
		double sum = 0;
		for (int i = 0; i<arr.length; i++) {
			sum += arr[i];
		}
		return sum;
	}

	// ex2 array's average
	public static double arrayMean(int [] arr) {
		double avg = 0;
		double sum = 0;
		for(int i = 0; i<arr.length; i++) {
			sum = sum + arr[i];
		}
		avg = sum/arr.length;
		return avg;
	}

	// ex3 
	public static double arrayStdev(int [] arr){
		double stdev = 0;
		double avg = 0;
		double sum = 0;
		for (int i = 0; i< arr.length; i++) {
			sum += arr[i];
		}
		avg = sum/arr.length;
		for (int j = 0; j< arr.length; j++) {
			stdev += Math.pow((arr[j] - avg), 2);
		}
		return Math.sqrt(stdev/arr.length) ;
	}

	// ex4 
	public static boolean palindrom(int [] arr) {
		int l = 0;
		int r = arr.length-1;

		while (l<l) {
			if (arr[l] == arr[r]) {
				l++;
				r--;
			}
		}
		return true;
	}

	// ex5 reverse array
	public static void reverse(int [] arr) {
		//int[] a = new int [arr.length];
		for(int i = arr.length-1; i>=0; i--) {
			System.out.print(arr[i] + ", ");
		}

	}

	// ex6 swap method
	public static void swap(int i, int j, int [] arr) {
		int temp = arr[i];
		arr[i] = arr[j];
		arr[j] = temp;
	}

	// ex7 
	// based on https://www.geeksforgeeks.org/sort-even-numbers-ascending-order-sort-odd-numbers-descending-order/
	public static void evenOddSort(int [] arr){
		int l = 0;
		int r = arr.length-1;
		int k = 0;
		while(l<r) {
			while(arr[l] %2 ==0) {
				l++;
				k++;
			}
		}
		while (arr[r] %2 != 0 && l<r) {
			r--;
			//swap
			if(l<r) {
				int temp = arr[l];
				arr[l] = arr[r];
				arr[r] = temp;
			}
		}
		System.out.println(Arrays.toString(arr));
	}

}