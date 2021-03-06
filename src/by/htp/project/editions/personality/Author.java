package by.htp.project.editions.personality;

public class Author {

	private String name;

	public String getName() {
		return name;
	}
	
	public Author() {
		super();
	}

	public Author(String name) {
		super();
		this.name = name;
	}

	@Override
	public String toString() {
		return "Author name = " + name;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((name == null) ? 0 : name.hashCode());
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
		Author other = (Author) obj;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		return true;
	}

	
	
}
