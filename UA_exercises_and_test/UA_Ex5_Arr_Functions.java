package UA_exercises_and_test;

public class UA_Ex5_Arr_Functions {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[][]arr2 = new int[5][5]; // {{1,2,3},{4,5,6},{7,8,9}};
		prArr2(arr2);

		int[][]arr2_2 = {{1,2,3},{1,2,3}};
		System.out.println(sumArr2(arr2_2));

		int [][]a2 = {{1,2,3},{1,2,3},{1,2,3}};
		System.out.println(trace(a2));

		int [][]a2_2 = {{1,2,3},{4,5,6},{7,8,9}};
		System.out.println(trace2(a2_2));

		int [][]a2_3 = {{1,2,3},{4,5,6},{7,8,9}};
		prArr2(a2_3);
		System.out.println();
		prArr2(transpose(a2_3));
	
		System.out.println(numZeros(arr2));
	}




	// Ex1 printing the 2D array, to generate the size it will be outside the function. and after we've created the array we can print it.
	public static void prArr2(int [][]arr2) {
		for(int i = 0; i<arr2.length; i++) {
			for (int j = 0; j<arr2[0].length; j++) {
				System.out.print(arr2[i][j] + " ");
			}
			System.out.println();
		}
	}

	// Ex2 sum of the array
	public static int sumArr2(int [][]arr2) {
		int sum = 0;
		for(int i = 0; i<arr2.length; i++) {
			for (int j = 0; j<arr2[0].length; j++) {
				sum += arr2[i][j];
			}
		}
		return sum;
	}

	// Ex3 sum of main diagonal
	public static int trace(int [][] a2) {
		int sum = 0;
		for(int i = 0; i<a2.length; i++) {
			for (int j = 0; j<a2[0].length; j++) {
				if (i == j)
					sum += a2[i][j];
			}

		}
		return sum;		
	}

	// Ex4 sum of secondary diagonal
	public static int trace2(int [][] a2) {
		int sum = 0;
		for(int i = 0; i<a2.length; i++) {
			for (int j = 0; j<a2[0].length; j++) {
				if ((i+j) == (a2.length-1)) // the quality of the secondary diagonal is that the sum of the place supposed to be equal to the row number/ a2 length
					sum += a2[i][j];
			}
		}
		return sum;
	}

	// Ex6
	public static int [][] transpose(int [][] a2){ // this function returning a 2D array that why it is starting with int[][]
		for (int i = 0; i<a2.length; i++) {
			for (int j = i+1; j<a2[0].length; j++) {
				// swap between i and j
				int temp = a2[i][j];
				a2[i][j] = a2[j][i];
				a2[j][i] = temp;
			}
		}
		return a2;
	}	

	// Ex7 
	public static int numZeros(int [][] a2) {
		int count = 0;
		for(int i =0; i<a2.length; i++) {
			for (int j = 0; j<a2[0].length; j++) {
				if (a2[i][j]==0)
					count++;
			}
		}
		return count;
	}
}
