package UA_exercises_and_test;

public class UA_Ex4_5 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		int[] arr = {1,2,3,4,5};
		int[] arr2 = {1,2,3,4,3,2,1};
		int left = 0;
		int right = arr2.length-1;

		while (left<right) {
			if (arr2[left] != arr2[right]) {
				System.out.println("not a palindrom");
				break;
			}
			else {
				left++;
				right--;
			}
			System.out.println("is palindrom");
			break;
		}

		for(int i =0; i<arr2.length;i++) {
			if (arr[i] == arr[arr.length-1-i]) { 
				continue;
			}
			else {
				System.out.println("not a palindrom");
				break;
			}
			}			
		System.out.println("is a palindrome");

	}
}