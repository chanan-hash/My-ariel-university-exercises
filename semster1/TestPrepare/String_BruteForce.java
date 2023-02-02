package TestPrepare;

import java.util.ArrayList;
import java.util.Arrays;

public class String_BruteForce {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String[] code = allCodes();
		System.out.println(Arrays.toString(code));
	}

	public static String[] allCodes() {
		ArrayList<String> codes = new ArrayList<String>();
		for(int i = 0; i<=5 ; i++) {
			
			for(int j = 0; j<=5 ; j++) {
				
				if (i == j) {continue;}
				
				for(int k = 0; k<=5 ; k++) {
				
					if((k == i) || (k == j)){continue;}
					
					for(int l = 0; l<=5 ; l++) {
					
						if((l == i) || (l == j) || (l == k)){continue;}
						String str = "";
						str = str + i + j + k + l + "#";
						codes.add(str);
					}
				}
			}
		}
		
		// Deep copy
		String[] s = new String[codes.size()];
		for(int i = 0; i<s.length; i++) {
			s[i] = codes.get(i);
		}
		return s;
		//return (String[]) codes.toArray();
	}
}
