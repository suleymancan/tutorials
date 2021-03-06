package model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

//jdbc orneklerinde annotation yok.
@Entity
public class Person {
	
	@Id
	@GeneratedValue(strategy=GenerationType.TABLE)
	private int id;
	private String name;
	private String surname;
	private int birthYear;
	
	
	//JPA için default constructor
	public Person() {
		super();
	}

	public Person(String name, String surname, int birthYear) {
		super();
		this.name = name;
		this.surname = surname;
		this.birthYear = birthYear;
	}

	public int getId() {
		return id;
	}

	@Override
	public String toString() {
		return "Person [name=" + name + ", surname=" + surname + ", birthYear=" + birthYear + "]";
	}

	public void setId(int id) {
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

	public int getBirthYear() {
		return birthYear;
	}

	public void setBirthYear(int birthYear) {
		this.birthYear = birthYear;
	}

}
