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
public class ScissorRockPaperGame {
	public static void start() {
		int userInput = -1;
		int randomInt = -1;
		String symbols[] = {"scissor", "rock", "paper"};
		
		start:
		while (true) {
			randomInt = (int)(Math.random()*3);
			
			System.out.print("scissor (0), rock (1), paper (2), exit (exit): ");
			Scanner input = new Scanner(System.in);
			try {
				userInput = input.nextInt();
				if (userInput < 0 || userInput > 2) {
					System.out.println("Invalid input please try again.");
					continue start;
				}
				
				String userSymbol = symbols[userInput];
				String botSymbol = symbols[randomInt];
				String result = checkUserWinOrLoseOrDraw(userSymbol, botSymbol);
		
				printResult(userSymbol, botSymbol, result);
			}
			catch (InputMismatchException error){
				String str = input.nextLine();
				if (str.equalsIgnoreCase("exit")) {
					System.exit(0);
				}
				System.out.println("Invalid input please try again.");
				continue start;
			}
			
		
		}
		
		
	}
	
	public static String checkUserWinOrLoseOrDraw(String user, String bot)  {
		switch (user) {
			case "scissor":
				if (bot.equals("scissor")) return "draw";
				if (bot.equals("rock")) return "lose";
				if (bot.equals("paper")) return "win";
				break;
			case "rock":
				if (bot.equals("scissor")) return "win";
				if (bot.equals("rock")) return "draw";
				if (bot.equals("paper")) return "lose";
				break;
			case "paper":
				if (bot.equals("scissor")) return "lose";
				if (bot.equals("rock")) return "win";
				if (bot.equals("paper")) return "draw";
				break;
			default:
				throw new Error();
		}
		
		throw new Error();
	}
	
	public static void printResult(String user, String bot, String result) {
		if (result.equals("draw")) {
			System.out.println("The computer is " + bot + ". You are " + user + " too. It is a draw");
		} else {
			System.out.println("The computer is " + bot + ". You are " + user + ". You " + result);
		}
	}
}
