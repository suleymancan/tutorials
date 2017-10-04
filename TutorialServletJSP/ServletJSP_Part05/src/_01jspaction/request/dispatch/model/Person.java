package _01jspaction.request.dispatch.model;


public class Person {

	private String name;
	private String surname;
	private String age;

	public Person() {
		super();
	}

	public Person(String name, String surname, String age) {
		super();
		this.name = name;
		this.surname = surname;
		this.age = age;
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

	public String getAge() {
		return age;
	}

	public void setAge(String age) {
		this.age = age;
	}
}
