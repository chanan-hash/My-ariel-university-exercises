// Practice number 4.1, Ariel University - arrays

package A;
import java.util.Scanner;
import java.util.Random;

public class UA_number4 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Scanner input = new Scanner(System.in);

		Random r = new Random();

		System.out.println("Enter a Number: ");
		int N = input.nextInt();		

		int [] arr = new int [N];
		int count = 0;

		// מספרים רנדומלים בין 0 לאן 
		for (int i = 0; i<arr.length; i++) {	
			// מונה לאפסים במערך

			System.out.println(r.nextInt(N));
			if (arr[i] == 0) { 				
				count ++;	
			}
		}
		System.out.println("The number of Zero in the array:" + count);
		
		input.close();
	}
// נתקעתי עם ההסדפסה של האפסים
}