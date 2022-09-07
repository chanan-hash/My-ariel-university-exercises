package UA_exercises_and_test;

public class UA_Test_29_06_2020 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(decimal2Binary(18));
		System.out.println(decimal2Binary2(18));

	}
	// q1
	public static String decimal2Binary(int a) {
		if (a<0)
			return "give another number grreater the 0";
		String t = "";
		int i = a;
		while (i>0) {
			//for (int i = a; i>=0; i--) { // we are starting from 'a' and declining every iteration
			if(i%2 == 1)
				t += "1";
			else if (i%2 == 0)
				t+= "0";
			i /= 2; // we're taking every iteration the One's digit out
		}
		if (t.charAt(0) == 0)
			t.replace(""+"0","");
		return t;
	}

	// their answer
	private static String decimal2Binary2(int n) {
		String s = "";
		while(n>0){
			s = (n%2) + s;
			n /= 2;
		}
		return s;
	}


	//q2
	/*
	public static boolean sameNumbers(int [][] mat) {
		int m = mat.length; // because this is a square/equal matrix we don't need also to specify the length of the row, such as int j = mat[0].length, because it is the same length		
		for (int i = 0; i<m; i++) {
			for (int j =0; j<m; j++) {
				if (mat[][])
			}


	 */
}
