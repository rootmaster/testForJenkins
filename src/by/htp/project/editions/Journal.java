package by.htp.project.editions;

import by.htp.project.editions.personality.Publisher;

public class Journal extends Edition {

	private int issueNumber;

	public int getIssueNumber() {
		return issueNumber;
	}

	public Journal() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Journal(String title, int year, Publisher publisher, int issueNumber) {
		super(title, year, publisher);
		this.issueNumber = issueNumber;
	}

	@Override
	public String toString() {
		return "[JOUR]\t" + super.toString() + "Issue Number = " + issueNumber;
	}

}
