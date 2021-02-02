/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lab04;
import java.util.Date;
import java.util.Random;
import java.math.BigInteger;
/**
 *
 * @author ACER PREDATOR
 */
public class StopWatch {
	private Date startTime;
	private Date endTime;
	
	public static void test() {
		StopWatch watch = new StopWatch();
		System.out.println("Creating a 1000-elements list...");
		double[] randomArray = _createRandomArray(1000);
		_printArray(randomArray);
		System.out.println("List created.");
		
		System.out.println("Sorting stopwatch starts...");
		watch.start();
		_sort(randomArray);
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
	
	StopWatch() {
		this.startTime = new Date();
	}
	
	public void start() {
		this.startTime = new Date();
	}
	
	public void stop() {
		this.endTime = new Date();
	}
	
	public long getElapsedTime() {
		return this.endTime.getTime() - this.startTime.getTime();
	}
	
	// testing methods.
	
	private static void _sort(double arr[]) 
    { 
        int n = arr.length; 
  
        // One by one move boundary of unsorted subarray 
        for (int i = 0; i < n-1; i++) 
        { 
            // Find the minimum element in unsorted array 
            int min_idx = i; 
            for (int j = i+1; j < n; j++) 
                if (arr[j] < arr[min_idx]) 
                    min_idx = j; 
  
            // Swap the found minimum element with the first 
            // element 
            double temp = arr[min_idx]; 
            arr[min_idx] = arr[i]; 
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
			if(numPerLine >= 5) {
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
			if(numPerLine >= 10) {
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
	
	private static boolean _isPalindrome(BigInteger n){
		String s = n.toString(); 
        StringBuilder sb = new StringBuilder(s);
		BigInteger reversed = new BigInteger(sb.reverse().toString());
		return n.compareTo(reversed) == 0;
	}
}
