package by.htp.project.main;

import by.htp.project.editions.Book;
import by.htp.project.editions.Journal;
import by.htp.project.editions.personality.Author;
import by.htp.project.editions.personality.Publisher;
import by.htp.project.library.Library;

public class Main {

	public static void main(String[] args) {

		Menu.startConcole(createTestData());

	}

	public static Library createTestData() {

		Library lib = new Library();

		Publisher p1 = new Publisher("Publisher1", "Address1", "Phone1");
		Publisher p4 = new Publisher("Publisher4", "Address4", "Phone4");
		Publisher p5 = new Publisher("Publisher5", "Address5", "Phone5");

		Author a1 = new Author("Author1");
		Author a2 = new Author("Author2");
		Author a3 = new Author("Author3");

		lib.addLibrary(new Book("Title3", 1925, p1, a3));
		lib.addLibrary(new Journal("mTitle2", 2001, p1, 1));
		lib.addLibrary(new Book("Title4", 1905, p4, a1));
		lib.addLibrary(new Journal("mTitle5", 2003, p1, 4));

		lib.addLibrary(new Book("Title1", 1900, p4, a1));
		lib.addLibrary(new Journal("mTitle3", 2002, p1, 5));
		lib.addLibrary(new Journal("mTitle4", 2002, p1, 2));
		lib.addLibrary(new Book("Title5", 1915, p5, a2));

		return lib;

	}

}
