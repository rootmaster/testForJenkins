package by.htp.project.editions;

import by.htp.project.editions.personality.Author;
import by.htp.project.editions.personality.Publisher;

public class Book extends Edition {

	private Author author;
	
	public Author getAuthor() {
		return author;
	}

	public Book() {
		super();
	}

	public Book(String title, int year, Publisher publisher, Author author) {
		super(title, year, publisher);
		this.author = author;
	}

	@Override
	public String toString() {
		return "[BOOK]\t" + super.toString() + author;
	}

	

}
