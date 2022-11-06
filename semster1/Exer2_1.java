package semster1;
// Tirgul 2
import java.util.Scanner;
public class Exer2_1 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Scanner in = new Scanner (System.in);
		System.out.println("Enter an a age: ");
		int x = in.nextInt();

		if (x<18) {
			System.out.println("The age is to little");
		}
		else if (x<65){
			System.out.println("The age is Bagir");
		}
		else {
			System.out.println("The age is Penssion");
		}
		in.close();
	}

}
