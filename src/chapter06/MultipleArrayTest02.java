package chapter06;

import java.util.Scanner;

public class MultipleArrayTest02 {

	public static void main(String[] args) {
		// 가변형 배열 생성 : 3행의 구조에 열은 1부터 하나씩 증가하는 구조
		int[][] matrix = new int[5][];
		matrix[0] = new int[1];
		matrix[1] = new int[2];
		matrix[2] = new int[3];
		matrix[3] = new int[2];
		matrix[4] = new int[1];
		
		int count = 10;
		for(int i=0; i<matrix.length; i++) {
			for(int j=0; j<matrix[i].length; j++) {
				matrix[i][j] = count;
				System.out.print(matrix[i][j]);
				count += 10;
			}
			System.out.println();
		}

	}

}




