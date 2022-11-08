package semster1;

import java.util.Arrays;

public class Exer3_2 {
// look in they used swap on One array
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int arr [] = {1,2,3,4,5};
		int [] arr2 = new int[arr.length];
		
		System.out.println(Arrays.toString(arr));
		
		for(int i = (arr.length-1); i>=0; i--) {
			for(int j = 0; j<i; j++) {
				
				System.out.println(arr[i]);
				arr2[j] = arr[i];
				System.out.println(arr[j]);

			}
		}
		
		System.out.println(Arrays.toString(arr));
		System.out.println(Arrays.toString(arr2));


	}
}
