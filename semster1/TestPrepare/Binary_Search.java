package TestPrepare;

public class Binary_Search {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		int [] a = {1,2,3,4,5,6,7,8};

		System.out.println(binarySearchRec(a, 6, 0, a.length));
		System.out.println(binarySearchIter(a, 6));

	}

	// Binary Search in recursion --> returning in which place is the value
	public static int binarySearchRec(int[] arr, int n, int left, int right) {
		if(left>right) {return -1;}

		int middle = (left + right)/2;
		if (arr[middle] == n) {
			return middle;
		}
		if (arr[middle] > n) {
			return binarySearchRec(arr, n, left, middle-1);
		}
		else {
			return binarySearchRec(arr, n, middle+1, right);
		}
	}

	public static int binarySearchIter(int[] arr, int n) {
		int Left = 0;
		int Right = arr.length-1;
		int mid = 0; 

		while (Left <= Right) {
			mid = (Right + Left)/2;

			if (n == arr[mid]) {
				return mid;
			}

			if(n > arr[mid]) {
				Left = mid +1;
			}
			else {
				Right = mid - 1;
			}
		}
		return -1;
	}
}