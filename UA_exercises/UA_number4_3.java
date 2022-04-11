// Practice number 4.3, Ariel University - arrays

package A;

public class UA_number4_3 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		int [] arr = new int [5];

		for (int i = 0; i<arr.length; i++) {
			System.out.print(i + " ");

		}
		System.out.println();
		System.out.println("the opposit array: ");

		for (int i = arr.length-1; i>=0; i--) {
			System.out.print(i + " ");
		}

	}

}
