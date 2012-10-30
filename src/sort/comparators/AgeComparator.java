package sort.comparators;

import java.util.Comparator;

import sort.objects.Person;

public class AgeComparator implements Comparator<Person> {

	/* (non-Javadoc)
	 * @see java.util.Comparator#compare(java.lang.Object, java.lang.Object)
	 */
	@Override
	public int compare(Person arg0, Person arg1) {
		if(arg0.getAge() < arg1.getAge()) {
			return -1;
		} else if (arg0.getAge() > arg1.getAge()) {
			return 1;
		}
		return 0;
	}
}
