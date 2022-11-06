package semster1;

import java.util.Scanner;

public class Exer2_4 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner in = new Scanner(System.in);

		System.out.println("Enter Three number: \nyour grade: ");
		int grade = in.nextInt();
		System.out.println("your average: ");
		double avg  = in.nextInt();
		System.out.println("Enter number of excersie (1-8:");
		int exce = in.nextInt();

		if (exce <=4) {
			System.out.println("fail! :(");
		}
		else if ((exce>=5) && (exce<=6)) {
			avg = avg*(0.2 +1);
			if(grade>=55) {
				double finalGrade = avg + grade;
				System.out.println(finalGrade);
			}
			else {
				System.out.println(grade);
			}
		}

		else {
			if(grade<=54) {
				if (avg>=80) {
					// need to complete it
				}
			}	
		}
		in.close();
	}
}
