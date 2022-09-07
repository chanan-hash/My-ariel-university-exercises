package UA_exercises_and_test;
import java.util.Arrays;

// All kinds of searches and sorts
public class UA_Ex8_Sorts {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] arr = {5,3,2};
		int n1 = 2;
		int n2 = 3;
		System.out.println(n1 + ", " + n2);
		System.out.println(Arrays.toString(arr));
		//	bubbleSort(arr);
		Swap(n1,n2);
		System.out.println(n1 + ", " + n2);

		selectionSort(arr);
	}

	//Swap methods, for convenience
	public static int Swap(int n1,int n2) {
		int temp = n1;
		n1 = n2;
		n2 = temp;

		return n1 & n2;
	}

	// Bubble sort
	public static void bubbleSort(int[] arr) {
		for (int i = arr.length; i > 0; i--) { // going over the array once, then we're doing another loop to check after we've swapped if it is still sorted and needs to be sorted again
			for (int j = i; j > 0; j--) { // we want the sort to be continued till it sorted till the end, and not swapping only between to places. 
				if(arr[j] > arr[j+1]) //
					Swap(arr[j],arr[j+1]);
			}
		}
		System.out.println(Arrays.toString(arr));
	}

	/*
	 * [5,3,2] --> the first iteration will swap like this:
	 * [3,2,5] --> we've swapped and put the biggest value in the end, but the array is still not sorted. this will get if we have only One loop
	 * so we need another loop do to the same operation again and again till the whole array is sorted.
	 * after the inner loop we'll get:
	 * [2,3,5]
	 * After it finishes it doing another iteration although it is sorted, because its not know that it sorted, the previous iteration just Swapped. then it is go over it again and see that every thing is sorted in the write place
	 * so although its sorted there is still another iteration in the end, after the sort, because the computer don't know that it is sorted if it will not check it
	 * The complexity is O(n^2).
	 * more simple (because we are just swapping) sort but not the most efficient
	 */


	public static void selectionSort(int[] arr) {
		for (int i = 0; i<arr.length; i++) {
			int minpos = i;
			for (int j = i; j<arr.length; j++) {
				if (arr[j]<arr[minpos]) {
					minpos = j; //taking the minimum position for index
				}
				int temp = arr[i]; // swap
				arr[i] = arr[minpos];
				arr[minpos] = temp;
			}
		}
		System.out.println(Arrays.toString(arr));
	}

	// ex9 by using binary search
	public static int BinarySerach (int[]arr) {
		int left = 0;
		int right = arr.length-1;

		while(left<=right) {
			int mid = (left+right)/2;
			if (mid!=arr[mid]) {
				return mid;
			}
			else {
				if (mid<arr[mid]) {
					right = mid-1; // go to the left half of the array
				}
				else {
					left = mid+1; // go to the right half of the array
				}
			}
		}
		return -1;


	}

}
