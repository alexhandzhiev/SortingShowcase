package sort.comparators;

import java.util.Comparator;

import sort.objects.Person;

/**
 * @author alex
 *
 */
public class NameComparator implements Comparator<Person> {

	/* (non-Javadoc)
	 * @see java.util.Comparator#compare(java.lang.Object, java.lang.Object)
	 */
	@Override
	public int compare(Person o1, Person o2) {
		return o1.getName().compareToIgnoreCase(o2.getName());
	}

}
