package sort.objects;

/**
 * @author alex
 * 
 */
public class Person implements Comparable<Person> {
	/**
	 * години 0-120
	 */
	private int age;
	/**
	 * височина в сантиметри
	 */
	private int height;
	/**
	 * пол
	 */
	private boolean isFemale;
	/**
	 * име
	 */
	private String name;
	/**
	 * тегло
	 */
	private int weight;
	/**
	 * факултетен номер
	 */
	private String facultyNumber;

	public Person(String name, boolean isFemale, int age, int height, int weight, String facultyNumber) {
		this.name = name;
		this.isFemale = isFemale;
		this.age = age;
		this.height = height;
		this.weight = weight;
		this.facultyNumber = facultyNumber;
	}

	public double getBodyMassIndex() {
		// ако разделим на double число (100.0) ще получим double резултат
		// защото, ще имаме неявно castvane, иначе ще получим целочислено делене и няма да е правилно
		return weight / Math.pow(height / 100.0, 2);
	}

	public void print() {
		System.out.println(getName() + "=> е на: " + getAge() + ", тежи: "
				+ getWeight() + ", висок е: " + getHeight() + ", BMI: "
				+ getBodyMassIndex());
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public int getHeight() {
		return height;
	}

	public void setHeight(int height) {
		this.height = height;
	}

	public boolean isFemale() {
		return isFemale;
	}

	public void setFemale(boolean isFemale) {
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

	public void setWeight(int weight) {
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
	 * Мога да приемам директно Person, защото горе съм параметризирал
	 * интерфейса с <Person>
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
