package by.htp.ahremenko;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import java.util.Scanner;

public class TasksWithStudents {

	public static void main(String[] args) throws IOException {
		try {
			
		BufferedReader reader = new BufferedReader(new FileReader("c:\\Temp\\students.csv"));
		
        String readedLine = null;
        Scanner scanner = null;
        int fieldNumber = 0;
        List<Student> studentList = new ArrayList<>();
        int id = 1;
        
        while ((readedLine = reader.readLine()) != null) {
            Student studentFromFile = new Student();
            scanner = new Scanner(readedLine);
            scanner.useDelimiter(";");
            while (scanner.hasNext()) {
                String data = scanner.next();
                studentFromFile.setId(id);
                if (fieldNumber == 0)
                	studentFromFile.setSurName(data);
                else if (fieldNumber == 1)
                	studentFromFile.setName(data);
                else if (fieldNumber == 2)
                	studentFromFile.setPatronymic(data);
                else if (fieldNumber == 3)
                	studentFromFile.setBirthday(data);
                else if (fieldNumber == 4)
                	studentFromFile.setFacultyName(data);
                else if (fieldNumber == 5)
                	studentFromFile.setStudyLevel(Integer.parseInt(data));
                else if (fieldNumber == 6)
                	studentFromFile.setGroupNumber(Integer.parseInt(data));
                else
                    System.out.println("Not applicable (extra) data: " + data);
                fieldNumber++;
            }
            fieldNumber = 0;
            id++;
            studentList.add(studentFromFile);
        }
        
        reader.close();
        
        for(int i=0;i<studentList.size();i++) {
        	studentList.get(i).printAttributes();
       	}
        
        // выводим список студентов одного факультета 
        KeyboardInput k = new KeyboardInput();
        String facultyNameNeeded = k.enterString("Enter the FacultyName" );

        for(int i=0;i<studentList.size();i++) {
        	if ( facultyNameNeeded.equals( studentList.get(i).getFacultyName()) ) {
        	     studentList.get(i).printAttributes();
        	}     
       	}
        
        // выводим список студентов родившихся после введенного года 
        int yearOfBD = k.enterInt(true, "Enter the Year of birthday" );

        for(int i=0;i<studentList.size();i++) {
        	if ( studentList.get(i).getBirthdayAsDate().get(Calendar.YEAR) > yearOfBD ) {
        	     studentList.get(i).printAttributes();
        	}     
       	}

        
        
        
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
	}

}
