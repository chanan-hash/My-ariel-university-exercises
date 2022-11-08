package tirgul1;
// Meir's implementation for Ex1
import java.util.Scanner;

public class Ex1 {
	// find the great PRIME common divisor of two numbers
	public static void main(String[] args) {
		System.out.println("Enter the first number for GPCD:");
		Scanner sc = new Scanner (System.in);
		long a = sc.nextLong();
		System.out.println("Enter the second number for GPCD:");
		long b = sc.nextLong();

		long start = System.nanoTime();		
		
		long ans = gpcd(a,b);
		
		long end = System.nanoTime();
		double dt = (end - start)/(1000.0);
		
		System.out.println("The GPCD for (" +a+ "," +b+ ") = " + ans);
		
		System.out.println("The runtime took: " +dt+ " micro seconds."); 

		sc.close();
	}																		// end of 'main' function



	// function to check if number is prime
	public static boolean isPrime(long n) {

		if(n==2) {
			return true;
		}

		if(n%2==0) {
			return false;
		}

		long i=3;
		long m= (long) Math.sqrt(n);

		while (i<=m){
			if (n%i==0) {
				return false;
			}//if            	          //end of the 'if' block
			i=i+2;
		}//while                           //end of the 'while' block
		return true;
	}										//end of 'is_prime' function


	//gcd
	public static long gcd (long x, long y) {
		long r = x % y;

		while (r!=0) {
			x = y;
			y = r;
			r = x % y;
		}

		return y;

	}


	//gpcd
	public static long gpcd (long a, long b) {
		long y = Math.min(a,b);
		long x = Math.max(a,b);											// x is the largest number

		if ( (isPrime (x)==true) || ((isPrime (y)==true) && (x%y!=0)) ) {				// if 'x' is prime || ('y' is prime and doesn't divide x)
			return 1;
		}																	
		else if ( (isPrime (y)==true) && (x%y==0) ) {								// if 'y' is prime and divides x
			return y;
		}																	// end of 'is prime' options

		long gcd = gcd(x,y);
		
		if (isPrime(gcd)==true) {
			return gcd;
		}

		long i=2, t=0;
		long sqrt = (long)(Math.sqrt(y));
		
		for (i=2; i<=sqrt; i=i+1) {
			if (y%i==0) {
				t=y/i;
				
				if ( (x%t==0) && (isPrime(t)==true) ) {
					return t;
				}		//end of the second 'if'
			}			//end of the first 'if'
		}				//end of the 'for' block


		long j = sqrt;

		for (j=sqrt; j>=2; j=j-1) {
			if ( (y%j==0) && (isPrime(j)) ) {
				return j;
			}
		}

		return 1;
	}

}																				//end of GPCD class
