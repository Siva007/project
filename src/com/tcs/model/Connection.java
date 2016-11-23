package com.tcs.model;

public class Connection {

	private int customerId;
	private long connectionNumber;
	private double pulseRateForLocal;
	private double pulseRateForSTD;
	private double pulseRateForISD;
	private String status;
	public int getCustomerId() {
		return customerId;
	}
	public void setCustomerId(int customerId) {
		this.customerId = customerId;
	}
	public long getConnectionNumber() {
		return connectionNumber;
	}
	public void setConnectionNumber(long connectionNumber) {
		this.connectionNumber = connectionNumber;

	}
	public double getPulseRateForLocal() {
		return pulseRateForLocal;
	}
	public void setPulseRateForLocal(double pulseRateForLocal) {
		this.pulseRateForLocal = pulseRateForLocal;
	}
	public double getPulseRateForSTD() {
		return pulseRateForSTD;
	}
	public void setPulseRateForSTD(double pulseRateForSTD) {
		this.pulseRateForSTD = pulseRateForSTD;
	}
	public double getPulseRateForISD() {
		return pulseRateForISD;
	}
	public void setPulseRateForISD(double pulseRateForISD) {
		this.pulseRateForISD = pulseRateForISD;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	
	
	
	
	
}
