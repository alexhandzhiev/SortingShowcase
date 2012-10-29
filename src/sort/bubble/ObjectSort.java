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
	 * ���������� �� ������. Person ������ �� ��������� ���������� Comparable,
	 * ������ ����� �� ��������, �� �� ���� ��-����� �� �������. ����
	 * �������������� compareTo(), Arrays.sort() ���� ���� �� �� ������, ��
	 * ����� �������� �� �������� ��������.
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
		System.out.println("�����: ");
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
		System.out.println("������ ��� ��������� : ");
		System.out.println("----------------------");
		printPersons(people);

		Arrays.sort(people, c);

		System.out.println("���� ���������� :");
		System.out.println("----------------------");
		printPersons(people);
	}

	private static Person[] createPeople() {
		Person[] people = new Person[5];
		people[0] = new Person("����", false, 21, 181, 78, "020931");
		people[1] = new Person("����", false, 28, 176, 80, "633533245");
		people[2] = new Person("�������", false, 24, 168, 90, "092371");
		people[3] = new Person("�������", true, 25, 168, 55, "1321543");
		people[4] = new Person("��������", true, 19, 166, 53, "00592371");
		return people;
	}

	private static void printPersons(Person[] people) {
		for (int i = 0; i < people.length; i++) {
			people[i].print();
		}
	}

	private static void createMenu() {
		System.out.println("======================");
		System.out.println("�������� �� ���������: ");
		System.out.println("[1] ���");
		System.out.println("[2] ��������");
		System.out.println("[3] �������");
		System.out.println("[4] BMI");
		System.out.println("[5] �����");
		System.out.println("======================");
		
	}
}