package com.github.eduzol.peoplesorter.util.comparator;

import java.util.Comparator;

import com.github.eduzol.peoplesorter.model.Person;

public class PersonDobComparator  implements Comparator<Person> {

	@Override
	public int compare(Person p1, Person p2) {
		
		if ( p1.getDateOfBirth().before( p2.getDateOfBirth()) ) {
            return -1;
        } else if ( p1.getDateOfBirth().after(p2.getDateOfBirth()) ) {
            return 1;
        } else {
            return 0;
        }        
		
	}

}
