package UA_exercises_and_test;

import java.util.Random;
import java.util.Scanner;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.ListIterator;
public class UA_Test_03_02_2019 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		long t = marsenne(7);
		System.out.println("\n"+t);

		simCoin();
		
		String s = "abracadabra";
		String s2 = s.replace(""+s.charAt(3), ""); // this will replace all chars the same as the char at place index 3 with empty place
		System.out.println(s2); // brcdbr --> the char was 'a'
		
		ArrayList<Integer> arr = new ArrayList<Integer>(); // creating a new array by using the class ArrayList it id like = int [] arr = new int[];
		for(int i=10; i >0 ;i-=2)
		arr.add(i); // adding i in junps of 2, from 10 till 0 not included
		System.out.println(arr); // 10,8,6,4,2

		for (int index=0; index < arr.size(); index++)
		arr.set(index, arr.get(index)-1); // replace 10,8,6,4,2 with 9,7,5,3,1
		System.out.println(arr); // 9,7,5,3,1

		ListIterator<Integer> iter = arr.listIterator();
		for (; iter.hasNext(); )
		{
		Integer number = iter.next();
		number*=2; // multiple the numbers by 2
		iter.set(number);
		}
		System.out.println(arr); // 18,14,10,6,2

		Iterator<Integer> iter2 = arr.iterator();

		for (; iter2.hasNext(); )

		{

		Integer number = iter2.next();
		number--;
		}
		System.out.println(arr);
		arr.remove((Integer)2); //if remove method get an Object, so it removes the first time that number is occurring 
		arr.remove((Integer)2); 
		System.out.println(arr);
	}

	// q1
	public static long marsenne(int i) {
		if ((int)Math.pow(2, i)-1 == 1) return 1;
		System.out.println(marsenne(i-1)+ "");
		return (int)Math.pow(2, i)-1;
	}

	// q2
	public static void simCoin() {
		Scanner sc = new Scanner(System.in);
		Random r = new Random();
		System.out.println("Please insert the probably for 0:");
		double probability = sc.nextDouble();
		System.out.println("Please insert number of tries:");
		int tries = sc.nextInt();
		sc.close();

		int count = 0;
		for (int i = 0; i<tries; i++) {
			//int roll = (int)(Math.random()*2);	//Returns the sum of its arguments,
			int roll = r.nextInt(1); // we can also do it by using random class, this is throwing random numbers from 0, till the given number. here it is One.
			if (roll == 0)
				count++;
		}
		double dif = probability - count;
		System.out.println("The difference is: " + dif);
	}

	// q3

	public static String single(String s) {
		String t = "";
		for (int i = 0 ; i< s.length(); i++) {
			if (s.length() - s.replace(""+s.charAt(i), "").length() == 1) // if we're replacing
				t += ""+s.charAt(i);
		}
		return t;
	}

}
