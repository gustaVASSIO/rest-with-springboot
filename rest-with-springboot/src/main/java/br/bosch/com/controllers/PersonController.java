package br.bosch.com.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import br.bosch.com.services.PersonServices;
import br.com.bosch.model.Person;

@RestController()
@RequestMapping("/persons")
public class PersonController {

	@Autowired
	private PersonServices service;
	
	@RequestMapping(value = "/{id}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public Person getById(@PathVariable(value = "id") String id) {

		return service.findById(id);
	}
	
	@RequestMapping(method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public List<Person> getAll() {
		
		return service.findAll();
	}
	@RequestMapping(method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
	public Person postPerson(@RequestBody() Person person) {
		
		return service.insert(person);
	}
	@RequestMapping(value = "/{id}", method = RequestMethod.PUT, produces = MediaType.APPLICATION_JSON_VALUE)
	public Person putPerson(@PathVariable() String id, @RequestBody() Person person) {
		
		return service.update(id, person);
	}
	
//	@RequestMapping(method = RequestMethod.DELETE, produces = MediaType.APPLICATION_JSON_VALUE)
//	public Person deletePerson() {
//		
//		return service.findAll();
//	}
}
