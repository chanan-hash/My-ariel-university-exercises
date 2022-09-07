package UA_exercises_and_test;
import java.util.Arrays;

public class UA_Test_30_1_2018 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		double a = 1.5;
		System.out.println((int)(a));
		//	System.out.println(square(246));
		System.out.println(reduce("aaabbccccxxxyzzaaa"));
	
		// q4
		Line l = new Line(3, 7, 8, 3); // the first object with all the qualities
        Line l1 = new Line(l); // that why we have a copy constructor that the class will be able to get another object from the class and to treat it as a regular object of the class 
        System.out.println(l.length());
        System.out.println(l1.length());
        System.out.println(l.on(2, 2));
	
	}

	// q1
	public static boolean square(int a) {
		int sum = 0;
		for (int i = 0; i<=a; i++) {
			if (a%i==0)
				sum += i*i; 
		}
		double sqrt = Math.sqrt(sum);
		return (int) (sqrt) == sqrt; // (int)(n) turning a number to an integer
	}

	// q2
	public static String reduce(String s) {
		String s2 = "";
		for (int i = 0; i <s.length(); i++) {
			String s3 = ""+s.charAt(i); // in every iteration we are defining a new String s3
			if (s2.endsWith(s3)==false) // checking if it already has the suffix, if it has that letter so it won't add it to the new String.
				s2 += s3;
		}
		return s2;
	}

	// q3 this answer will be built from three functions
	public boolean symmetric(int[][] a, int[][] b) {
		return isSymX(a, b); // || isSymY(a, b);
	}

	private static boolean isSymX(int[][] a, int[][] b) {
		if(a.length!=b.length || a[0].length!=b[0].length) // first of all checking the array have the same number of rows (a.lenght), and the same columns (a[0].length)
			return false; // if not we're already know that they won't be symmetric
		
		int ah = a.length-1, bh = b.length-1; // 2 variables which represent the height/rows of the arrays

		for (int i =0; i<=ah; i++) {
			if(!Arrays.equals(a[i],b[bh-1]))
				return false;
		}
		return true;
	}
	
	
}