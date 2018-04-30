package by.htp.project.editions;

import by.htp.project.editions.personality.Publisher;

public abstract class Edition {
	
	private String title;
	private int year;
	private Publisher publisher;
	
	public String getTitle() {
		return title;
	}
	
	public int getYear() {
		return year;
	}
	
	public Edition() {
		super();
	}

	public Edition(String title, int year, Publisher publisher) {
		super();
		this.title = title;
		this.year = year;
		this.publisher = publisher;
	}

	@Override
	public String toString() {
		return "Title = " + title + ", year = " + year + ", " + publisher + ", ";
	}

}
