package UA_exercises_and_test;

public class UA_Test_26_02_2020 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(semiPrime(4));   //true
		System.out.println(semiPrime(5));   //false
		System.out.println(semiPrime(6));   //true
		System.out.println(semiPrime(12));  //false
		System.out.println(semiPrime(15));  //true
		System.out.println(semiPrime(30));  //false
	}
	
	//q1
	public static boolean semiPrime(int n) {
		for (int i=2; i<n; i++) {
			for (int j=i; j<n; j++) { // because we're checking for two numbers
				if(isPrime(i)&& isPrime(j) && i*j == n) // we are checking if the number are prime, and if their double are equal to 'n' 
					return true;
			}
		}
		return false;
	}

	// we will use outer function of isPrime
	public static boolean isPrime(int n) {
		for (int i = 2; i<=Math.sqrt(n); i++) {
			if(n%i==0)
				return false;
		}
		return true;
	}

	//q2
	/*public static int findMax(String str) {
		String numbers = "123456789";
		String max = "";
		for(int i = 0; i<str.length(); i++) {
			
		}
	}
*/
}
