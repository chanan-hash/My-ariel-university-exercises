package UA_exercises_and_test;

public class UA_Test_25_02_2018 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(MarsennePrime(127));
		System.out.println(MarsennePrime(99));
		System.out.println(MarsennePrime(7));
		System.out.println(moveMost("abbacbca"));
		System.out.println(Math.random());
		char a[][] =   
			{{'a','w','x','r','e'},
					{'f','y','e','s','h'},
					{'t','y','y','e','a'},
					{'a','a','h','t','r'},
					{'h','f','g','z','z'}};
		System.out.println(crossword(a, "yesh"));
		System.out.println(crossword(a, "hat"));
		System.out.println(crossword(a, "yafw"));
		System.out.println(crossword(a, "hatfa"));
	}

	//q1
	public static boolean MarsennePrime(int n) {
		// checking primerity
		if (isMarsenne(n)) // if true
			return isPrime(n); // if true
		return false;
	}

	public static boolean isMarsenne(int n) {
		double x = Math.log(n+1)/Math.log(2); // by log law this is giving us log2(n+1), 2 - is the base, n+1 - is the b
		// and this is giving us the 'i' in 2^(i-1) = n --> i= log2(n+1), by log law 
		return x == Math.ceil(x); // returns true if it is right
	}

	public static boolean isPrime (int n) {
		if (n==1) return false;
		for (int i = 2; i<(int)Math.sqrt(n); i++) { // i need to be stardet form 2, so we won't divide by Zero, and everything is divided by One
			if (n%i==0)
				return false;
		}
		return true;
	}

	// q2


	public static String moveMost(String str) {
		int count = 0;
		char[] c = str.toCharArray(); // convert the string to char array. "abc" --> ['a','b','c']  
		char max = ' ';
		for (int i = 0; i<c.length; i++) {
			int corChar = str.length() - str.replace(""+str.charAt(i), "").length(); // counting the times that char int the String by replacing it with a blank and reducing it from the  original length.
			// the most the answer is small, it means that that char if appearing the most.
			if (corChar > count)
				count = corChar;
			max = str.charAt(i); // that means that that char if appearing the most if it is greater than count 
		}
		str = str.replace(""+max, ""); // changing max char to a blank, and them we will add then again, and automatically it will go to the end like and queue
		for (int i=0;i<count; i++) { // adding the char the same times as count that it the many times that char was in the String
			str += max;	
		}
		return str;
	}

	// option 2

	/*	public static String moveMost2(String str) {
		String max = "";
		for (int i = 0 ; i<str.length(); i++) {
			String c = ""+str.charAt(i);
			int cor = str.length() - str.replace(c, "").length(); // the number that char is in the String (the whole length minus the length without the char = giving us how many times this in the String) 
			//		if (max.length() < cor)
			//				max = c.repeat(cor);
		}
		return str.replace(max.charAt(0)+"", "") + max;
	}
	 */	

	// q3
	public static boolean crossword(char[][] a, String s) {
		// the rows
		for (int i = 0; i<a.length; i++) {
			String temp = new String (a[i]); // creating a new String by usin the class itself
			if(temp.contains(s))
				return true;
		}
		// the columns
		for (int j = 0; j<a[0].length; j++) { // row length a[0].length
			String temp = "";
			for (int i = a.length-1; i>=0; i--) { // going from the end of the  
				temp += a[i][j]; // building a word 
				if (temp.contains(s))
					return true;
			}
		}
		return false;
	}

}
