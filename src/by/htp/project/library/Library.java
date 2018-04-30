package by.htp.project.library;

import by.htp.project.editions.Book;
import by.htp.project.editions.Edition;
import by.htp.project.editions.Journal;
import by.htp.project.editions.personality.Author;

public class Library {

	private static final int ARRAY_SIZE = 10;
	private Edition[] editions = new Edition[ARRAY_SIZE];
	private int count = 0;
	private int booksCount = 0;
	private int journalsCount = 0;

	public Library() {
		super();
	}

	public Edition[] getEditions() {

		if (editions == null) {
			return null;
		}
		
		Edition[] returnEditions = new Edition[count];
		int j = 0;
		for (int i = 0; i < count; i++) {
			if (editions[i] != null) {
				returnEditions[j++] = editions[i];
			}
		}
		return returnEditions;

	}

	public void setEditions(Edition[] editions) {

		if (editions == null) {
			this.editions = null;
			return;
		}

		for (Edition e : editions) {
			if (e != null) {
				count++;
				if (e.getClass().equals(Book.class)) {
					booksCount++;
				} else {
					journalsCount++;
				}
			}
		}
		this.editions = editions;

	}

	public void addLibrary(Edition edition) {

		if (edition == null) {
			return;
		}

		if (editions != null) {
			if (count > editions.length) {
				enlargeArrayEditions();
			}
		} else {
			editions = new Edition[ARRAY_SIZE];
			count = 0;
		}

		editions[count++] = edition;
		if (edition.getClass().equals(Book.class)) {
			booksCount++;
		} else {
			journalsCount++;
		}

	}

	public void enlargeArrayEditions() {

		Edition[] newEditions = new Edition[editions.length + ARRAY_SIZE];
		for (int i = 0; i < count; i++) {
			newEditions[i] = editions[i];
		}
		editions = newEditions;

	}

	public Book[] getBooks() {

		if (booksCount == 0) {
			return null;
		}

		Book[] books = new Book[booksCount];
		int j = 0;
		for (int i = 0; i < count; i++) {
			if (editions[i].getClass().equals(Book.class)) {
				books[j++] = (Book) editions[i];
			}
		}
		return books;

	}

	public Journal[] getJournals() {

		if (journalsCount == 0) {
			return null;
		}

		Journal[] journals = new Journal[journalsCount];
		int j = 0;
		for (int i = 0; i < count; i++) {
			if (editions[i].getClass().equals(Journal.class)) {
				journals[j++] = (Journal) editions[i];
			}
		}
		return journals;

	}

	// ************************************************

	public void deleteJournalByNumber(int number) {

		if (journalsCount == 0) {
			return;
		}

		for (int i = 0; i < count; i++) {
			if (editions[i].getClass().equals(Journal.class)) {
				Journal m = (Journal) editions[i];
				if (m.getIssueNumber() == number) {
					count--;
					journalsCount--;

					for (; i < count; i++) {
						editions[i] = editions[i + 1];
					}
					break;
				}
			}
		}

	}

	public void deleteBookByTitle(String title) {

		if (booksCount == 0) {
			return;
		}

		for (int i = 0; i < count; i++) {
			if (editions[i].getClass().equals(Book.class)) {
				Book b = (Book) editions[i];
				if (b.getTitle().equalsIgnoreCase(title)) {
					count--;
					booksCount--;
					for (; i < count; i++) {
						editions[i] = editions[i + 1];
					}
					break;
				}
			}
		}

	}

	// *************************************************

	public Book[] getSortedBooksByYear() {
		Book[] sortBooks = getBooks();

		if (sortBooks != null) {

			int min;
			Book buf;
			for (int i = 0; i < booksCount - 1; i++) {
				min = i;
				for (int j = i + 1; j < booksCount; j++) {
					if (sortBooks[min].getYear() > sortBooks[j].getYear()) {
						buf = sortBooks[min];
						sortBooks[i] = sortBooks[j];
						sortBooks[j] = buf;
					}
				}
			}

		}

		return sortBooks;

	}

	public Journal[] getSortedJournalsByNumber() {

		Journal[] sortJournals = getJournals();

		if (sortJournals != null) {

			int min;
			Journal buf;

			for (int i = 0; i < journalsCount - 1; i++) {
				min = i;
				for (int j = i + 1; j < journalsCount; j++) {
					if (sortJournals[min].getIssueNumber() > sortJournals[j].getIssueNumber()) {
						buf = sortJournals[min];
						sortJournals[i] = sortJournals[j];
						sortJournals[j] = buf;
					}
				}
			}

		}

		return sortJournals;

	}

	// *************************************************

	public Journal searchJournalByTitle(String title) {
		Journal[] journals = getJournals();
		if (journals != null) {
			for (int i = 0; i < journalsCount; i++) {
				if (journals[i].getTitle().equalsIgnoreCase(title)) {
					return journals[i];
				}
			}
		}
		return null;
	}

	public Book searchBookByAuthor(Author author) {
		Book[] books = getBooks();
		if (books != null) {
			for (int i = 0; i < booksCount; i++) {
				if (books[i].getAuthor().equals(author)) {
					return books[i];
				}
			}
		}
		return null;
	}

}

// какого размера нужны массивы, чтоб не выводилось null
