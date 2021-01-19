package lab02;
import java.util.*;
/**
 *
 * @author Sirisap Siripattanakul
 */

public class FutureDates {

	public static String days[] = {"Sunday", "Monday", "Tuesday", "Wednesday", "Thursday", "Friday", "Saturday"};
	public static void start() {
		
		int startDay = 0;
		long numberOfDaysAfter = 0;
		
		// input initial day.
		startDay:
		while (true) {
			System.out.print("Enter today's day: ");
			Scanner inputStartDay = new Scanner(System.in);
			try {
				startDay = inputStartDay.nextInt();
				if (startDay < 0 || startDay > 6) {
					System.out.println("Invalid input please try again.");
					continue startDay;
				}
				break;
			}
			catch (InputMismatchException error){
				FutureDates.errorHandling(inputStartDay);
				continue startDay;
			}
		}
		
		// days after
		afterDay:
		while (true) {
			System.out.print("Enter the number of days elapsed since today: ");
			Scanner inputNumberOfDaysAfter = new Scanner(System.in);
			try {
				numberOfDaysAfter = inputNumberOfDaysAfter.nextLong();
				if (numberOfDaysAfter < 0 || numberOfDaysAfter > Long.MAX_VALUE) {
					System.out.println("Invalid input please try again.");
					continue afterDay;
				}
				break;
			}
			catch (InputMismatchException error){
				FutureDates.errorHandling(inputNumberOfDaysAfter);
				continue afterDay;
			}
		}
		
		String futureDay = computeDayAfter(startDay, numberOfDaysAfter);
		
		System.out.println("Today is " + days[startDay] + " and the future day is " + futureDay);
	}
	
	private static void errorHandling(Scanner scanner) {
		String str = scanner.nextLine();
			if (str.equalsIgnoreCase("exit")) {
				System.exit(0);
			}
			System.out.println("Invalid input please try again.");
	}
	
	private static String computeDayAfter(int startDay, long daysAfter) {
		int remainDaysAfter = (int)daysAfter%7;
		int futureDay = startDay + remainDaysAfter;
		return  futureDay > 6 ? days[futureDay-7] : days[futureDay];
	}
}
