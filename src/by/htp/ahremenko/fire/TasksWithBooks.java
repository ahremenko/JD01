package by.htp.ahremenko.fire;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import by.htp.ahremenko.KeyboardInput;
import by.htp.ahremenko.entity.Book;
import by.htp.ahremenko.entity.Book.BookFields;
import by.htp.ahremenko.entity.BookComparator;
import by.htp.ahremenko.entity.ProfessionalBook;
import by.htp.ahremenko.logic.BookActions;

public class TasksWithBooks {

	public static void main(String[] args) throws IOException {
		
        List<ProfessionalBook> bookList = BookActions.readFromFile("c:\\Temp\\books.csv");
        System.out.println(bookList);
        
        KeyboardInput kbd = new KeyboardInput();
        String searchingString = kbd.enterString("Type Author for searching");
        //searchingString = "Gosling";
        List<ProfessionalBook> bookListFound = BookActions.getBookListByOneField(bookList, searchingString, BookFields.AUTHOR);
        // sort by Title
        if ( bookListFound.size() > 0 ) {
        	Collections.sort (bookListFound, new BookComparator (BookFields.TITLE, false));
        	System.out.println("Found books by " + searchingString + " (order by TITLE DESC): " + bookListFound);
        } else {
        	System.out.println("Not found any books by " + searchingString );
        }

        searchingString = kbd.enterString("Type PublishedYear for searching");
        //searchingString = "2016";
        bookListFound = BookActions.getBookListByOneField(bookList, searchingString, BookFields.YEARPUBLISHED);
        // sort by Pages
        if ( bookListFound.size() > 0 ) {
        	Collections.sort (bookListFound, new BookComparator (BookFields.PAGES, true));
        	System.out.println("Found books published at " + searchingString + " (order by PAGES ASC): " +  bookListFound);
        } else {
        	System.out.println("Not found any books published at " + searchingString );
        }
        
        
        // book for searching ( please, fill all attributes)
        ProfessionalBook searchingBook = new ProfessionalBook("CSS", "Eric A. Meyer", 2002, 432, "O'relly", 1);
        //ProfessionalBook searchingBook = new ProfessionalBook("Overkill: The Untold Story of Motorhead", "Joel Mclver", 2011, 336, "Omnibus Press", 0);
        // start searching
        if ( bookList.contains(searchingBook)) {
        	System.out.println("Found book: " + bookList.get( bookList.indexOf(searchingBook) ) );
        } else {
        	System.out.println("Not found book : " + searchingBook );
        }
        	
	}
}
