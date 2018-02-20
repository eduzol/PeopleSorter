package com.github.eduzol.peoplesorter.util;

import java.util.Comparator;

import com.github.eduzol.peoplesorter.model.Person;

public class PersonSsnComparator implements Comparator<Person> {

	@Override
	public int compare(Person p1, Person p2) {
		return p1.getSsn().compareTo(p2.getSsn()); 
	}
	
}
