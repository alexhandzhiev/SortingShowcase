package sort.comparators;

import java.util.Comparator;

import sort.person.Person;

/**
 * @author alex
 * �������� ���� rofl
 */
public class SexComparator implements Comparator<Person> {

	@Override
	public int compare(Person arg0, Person arg1) {
		if(arg0.isFemale() == arg1.isFemale()) {
			return 0;
		} else if(arg0.isFemale()) {
			return -1;
			//� arg1 � ���
		} else {
			//arg0 � ���� - arg1 e ���
			return 1;
		}
	}
}
