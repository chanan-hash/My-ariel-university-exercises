package Exe.EX3;

import java.util.Arrays;

public class Ex3_check {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		int [][] mat = new int[4][6];

		for(int i = 0; i<mat.length;i++) {
			for (int j = 0; j<mat[0].length;j++) {
				if(i==j) {
					mat[i][j] = 1;
				}
			}
		}
		System.out.println(Arrays.deepToString(mat));

	}

}
