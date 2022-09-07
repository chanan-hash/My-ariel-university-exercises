package UA_exercises_and_test;

import java.util.regex.Pattern;

public class UA_Test_10_02_2013 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(appearance("aabbbtgjjjjjiu",3));
		System.out.println(appearance("aabbbtgjjjjjiu",0));
		System.out.println(appearance("abbbtgjjjjjaiu",2));
		System.out.println(appearance("aabbbtgjjjjjiu",6));

		System.out.println();

		chareqA3();
		System.out.println();
		eqA3();
	
		 String s1 = "123";
	        String s2 = "-123";
	        String s3 = "+123";
	        String s4 = "1.2.3";
	        String s5 = "-.123";
	        String s6 = "-123.";
	        String s7 = "-e123";
	        String s8 = "&123";
	        String s9 = "-+123";
	        String s10 = ".-123";
	        System.out.println(s1+" - "+ isANumber(s1));
	        System.out.println(s2+" - "+ isANumber(s2));
	        System.out.println(s3+" - "+ isANumber(s3));
	        System.out.println(s4+" - "+ isANumber(s4));
	        System.out.println(s5+" - "+ isANumber(s5));
	        System.out.println(s6+" - "+ isANumber(s6));
	        System.out.println(s7+" - "+ isANumber(s7));
	        System.out.println(s8+" - "+ isANumber(s8));
	        System.out.println(s9+" - "+ isANumber(s9));
	        System.out.println(s10+" - "+ isANumber(s10));	
	}

	// q5
	public static char appearance(String s, int n){

		for(int i = 0; i<s.length(); i++) {
			// in python you have inbuilt function which is called 'count' and this is returning the times the char is in the string   
			char c = s.charAt(i); // we're creating a char that it every iteration the next letter in the string
			if (s.length() - s.replace(""+c,"").length() == n) // if we are replacing with blank, means we are taking out 'c', if and the sub will be n, it means that 'c' is found n times in the string.
				return c;
		}
		return '?';
	}

	// q6
	public static void chareqA3(){
		for (int i = 10 ; i < 100; i++ ) {
			int sum = 0;
			int pow3 = i*i*i;//Math.pow(int()i,int()3);
			while(pow3>0){ // maybe to change it to a while loop, and not a for loop like this: for (int j = 0; j<pow3; j++), because then we want get the whole numbers because j will be big than pow3 quicker. 
				// The condition we need is only while pow3 bigger than 0.
				sum += (pow3%10); // adding the Ones digit
				pow3 /=10; // decreasing pow3 10 times to get every digit each iteration
			}
			if (sum == i) {
				System.out.println("number: " + i + " ,its power by 3: " + pow3);
			}
		}
	}

	// the way they solved q6
	private static void eqA3() {
		for (int i = 10; i < 100; i++) {
			if(sumDigits(i*i*i) == i)
				System.out.println(i);
		}
	}

	private static int sumDigits(int n) {
		int sum = 0;
		while(n>0){
			sum += n%10;
			n/=10;
		}
		return sum;
	}

	// their solution for q3 
	 private static String isANumber(String s) {
	        if(Pattern.matches("^[+-]?\\d+$", s)) return "int";
	        if(Pattern.matches("^([+-]?\\d*\\.\\d*)$", s)) return "double";
	        return "not a number";
	    }
	
	
}
