package example.springboot.poc;

public class Employee {
	private long id;
	private String name;
	private String lastName;

	public String getName() {
		return name;
	}

	public Employee setName(String name) {
		this.name = name;
		return this;
	}

	public String getLastName() {
		return lastName;
	}

	public Employee setLastName(String lastName) {
		this.lastName = lastName;
		return this;
	}

	public long getId() {
		return id;
	}

	public Employee setId(long id) {
		this.id = id;
		return this;
	}
}