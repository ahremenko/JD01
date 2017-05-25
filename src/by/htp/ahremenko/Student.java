package by.htp.ahremenko;

import java.io.IOException;

public class Student extends Person {
	
	private String facultyName;
	private int studyLevel;
	private int groupNumber;
	
	public Student() {
		super();
	}
	
	public Student(String name, String surName, String bd, String facultyName, int studyLevel, int groupNumber) throws IOException  {
		super(name, surName, "", bd);
		setFacultyName(facultyName);
		setStudyLevel(studyLevel);
		setGroupNumber(groupNumber);
	}

	public String getFacultyName() {
		return facultyName;
	}

	public void setFacultyName(String facultyName) {
		this.facultyName = facultyName;
	}

	public int getStudyLevel() {
		return studyLevel;
	}

	public void setStudyLevel(int studyLevel) {
		this.studyLevel = studyLevel;
	}

	public int getGroupNumber() {
		return groupNumber;
	}

	public void setGroupNumber(int groupNumber) {
		this.groupNumber = groupNumber;
	}

	public void printAttributes() {
    	String facultyName = "";
    	String studyLevel = "";        	
    	String groupNumber = "";

    	if (getFacultyName() != "" ) {
    		facultyName = ", Faculty: " + getFacultyName();	
    	} else {
    		facultyName = "";
    	}

    	if (getGroupNumber() > 0 ) {
    		studyLevel = ", Stage #: " + getStudyLevel();	
    	} else {
    		studyLevel = "";
    	}
    	
    	if (getGroupNumber() > 0 ) {
    		groupNumber = ", Group #: " + getGroupNumber();	
    	} else {
    		groupNumber = "";
    	}
		
		super.printAttributes();
    	System.out.println( facultyName + studyLevel + groupNumber ); 
	}
	
}
