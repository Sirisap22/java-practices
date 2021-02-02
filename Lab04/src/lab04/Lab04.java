/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lab04;

import java.math.BigInteger;
import java.util.GregorianCalendar;
import java.util.Random;
import lab04.Stock;
import lab04.StopWatch;

/**
 *
 * @author ACER PREDATOR
 */
public class Lab04 {

	/**
	 * @param args the command line arguments
	 */
	public static void main(String[] args) {

		testStock();
		testGregorianCalendar();
		testStopWatch();
	}

	// testing stock.
	public static void testStock() {
		Stock oracle = new Stock("ORCL", "Oracle Corporation");
		oracle.setPreviousClosingPrice(34.5);
		oracle.setCurrentPrice(34.35);

		System.out.println("Symbol: " + oracle.getSymbol());
		System.out.println("Name: " + oracle.getName());
		System.out.println("Previous Closing Price: " + oracle.getPreviousClosingPrice());
		System.out.println("Current Price: " + oracle.getCurrentPrice());
		System.out.println("Price Change: " + oracle.getChangePercent() + "%");
	}

	// testing gregorian calendar.
	public static void testGregorianCalendar() {
		GregorianCalendar calendar = new GregorianCalendar();

		_printCalendar(calendar);

		System.out.println("-------------");

		long oneDayMillis = _daysToMillis(1);
		calendar.setTimeInMillis((long) calendar.getTimeInMillis() + oneDayMillis);

		System.out.println("After specified the elapsed time of one day after current day");
		_printCalendar(calendar);
		System.out.println(calendar.getTime());
	}

	private static void _printCalendar(GregorianCalendar calendar) {
		System.out.printf("Year is %d\n", calendar.get(GregorianCalendar.YEAR));
		System.out.printf("Month is %d\n", calendar.get(GregorianCalendar.MONTH));
		System.out.printf("Date is %d\n", calendar.get(GregorianCalendar.DATE));
		System.out.printf("Day of week is %d\n", calendar.get(GregorianCalendar.DAY_OF_WEEK));
	}

	private static long _daysToMillis(int days) {
		return (long) (days * 24 * 60 * 60 * 1000);
	}

	// testing stopwatch.
	public static void testStopWatch() {
		StopWatch watch = new StopWatch();
		System.out.println("Creating a 1000-elements list...");
		double[] randomArray = _createRandomArray(1000);
		_printArray(randomArray);
		System.out.println("List created.");

		System.out.println("Sorting stopwatch starts...");
		watch.start();
		_selectionSort(randomArray);
		watch.stop();
		_printArray(randomArray);
		System.out.println("Sorting stopwatch stoped.");
		System.out.printf("The sort time is %d milliseconds. \n", watch.getElapsedTime());

		System.out.println("Creating a 1000 PalindromPrime...");
		watch.start();
		long[] palindromePrime = _palindromePrime(1000);
		watch.stop();
		_printArray(palindromePrime);
		System.out.println("PalindromPrime created.");
		System.out.println("The palindromPrime stopwatch stoped.");
		System.out.printf("The palindromPrime time is %d milliseconds.", watch.getElapsedTime());

	}

	private static void _selectionSort(double arr[]) {
		int n = arr.length;

		// One by one move boundary of unsorted subarray
		for (int i = 0; i < n - 1; i++) {
			// Find the minimum element in unsorted array
			int minIndex = i;
			for (int j = i + 1; j < n; j++)
				if (arr[j] < arr[minIndex])
					minIndex = j;

			// Swap the found minimum element with the first
			// element
			double temp = arr[minIndex];
			arr[minIndex] = arr[i];
			arr[i] = temp;
		}
	}

	private static double[] _createRandomArray(int n) {
		double[] randomDoubles = new double[n];
		for (int i = 0; i < n; ++i) {
			Random r = new Random();
			randomDoubles[i] = 0.0 + (1000.0 - 0.0) * r.nextDouble();
		}

		return randomDoubles;
	}

	private static void _printArray(double[] array) {
		int numPerLine = 0;
		for (int i = 0; i < array.length; ++i) {
			++numPerLine;
			System.out.printf("%.2f ", array[i]);
			if (numPerLine >= 5) {
				numPerLine = 0;
				System.out.println();
			}
		}
	}

	private static void _printArray(long[] array) {
		int numPerLine = 0;
		for (int i = 0; i < array.length; ++i) {
			++numPerLine;
			System.out.print(array[i] + " ");
			if (numPerLine >= 10) {
				numPerLine = 0;
				System.out.println();
			}
		}
	}

	private static long[] _palindromePrime(int size) {
		long[] array = new long[size];
		long n = 0;
		int index = 0;
		while (index < size) {
			if (_isPrime(new BigInteger(Long.toString(n))) && _isPalindrome(new BigInteger(Long.toString(n)))) {
				array[index] = n;
				++index;
			}
			++n;
		}

		return array;
	}

	private static boolean _isPrime(BigInteger n) {
		return n.isProbablePrime(1);
	}

	private static boolean _isPalindrome(BigInteger n) {
		String s = n.toString();
		StringBuilder sb = new StringBuilder(s);
		BigInteger reversed = new BigInteger(sb.reverse().toString());
		return n.compareTo(reversed) == 0;
	}

}
