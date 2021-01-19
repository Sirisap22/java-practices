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
public class DayOfTheWeek {
	public static void start() {
		int year = 0;
		int month = 0;
		int day = 0;
		
		// input year.
		year:
		while (true) {
			System.out.print("Enter year: (e.g., 2012): ");
			Scanner inputYear = new Scanner(System.in);
			try {
				year = inputYear.nextInt();
				if (year < 0 || year > Integer.MAX_VALUE) {
					System.out.println("Invalid input please try again.");
					continue year;
				}
				break;
			}
			catch (InputMismatchException error){
				errorHandling(inputYear);
				continue year;
			}
		}
		
		// input month
		month:
		while (true) {
			System.out.print("Enter month: 1-12: ");
			Scanner inputMonth = new Scanner(System.in);
			try {
				month = inputMonth.nextInt();
				if (month < 1 || month > 12) {
					System.out.println("Invalid input please try again.");
					continue month;
				}
				
				// tranform January(1) or February(2)
				if (month == 1 || month == 2) {
					// change month to 13/14
					month += 12;
					// decrease year by 1
					year -= 1;
				}
					
				break;
			}
			catch (InputMismatchException error){
				errorHandling(inputMonth);
				continue month;
			}
		}
		
		day:
		while (true) {
			System.out.print("Enter the day of the month: 1-31: ");
			Scanner inputDay = new Scanner(System.in);
			try {
				day = inputDay.nextInt();
				if (day < 1 || day > 31) {
					System.out.println("Invalid input please try again.");
					continue day;
				}
				break;
			}
			catch (InputMismatchException error){
				errorHandling(inputDay);
				continue day;
			}
		}
		
		String dayOfWeek = computeDayOfWeek(year, month, day);
		
		System.out.println("Day of the week is " + dayOfWeek);
		
	}
	
	private static void errorHandling(Scanner scanner) {
		String str = scanner.nextLine();
			if (str.equalsIgnoreCase("exit")) {
				System.exit(0);
			}
			System.out.println("Invalid input please try again.");
	}
	
	private static String computeDayOfWeek(int year, int month, int day) {
		String days[] = {"Saturday", "Sunday", "Monday", "Tuesday", "Wednesday", "Thursday", "Friday"};
		int h;
		int q = day;
		int m = month;
		int j = (int)Math.floor(year/100);
		int k = year%100;
		
		h = (q + (26*(m+1)/10) + k + k/4 + j/4 + 5*j)%7;
		
		return days[h];
	}
	
}
