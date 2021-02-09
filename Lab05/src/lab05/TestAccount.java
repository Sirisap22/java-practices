/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lab05;
import lab05.Account;
import java.util.*;
/**
 *
 * @author ACER PREDATOR
 */
public class TestAccount {
	public static void start() {
		Account account = new Account(1122, 20_000);
		
		System.out.println("Id : " + account.getId());
		System.out.println("Balance : " + account.getBalance());
		
		System.out.println("Date created : " + account.getDateCreated().toString());

		aInterRate:
		while(true) {
			System.out.print("Enter Annual interest rate (in percentage) : ");
			Scanner inputAInterRate = new Scanner(System.in);
			try {
				account.setAnnualInterestRate(inputAInterRate.nextDouble());
				break;
			}
			catch (InputMismatchException | IllegalArgumentException error){	
				System.out.println(error);
				continue aInterRate;
			}
		}
		
		System.out.println("Annual interest rate : " + account.getAnnualInterestRate()+"%");
		
		withdraw:
		while(true) {
			System.out.print("Enter withdraw amount : ");
			Scanner inputWithdraw = new Scanner(System.in);
			try {
				account.withdraw(inputWithdraw.nextDouble());
				break;
			}
			catch (InputMismatchException | IllegalArgumentException error){	
				System.out.println(error);
				continue withdraw;
			}
		}
		
		System.out.println("Balance : " + account.getBalance());
		
		deposit:
		while(true) {
			System.out.print("Enter deposit amount : ");
			Scanner inputDeposit = new Scanner(System.in);
			try {
				account.deposit(inputDeposit.nextDouble());
				break;
			}
			catch (InputMismatchException | IllegalArgumentException error){	
				System.out.println(error);
				continue deposit;
			}
		}
		
		
		System.out.println("Balance : " + account.getBalance());
		System.out.println("Monthly interest : " + account.getMonthlyInterest());
	}
}
