package TestPrepare;

import java.util.Arrays;

public class Bubble_Sort {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		int[] arr = {1,4,2,6,3,8,1,0};

		System.out.println(Arrays.toString(arr));
		// Descending
		BubbleSort(arr);
		System.out.println(Arrays.toString(arr));
		//Ascending
		BubbleSortAsc(arr);
		System.out.println(Arrays.toString(arr));
		
	}


	// Swap function

	public static void Swap(int[]a, int i, int j) {
		int temp = a[i];
		a[i] = a[j];
		a[j] = temp;
	}

	// Sort in Descending order
	public static void BubbleSort(int[]arr) {
		for (int i = arr.length-1; i>0 ; i--) {
			for (int j = 0; j<i; j++) {
				if (arr[j] < arr[j+1]) {
					Swap(arr, j, j+1);
				}
			}
		}
	}

	// Sort in Ascending order
	public static void BubbleSortAsc(int[]a) {
		for (int i = a.length-1; i>0; i--) {
			for (int j = 0; j<i; j++) {
				if (a[j] > a[j+1]) {
					Swap(a, j, j+1);
				}
			}
		}
	} 


}
