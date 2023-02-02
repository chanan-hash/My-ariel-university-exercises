package TestPrepare;

import java.util.Arrays;

public class Selection_Sort {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] arr = {1,4,2,6,3,8,1,0,5,0,3,17,4,82,7,3};
		
		System.out.println(Arrays.toString(arr));
		// Descending
		InsertionSortDsc(arr);
		System.out.println(Arrays.toString(arr));
		//Ascending
		InsertionSortAsc(arr);
		System.out.println(Arrays.toString(arr));

	}

	
	public static void Swap(int[] a, int i, int j) {
		int temp = a[i];
		a[i] = a[j];
		a[j] = temp;		
	}
	
	public static void InsertionSortDsc(int[] arr) {
		for (int i = 0 ; i<arr.length; i++) {
			int minIndex = i;
			for (int j = i+1; j<arr.length; j++) {
				if (arr[j] < arr[minIndex]) {
					minIndex = j;
				}
			}
			Swap(arr, i, minIndex);
		}
	}
	
	
	public static void InsertionSortAsc(int[] arr) {
		for (int i = 0; i < arr.length; i++) {
			int maxIndex = 0;
			for (int j = i; j < arr.length-1; j++) { // here the length -1 is important
				if (arr[j] > arr[maxIndex]) {
					maxIndex = j;
				}
			}
			Swap(arr, i, maxIndex);
		}
	}
	
}
