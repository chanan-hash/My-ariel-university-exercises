package UA_exercises_and_test;

public class UA_Test_19_02_2019 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(isSphenic(30));  //true
		System.out.println(isSphenic(60));  //true
		System.out.println(isSphenic(15));  //false
		System.out.println(isSphenic(98));  //false

		String a = "kjfbj,sd";
		String b = "dnl";
		String c = "kjf";
		System.out.println(a.concat(b));
		System.out.println(a.contains(b));
		System.out.println(a.contains(c));


		System.out.println(mergeStrings2("xyz2aaa2", "2abcde22"));
		
		
		int x=3,y=7;
		swap(x,y);
		System.out.println(x+" "+y); //7 3
		int[] array={6,4,2,0,5,1};
		swap(array,0,1); // it uses the numbers as an index so --> array[0] = 6, array[1] = 4, and swap between them 
		System.out.println(array[0]+" "+array[1]); // 4 6
		swap(array[0],array[1]); // taking numbers
		System.out.println(array[0]+" "+array[1]); // 6 4
		String d="ABC";
		String e="wxz";
		swap(d,e); // d = "wxz", e = "ABC"
		System.out.println(d+" "+e); // wxz  ABC
		int cell=3;
		while(cell>=0 && cell<=5) { // between five and zero
		System.out.print(cell + " "); // first iteration is 3
		cell= array[cell]; // array[3] = 0, the fourth place , then array[0] = 6, and 6>5, so it goes out of the loop and we have 3 0
		}
		System.out.println();
	}

	// q1
	public static boolean isSphenic(int n) {
		for (int i = 2; i<n; i++) { // because they supposed to be prime numbers we need to run the loop from 2
			for (int j = 2; j<n; j++) {
				for (int k = 2; k <n; k++) {
					if(isPrime(i)&& isPrime(j)&& isPrime(k) && i!=j && i!=k && j!=k)// if they are prime and not equal to one each other
						if (i*j*k == n)
							return true;
				}
			}
		}
		return false; // if we've finished the whole loops and didn't return true, so it means it is false, and the number is not sphenic 
	}

	// we need to build a prime number check function

	public static boolean isPrime (int num) {
		if (num==1) return false;
		for (int i = 2 ;i< Math.sqrt(num); i++) {
			if (num%i==0) return false; // that means that num is divided not only by itself and 1, but also with i
		}
		return true;
	}

	// q3
	public static String mergeStrings(String a, String b) {
		String s = "";
		for (int i = 0; i<=a.length()-1; i++) {
			for (int j = 0; j<=b.length()-1; j++) {
				if (a.charAt(i) == b.charAt(j) && b.charAt(j) != s.charAt(j))
					s += a.charAt(i);
			}
		}
		return s;
	}

	// how they did it
	private static String mergeStrings2(String a, String b) {
		String merged = "";
		for (int i = 0; i < a.length(); i++) {
			String c = ""+a.charAt(i); // every iteration we are only adding one char and checking it.
			if(b.contains(c) && !(merged.contains(c)))
				merged+=c;
		}
		return merged;
	}

	public static void swap(int x,int y) {
		int help=x;
		x=y;
		y=help;
	}
	public static void swap(int[] arr,int i,int j) {
		int help=arr[i];
		arr[i]=arr[j];
		arr[j]=help;
	}
	public static void swap(String a,String b) {
		String help=a;
		a=b;
		b=help;
	}


}