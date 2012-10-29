package sort.bubble;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;

import sort.comparators.AgeComparator;
import sort.comparators.BmiComparator;
import sort.comparators.HeightComparator;
import sort.comparators.SexComparator;
import sort.person.Person;

public class ObjectSort {

	/**
	 * Сравняване на обекти. Person трябва да наследява интерфейса Comparable,
	 * защото иначе се взривява, че не знае по-какво да сортира. Като
	 * имплементираме compareTo(), Arrays.sort() вече може да го ползва, по
	 * какъв критерий да сравнява обектите.
	 * 
	 * @param args
	 */
	public static void main(String[] args) {
		prepareMenu();
	}

	private static void prepareMenu() {
		createMenu();
		selectSorting();
	}

	private static void selectSorting() {
		System.out.println("Избор: ");
		Scanner scan = new Scanner(System.in);
		int input = scan.nextInt();

		switch (input) {
		case 1:
			sortPersons(new SexComparator());
			break;
		case 2:
			sortPersons(new HeightComparator());
			break;
		case 3:
			sortPersons(new AgeComparator());
			break;
		case 4:
			sortPersons(new BmiComparator());
			break;
		case 5:
			exit();
			break;
		default:
			System.out.println("Error! Please enter a valid value.");
			selectSorting();
			break;
		}
		prepareMenu();
	}

	private static void exit() {
		System.out.println("Are you sure you want to exit.");
		Scanner scan = new Scanner(System.in);
		String answer = scan.nextLine();
		if (answer.equals("y")) {
			System.out.println("kthxbye");
			System.exit(0);
		}
		prepareMenu();
	}

	private static void sortPersons(Comparator c) {
		Person[] people = createPeople();
		System.out.println("Хората при създаване : ");
		System.out.println("----------------------");
		printPersons(people);

		Arrays.sort(people, c);

		System.out.println("След подредбата :");
		System.out.println("----------------------");
		printPersons(people);
	}

	private static Person[] createPeople() {
		Person[] people = new Person[5];
		people[0] = new Person("Пешо", false, 21, 181, 78, "020931");
		people[1] = new Person("Ваню", false, 28, 176, 80, "633533245");
		people[2] = new Person("Картофа", false, 24, 168, 90, "092371");
		people[3] = new Person("Маринка", true, 25, 168, 55, "1321543");
		people[4] = new Person("Пипилота", true, 19, 166, 53, "00592371");
		return people;
	}

	private static void printPersons(Person[] people) {
		for (int i = 0; i < people.length; i++) {
			people[i].print();
		}
	}

	private static void createMenu() {
		System.out.println("======================");
		System.out.println("Критерий за сортиране: ");
		System.out.println("[1] Пол");
		System.out.println("[2] Височина");
		System.out.println("[3] Възраст");
		System.out.println("[4] BMI");
		System.out.println("[5] Изход");
		System.out.println("======================");
		
	}
}