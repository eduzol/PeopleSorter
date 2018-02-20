package com.github.eduzol.peoplesorter.util.validator;

import java.util.Comparator;
import java.util.Map;

import com.github.eduzol.peoplesorter.exception.PersonSorterException;
import com.github.eduzol.peoplesorter.model.Person;

public class PersonSorterValidator {

	public void checkNull(Iterable<Person> people ) {
		if ( people == null) {
			throw new PersonSorterException("people is null");
		}
	}
	
	public void checkKeys(Map<String, Comparator<Person>> comparatorMap  , String key) {
		
		if ( !comparatorMap.containsKey(key)) {
			throw new PersonSorterException("key not found in ComparatorMap: " + key);
		}
		
	}
	
}
