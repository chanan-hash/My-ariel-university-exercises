package UA_exercises_and_test;

import java.util.Arrays;

//import java.util.Arrays;

public class CompressedArray {

	Compressed [] comarray;

	public CompressedArray(int []arr) {
		int j=0, k=0, count = 0;

		comarray = new Compressed[arr.length]; // the length of the array
		for (int i = 0; i<arr.length; i++) {
			count = 0; //initializing the counter of the value int the places every iteration
			for (j=i; j<arr.length && arr[i]==arr[j]; j++) { // we want to check if it is the same value in the next index
				count++;
				// we could have done it like an if condition, and the int the for loop to write only j<arr.lenght
				/*if (arr[i]==arr[j])
					count++;*/
			}
			comarray[k++] = new Compressed(arr[i],count); // arr[i] - is the value, count - is the length
		}
		comarray = Arrays.copyOf(comarray,k); 
	}
	/*@Override
	public String toString() {
		return "CompressedArray [comarray=" + Arrays.toString(comarray) + "]";
	}
	 */
	// toString without Arrays class
	@Override
	public String toString() {
		String ret = "[";

		int i;
		for (i = 0 ; i< comarray.length; i++) {
			ret += comarray[i].toString() + ",";
		}
		ret += comarray[i].toString() + "]"; // adding the last i, that why we have declared it outside the loop so we can use it after the loop
		// closing the String with "]", so it won't finish only with ,
		return ret;
	}
}
