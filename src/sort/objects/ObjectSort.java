package sort.objects;

import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.Scanner;

import sort.comparators.AgeComparator;
import sort.comparators.BmiComparator;
import sort.comparators.FacultyNumberComparator;
import sort.comparators.HeightComparator;
import sort.comparators.NameComparator;
import sort.comparators.SexComparator;
import sort.reader.PeopleReader;

/**
 * @author alex
 * Упражнения - 28.10.2012г.
 */
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
			sortPersons(new NameComparator());
			break;
		case 6:
			sortPersons(new FacultyNumberComparator());
			break;
		case 7:
			findByName();
			break;
		case 8:
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
	
	private static void findByName() {
		System.out.println("Напишете търсеното име: ");
		Scanner scan = new Scanner(System.in);
		String input = scan.next().trim();
		PeopleReader pplReader = new PeopleReader("databaseLOL.txt");
		Person[] people = pplReader.readPeople();
		Person personToSearch = new Person(input, null, null, null, null, null);
		Person personFound = people[Collections.binarySearch(Arrays.asList(people), personToSearch, new NameComparator())];
		personFound.print();
	}

	private static Person[] createPeople() {
		PeopleReader peopleReader = new PeopleReader("databaseLOL.txt");
		return peopleReader.readPeople();
	}

	private static void printPersons(Person[] people) {
		for (int i = 0; i < people.length; i++) {
			people[i].print();
		}
	}

	private static void createMenu() {
		System.out.println("======================");
		System.out.println("Моля изберете стойност: ");
		System.out.println("[1] Пол");
		System.out.println("[2] Височина");
		System.out.println("[3] Възраст");
		System.out.println("[4] BMI");
		System.out.println("[5] Име");
		System.out.println("[6] Факултетен номер");
		System.out.println("[7] Търсене по име");
		System.out.println("[8] Изход");
		System.out.println("======================");
		
	}
}