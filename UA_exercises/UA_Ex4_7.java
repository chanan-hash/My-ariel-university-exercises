package UA_exercises;
import java.util.Scanner;
import java.util.Arrays;
public class UA_Ex4_7 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Scanner in = new Scanner(System.in);
		int n1,n2,n3;
		System.out.println("Enter three numbers:");
		n1 = in.nextInt();
		n2 = in.nextInt();
		n3 = in.nextInt();

		//we can put the into an array and then swap them
		// or we can check right now who is bugger and then to put them in the array
		int[] array = {n1,n2,n3};
		System.out.println(Arrays.toString(array));
		int temp = 0;
		/*int i = 0;
		int temp = 0;
		while(i<=array.length-1) {
			if(array[i]<array[i+1]) {
				continue;	
			}
			else { //swap
				temp = array[i];
				array[i] = array[i+1];
				array[i+1] = temp;
			}
		i++;
		}
		 */

		// based from the website https://www.softwaretestinghelp.com/sort-arrays-in-java/
		for (int i = 0; i<array.length; i++) {
			for (int j = i+1; j<array.length; j++) { // going over the array again butt starting from the second place/index, this is saving us from 'out of bound'
				if (array[i]>array[j]) {
					//Swap(array[i],array[j]);
					temp = array[i]; // swap
					array[i] = array[j];
					array[j] = temp;
				}
			}
		}
		
		System.out.println(Arrays.toString(array));
		in.close();
	}

	public static int Swap(int a, int b) {
		int temp = a;
		a = b;
		b = temp;

		return (a & b);
	}

}
