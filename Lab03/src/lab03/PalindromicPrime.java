/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lab03;

/**
 *
 * @author ACER PREDATOR
 */
public class PalindromicPrime {
	public static void start() {
		int numbersOfPalindromicPrime = 0;
		int numbersPerLine = 0;
		int n = 0;
		while (numbersOfPalindromicPrime < 100) {
			if (isPrime(n) && isPalindrome(n)) {
				System.out.print(n + "\t");
				numbersOfPalindromicPrime++;
				numbersPerLine++;
			}
			if (numbersPerLine >= 10) {
				System.out.println("\n");
				numbersPerLine = 0;
			}
			n++;
		}
	}
	
	public static boolean isPrime(int n) {
		if (n < 2) return false;
        int rootN = (int) Math.sqrt(n);
        for (int divider = 2; divider <= rootN; ++divider)
            if (n % divider == 0) return false;
		
		return true;
	}
	
	public static boolean isPalindrome(int n){
		int num = n;
		int reversed = 0;
		while(num != 0) {
			int digit = num%10;
			reversed = reversed * 10 + digit;
			num /= 10;
		}
		
		return n == reversed;
	}
}
