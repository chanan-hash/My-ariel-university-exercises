package UA_exercises_and_test;

public class UA_Ex8 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		System.out.println(gcd(36,63));
		System.out.println(gcd(63,36));

		System.out.println(round(127.5));
	}


	// ex1 checking if an array is sorted
	public static boolean isSorted(int[] arr) {
		boolean ans = false;
		for (int i =0; i<=arr.length; i++) {
			if (arr[i]<=arr[i+1])
				ans = true;
			else if(arr[i]>arr[i+1])
				ans = false;
		}
		return ans;

		/* with while loop ----> a better way to check this if it is sorted, explains below
		 int i = 0; 
	 	while(i<arr.length){
	 	if(arr[i] > arr[i+1) // we are looking for one time that is not sorted and then we can leave the loop
	 							this instead checking every iteration if it is sorted
	 		return false // if we are returning something so its leaving the loop and the function and returning what we have told it.
	 	}
	 return true; // if we didn't return false it means, the loop ran till the end, and we've finished it,
	  and the array is sorted and we can true

		 */
	}

	// ex2 matrix row sort checkup
	public static boolean rowsSorted(int [][]mat) {
		boolean ans = false;
		for (int i = 0; i< mat.length; i++) {
			for (int j = 0 ; j<mat[0].length; j++) { // or int j = i+1;
				if(mat[i][j] <= mat[i][j+1]) // i that represent the column staying the same, but j which representing the row is checking if he is small from j+1
					ans = true;
				else
					return false;
			}
		}

		return ans;
	}

	// ex3
	public static int gcd(int p, int q) {
		int max = 0;
		for(int i = 1; i<p; i++){ // i is starting from 1, so we won't divide by zero
			for (int j = i; j<q; j++) {
				if(i==j) { // because we have nested loop and two variables i & j, so before checking the gcd, we're checking that i & j are equal
					if ((p % i == 0) && (q % j == 0)) { // and only then we are checking the gcd, so it will be the same number 
						if(i>max)
							max = i;
					}
				}
			}
		}
		return max;
	}

	// ex5 taking double number and turning it to a long number
	public static long round(double d) {
		long round = Math.round(d);
		return round;
	}

	// ex6 
	boolean isSortedUp(int arr[], int start, int end) {
		boolean ans = true;
		for (int i = start; i<=end; i++) { // it is like ex1 but we are running on the array according to start and end indexes 
			if (arr[i]<=arr[i+1])
				ans = true;
			else if(arr[i]>arr[i+1])
				ans = false;
		}
		return ans;
	}

	// ex7 checking if most of the values in the array are positive
	public static boolean mostPositive(int arr[]) {
		int count = 0;
		for (int i = 0; i< arr.length; i++) {
			if (arr[i]> 0)
				count++;
		}
		if (count>(arr.length/2))
			return true;
		else {
			return false;
		}
	}

	// ex8 
	public static int biggest2(int[] arr){
		int max = 0;
		int max2 = 0;
		for (int i = 0; i<arr.length; i++) {
			if(arr[i]>max) // max will save the biggest value
				max = arr[i];
		}
		for(int j = 0; j<arr.length; j++)
			if(arr[j] == max)
				arr[j] = 0; // if the value in the array is equal to the max number so we are initializing it to Zero 

		for (int k = 0 ;k<arr.length; k++) {
			if(arr[k]>max2)
				max2 = arr[k];
		}
		return max2;
	}

	// ex9 
	public static boolean colsSorted(int [][]mat) {
		boolean ans = false;
		for (int i = 0; i< mat.length; i++) {
			for (int j = 0 ; j<mat[0].length; j++) { // or int j = i+1;
				if(mat[i][j] <= mat[i+1][j]) // j that represent the rows staying the same, but i which representing the column, is checking if he is small from i+1
					ans = true;
				else
					return false;
			}
		}

		return ans;
	}
}
