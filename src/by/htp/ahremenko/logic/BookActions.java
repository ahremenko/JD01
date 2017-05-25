package by.htp.ahremenko.logic;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;


//import by.htp.ahremenko.entity.Book;
import by.htp.ahremenko.entity.ProfessionalBook;
import by.htp.ahremenko.entity.Book.BookFields;

public class BookActions {
	
	public static List<ProfessionalBook> readFromFile (String fileName) throws IOException {
		// read file and fillArrayList
		
		List<ProfessionalBook> bookList = new ArrayList<>();
		try {
			
		BufferedReader reader = new BufferedReader(new FileReader(fileName));
        String readedLine = null;
        Scanner scanner = null;
        int fieldCounter = 0;
        while ((readedLine = reader.readLine()) != null) {
        	ProfessionalBook bookFromFile = new ProfessionalBook();
            scanner = new Scanner(readedLine);
            scanner.useDelimiter(";");
            while (scanner.hasNext()) {
                String data = scanner.next();
                try {
                if ( (fieldCounter == 0) && (!data.equals("")))
                	bookFromFile.setTitle(data);
                else if ( (fieldCounter == 1) && (!data.equals("")))
                	bookFromFile.setAuthor(data);
                else if ( (fieldCounter == 2) && (!data.equals("")))
                	bookFromFile.setYearPublished(Integer.parseInt(data));
                else if ( (fieldCounter == 3) && (!data.equals("")))
                	bookFromFile.setPages(Integer.parseInt(data));
                else if ( (fieldCounter == 4) && (!data.equals("")))
                	bookFromFile.setPublisherName(data);
                else if ( (fieldCounter == 5) && (!data.equals("")))
                	if (data.equals("CD")) {
                		bookFromFile.setHasCD(1);
                	}	
                else
                    System.out.println("Extra data: " + data);
                } catch (NumberFormatException e) {
                }
                fieldCounter++;
            }
            if (!bookFromFile.getTitle().equals("")) {
            	bookList.add(bookFromFile);
            }	
            fieldCounter = 0;            
        }
        reader.close();
        
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		
		return bookList;
	}
	
	public static List<ProfessionalBook> getBookListByOneField (List<ProfessionalBook> bookList, String searchingString, BookFields searchingField) {
		List<ProfessionalBook> bookListFound = new ArrayList<>();
		
		/*for(int i=0;i<bookList.size();i++) {
			if (bookList.get(i).getAuthor().equals(author) ) {
				bookListFound.add(bookList.get(i));
			}
		}*/
		for(int i=0;i<bookList.size();i++) {
			if (bookList.get(i).searchByField(searchingString, searchingField)  ) {
				bookListFound.add(bookList.get(i));
			}
		}
		
		return bookListFound;
	}
	
}
