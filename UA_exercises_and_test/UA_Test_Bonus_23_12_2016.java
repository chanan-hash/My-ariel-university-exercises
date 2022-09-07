package UA_exercises_and_test;
import java.util.Arrays;
public class UA_Test_Bonus_23_12_2016 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		System.out.println(tri(10));
		System.out.println(tri(21));
		System.out.println(tri(22));

		int a[] ={1,2,3,4,6,9,2,3,5,2};
		int a1[] = {2,3};
		int b[] ={2,5,2,5,2};
		int b1[] = {2,5,2};
		int c[] = {1,2,3,4,6,9,5};
		int c1[] = {4,8,6,9};
		System.out.println(numarray(a,a1));
		System.out.println(numarray(b,b1));
		System.out.println(numarray(c,c1));

		String str = "ksdnkjsdndjkfnd ffhdfj dfghkl geg";
		String []d = str.split(" ");
		String []e = str.split("d");
		System.out.println(Arrays.deepToString(d));
		System.out.println(Arrays.toString(e));		

		System.out.println(longestWord("I love java and python"));
		System.out.println(longestWord2("I love java and python"));
	}

	//q1
	public static boolean tri (int i) {
		int sum = 0;
		for (int j = 0; sum< i; j++ ) { // the sum needs to be smaller than i -> the given number so, it will run from the sum till 'i', and not till j like a regular loop
			sum += j;
			/* lets do the iterations if i=10

		1. sum = 0, j = 0
		2. sum = 0, j = 1 --> sum = 1, 1<10 
		3. sum = 1, j = 2 --> sum = 3, 3<10
		4. sum = 3, j = 3 --> sum = 6, 6<10
		5. sum = 6, j = 4 --> sum = 10, 10=10 --> return true

		if i = 12

		1. sum = 0, j = 0
		2. sum = 0, j = 1 --> sum = 1, 1<10 
		3. sum = 1, j = 2 --> sum = 3, 3<10
		4. sum = 3, j = 3 --> sum = 6, 6<10
		5. sum = 6, j = 4 --> sum = 10, 10<12
		6. sum = 10, j = 5 --> sum = 15, 15>12 --> return false

			 */
		}
		return sum == i;
	}

	//q2
	public static int numarray(int bigarr[], int smallarr[]) {
		int count = 0;
		for (int i = 0; i<bigarr.length - smallarr.length; i++) { // the loop running until the difference between the arrays
			if (bigarr[i] == smallarr[0]) { // if the cell in the bigarray is equal to the beginning of the small array, says that maybe it similar, depend on the continuance of the small array
				int flag = 0;
				for (int j = 0; j<smallarr.length; j++) { // now we are checking the rest of the small array
					if (bigarr[i+j] == smallarr[j]) // in bigarr we're checking from 'i+j' because 'i' represent the beginning of the checkup, it doesn't necessarily start at bigarr[0]
						flag++;
				}	
				if (flag == smallarr.length) // means the whole small array is in the bigg array, because 'flag' got to the same length of the small array
					count++;
			}
		}

		return count;
	}


	//q3 
	//this is giving the length of the longest word
	public static int longestWordlengh(String s) {
		int count = 0;
		int max = 0;
		for (int i = 0; i<s.length(); i++) {
			if (s.charAt(i)!=' ')
				count++;
			if (count > max)
				count = max;
		}		
		return max;
	}

	public static String longestWord(String s) {
		int max = 0;
		String a[] = s.split(" "); // splitting the string into an array after a given string, here we've put after every space (when it splits the String it takes of the given char/string to split, so if it is a space it doesn't matter
		String bigest = "";
		// now we can treat it as an array
		for (int i=0; i<a.length; i++) { // a[i].length --> is giving us the length of the word/the cell in the array, instead doing another loop for every cell in the array 
			if (a[i].length() > max)
				max = a[i].length();
			bigest = a[i];
		}
		return bigest;
	}

	public static String longestWord2(String str) {
		String b[] = str.split(" ");
		String maximum = "";
		for(int i =0; i<b.length; i++) {
			if(b[i].length() > maximum.length()) // here we are checking the words themselves, instead checking the length of them and then to put the max in the string, here it is directly
				maximum = b[i];
		}
		return maximum;
	}

}
