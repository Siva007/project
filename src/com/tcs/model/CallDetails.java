package com.tcs.model;

import java.util.Date;

public class CallDetails 
{

		long custid;
		long conno;
		int callid;
		Date doc;
		int duration;
		long dialno;
		String calltype;
		
		public long getCustid() {
			return custid;
		}
		public void setCustid(long custid) {
			this.custid = custid;
		}
		public long getConno() {
			return conno;
		}
		public void setConno(long conno) {
			this.conno = conno;
		}
		public int getCallid() {
			return callid;
		}
		public void setCallid(int callid) {
			this.callid = callid;
		}
		public Date getDoc() {
			return doc;
		}
		public void setDoc(Date doc) {
			this.doc = doc;
		}
		public int getDuration() {
			return duration;
		}
		public void setDuration(int duration) {
			this.duration = duration;
		}
		public long getDialno() {
			return dialno;
		}
		public void setDialno(long dialno) {
			this.dialno = dialno;
		}
		public String getCalltype() {
			return calltype;
		}
		public void setCalltype(String calltype) {
			this.calltype = calltype;
		}
		

}

	
//Call inside CallBean......
