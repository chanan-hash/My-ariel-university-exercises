package semster1;

//import java.util.Scanner;

public class Exer2_8 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		/*Scanner in = new Scanner(System.in);
		System.out.println("Enter a number for numerator: ");
		int num = in.nextInt();
		System.out.println("Enter a number for denominator:");
		int dem = in.nextInt();
		
		if((num<10) && (dem<10) && (num>dem)) {
			System.out.println("not a good number try agian: ");
		}
		*/
		int count = 0;
		for (int i =  10; i<100; i++) {
			int i2 = i/10;
			System.out.println("\ti2: " + i2);
			for (int j = i+1; j <100; j++) {
				int j2 = j%10;
				System.out.println("j2: " + j2);
				if((double)i/j == (double)i2/j2){
					count++;
				}
			}
		}
		System.out.println(count);	
	//	in.close();
	}

}
