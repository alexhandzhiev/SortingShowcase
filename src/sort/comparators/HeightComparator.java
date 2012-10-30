package sort.comparators;

import java.util.Comparator;

import sort.objects.Person;

public class HeightComparator implements Comparator<Person> {

	@Override
	public int compare(Person arg0, Person arg1) {
		if(arg0.getHeight() < arg1.getHeight()) {
			return -1;
		} else if (arg0.getHeight() > arg1.getHeight()) {
			return 1;
		}
		return 0;
	}

}
