/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lab06;

import java.util.InputMismatchException;
import java.lang.IllegalArgumentException;
import java.lang.IllegalStateException;
import java.util.Scanner;

/**
 *
 * @author ACER PREDATOR
 */
public class TestBMI {
	public static void start() {
		// 145 5 10
		Scanner inputName = new Scanner(System.in);
		Scanner inputAge = new Scanner(System.in);
		Scanner inputWeightInPounds = new Scanner(System.in);
		Scanner inputHeightInFeet = new Scanner(System.in);
		Scanner inputHeightInInches = new Scanner(System.in);
		
		String name;
		int age;
		double weight;
		double heightF;
		double heightI;
		BMI bmi;
		
		try {
			System.out.print("Enter name: ");
			name = inputName.nextLine().trim();
			
			System.out.print("Enter age: ");
			age = inputAge.nextInt();
			
			System.out.print("Enter weight in pounds: ");
			weight = inputWeightInPounds.nextDouble();
			
			System.out.print("Enter feet: ");
			heightF = inputHeightInInches.nextDouble();
			
			System.out.print("Enter inches: ");
			heightI = inputHeightInInches.nextDouble();
			
			
			bmi = new BMI(name, age, weight, heightF, heightI);
			
			System.out.printf("Name : %s\n", bmi.getName());
			System.out.printf("Age : %d\n", bmi.getAge());
			System.out.printf("Height : %.2f feets %.2f inches\n", bmi.getFeet(), bmi.getInches());
			System.out.printf("Weight : %.2f pounds\n", bmi.getWeight());
			System.out.printf("BMI : %.2f\n", bmi.getBMI());
			System.out.printf("Interprelation : %s\n", bmi.getInterpretation());
			
		} catch(InputMismatchException | IllegalArgumentException | IllegalStateException error) {
			System.out.println(error);
		}

	}
}
