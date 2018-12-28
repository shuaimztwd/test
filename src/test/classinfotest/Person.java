package test.classinfotest;

public class Person implements China {

	private String name;
	private int age;

	public Person() {
		super();
	}

	public Person(String name) {
		this();
		this.setName(name);
	}

	public Person(String name, int age) {
		this(name);
		this.setAge(age);
	}

	/**
	 * @return the name
	 */
	public String getName() {
		return name;
	}

	/**
	 * @param name
	 *            the name to set
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * @return the age
	 */
	public int getAge() {
		return age;
	}

	/**
	 * @param age
	 *            the age to set
	 */
	public void setAge(int age) {
		this.age = age;
	}

	@Override
	public void sayChina() {
		System.out.println("author = " + AUTHOR + "，china = " + NATIONAL);
	}

	@Override
	public String sayHello(String name, int age) {
		return "name = " + name + "，age = " + age;
	}

}
