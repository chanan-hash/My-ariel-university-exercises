package UA_exercises_and_test;

public class UA_Ex7_Recursion {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(fact(0));
		System.out.println(fact(1));
		System.out.println(fact(2));		
		System.out.println(fact(5));

		System.out.println(sum(3)); // 1+2+3 = 6
		System.out.println(sum(5)); 
		System.out.println(sum(8)); 

		printLine(5);
		System.out.println();
		printLine(3);
		System.out.println();
		printLine(7);
		System.out.println();

		System.out.println(fibonacci(6)); // getting the index number and giving that number in fibonacci series
		System.out.println(fibonacci(8));
		System.out.println(fibonacci(10));

		System.out.println(fibonachiSumma(2));
		System.out.println(fibonachiSumma(3));
		System.out.println(fibonachiSumma(4));
		System.out.println(fibonachiSumma(5));
		System.out.println(fibonachiSumma(6));
		System.out.println(fibonachiSumma(8));
		System.out.println(fibonachiSumma(10));

		System.out.println(reverseNumber(761));
		System.out.println(reverseNumber(12345));
		System.out.println(reverseNumber(54321));
		System.out.println(reverseNumber(782));
		System.out.println(78/10);
		System.out.println(8/10);


	}


	// ex1 factorial function
	public static int fact (int n) {
		if(n==0)		// Base condition when n gets to that number it will return a number, to start working with
			return 1;
		if (n==1)
			return 1;
		return (n) * fact(n-1); // calling the function itself for the recursion
	}

	// ex2
	public static int sum(int num) {
		if(num == 0)
			return -1;
		if(num==1)
			return 1; // we need to think what will be num-1
		return (num)+ sum(num-1);

		/* another way of that function
		if (n > 1){
			return n+sum(n-1);
		}
		else{
			return 1;
		}
		 */
	}

	//ex3
	public static void printLine(int num) {	
		/*for(int i = 0; i<num; i++) {
			System.out.print("*");
		}
		printLine(num-1);
		 */
		char c = '*';
		if (num == 0) // it working like a loop
			return;
		if (num>1) 
			printLine(num-1);
		System.out.print(c); // every time we are printing only once the '*', and reducing num by one till it gets to 0, them we return nothing.g
	}




	//ex6 fibonacci series
	public static int fibonacci(int num) {
		if (num == 0)
			return 0;
		if (num ==1)
			return 1;
		if (num ==2)
			return 1;

		return fibonacci(num-1)+fibonacci(num-2); // we want to return num, but in fibonacci it equals to the sum of the two numbers befor it.
		// // a(n) = a(n - 1) + a(n - 2)
		// n = fibonacci(n - 1) + fibonacci(n - 2)

		/* another way to write the function
		 public static int fibonachi(int n){
		if(n==1 || n==2) return 1;
		return fibonachi(n-1) + fibonachi(n-2);
	} 
		 */

	}

	// ex 6.a - fibonacci sum
	public static int fibonachiSumma(int n){
		if (n ==1)
			return 1;
		if (n ==2) // the index (the second number in fibonacci series is 1, so 1+1=2)
			return 2; // we are returning the sum of the series till that index (n)
		return fibonachiSumma(n-1)+ fibonacci(n); // the sum of the previous number + the next number in the series
	}


	//ex7 turning a number 761 --> 167, not with recursion
	public static int reverseNumber(int number) {
		int res = 0;
		for (res = 0; number>0; number /= 10) {
			res = res*10;
			res = res+number%10;
		}
		return res;
	}

	/* another way to write the function
	public static int reverseNumber(int number){
		int result = 0;;
		while (number != 0){
			result = result*10 + number%10;
			number = number/10;
		}
		return result;

	 */

}
