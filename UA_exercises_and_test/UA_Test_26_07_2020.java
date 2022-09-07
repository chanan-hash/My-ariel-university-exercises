package UA_exercises_and_test;

import java.util.Arrays;

public class UA_Test_26_07_2020 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		System.out.println(Binary2Dec("110"));
		System.out.println(Binary2Dec2("110"));
		System.out.println(Binary2Dec("11010"));
		
		// question 1:
		String S = "11010";
		int sum = Binary2Dec(S);
		System.out.println("sum = "+sum);

		// //question 2:
		/*	int [][][] im=MyImageIO.readImageFromFile("src\\cat.jpeg");
		int[][] gray= rgb2gray(im);
		MyImageIO.writeImageToFile("src\\catGray3.jpg",gray);
		 */

		// question 3
		int[] a = {0,2,4,6,8};
		int[] b = {1,3,5,7};
		System.out.println(Arrays.toString(interlace(a,b)));

	}
	public static int Binary2Dec(String S) {
		int n = 0;
		int l = S.length() - 1; // the length of the string
		for (int i = 0; i <= l; i++) {
			if(S.charAt(i) != '0' && S.charAt(i) != '1')
				return -1;
			int digit = Integer.parseInt("" + S.charAt(i)); 
			n += digit * (int) Math.pow(2, l - i);
		}
		return n;
	}

	public static int Binary2Dec2(String S) {
		int binary = Integer.parseInt(S); // converting String to a number
		int decimal = 0;
		int n = 0;
		while (true) {
			if (binary == 0) {
				break;}
			else {
				int temp = binary%10; // getting the binary digits
				decimal += temp*(int)Math.pow(2, n);
				binary = binary/10; // reducing the binary number by one digit from the right every iteration 
				n++;
			}
		}
		return decimal;
	}

	// q2
	public static int[][] rgb2gray(int[][][] imRGB) {
		//creating the matrix of the new image
		int w = imRGB[0][0].length;// weigh of the image
		int h = imRGB[0].length; // height of the image
		int[][] gray = new int [h][w]; // declaring the desired image's array

		for (int i = 0; i <h; i++) {
			for (int j = 0; j<w; j++) {
				gray[i][j] = (int)(0.30 * imRGB[0][i][j] + 0.59 * imRGB[1][i][j] + 0.11 * imRGB[2][i][j])*255;
			}
		}
		return gray;
	}

	// q3
	public static int[] interlace (int[]a, int[]b) {
		int i = 0, j = 0, k = 0;
		int alen = a.length, blen = b.length;
		int[] c = new int [alen + blen]; // a new array tha size of the two arrays

		while (i < alen && j <blen) { // adding one by one
			c[k++] = a[i++]; // adding every iteration, one from a --> in the beginning k =0 i =0, c[0] = a[0]
			c[k++] = b[j++]; // here k = 1, j = 0, c[1] = b[0] 
			// it is important that k is increasing more than i and j, then every iteration we're adding to two places in c, one from a, and the second from b
			// next iteration, c[2] = a[1] --> c[3] = b[1]... etc... c[alen+blen] = a[alen-1] and c[alen+blen] = b[blen-1]

		}
		while (i<alen) {
			c[k++] = a[i++]; // adding leftovers from a
		}
		while (j<blen) {
			c[k++] = b[j++]; // adding leftovers from a
		}

		return c;
	}
}