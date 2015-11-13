package com.util;

import java.util.Calendar;

public class Util {


	
	public static String numberGenerator(int length){

		StringBuffer buffer = new StringBuffer();
		String characters = "123456789";
		
		int charactersLength = characters.length();

		for (int i = 0; i < length; i++) {
			double index = Math.random() * charactersLength;
			buffer.append(characters.charAt((int) index));
		}
		return buffer.toString();
	}
	
	public static String ssnGenerator(){

		StringBuffer buffer = new StringBuffer();
		String characters = "12345678";
		
		int charactersLength = characters.length();

		for (int i = 0; i < 9; i++) {
			double index = Math.random() * charactersLength;
			buffer.append(characters.charAt((int) index));
		}
		return buffer.toString();
	}
	
	public static String getOldDate(){

		Calendar cal = Calendar.getInstance();
		cal.add(Calendar.YEAR, -35);
		
		return Util.getMonth(cal)+"-"+Util.getDay(cal)+"-"+Util.getYear(cal);
		
	}
	
	public static String  getDay(Calendar cal){
		int dayOfMonth = cal.get(Calendar.DAY_OF_MONTH);
		if(dayOfMonth < 10){
			return "0"+String.valueOf(dayOfMonth);
		}
		return String.valueOf(dayOfMonth);
	}
	
	public static String  getMonth(Calendar cal){
		int month = cal.get(Calendar.MONTH)+1;
		if(month < 10){
			return "0"+String.valueOf(month);
		}
		return String.valueOf(month);
	}
	
	public static String getYear(Calendar cal){
		int year = cal.get(Calendar.YEAR);
		return String.valueOf(year);
	}
	
	public static String generateRandomString(int length){

		StringBuffer buffer = new StringBuffer();
		String characters = "aeiouabcdefghijklmnopqrstuvwxyzaeiouaeaeiou";
		
		int charactersLength = characters.length();

		for (int i = 0; i < length; i++) {
			double index = Math.random() * charactersLength;
			buffer.append(characters.charAt((int) index));
		}
		return "X"+buffer.toString();
	}
	
}
