package sort.comparators;

import java.util.Comparator;

import sort.objects.Person;

/**
 * @author alex
 * �������� ���� rofl
 */
public class SexComparator implements Comparator<Person> {

	/* (non-Javadoc)
	 * @see java.util.Comparator#compare(java.lang.Object, java.lang.Object)
	 */
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
