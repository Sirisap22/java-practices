/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lab04;
import java.util.GregorianCalendar;
import java.util.Date;
/**
 *
 * @author ACER PREDATOR
 */
public class GreCal {
	public static void start() {
		GregorianCalendar calendar = new GregorianCalendar();
		
		printCalendar(calendar);
		
		System.out.println("-------------");
		
		long oneDayMillis = daysToMillis(1);
		calendar.setTimeInMillis((long)calendar.getTimeInMillis()+oneDayMillis);
		
		System.out.println("After specified the elapsed time of one day after current day");
		printCalendar(calendar);
		System.out.println(calendar.getTime());
	}
	
	private static void printCalendar(GregorianCalendar calendar) {
		System.out.printf("Year is %d\n", calendar.get(GregorianCalendar.YEAR));
		System.out.printf("Month is %d\n", calendar.get(GregorianCalendar.MONTH));
		System.out.printf("Date is %d\n", calendar.get(GregorianCalendar.DATE));
		System.out.printf("Day of week is %d\n", calendar.get(GregorianCalendar.DAY_OF_WEEK));
	}
	
	private static long daysToMillis(int days) {
		return (long)(days*24*60*60*1000);
	}
}
