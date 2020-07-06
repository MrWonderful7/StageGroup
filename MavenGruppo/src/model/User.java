package model;
import java.util.Date;


public class User {
	
	String name;
	String surname;
	Date birthDate;
	int age;
	int id;
	String roles;
	
	public User(int id, String name, Date birthDate,String surname, int age, String roles) {
		this.id = id;
		this.name = name;
		this.surname = surname;
		this.birthDate = birthDate;
		this.age = age;
		
		this.roles = roles;
	}

	public User(String name, String surname, Date birthDate, int age, String roles) {
		
		this.name = name;
		this.surname = surname;
		this.birthDate = birthDate;
		this.age = age;
		this.roles = roles;
	}

public User() {}


	public String getRoles() {
		return roles;
	}


	public void setRoles(String roles) {
		this.roles = roles;
	}


	public User(int id) {
		this.id = id;
	}

	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getSurname() {
		return surname;
	}

	public void setSurname(String surname) {
		this.surname = surname;
	}

	public Date getBirthDate() {
		return birthDate;
	}

	public void setBirthDate(Date birthDate) {
		this.birthDate = birthDate;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	
	
}
