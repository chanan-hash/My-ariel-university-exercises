// Practice number 4.2, Ariel University - arrays

package A;

import java.util.Random;

public class UA_number42 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Random r = new Random();


		int [] arr = new int [10];
		int n = 0;

		for (int i = 0; i<arr.length; i++) {

			//			System.out.println(r.nextInt(10<=n<=30));

			System.out.println(i);

		}			
		for (int j = 0; j<arr.length; j ++) {
			if (arr[j] > arr[j-1]) {
				n = arr[j];			 
		}
		}
		System.out.println("Max: " + n);


		/*
		 						n = arr[i];
					}

		}
		for (int i = 0; i<arr.length; i++) {

			System.out.println(arr[i]);
			if (arr[i] > arr[i-1]) {
				n = arr[i];
			}
			System.out.println("Max: " + n);

		 */
	}
}

