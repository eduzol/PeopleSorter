package com.github.eduzol.peoplesorter.test;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import org.junit.Assert;
import org.junit.Test;

import com.github.eduzol.peoplesorter.exception.PersonSorterException;
import com.github.eduzol.peoplesorter.model.Person;
import com.github.eduzol.peoplesorter.util.PersonSorter;


public class PersonSorterTest {

	@Test
	public void testAscendingSortingByLastName() {
		
		
		List<Person> peopleList =  new ArrayList<Person>();
		
		for ( int i = 0 ; i < 10 ; i++) {
			String sampleLastName = UUID.randomUUID().toString().replaceAll("-","").substring(22);
			Person p =  new Person();
			p.setLastName(sampleLastName);
			System.out.println("adding " + p);
			peopleList.add(p);
		}
		
		List<Person> sortedList = PersonSorter.sort(peopleList, "lastName", "true");
		
		Assert.assertTrue(!sortedList.isEmpty());
		Person prev = sortedList.get(0);
		
		for(int i = 1; i < sortedList.size() ; i++  ) {
			
			Person current = sortedList.get(i);
			System.out.println(current);
			int comparisonResult=prev.getLastName().compareTo(current.getLastName());
			Assert.assertTrue( comparisonResult<=0);
			prev = current;
		}
		
	}
	
	@Test
	public void testDescendingSortingByLastName() {
		
		
		List<Person> peopleList =  new ArrayList<Person>();
		
		for ( int i = 0 ; i < 10 ; i++) {
			String sampleLastName = UUID.randomUUID().toString().replaceAll("-","").substring(22);
			Person p =  new Person();
			p.setLastName(sampleLastName);
			//TODO configure proper logging
			System.out.println("adding " + p);
			peopleList.add(p);
		}
		
		List<Person> sortedList = PersonSorter.sort(peopleList, "lastName", "false");
		
		Assert.assertTrue(!sortedList.isEmpty());
		Person prev = sortedList.get(0);
		
		for(int i = 1; i < sortedList.size() ; i++  ) {
			
			Person current = sortedList.get(i);
			System.out.println(current);
			int comparisonResult=prev.getLastName().compareTo(current.getLastName());
			Assert.assertTrue( comparisonResult>=0);
			prev = current;
		}
		
	}
	
	@Test (expected = PersonSorterException.class)
	public void testFieldNotFound() {
		
		List<Person> peopleList =  new ArrayList<Person>();
		List<Person> sortedList = PersonSorter.sort(peopleList, "ransdomada", "false");
		
	}
}
