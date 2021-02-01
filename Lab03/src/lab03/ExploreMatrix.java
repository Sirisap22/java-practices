/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lab03;
import java.util.*;
/**
 *
 * @author ACER PREDATOR
 */
public class ExploreMatrix {
	public static void start() {
		int size = 0;
		
		size:
		while (true) {
			System.out.print("Enter the size for the matrix: ");
			Scanner inputSize = new Scanner(System.in);
			try {
				size = inputSize.nextInt();
				if (size <= 0 || size > Integer.MAX_VALUE) {
					System.out.println("Invalid input please try again.");
					continue size;
				}
				break;
			}
			catch (InputMismatchException error){
				ExploreMatrix.errorHandling(inputSize);
				continue size;
			}
		}
		
		int[][] matrix = randomMatrix(size);

		printMatrix(matrix);
		
		checkRowAllSame(matrix);
		checkColumnAllSame(matrix);
		checkSuperdiagonal(matrix);
		checkDiagonal(matrix);
		checkSubdiagonal(matrix);
	}
	
	private static int[][] randomMatrix(int size) {
		int[][] matrix = new int[size][size];
		
		for (int i = 0; i < size; i++) {
			for (int j = 0; j < size; j++) {
				matrix[i][j] = (int)Math.round(Math.random()); 
			}
		}
		
		return matrix;
	}
	
	private static void printMatrix(int[][] matrix) {
		int size = matrix.length;
		
		for (int i = 0; i < size; i++) {
			for (int j = 0; j < size; j++) {
				System.out.print(matrix[i][j] + " ");
			}
			System.out.print("\n");
		}
		System.out.print("\n");
	}
	
	private static void checkRowAllSame(int[][] matrix) {
		int size = matrix.length;
		
		boolean isSame = false;
		
		if (size == 1) {
			System.out.println("All " + matrix[0][0] + "s on row 0");
			return;
		}
		
		for (int row = 0; row < size; row++) {
			boolean isAllSame = true;

			for (int column = 0; column < size - 1; column++) {
				if (matrix[row][column] != matrix[row][column+1]) {
					isAllSame = false;
					break;
				}
			}
			
			if (isAllSame) {
				if (!isSame) isSame = true;
				System.out.println("All " + matrix[row][0] + "s on row " + row);
			}
		}
		
		if (!isSame) {
			System.out.println("No same numbers on a row");
		}
	}
	
	private static void checkColumnAllSame(int[][] matrix) {
		int size = matrix.length;
		boolean isSame = false;
		if (size == 1) {
			System.out.println("All " + matrix[0][0] + "s on column 0");
			return;
		}
		
		for (int column = 0; column < size; column++) {
			boolean isAllSame = true;

			for (int row = 0; row < size - 1; row++) {
				if (matrix[row][column] != matrix[row+1][column]) {
					isAllSame = false;
					break;
				}
			}
			
			if (isAllSame) {
				if (!isSame) isSame = true;
				System.out.println("All " + matrix[0][column] + "s on column " + column);
			}
		}
		
		if (!isSame) {
			System.out.println("No same numbers on a column");
		}
	}
	
	private static void checkSuperdiagonal(int[][] matrix) {
		int size = matrix.length;
		if (size == 1) {
			System.out.println("Rank one matrix doesn't have the superdiagonal");
			return;
		}
		if (size == 2) {
			System.out.println("All " + matrix[0][1] + "s on the superdiagonal");
			return;
		}
		

		for (int row = 0; row < size-2; row++) {
			if (matrix[row][row+1] != matrix[row+1][row+2]) {
				System.out.println("No same numbers on the superdiagonal");
					return;
			}	
		}
		
		System.out.println("All " + matrix[0][1] + "s on the superdiagonal");
		
	}
	
	private static void checkDiagonal(int[][] matrix) {
		int size = matrix.length;
		if (size == 1) {
			System.out.println("All " + matrix[0][0] + "s on the diagonal");
			return;
		}
		for (int i = 0; i < size-1; i++) {
			if (matrix[i][i] != matrix[i+1][i+1]) {
				System.out.println("No same numbers on the diagonal");
				return;
			}
		}
		
		System.out.println("All " + matrix[0][0] + "s on the diagonal");
	}
	
	private static void checkSubdiagonal(int[][] matrix) {
		int size = matrix.length;
		if (size == 1) {
			System.out.println("Rank one matrix doesn't have the subdiagonal");
			return;
		}
		if (size == 2) {
			System.out.println("All " + matrix[1][0] + "s on the subdiagonal");
			return;
		}
		
		for (int row = 1; row < size-1; row++) {
			if (matrix[row][row-1] != matrix[row+1][row]) {
				System.out.println("No same numbers on the subdiagonal");
					return;
			}	
		}
		
		
		System.out.println("All " + matrix[1][0] + "s on the subdiagonal");
	}
	
	
	private static void errorHandling(Scanner scanner) {
		String str = scanner.nextLine();
			if (str.equalsIgnoreCase("exit")) {
				System.exit(0);
			}
			System.out.println("Invalid input please try again.");
	}
}
