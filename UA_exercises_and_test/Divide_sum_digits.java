package UA_exercises_and_test;

public class Divide_sum_digits {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int num = 2;
		while(num>=2 && num<=1000) {
			int newnum = num;
			int sum = 0;		// we want to generate the number in every iteration

			while(newnum>0) {
				int digit = newnum%10; // getting the Ones number
				sum += digit; // adding it to the sum
				newnum=newnum/10; // to get the next number for the Ones digit --> 145,14,1 
			}
			if(num%sum==0) {
				System.out.println(num + " divided by " + sum);
				
			}
			num++;
		}
	}

}
