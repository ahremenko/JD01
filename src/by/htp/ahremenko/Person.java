package by.htp.ahremenko;

import java.io.IOException;
import java.util.Calendar;
import java.util.GregorianCalendar;

public class Person {
	
	private int id;
	private String name;
	private String surName;
	private String patronymic;
	private GregorianCalendar birthday;
	private String address;
	private String phoneNumber;
	
	{
		id = -1;
		name = "N/A";
		surName = "N/A";
		patronymic = "";
		birthday = new GregorianCalendar(1900, Calendar.JANUARY, 1);
		address = "";
		phoneNumber = "";
	}
	
	public Person()  {
	}

	public Person (String ... args) throws IOException {
		for (int i=0; i<args.length;i++) {
			switch (i) {
			 case 0: setName(args[i]);
			 		 break;
			 case 1: setSurName(args[i]);
	 		 		 break;
			 case 2: setPatronymic(args[i]);
		 		     break;
			 case 3: setBirthday(args[i]);
 		     		 break;
			 case 4: setAddress(args[i]);
	     		     break;
			 case 5: setPhoneNumber(args[i]);
	     		     break;
			} 
		}
	}
	
	public void setId (int i) {
		id = i;
	}
	
	public int getId() {
		return id;
	}
	
	public void setName(String s) {
		name = s;
	}

	public String getName() {
		return name;
	}

	
	public void setSurName(String s) {
		surName = s;
	}

	public String getSurName() {
		return surName;
	}
	
	public void setPatronymic(String s) {
		patronymic = s;
	}

	public String getPatronymic() {
		return patronymic;
	}
	
	public void setBirthday( String s) throws IOException  { // get a string like '01.03.2015', parse it and set birthday of person
		try {
		    int day = Integer.parseInt(s.substring(0, 2));
		    int month = Integer.parseInt(s.substring(3, 5))-1;
		    int year = Integer.parseInt(s.substring(6, 10));
		    birthday.set(year, month, day);
		} catch (Exception e) {
			e.printStackTrace();
			birthday.set(1900, Calendar.JANUARY, 1);
		}
	}
	
	public String getBirthdayAsString() {
		return String.format("%td.%tm.%tY",birthday,birthday,birthday);
	}

	public GregorianCalendar getBirthdayAsDate() {
		return birthday;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String s) {
		address = s;
	}

	public String getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(String s) {
		phoneNumber = s;
	}
	
	public void printAttributes() {
    	System.out.print("[id: " + getId() + "] : " + getName() + " " + getSurName() + " " + getPatronymic() + ", birthday: " + getBirthdayAsString() ); 
	}
	
}
