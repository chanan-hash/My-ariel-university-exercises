package UA_exercises_and_test;

public class UA_Test_07_08_2018 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.err.println(countExactly2(121212, 2, 3));
		System.err.println(countExactly2(121212, 2, 4));
		System.err.println(countExactly2(121212, 4, 3));
		System.err.println(countExactly2(121212, 4, 0));
	}

	//q1
	public static boolean countExactly(int num, int digit, int count) {
		if (count<0) return false;
		int counter = 0;
		if (num%10 == digit) // the modulu giving us the One's digit 324 % 10 = 4 because 10 getting in 320, 32 time and we have 4 left that it is rest.
			counter++;
		if (counter == count)
			return true;
		return countExactly(num/10, digit, counter); // dividing by 10 reducing the One's digit from the number --> 324/10 = 32
	}
	//	their answer
	public static boolean countExactly2(int num, int digit, int count) {
		if (num==0) return count == 0; // base condition, that the num and the count are the same number 
		if (num%10 == digit)
			count--;
		return countExactly2(num/10, digit, count);
	}

}
