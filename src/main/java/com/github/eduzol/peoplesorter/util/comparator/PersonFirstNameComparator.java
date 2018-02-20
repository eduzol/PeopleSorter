package com.github.eduzol.peoplesorter.util.comparator;

import java.util.Comparator;

import com.github.eduzol.peoplesorter.model.Person;

public class PersonFirstNameComparator  implements Comparator<Person> {

	@Override
	public int compare(Person p1, Person p2) {
		return p1.getFirstName().compareTo(p2.getFirstName());
	}

}
