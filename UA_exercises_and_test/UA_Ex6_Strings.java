package UA_exercises_and_test;

public class UA_Ex6_Strings {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String str = "abccba";
		String str2 = "abc";
		String str3 = "Hello world !";

		System.out.println(String_palindrome(str));
		System.out.println(String_palindrome(str2));
		Revers_String(str2);
		System.out.println(First_Char_Number(str));

		Is_Equal(str, str2);
		System.out.println(Words_number(str3));
		lowercase(str3);
		
		System.out.println(Capital_first(str));
		//String_sort(str);
	}


	// ex1
	public static void Is_Equal(String str1 ,String str2) {
		for (int i=0; i<str1.length(); i++) {
			for (int j = 0; j<str2.length(); j++) {
				if(str1.charAt(i)!=str2.charAt(j)) {
					System.out.println("The strings are not equal");
					break;
				}
			}
			System.out.println("The strings are equal");
		}
	}

	//ex2 palindromic String
	public static boolean String_palindrome(String str) {
		int L = 0;
		int R = str.length()-1;

		while (L<R) {
			if(str.charAt(L) != str.charAt(R)) { // charAt giving the char at a given index
				return false;				
			}
			else { // means that the two chars are equal, so continue checking
				L++;
				R--;
			}
		}
		return true;
	}

	// ex3 reverse string
	public static void Revers_String(String str) {
		String new_str = "";

		for(int i = str.length()-1; i>=0 ;i--) { // we are running on the string from the and to the beginning and adding it to new new empty String
			new_str += str.charAt(i);
		}
		System.out.println(new_str);
	}

	// ex4 
	public static int First_Char_Number (String str) {
		int count = 0;
		for(int i =0; i<str.length();i++) {
			if (str.charAt(i) == str.charAt(0))
				count++;
		}
		return count;
	}

	// ex5
	public static int Words_number(String str) {
		int count = 0;
		for(int i = 0; i<str.length();i++) {
			if(str.charAt(i) == ' ') { // String is marked with "", and chars with ''.
				count++;
			}
		}
		return count+1; // because we are counting the spaces (we are assuming that between words we have only one space) so we have always one space less than the words, so we're adding 1 to the counter.
	}

	//ex6.1 changing the capital letters to small letters
	public static void lowercase(String str) {
		for(int i = 0; i<str.length();i++) {
			if(str.substring(i,i+1).equals(str.substring(i,i+1).toUpperCase()) ) {
				str.replaceAll(str.substring(i,i+1),str.substring(i,i+1).toLowerCase());
			}
		}
		System.out.println(str);
	}
	 

	// ex6.2 sorting ascending order String
	/*public static void String_sort(String str) {
		String newstr = "";
		int i = 0;
		while(i<=str.length()) {
			int j = i+1;
			while(j<str.length()){
				if(str.charAt(j)<str.charAt(i)) { //swap
					int temp = i;
					i = j;
					j = temp;
					
				}
				newstr += str.charAt(j);
				j++;				
			}
			i++;
		}
		System.out.println(newstr);
	}
*/

	// ex7.1
	public static String Capital_first(String str) {
		str.replaceAll(str.substring(0,1),str.substring(0,1).toUpperCase());
		return str;
	}
}
