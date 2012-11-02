package sort.objects;

import java.text.DecimalFormat;

/**
 * @author alex
 * 
 */
public class Person implements Comparable<Person> {
	/**
	 * ������ 0-120
	 */
	private Integer age;
	/**
	 * �������� � ����������
	 */
	private Integer height;
	/**
	 * ���
	 */
	private Boolean isFemale;
	/**
	 * ���
	 */
	private String name;
	/**
	 * �����
	 */
	private Integer weight;
	/**
	 * ���������� �����
	 */
	private String facultyNumber;

	public Person(String name, Boolean isFemale, Integer age, Integer height, Integer weight, String facultyNumber) {
		this.name = name;
		this.isFemale = isFemale;
		this.age = age;
		this.height = height;
		this.weight = weight;
		this.facultyNumber = facultyNumber;
	}

	public double getBodyMassIndex() {
		// ��� �������� �� double ����� (100.0) �� ������� double ��������
		// ������, �� ����� ������ castvane, ����� �� ������� ����������� ������ � ���� �� � ��������
		DecimalFormat formatDouble = new DecimalFormat("#,##");
//		return Double.valueOf(formatDouble.format(weight / Math.pow(height / 100.0, 2)));
		return weight / Math.pow(height / 100.0, 2);
	}

	public void print() {
		System.out.println(getName() + "=> � ��: " + getAge() + ", ����: "
				+ getWeight() + ", ����� �: " + getHeight() + ", BMI: "
				+ getBodyMassIndex());
	}

	public int getAge() {
		return age;
	}

	public void setAge(Integer age) {
		this.age = age;
	}

	public int getHeight() {
		return height;
	}

	public void setHeight(Integer height) {
		this.height = height;
	}

	public boolean isFemale() {
		return isFemale;
	}

	public void setFemale(Boolean isFemale) {
		this.isFemale = isFemale;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getWeight() {
		return weight;
	}

	public void setWeight(Integer weight) {
		this.weight = weight;
	}
	
	public String getFacultyNumber() {
		return facultyNumber;
	}

	public void setFacultyNumber(String facultyNumber) {
		this.facultyNumber = facultyNumber;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Comparable#compareTo(java.lang.Object) -1 less than 0
	 * equal 1 greater than
	 * 
	 * ���� �� ������� �������� Person, ������ ���� ��� ��������������
	 * ���������� � <Person>
	 */
	@Override
	public int compareTo(Person arg0) {
		if (this.getBodyMassIndex() > arg0.getBodyMassIndex()) {
			return 1;
		} else if (this.getBodyMassIndex() < arg0.getBodyMassIndex()) {
			return -1;
		}
		return 0;
	}
}
