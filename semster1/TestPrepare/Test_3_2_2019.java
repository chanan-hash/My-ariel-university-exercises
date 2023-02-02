package TestPrepare;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.ListIterator;

public class Test_3_2_2019 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ArrayList<Integer> arr = new ArrayList<Integer>();
		for (int i = 10; i > 0; i -= 2)
			arr.add(i);
		System.out.println(arr);

		for (int index = 0; index < arr.size(); index++)
			arr.set(index, arr.get(index) - 1);
		System.out.println(arr);

		ListIterator<Integer> iter = arr.listIterator();
		for (; iter.hasNext();) {
			Integer number = iter.next();
			number *= 2;
			iter.set(number);
		}
		System.out.println(arr);

		Iterator<Integer> iter2 = arr.iterator();
		for (; iter2.hasNext();) {
			Integer number = iter2.next();
			number--;
		}
		System.out.println(arr);

		arr.remove((Integer) 2);
		arr.remove((Integer) 2);
		System.out.println(arr);


		///// 18/07/2019 --> q5

		int a = 8;
		int b = 3;
		int r1 = a/b;
		int r2 = (int)((double)a/b);
		double r3 = a/b;
		double r4 = (double)a/b;
		double r5 = (double)(a/b);
		String str = r1 + "," + r2 + "," + r3 + "," + r4 + "," + r5;
		System.out.println(str);
		System.out.println("1+2 = " + 1 + 2);
		int[] array1= {1,2,3,4,5};
		int[] array2= {1,2,3,4,5};
		System.out.println(array1 == array2);



	}
}




