package com.github.eduzol.peoplesorter.util.comparator;

import java.util.Comparator;

import com.github.eduzol.peoplesorter.model.Person;

public class PersonLastNameComparator  implements Comparator<Person>{

	@Override
	public int compare(Person p1, Person p2) {
		return p1.getLastName().compareTo(p2.getLastName());
	}

	
}
