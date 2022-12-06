package CircleExer7;

import java.util.Arrays;
import java.util.Random;

public class Main_Table {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Table[] t = new Table[10];
		Random r = new Random();
		System.out.println(t.length);

		for(int i = 0; i<t.length; i++) {
			t[i]= new Table (r.nextDouble(50, 200),r.nextDouble(50, 200)); // create a new object
		}
		
		System.out.println(Arrays.deepToString(t));
		for(int j = 0; j<t.length;j++) {
			t[j].toString();
			System.out.println();
			System.out.print("[" + t[j].getWidth() + ", " + t[j].getLength());
		}

	}

}
