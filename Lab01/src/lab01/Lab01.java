/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lab01;

import java.util.*;

/**
 *
 * @author Sirisap Siripattanakul
 */
public class Lab01 {

	/**
	 * @param args the command line arguments
	 */
	public static void main(String[] args) {
		// TODO code application logic here
		Lab01.solve1(312_032_486);
		Lab01.solve2();
		Lab01.solve3();
		Lab01.solve4();
	}

	public static void solve1(long currentPop) {
		int oneYearDays = 365;
		
		long fiveYearSecs = oneYearDays * 24 * 60 * 60 * 5;
		
		long newBirthPop = (long)Math.floor((fiveYearSecs)/7);
		long newDeadPop = (long)Math.floor((fiveYearSecs)/13);
		long newImmi = (long)Math.floor((fiveYearSecs)/45);
		
		currentPop = currentPop + newBirthPop - newDeadPop + newImmi;
		
		System.out.println("Population in five years : "+currentPop);
		
	}
	
	public static void solve2() {
		float a = 3.4f;
		float b = 50.2f;
		float e = 44.5f;

		float c = 2.1f;
		float d = 0.55f;
		float f = 5.9f;
		
		float x = (e*d - b*f)/(a*d - b*c);
		float y = (a*f - e*c)/(a*d - b*c);
		
		System.out.println("x : "+ x + ", y : " + y);
	}
	
	public static void solve3() {
		while (true) {
		System.out.print("Enter a number between 0 and 1000: ");
		Scanner input = new Scanner(System.in);
		int num;
		try {
			num = input.nextInt();
			if (num >= 1000 || num <= 0){
				System.out.println("Invalid number please try again.");
				continue;
			};
		}
		catch (InputMismatchException error){
			String str = input.nextLine();
			if (str.equalsIgnoreCase("exit")) {
				System.exit(0);
			}
			System.out.println("Invalid input please try again.");
			continue;
		}
		
		String numString = Integer.toString(num);
		
		int sum = 0;
		
		for (int i = 0; i < numString.length(); i++) {
			char temp = numString.charAt(i);
			sum += Integer.parseInt(String.valueOf(temp));
		}
		
		System.out.println("Sum of independent numbers : " + sum);
		break;
		}
	}
	
	public static void solve4() {
		double weightInKg = 1;
		double heightInMeter = 1;
		
		weight:
		while (true) {
			System.out.print("Enter weight in pounds: ");
			Scanner inputWeight = new Scanner(System.in);
			try {
				weightInKg = inputWeight.nextDouble() * 0.45359237;
				if (weightInKg <= 0) {
					System.out.println("Invalid weight please try again.");
					continue weight;
				}
				break;
			}
			catch (InputMismatchException error){
				String str = inputWeight.nextLine();
				if (str.equalsIgnoreCase("exit")) {
					System.exit(0);
				}
				System.out.println("Invalid input please try again.");
				continue weight;
			}
		}
		
		height:
		while (true) {
			System.out.print("Enter height in inches: ");
			Scanner inputHeight = new Scanner(System.in);
			try {
				heightInMeter = inputHeight.nextDouble() * 0.0254;
				if (heightInMeter <= 0) {
					System.out.println("Invalid height please try again.");
					continue height;
				}
				break;
			} catch (InputMismatchException error){
				String str = inputHeight.nextLine();
				if (str.equalsIgnoreCase("exit")) {
					System.exit(0);
				}
				System.out.println("Invalid input please try again.");
				continue;
			}
			
		}
		
		double BMI = weightInKg/(heightInMeter* heightInMeter);
		System.out.printf("BMI is %.4f\n",BMI);
	}
	
}
