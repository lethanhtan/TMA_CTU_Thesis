package edu.ctu.thesis.travelsystem.controller;

public class Sales {
	private String month;
	private int sales;
	private String color;
	
	Sales(String month, int sales, String color){
		this.month = month;
		this.sales = sales;
		this.color = color;
	}
	
	public String getMonth() {
		return this.month;
	}
	
	public int getSales() {
		return this.sales;
	}
	
	public String getColor() {
		return this.color;
	}
	
}
