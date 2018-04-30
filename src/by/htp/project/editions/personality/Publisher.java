package by.htp.project.editions.personality;

public class Publisher {

	private String name;
	private String address;
	private String phone;

	public Publisher() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Publisher(String name, String address, String phone) {
		super();
		this.name = name;
		this.address = address;
		this.phone = phone;
	}

	@Override
	public String toString() {
		return "Publisher name = " + name;
	};

}
