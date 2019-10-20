package com.MBASE.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.MBASE.Domain.Person;
import com.MBASE.repository.PersonRepository;
/**
 * 
 * @author Sam
 * Person service
 */
@Service
public class PersonService {
	
	@Autowired
	private PersonRepository personRepository;
	
	
	//creation operation
	public Person SavePerson(Person p) {
		return personRepository.save(p);
	}
	
	//retrieve operation
	public List<Person> getAll(){
		List<Person> p = new ArrayList<>();
		personRepository.findAll().forEach(p::add); // java 8
		return p;
	}
	
	public Person getFirstName(String firstname) {
		return personRepository.findByFirstname(firstname);
	}
	
	public Optional<Person> getPersonById(String Id) {
		return  personRepository.findById(Id);
	}
	
	//update operation
	public Person update(Person bk) {
		Person p = personRepository.findByFirstname(bk.getFirstname());
		p.setFirstname(bk.getFirstname());
		p.setLastname(bk.getLastname());
		p.setAge(bk.getAge());
		return personRepository.save(p);
	}
	//delete operation
	public void deleteAll() {
		personRepository.deleteAll();
	}
	public void delete(String firstname) {
		Person p = personRepository.findByFirstname(firstname);
		personRepository.delete(p);
	}

}
