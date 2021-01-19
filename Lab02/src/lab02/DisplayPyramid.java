/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lab02;

import java.util.InputMismatchException;
import java.util.Scanner;

/**
 *
 * @author Sirisap Siripattanakul
 */
public class DisplayPyramid {
	public static void start() {
		int number = 0;
		
		number:
		while (true) {
			System.out.print("Enter the number of lines: ");
			Scanner inputNumber = new Scanner(System.in);
			try {
				number = inputNumber.nextInt();
				if (number < 1 || number > 15) {
					System.out.println("Invalid input please try again.");
					continue number;
				}
				break;
			}
			catch (InputMismatchException error){
				String str = inputNumber.nextLine();
				if (str.equalsIgnoreCase("exit")) {
					System.exit(0);
				}
				System.out.println("Invalid input please try again.");
				continue number;
			}
		}
		
		printPattern(number);
	}
	
	public static void printPattern(int num) {
		int lineLength = num * 2 - 1;
		for (int i = 1; i <= num; ++i) {
			int number = i;
			for (int j = 0; j < Math.floor(lineLength/2); ++j) {
				if (num - i > j) System.out.print("\t");
				else System.out.print(num - j+" \t");
			}
			System.out.print("1\t");
			for (int j = 0; j < Math.floor(lineLength/2); ++j) {
				if (j+2 > i) System.out.print(" \t");
				else System.out.print(j+2+ "\t");
			}
			System.out.print("\n");
		}
	}
}
