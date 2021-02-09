/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lab05;
import lab05.RegularPolygon;
import java.util.*;
/**
 *
 * @author ACER PREDATOR
 */
public class TestRegularPolygon {
	private static boolean isOpened = true;
	private static int selectedMode = 0;
	
	public static void start() {
		while(isOpened) {
			RegularPolygon rp = null;
			int n;
			double side;
			double x;
			double y;
			
			selectedMode = selectModeMenu();
			if (selectedMode == 4) break;
			
			switch (selectedMode) {
				case 1:
					rp = new RegularPolygon();
					break;
				case 2:
					n = inputN();
					side = inputSize();
					rp = new RegularPolygon(n, side);
					break;
				case 3:
					n = inputN();
					side = inputSize();
					x = inputX();
					y = inputY();
					rp = new RegularPolygon(n, side, x, y);
					break;
				default:
			}
			
			if (rp != null) {
				displayPolygon(rp);
			}	
		}
	}
	
	private static int selectModeMenu() {
		System.out.println("[1] no-constructor");
		System.out.println("[2] using n and side constructor");
		System.out.println("[3] using n, side, x and y constructor");
		System.out.println("[4] exit");

		int mode;
		
		selectMode:
		while(true) {
			System.out.print("Please select a mode : ");
			Scanner inputMode = new Scanner(System.in);
			try {
				mode = inputMode.nextInt();
				if (mode < 1 || mode > 4)
					throw new IllegalArgumentException("The selected mode should be between 1 and 4 (inclusive)");
				break;
			}
			catch (InputMismatchException | IllegalArgumentException error){	
				System.out.println(error);
				continue selectMode;
			}
		}
		
		return mode;
	}
	
	private static int inputN() {
		int n = 3;
		
		n:
		while(true) {
			System.out.print("Enter number of side : ");
			Scanner inputN = new Scanner(System.in);
			try {
				n = inputN.nextInt();
				if (n < 3) throw new IllegalArgumentException("Invalid number of side.");
				break;
			}
			catch (InputMismatchException | IllegalArgumentException error){	
				System.out.println(error);
				continue n;
			}
		}
		
		return n;
	}
	
	private static double inputSize() {
		double side = 1f;
		
		side:
		while(true) {
			System.out.print("Enter length of each size : ");
			Scanner inputSide = new Scanner(System.in);
			try {
				side = inputSide.nextDouble();
				if (side <= 0) throw new IllegalArgumentException("Invalid length.");
				break;
			}
			catch (InputMismatchException | IllegalArgumentException error){	
				System.out.println(error);
				continue side;
			}
		}
		
		return side;
	}
	
	private static double inputX() {
		double x = 0f;
		
		x:
		while(true) {
			System.out.print("Enter x-coordinate : ");
			Scanner inputX = new Scanner(System.in);
			try {
				x = inputX.nextDouble();
				break;
			}
			catch (InputMismatchException | IllegalArgumentException error){	
				System.out.println(error);
				continue x;
			}
		}
		
		return x;
	}
	
	private static double inputY() {
		double y = 0f;
		
		y:
		while(true) {
			System.out.print("Enter y-coordinate : ");
			Scanner inputY = new Scanner(System.in);
			try {
				y = inputY.nextDouble();
				break;
			}
			catch (InputMismatchException | IllegalArgumentException error){	
				System.out.println(error);
				continue y;
			}
		}
		
		return y;
	}
			
	private static void displayPolygon(RegularPolygon rp) {
		System.out.println("Number of side : " + rp.getN());
		System.out.println("length of each side : " + rp.getSide());
		System.out.println("x : " + rp.getX());
		System.out.println("y : " + rp.getY());
		System.out.printf("Perimeter : %.2f\n", rp.getPerimeter());
		System.out.printf("Area : %.2f\n", rp.getArea());
	} 
}
