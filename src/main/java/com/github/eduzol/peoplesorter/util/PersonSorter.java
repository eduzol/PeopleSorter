package com.github.eduzol.peoplesorter.util;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Map;

import com.github.eduzol.peoplesorter.model.Person;
import com.github.eduzol.peoplesorter.util.comparator.PersonDobComparator;
import com.github.eduzol.peoplesorter.util.comparator.PersonHeightComparator;
import com.github.eduzol.peoplesorter.util.comparator.PersonLastNameComparator;
import com.github.eduzol.peoplesorter.util.comparator.PersonSsnComparator;
import com.github.eduzol.peoplesorter.util.comparator.PersonWeightComparator;
import com.github.eduzol.peoplesorter.util.validator.PersonSorterValidator;
import com.google.common.collect.ImmutableMap;
import com.google.common.collect.Lists;


public class PersonSorter {

	private static final Map<String, Comparator<Person>> comparatorMap = ImmutableMap.<String, Comparator<Person>>builder()
		    .put("ssn", new PersonSsnComparator())
		    .put("dateOfBirth" , new PersonDobComparator() )
		    .put("firstName" , new PersonDobComparator() )
		    .put("lastName", new PersonLastNameComparator() )
		    .put("heightIn" , new PersonHeightComparator())
		    .put("weightLb", new PersonWeightComparator() )
		    .build();
	
	private static final PersonSorterValidator validator = new PersonSorterValidator();
	
	public static List<Person> sort(Iterable<Person> people, String sortField,	String ascending ){
	
		validator.checkNull(people);
		validator.checkKeys(comparatorMap, sortField);
		
		List<Person> peopleList =  Lists.newArrayList(people);
		Comparator<Person> comparator = comparatorMap.get(sortField);
		boolean isAscending = Boolean.parseBoolean(ascending);
		
		if ( isAscending ) {
			Collections.sort(peopleList, comparator );
		}else {
			Collections.sort(peopleList, comparator.reversed() );
		}
		
		return peopleList;
		
	}

}
