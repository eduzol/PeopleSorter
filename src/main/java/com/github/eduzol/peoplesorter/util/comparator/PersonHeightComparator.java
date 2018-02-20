package com.github.eduzol.peoplesorter.util.comparator;

import java.util.Comparator;

import com.github.eduzol.peoplesorter.model.Person;

public class PersonHeightComparator  implements Comparator<Person> {

	@Override
	public int compare(Person p1, Person p2) {
		return Double.compare(p1.getHeightIn(), p2.getHeightIn());
	}

}
