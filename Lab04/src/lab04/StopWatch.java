/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lab04;
import java.util.Date;
import java.util.Random;
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
		
		System.out.println("Creating a 100 PalindromePrime...");
		watch.start();
		long[] palindromePrime = _palindromePrime(100);
		watch.stop();
		_printArray(palindromePrime);
		System.out.println("PalindromePrime created.");
		System.out.println("The palindromePrime stopwatch stoped.");
		System.out.printf("The palindromePrime time is %d milliseconds.", watch.getElapsedTime());
		
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
			System.out.printf("%d ", array[i]);
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
			if (_isPrime(n) && _isPalindrome(n)) {
				array[index] = n;
				++index;
			}
			++n;
		}
		
		return array;
	}
	
	private static boolean _isPrime(long n) {
		// Corner cases 
        if (n <= 1) 
            return false; 
        if (n <= 3) 
            return true; 
  
        // This is checked so that we can skip 
        // middle five numbers in below loop 
        if (n % 2 == 0 || n % 3 == 0) 
            return false; 
  
        for (long i = 5; i * i <= n; i = i + 6) 
            if (n % i == 0 || n % (i + 2) == 0) 
                return false; 
  
        return true; 
	}
	
	private static boolean _isPalindrome(long n){
		long num = n;
		long reversed = 0;
		StringBuilder sb = new StringBuilder();
		sb.append(num);
		sb = sb.reverse();
		String intermediateString = sb.toString();
		reversed = Long.parseLong(intermediateString);
		
		return n == reversed;
	}
}
