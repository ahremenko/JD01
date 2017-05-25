package by.htp.ahremenko;

public class Book {
	private String title;
	private String author;
	private int bookId;
	private int yearPublished;
	private int pages;
	private String publisherName;
	
	public Book () {
		title = "";
		author = "";
		bookId = -1;
		yearPublished = -1;
		pages = 0;
		publisherName = "";
	}
	
	public Book ( String t, String a, int y) {
		title = t;
		author = a;
		yearPublished = y;
		bookId = -1;
		pages = 0;
		publisherName = "";
	}
	
	public void setTitle (String s) {
		title = s;
	}
	public void setAuthor (String s) {
		author = s;
	}
	public void setYearPublished (int i) {
		yearPublished = i;
	}
	public void setId (int i) {
		bookId = i;
	}
	public void setPages (int i) {
		pages = i;
	}
	public void setPublisherName (String s) {
		publisherName = s;
	}

	
	public String getTitle() {
		return title;
	}
	public String getAuthor() {
		return author;
	}
	public int getYearPublished() {
		return yearPublished;
	}
	public int getId() {
		return bookId;
	}
	public int getPages() {
		return pages;
	}
	public String getPublisherName() {
		return publisherName;
	}

}
