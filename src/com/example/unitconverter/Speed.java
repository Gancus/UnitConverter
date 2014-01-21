package com.example.unitconverter;

public class Speed {
	private double kmph;
	
	public void setKilometersPerHour(double kmph) {
		this.kmph = kmph;
	}
	public void setKilometersPerSecond(double kmps) {
		kmph = kmps * 3600;
	}
	public void setMetersPerSecond(double mps){
		kmph = mps * 3.6;
	}
	public void setMetersPerHour(double mph) {
		kmph = mph / 1000;
	}
	public void setMilesPerHour(double mph) {
		kmph = mph * 1.6;
	}
	public void setFeetsPerSecond(double fps) {
		kmph = fps * 1.09728;
	}
	public void setKnots(double knots) {
		kmph = knots * 1.852;
	}
	public void setMach(double mach) {
		kmph = mach * 1225.056;
	}
	
	public double getKilometersPerHour() {
		return kmph;
	}
	public double getKilometersPerSecond() {
		return kmph * 0.000278;
	}
	public double getMetersPerSecond() {
		return kmph * 0.277778;
	}
	public double getMetersPerHour() {
		return kmph * 1000;
	}
	public double getMilesPerHour() {
		return kmph * 0.621371;
	}
	public double getFeetsPerSecond() {
		return kmph * 0.911344;
	}
	public double getKnots() {
		return kmph * 0.539957;
	}
	public double getMach() {
		return kmph * 0.000816;
	}
}
