package by.htp.ahremenko.entity;

import java.util.Comparator;
import by.htp.ahremenko.entity.Book.BookFields;

public class BookComparator implements Comparator<ProfessionalBook> {
		
		private BookFields sortBy;
		
		public BookComparator (BookFields sortingField, boolean isAsc) {
			setSortingField(sortingField);
			sortingField.setAscend(isAsc);
		}
		
		public final void setSortingField(BookFields sortingField) {
			if (sortingField == null) {
				throw new IllegalArgumentException();
			}
			this.sortBy = sortingField;
		}
		
		public BookFields getSortingField() {
			return sortBy;
		}

		@Override
		public int compare(ProfessionalBook one, ProfessionalBook two) {
			switch (sortBy) {
			case TITLE: {
				if ( sortBy.getAscend() ) {
					return one.getTitle().compareTo(two.getTitle());
				} else {
					return two.getTitle().compareTo(one.getTitle());
				}
			}
			case AUTHOR: {
				if ( sortBy.getAscend() ) {
					return one.getAuthor().compareTo(two.getAuthor());
				} else {
					return two.getAuthor().compareTo(one.getAuthor());
				}
			}
			case YEARPUBLISHED:{
				if ( sortBy.getAscend() ) {
					return one.getYearPublished() - two.getYearPublished();
				} else {
					return two.getAuthor().compareTo(one.getAuthor());
				}
			}
			case PAGES: {
				if ( sortBy.getAscend() ) {
					return one.getPages() - two.getPages();
				} else {
					return two.getPages() - one.getPages();
				}
			}
			case PUBLISHERNAME: {
				if (sortBy.getAscend()) {
					return one.getPublisherName().compareTo(two.getPublisherName());
				} else {
					return two.getPublisherName().compareTo(one.getPublisherName());
				}
			}
			default:
				throw new EnumConstantNotPresentException(BookFields.class,sortBy.name());
		}
		}		

}
	

