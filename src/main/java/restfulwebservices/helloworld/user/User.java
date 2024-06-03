package restfulwebservices.helloworld.user;

import java.time.LocalDate;
/**
 * 1. Getter and Setter
 * 2. Constructor 
 * What is the correct order ?
 * You can say as Data Class/ Entity Class / persistence Class.
 * All of them are same.
 */

public class User {
	private Integer id;
	private String name;
	private LocalDate birthDate;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public LocalDate getBirthDate() {
		return birthDate;
	}

	public void setBirthDate(LocalDate birthDate) {
		this.birthDate = birthDate;
	}

	public User(Integer id, String name, LocalDate birthDate) {
		super();
		this.id = id;
		this.name = name;
		this.birthDate = birthDate;
	}

	@Override
	public String toString() {
		return "User [id=" + id + ", name=" + name + ", birthDate=" + birthDate + "]";
	}

}
