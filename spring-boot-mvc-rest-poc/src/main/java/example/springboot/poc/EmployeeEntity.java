package example.springboot.poc;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class EmployeeEntity {
	
	@Id
	@GeneratedValue /*(generator = "uuid")
	@GenericGenerator(name = "uuid", strategy = "uuid2") */
	private String id;
	
	@Column
	private String name;
	
	@Column
	private String lastName;

	public String getName() {
		return name;
	}

	public EmployeeEntity setName(String name) {
		this.name = name;
		return this;
	}

	public String getLastName() {
		return lastName;
	}

	public EmployeeEntity setLastName(String lastName) {
		this.lastName = lastName;
		return this;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

}