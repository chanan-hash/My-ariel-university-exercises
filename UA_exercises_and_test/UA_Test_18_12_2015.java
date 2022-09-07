
package UA_exercises_and_test;

//import java.util.Arrays;

public class UA_Test_18_12_2015 {
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(diff2("1234", "1245"));
		System.out.println(diff2("1234", "12345"));
		System.out.println(diff2("1234", "678"));
		System.out.println(subprime2(919));  //true
		System.out.println(subprime(321));  //true
		System.out.println(subprime2(11));   //true
		System.out.println(subprime(914));  //false
	}

	// q1
	// we will build a function that checks if a number is a prime number
	public static boolean isPrime(int n) {
		for (int i = 2; i<=Math.sqrt(n); i++) { // it is important to do <=, less equal to
			if (n % i==0)
				return false;
		}
		return true;
	}

	// we will separate the number by dividing by 10, and check every iteration if it is a prime number
	public static boolean subprime (int n) {
		for (int i = 0; i<n; i++) {	
			if (isPrime(n))
				return true;
			n /= 10; // taking of the rightest digit every iteration 
		}
		return false;
	}

	// q1 their way, they turned the number to a String and first checked if the number is prime, and then if it is in(contains) the number
	public static boolean subprime2(int n){
		String num = String.valueOf(n);
		for (int i=2; i<=n; i++)
			if(isPrime(i) && num.contains(String.valueOf(i)))
				return true;
		return false;
	}

	// q2
	public static int contains(int[]arrbig, int[] arrsmall) {
		int index = 0;
		for (int i = 0; i<arrsmall.length; i++) {
			for (int j= 0; j<arrbig.length; j++) {
				if (arrbig[j]!=arrsmall[i])
					return -1;
				else
					index = j;
			}
			//			Arrays.asList(arrbig).containsAlll(arrsmall) checking if one object or few objects in another list (we've converted the array to a list)
			index = arrbig.length - arrsmall.length - index;
		}
		return index;
	}

	// q2 second way
	/*	public static int contains2(int[]arrbig, int[] arrsmall) {
		int index = 0;
		if(Arrays.asList(arrbig).containsAlll(arrsmall)) //checking if one object or few objects in another list (we've converted the array to a list)
			for (int i = 0; i < arrsmall.length; i++) {
				for (int j = 0; j<arrbig.length; j++) {
					if (arrbig[j]!=arrsmall[i])
						index = i;
					break;
				}
			}
		return index;
	}
	 */
	// q3
	public static String diff(String a, String b) {
		String temp = "";
		//if (a.length() == b.length()) {
		for (int i = 0; i<a.length();i++) {
			for (int j = 0; j<b.length(); j++) {
				if (a.charAt(i)!=b.charAt(i))
					temp += a.charAt(i);
			}
		}
		//	}
		return temp;
	}

	// q3 second way
	public static String diff2(String a, String b){
		String t = "";
		for (int i = 0; i < a.length(); i++)
			if(!b.contains(""+a.charAt(i)))
				t += a.charAt(i);
		return t;
	}
}
