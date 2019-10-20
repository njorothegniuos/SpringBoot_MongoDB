package com.MBASE.repository;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.MBASE.Domain.Person;

public interface PersonRepository extends MongoRepository<Person, String> {
	
	public Person findByFirstname(String firstname);
	
	public List<Person> findByAge(int age);

}
