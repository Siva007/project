package com.tcs.model;

public class PasswordGenerator {
	private static final String ALPHA_NUM = "0123456789ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz_@%&";
	/*public static void main(String[] args) {
		PasswordGenerator ps = new PasswordGenerator();
		System.out.println("Generated random String is :"+ps.getAlphaNumeric(8));
		
		}*/
	public String getAlphaNumeric(int len) {
		StringBuffer sb = new StringBuffer(len);
			for (int i = 0; i < len; i++) {
				int pwd = (int) (Math.random() * ALPHA_NUM.length());
				sb.append(ALPHA_NUM.charAt(pwd));
			}
		return sb.toString();
		}
	
	}



