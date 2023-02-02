package TestPrepare;

import java.util.Arrays;

public class Insertion_Sort {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] arr = {1,4,2,6,3,8,1,0,5,0,3,17,4,82,7,3};

		System.out.println(Arrays.toString(arr));
		InsertionSortAsc(arr);
		System.out.println(Arrays.toString(arr));
		InsertionSortDsc(arr);
		System.out.println(Arrays.toString(arr));
	}

	public static void Swap(int[] a, int i, int j) {
		int temp = a[i];
		a[i] = a[j];
		a[j] = temp;
	}
	
	public static void InsertionSortAsc(int[] arr) {
		for (int i = 1; i< arr.length; i++) {
			for (int j = i ; j > 0 && arr[j-1] > arr[j] ; j--) {
				Swap(arr, j, j-1);
			}
		}
	}
	
	public static void InsertionSortDsc(int[] a) {
		for (int i = 0; i<a.length; i++) {
			for(int j = i; j >0 && a[j-1] < a[j]; j--) {
				Swap(a, j, j-1);
			}
		}
	}
	
}
