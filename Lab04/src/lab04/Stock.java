/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lab04;
import java.lang.IllegalArgumentException;
import java.lang.IllegalStateException;
/**
 *
 * @author ACER PREDATOR
 */
public class Stock {
	private String symbol;
	private String name;
	private double previousClosingPrice;
	private double currentPrice;
	
	public static void test() {
		Stock oracle = new Stock("ORCL", "Oracle Corporation");
		oracle.setPreviousClosingPrice(34.5);
		oracle.setCurrentPrice(34.35);
		
		System.out.println("Symbol: " + oracle.getSymbol());
		System.out.println("Name: " + oracle.getName());
		System.out.println("Previous Closing Price: " + oracle.getPreviousClosingPrice());
		System.out.println("Current Price: " + oracle.getCurrentPrice());
		System.out.println("Price Change: " + oracle.getChangePercent() + "%");
	}
	
	Stock(String symbol, String name) {
		this.symbol = symbol;
		this.name = name;
		this.previousClosingPrice = -1.0;
		this.currentPrice = -1.0;
	}
	
	private boolean isValidPrice(double price) {
		if (price <= 0.0 || price > Double.MAX_VALUE) {
			return false;
		}
		
		return true;
	}
	
	public String getSymbol() {
		return this.symbol;
	}
	
	public String getName() {
		return this.name;
	}
	
	public double getPreviousClosingPrice() {
		return this.previousClosingPrice;
	}
	
	public void setPreviousClosingPrice(double price) {
		if (!this.isValidPrice(price))
			throw new IllegalArgumentException("Invalid previous closing price");
		this.previousClosingPrice = price;
	}
	
	public double getCurrentPrice() {
		return this.currentPrice;
	}
	
	public void setCurrentPrice(double price) {
		if (!this.isValidPrice(price))
			throw new IllegalArgumentException("Invalid current price");
		this.currentPrice = price;
	}
	
	public double getChangePercent() {
		// check if both prices is initialized
		if (this.currentPrice == -1.0) {
			throw new IllegalStateException("Current price haven't initialzed.");
		}
		else if (this.previousClosingPrice == -1.0) {
			throw new IllegalStateException("Previous closing price haven't initialzed.");
		}
		
		double changedPercent = ((this.currentPrice - this.previousClosingPrice)/this.previousClosingPrice) * 100.0;
		return changedPercent;
	}
	
	
}
