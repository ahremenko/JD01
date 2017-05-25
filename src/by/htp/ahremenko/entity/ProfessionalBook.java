package by.htp.ahremenko.entity;

public class ProfessionalBook extends Book {
	
	private int hasCD;
	{
		hasCD = 0;
	}
	
	public enum ProfessionalBookFields {
		TITLE, AUTHOR, YEARPUBLISHED, PAGES, PUBLISHERNAME, HASCD
	}
	
	public ProfessionalBook() {
		super();
	}
	
	public ProfessionalBook(String t, String a, int y, int p, String pn, int hCD) {
		this.setTitle(t);
		this.setAuthor(a);
		this.setYearPublished(y);
		this.setPages(p);
		this.setPublisherName(pn);
		hasCD = hCD;
	}
	
	public int getHasCD() {
		return hasCD;
	}

	public void setHasCD(int hasCD) {
		this.hasCD = hasCD;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		result = prime * result + hasCD;
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (!super.equals(obj))
			return false;
		if (getClass() != obj.getClass())
			return false;
		ProfessionalBook other = (ProfessionalBook) obj;
		if (hasCD != other.hasCD)
			return false;
		return true;
	}

	@Override
	public String toString() {
		return super.toString() + " [hasCD=" + hasCD + "]";
	}
	
	
}
