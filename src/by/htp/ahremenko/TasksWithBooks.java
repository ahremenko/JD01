package by.htp.ahremenko;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class TasksWithBooks {

	public static void main(String[] args) throws IOException {

		try {
			
		BufferedReader reader = new BufferedReader(new FileReader("c:\\Temp\\books.csv"));
		
        String readedLine = null;
        Scanner scanner = null;
        int index = 0;
        List<Book> bookList = new ArrayList<>();
        
        while ((readedLine = reader.readLine()) != null) {
            Book bookFromFile = new Book();
            scanner = new Scanner(readedLine);
            scanner.useDelimiter(";");
            while (scanner.hasNext()) {
                String data = scanner.next();
                if (index == 0)
                	bookFromFile.setTitle(data);
                else if (index == 1)
                	bookFromFile.setAuthor(data);
                else if (index == 2)
                	bookFromFile.setYearPublished(Integer.parseInt(data));
                else if (index == 3)
                	bookFromFile.setPages(Integer.parseInt(data));
                else if (index == 4)
                	bookFromFile.setPublisherName(data);
                else
                    System.out.println("Extra data: " + data);
                index++;
            }
            index = 0;
            bookList.add(bookFromFile);
        }
        
        reader.close();
        
        for(int i=0;i<bookList.size();i++) {
        	String pages = "";
        	String publisherName = "";
        	if (bookList.get(i).getPages() > 0 ) {
        		pages = ", pages: " + bookList.get(i).getPages();	
        	} else {
        		pages = "";
        	}
        	if (bookList.get(i).getPublisherName() != "" ) {
        		publisherName = ", Publisher: " + bookList.get(i).getPublisherName();	
        	} else {
        		publisherName = "";
        	}
        			
        	System.out.println("Book #" + (i+1) + ": " + bookList.get(i).getTitle()+" by "+bookList.get(i).getAuthor()+", was published in "+bookList.get(i).getYearPublished()
        			+ pages + publisherName);
       	}
        
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		
	}

}
