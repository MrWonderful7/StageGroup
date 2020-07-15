package model;

import java.sql.Timestamp;
import java.util.Date;


public class User {
	
	String name;
	String surname;
	Date birthDate;
	Timestamp CreationTimestamp;
	int age;
	int id;
	Type type;
	

	public User(String name, String surname, Date birthDate, Timestamp creationTimestamp, int age, int id, Type type) {
		
		this.name = name;
		this.surname = surname;
		this.birthDate = birthDate;
		CreationTimestamp = creationTimestamp;
		this.age = age;
		this.id = id;
		this.type = type;
	}


	public User(int id, String name, Date birthDate,String surname, int age, Type type, Timestamp CreationTimestamp) {
		this.id = id;
		this.name = name;
		this.surname = surname;
		this.birthDate = birthDate;
		this.age = age;
		this.type = type;
		this.CreationTimestamp=CreationTimestamp;
		
	}
	
	public User(int id, String name, Date birthDate,String surname, int age, Type type) {
		this.id = id;
		this.name = name;
		this.surname = surname;
		this.birthDate = birthDate;
		this.age = age;
		this.type = type;
		
		
	}


	public User(String name, String surname, Date birthDate, int age,  Type type,Timestamp CreationTimestamp) {
		
		this.name = name;
		this.surname = surname;
		this.birthDate = birthDate;
		this.age = age;
		this.type = type;
		this.CreationTimestamp=CreationTimestamp;
	}

public User() {}


	
	public User(int id) {
		this.id = id;
	}

	
	public User(int id2, String name2) {
		this.id = id2;
		this.name = name2;
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

	public Timestamp getCreationTimestamp() {
		return CreationTimestamp;
	}

	public void setCreationTimestamp(Timestamp creationTimestamp) {
		CreationTimestamp = creationTimestamp;
	}

	public Type getType() {
		return type;
	}

	public void setType(Type type) {
		this.type = type;
	}
	

	
}
