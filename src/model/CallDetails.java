package model;

public class CallDetails 
{
	private int callId;
	private String dateOfCall;
	private double callDuration;
	private int connectionNumber;
	private String numberToWhichCallWasMade;
	private String typeOfCall;
	public int getConnectionNumber() 
	{
		return connectionNumber;
	}
	public void setConnectionNumber(int connectionNumber) 
	{
		this.connectionNumber = connectionNumber;
	}
	public int getCallId() 
	{
		return callId;
	}
	public void setCallId(int callId) 
	{
		this.callId = callId;
	}
	public String getDateOfCall() 
	{
		return dateOfCall;
	}
	public void setDateOfCall(String dateOfCall) 
	{
		this.dateOfCall = dateOfCall;
	}
	public double getCallduration() 
	{
		return callDuration;
	}
	public void setCallDuration(double callDuration) 
	{
		this.callDuration = callDuration;
	}
	public String getNumberToWhichCallWasMade() 
	{
		return numberToWhichCallWasMade;
	}
	public void setNumberToWhichCallWasMade(String numberToWhichCallWasMade) 
	{
		this.numberToWhichCallWasMade = numberToWhichCallWasMade;
	}
	public String getTypeOfCall() 
	{
		return typeOfCall;
	}
	public void setTypeOfCall(String typeOfCall) 
	{
		this.typeOfCall = typeOfCall;
	}

}
