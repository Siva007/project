package com.tcs.model;

public class Tariff {
private String tcode;
private double monthlyRental;
private double local;
private double std;
private double isd;
public String getTcode() {
	return tcode;
}
public void setTcode(String tcode) {
	this.tcode = tcode;
}
public double getMonthlyRental() {
	return monthlyRental;
}
public void setMonthlyRental(double monthlyRental) {
	this.monthlyRental = monthlyRental;
}
public double getLocal() {
	return local;
}
public void setLocal(double local) {
	this.local = local;
}
public double getStd() {
	return std;
}
public void setStd(double std) {
	this.std = std;
}
public double getIsd() {
	return isd;
}
public void setIsd(double isd) {
	this.isd = isd;
}


}
