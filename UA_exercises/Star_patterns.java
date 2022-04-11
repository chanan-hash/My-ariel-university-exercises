package UA_exercises;

public class Star_patterns {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		/*
		int num = 5;
		int i=0,j=0;
		while(i<num) {
			while(j<=i) {
			System.out.print("* ");
			j++;
			}
			System.out.println();
			j = 0;
			i++;
		 *
		 **
		 ***
		 ****
		 *****
		}
	}
		 */
		
		int num = 5;
		int i=0,j=num;
		while(i<=num) {
			while(j>=i) {
				System.out.print("* ");
				j--;
			}
			System.out.println();
			j = num;
			i++;
		/*
		 ******
		 ***** 
		 **** 
		 ***
		 **
		 * 
		 */
		
		}
	}	
}

