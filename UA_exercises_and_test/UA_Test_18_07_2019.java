package UA_exercises_and_test;

public class UA_Test_18_07_2019 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		for(int i=1; i<20; i++) {
			System.out.println(heartBeat(i));
		}
		System.out.println(isDivisible(new int[]{-1,2,3,6,1,8,4,-2}));  //true
		System.out.println(isDivisible(new int[]{1,2,3,4,5}));          //false
		System.out.println(isDivisible(new int[]{1,1,1,1}));          //true
		System.out.println(isDivisible(new int[]{1,2,2,6,2,3}));          //true
	
		// q5
	    int a = 8;
        int b = 3;
        int r1 = a/b; // 2
        int r2 = (int)((double)a/b); //2.0 --> 2
        double r3 = a/b; // 2.0
        double r4 = (double)a/b; // 2.6666667
        double r5 = (double)(a/b); // 2.0
        String str = r1 + "," + r2 + "," + r3 + "," + r4 + "," + r5; 
        System.out.println(str); // 2,2,2,2.666667,2.666667
        System.out.println("1+2 = " + 1 + 2); // 1+2= 3, it is 12, because there is String there it changes the + to String format
        int[] array1= {1,2,3,4,5};
        int[] array2= {1,2,3,4,5};
        System.out.println(array1 == array2); // true, it is false, because although the number inside are the same, but they arr to different objects as we can see underneath
        System.out.println(array1);
        System.out.println(array2);
	}

	// q1
	public static double heartBeat(int n) {
		// similar to the idea of fibonacci sequence
		if (n == 1) return 55;
		if (n == 2) return 57;
		if(n%5 == 0) return 3 + heartBeat(n-1);
		return (heartBeat(n-2) + heartBeat(n-1))/2.0+2;
	}

	// q2
	// we need to write a 3 more outside methods to help us
	public static boolean isDivisible(int[]arr) {
		// we need to loop for one array to the index from the start and the index from the end
		for (int i =0; i<arr.length; i++) {
			for (int j = arr.length-1; j>0; j--) {
				if (leftMul(arr, i)*rightMul(arr, j) == betweenMul(arr, i, j))
					return true;
			}
		}
		return false;
	}

	private static int leftMul(int[]a, int j ) { // 'j' is a given index in the big function
		int ans = 1;
		for (int i = 0; i<= j; i++) { // going over from the beginning of the array, till the given index (we don't need it to go over the whole array)
			ans *= a[i]; // that why we are starting ans from one and not 0, because then we would get only 0;
		}
		return ans;
	}

	private static int rightMul(int[]a, int i ) { // 'j' is a given index in the big function
		int ans = 1;
		for (int j = a.length-1; j>=i; j--) { // going oner from the left side of the array, from the end till the given index
			ans *= a[j];
		}
		return ans;	
	}

	private static int betweenMul(int[]a, int i	,int j) {
		int b = 1;
		for (int k = i+1; k<j; k++) { // k is starting one place after i, and running till j
			b *= a[k];
		}
		return b;
	}

	// q3


}
