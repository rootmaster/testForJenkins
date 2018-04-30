package by.htp.project.main;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.Reader;
import java.util.Scanner;

import by.htp.project.editions.Book;
import by.htp.project.editions.Edition;
import by.htp.project.editions.Journal;
import by.htp.project.editions.personality.Author;
import by.htp.project.editions.personality.Publisher;
import by.htp.project.library.Library;

public class Menu {

	public static void itemsMenu() {
		System.out.println("1. Просмотреть список всех изданий");
		System.out.println("2. Просмотреть отдельно список книг/журналов");
		System.out.println("\t2.1 Сортировать список книг по годуиздания/журналов по номеру выпуска");
		System.out.println("\t2.2 Поиск книги по автору/журнала по названию");
		System.out.println("3. Добавить новое издание");
		System.out.println("4. Удалить издание");
		System.out.println("5. Добавить книжное издание из файла");
		System.out.println("0. Выход");
	}

	public static void readBookFromFile(Library lib, String path) {

		try (Reader reader = new FileReader(path)) {

			BufferedReader br = new BufferedReader(reader);
			String[] str = null;
			String line = null;
			while ((line = br.readLine()) != null) {
				str = line.split(" ");
				int y = Integer.parseInt(str[1]);
				lib.addLibrary(new Book(str[0], y, new Publisher(str[2], str[3], str[4]), new Author(str[5])));
			}
			

		} catch (FileNotFoundException e) {
			System.out.println(e.getMessage());
		} catch (IOException e) {
			System.out.println(e.getMessage());
		}

	}

	public static void startConcole(Library lib) {
		itemsMenu();
		commandProcessing(lib);

	}

	public static void commandProcessing(Library lib) {

		Scanner sc = new Scanner(System.in);

		int k = -1;

		while (true) {

			switch (k) {
			case 0:
				System.out.println("Выход...");
				System.exit(0);
				break;
			case 1:
				printAllFromLibrary(lib);
				break;
			case 2:
				printBooksFromLibrary(lib);
				printJournalsFromLibrary(lib);
				break;
			case 3:
				lib.addLibrary(new Journal("mTitle1", 2001, new Publisher("Publisher1", "Address1", "Phone1"), 3));
				lib.addLibrary(new Book("Title2", 1910, new Publisher("Publisher5", "Address5", "Phone5"),
						new Author("Author2")));
				break;
			case 4:
				lib.deleteJournalByNumber(3);
				lib.deleteBookByTitle("title2");
				break;
			case 5:
				readBookFromFile(lib, "d:\\txt.txt");
				break;
			case 21:
				printSortedBooksByYear(lib);
				printSortedJournalsByNumber(lib);
				break;
			case 22:
				printSearchBookByAuthor(lib, new Author("Author1"));
				printSearchBookByAuthor(lib, new Author("Author"));
				printSearchJourlanByTitle(lib, "mTitle2");
				printSearchJourlanByTitle(lib, "mTitle");
				break;

			default:
				System.out.println("Не правильный номер команды");
				break;
			}

			System.out.print("Номер команды: ");
			k = sc.nextInt();
			System.out.print("========================================\n");

		}
	}

	public static void printAllFromLibrary(Library lib) {
		if (lib != null) {
			for (Edition edition : lib.getEditions()) {
				System.out.println(edition);
			}
		}
	}

	public static void printBooksFromLibrary(Library lib) {
		if (lib != null) {
			System.out.println("========== BOOKS ==========");
			for (Book books : lib.getBooks()) {
				System.out.println(books);
			}
		}
	}

	public static void printJournalsFromLibrary(Library lib) {
		if (lib != null) {
			System.out.println("========== JOURNALS ==========");
			for (Journal journals : lib.getJournals()) {
				System.out.println(journals);
			}
		}
	}

	public static void printSortedBooksByYear(Library lib) {
		if (lib != null) {
			System.out.println("========== SORTED BOOKS BY YEAR ==========");
			for (Book books : lib.getSortedBooksByYear()) {
				System.out.println(books);
			}
		}
	}

	public static void printSortedJournalsByNumber(Library lib) {
		if (lib != null) {
			System.out.println("========== SORTED JOURNALS BY NUMBER ==========");
			for (Journal journals : lib.getSortedJournalsByNumber()) {
				System.out.println(journals);
			}
		}
	}

	public static void printSearchJourlanByTitle(Library lib, String title) {
		System.out.println(lib.searchJournalByTitle(title));
	}

	public static void printSearchBookByAuthor(Library lib, Author author) {
		System.out.println(lib.searchBookByAuthor(author));
	}

}
