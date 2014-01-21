package com.example.unitconverter;

public class Mass {
	private double kilograms;
	
	
	public void setKilograms(double value) {
		kilograms = value;
	}
	public void setGrams(double value) {
		kilograms = value / 1000;
	}
	public void setTonnes(double value) {
		kilograms = value * 1000;
	}
	public void setCarats(double value) {
		kilograms = value * 0.0002;
	}
	public void setOunces(double value) {
		kilograms = value * 0.02835;
	}
	public void setPounds(double value) {
		kilograms = value * 0.453592;
	}
	public double getKilograms() {
		return kilograms;
	}
	public double getGrams() {
		return kilograms * 1000;
	}
	public double getTonnes() {
		return kilograms / 1000;
	}
	public double getCarats() {
		return kilograms * 5000;
	}
	public double getOunces() {
		return kilograms * 35.274;
	}
	public double getPounds() {
		return kilograms * 2.2046226;
	}
}
