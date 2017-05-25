package by.htp.ahremenko.entity;

public class Book {
	private String title;
	private String author;
	private int yearPublished;
	private int pages;
	private String publisherName;
	
	public enum BookFields {
		TITLE(true), AUTHOR(true), YEARPUBLISHED(false), PAGES(true), PUBLISHERNAME(true);
		private boolean isAsc;
		private BookFields(boolean ascend) {
			this.isAsc = ascend;
		}
		public void setAscend(boolean ascend) {
			this.isAsc = ascend;
		}
		public boolean getAscend() {
			return isAsc;
		}
	}
	
	public Book () {
		title = "";
		author = "";
		yearPublished = -1;
		pages = 0;
		publisherName = "";
	}
	
	public Book ( String t, String a, int y) {
		title = t;
		author = a;
		yearPublished = y;
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
	public int getPages() {
		return pages;
	}
	public String getPublisherName() {
		return publisherName;
	}

	@Override
	public int hashCode() {
		final int prime = 73;
		int result = 1;
		result = prime * result + ((author == null) ? 0 : author.hashCode());
		result = prime * result + pages;
		result = prime * result + ((publisherName == null) ? 0 : publisherName.hashCode());
		result = prime * result + ((title == null) ? 0 : title.hashCode());
		result = prime * result + yearPublished;
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Book other = (Book) obj;
		if (author == null) {
			if (other.author != null)
				return false;
		} else if (!author.equals(other.author))
			return false;
		if (pages != other.pages)
			return false;
		if (publisherName == null) {
			if (other.publisherName != null)
				return false;
		} else if (!publisherName.equals(other.publisherName))
			return false;
		if (title == null) {
			if (other.title != null)
				return false;
		} else if (!title.equals(other.title))
			return false;
		if (yearPublished != other.yearPublished)
			return false;
		return true;
	}

	@Override
	public String toString() {
		//return " [" + title + "; " + author + "; " + yearPublished + "; " + pages + "; " + publisherName + "]";
		return "\r\n Book [title=" + title + ", author=" + author + ", yearPublished=" + yearPublished + ", pages=" + pages
				+ ", publisherName=" + publisherName + "]";
	}
	
	public boolean searchByField (String searchingString, BookFields fieldForSearch) {
		switch (fieldForSearch) {
		case TITLE: return this.title.equals(searchingString);
		case AUTHOR: return this.author.equals(searchingString);
		case PUBLISHERNAME: return this.publisherName.equals(searchingString);
		case YEARPUBLISHED: return ( this.yearPublished == Integer.parseInt(searchingString) );
		case PAGES: return ( this.pages == Integer.parseInt(searchingString) );
		}
		return false;
	}

}
