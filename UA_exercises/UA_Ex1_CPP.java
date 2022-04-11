package A;

import java.util.Scanner;


// This is exercise made for C++, but I have translated it for java because it comfortable to me, the idea is the same.
public class UA_Ex1_CPP {


	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner input = new Scanner(System.in);
		System.out.print("Hello! please enter your number \r\n" +
				"0 for exit\r\n" + 
				"1 for change money\r\n" + 
				"2 for solve the quadratic equation\r\n" + 
				"3 for income tax\r\n" +
				"Enter yout chosie: ");
		int answer = input.nextInt();

		while (answer > 4 || answer < 0) {
			System.out.println("please try again!");
			System.out.print("Hello! please enter your number \r\n" +
					"0 for exit\r\n" + 
					"1 for change money\r\n" + 
					"2 for solve the quadratic equation\r\n" + 
					"3 for income tax\r\n" +
					"Enter yout chosie: ");
		answer = input.nextInt();
		}
		
		// Mission 1		
		if (answer == 1) {
			System.out.print("Enter your money: ");
			int a,b,c,d,e,f,g;
			int money = input.nextInt();

			a = money/100;
			b = (money-a*100)/50;
			c = (money %100%50)/20;
			d = (money - a*100 - b*50 - c*20)/10;
			e = (money %100%50%20%10)/5;
			f = (money - a*100 - b*50 - c*20 - d*10 - e*5)/2;
			g = (money - a*100 - b*50 - c*20 - d*10 - e*5 - f*2)/1;

			System.out.println(a + " Hunders, " + b + " Fifties, " + c + " Twenties, " + d + " Ten, " + e + " Fives, " + f + " Two, " + g +" Ones");
			System.out.println("your money is: " + (a*100 + b*50 + c*20 + d*10 + e*5 + f*2 + g*1) + " NIS");
		}
		// Mission 2
		
		if (answer == 2) {
			System.out.println("Enter three numbers for the equation: ax^2 + bx + c  = 0");
			double a,b,c;
			System.out.print("Enter a: ");
			a = input.nextInt();
			System.out.print("Enter b: ");
			b = input.nextInt();
			System.out.print("Enter c: ");
			c = input.nextInt();
			System.out.println("your numbers are:" + a + ", " + b + ", "+ c);
			System.out.println("the equation is:" + a +"x^2 + " + b +"x + " + c + " = 0" );
			
			double x1 = (-b + Math.sqrt(Math.pow(b, 2)-4*a*c))/2;
			double x2 = (-b - Math.sqrt(Math.pow(b, 2)-4*a*c))/2;
			
			if(x1!=x2)
				System.out.println("The answers of the equation are: x1= " + x1 + ", x2= " + x2);
			else if (x1==x2)
				System.out.println("The equation has only one solution " + x1);
			else
				System.out.println("There is no solution for the equation!");
		}
		
		// Mission 3

		if (answer == 3) {
		System.out.print("Enter your slary: ");
		double salary = input.nextInt();
		double tax = 0;

		if (salary <= 10000)
			tax = 
			(salary*0.1);
		else if (10000 < salary && salary <= 20000)
			tax = (salary*0.2);
		else if (20000 < salary && salary <= 30000)
			tax = (salary*0.3);
		else if (30000 < salary && salary <= 40000)
			tax = (salary*0.4);
		else if (salary > 40000)
			tax = (salary*0.5);
		
		System.out.println("your salary is: " + salary + ", and your tax to pay is: " + tax);
		}
		
		input.close();

	}

}
