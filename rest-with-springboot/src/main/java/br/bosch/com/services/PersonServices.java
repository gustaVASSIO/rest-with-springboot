package br.bosch.com.services;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.atomic.AtomicLong;
import java.util.logging.Logger;

import org.springframework.stereotype.Service;

import br.com.bosch.model.Person;

@Service
public class PersonServices {
	private final AtomicLong counter  = new AtomicLong();
	private Logger logger = Logger.getLogger(PersonServices.class.getName());
	
	public Person findById(String id) {
		logger.info("Finding one person");
		Person person = new Person();
		
		person.setId(counter.incrementAndGet());
		person.setFirstname("Gustavo");
		person.setLastname("Anacleto");
		person.setAddress("Campinas SP");
		person.setGender("M");
		
		return person;
	}
	
	public List<Person> findAll() {
		logger.info("Finding all persons");
		
		List<Person> persons = new ArrayList<>();

		for (int i = 0 ; i < 8  ; i ++) {
			Person person = mockPerson(i);
			persons.add(person);
		}

		return persons;
	}
	
	public Person insert(Person person) {
		logger.info("ISERT PERSON ON DATABASE");
		return person;
	}
	
	public Person update(String id, Person person) {
		logger.info("UPDATE PERSON ON DATABASE WHERE ID = " + id);
		
		return person;
	}
	
	private Person mockPerson(int i) {
		// TODO Auto-generated method stub
		Person person = new Person();
		
		person.setId(counter.incrementAndGet());
		person.setFirstname("Gustavo" + i);
		person.setLastname("Anacleto"+ i );
		person.setAddress("Campinas SP" + i);
		person.setGender("M" + i);
		
		return person;
	}
}
 