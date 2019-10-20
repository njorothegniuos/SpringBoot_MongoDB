package com.MBASE;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.MBASE.Domain.Person;
import com.MBASE.repository.PersonRepository;
import com.MBASE.service.PersonService;

@RunWith(SpringRunner.class)
@SpringBootTest
public class SpringBootRestMongodbApplicationTests {
	
	@InjectMocks
	PersonService personService;
	
	@Mock
	PersonRepository personRepository;
	
	private static final String firstname="SAM";
	private static final String Id="5daa746adb160b1884c91572";
	@Test
	public void getPersonByIdTest() {
		personRepository.findById(Id);
		verify(personRepository).findById(Id);
	}
	@Test
	public void getFirstNameTest() {
		personRepository.findByFirstname(firstname);
		verify(personRepository).findByFirstname(firstname);
	}
	
	@Test
	public void getAllTest() {
		personService.getAll();
		verify(personRepository).findAll();
	}
	
	@Test
	public void createTest() {
		Person p = mock(Person.class);
		personService.SavePerson(p);
		verify(personRepository).save(p);			
	}

	@Test
	public void updateTest() {
		Person p = mock(Person.class);
		when(p.getFirstname()).thenReturn(firstname);
		when(p.getLastname()).thenReturn("mburu test");
		when(p.getAge()).thenReturn(30);
		when(personRepository.findByFirstname(firstname)).thenReturn(p);
		personService.update(p);
		verify(personRepository).save(p);
	}
	
	@Test
	public void deleteAllTest() {
		personService.deleteAll();
		verify(personRepository).deleteAll();
	}
	
	@Test
	public void deleteTest() {
		personRepository.deleteById(Id);
		verify(personRepository).deleteById(Id);
	}
	
	@Test
	public void contextLoads() {
	}
	

}
