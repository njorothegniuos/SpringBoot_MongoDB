package com.MBASE.controller;

import java.text.ParseException;
import java.util.List;

import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.MBASE.DTO.PersonDTO;
import com.MBASE.Domain.Person;
import com.MBASE.ModelMapper.PersonConversion;
import com.MBASE.service.PersonService;

@RestController
@RequestMapping("/api/Person")
public class PersonController {
	
	@Autowired
	public PersonService personService;
	
	@Autowired
    private PersonConversion personConversion;
	

	@RequestMapping(method = RequestMethod.POST, value="/create")
	public String create(@Valid @RequestBody PersonDTO postDto) throws ParseException {
		Person bk = personConversion.convertToEntity(postDto);
	    bk = personService.SavePerson(bk);
	    PersonDTO personDTO = personConversion.convertToDto(bk);
		return personDTO.tosString();
	}
	
	@RequestMapping(value = "/{firstname}", method = RequestMethod.GET)
	public Person getPerson(@PathVariable(value = "firstname") String firstname) {
		return personService.getFirstName(firstname);		
	}
	
	@RequestMapping(value = "/getAll", method = RequestMethod.GET)
	public List<Person> getAll(){
		return personService.getAll();
	}
	
	@RequestMapping("/update")
	public String update(@Valid @RequestBody Person bk) {
		Person p = personService.update(bk);
		return p.tosString();
	}
	
	@DeleteMapping("/{id}")
	public String delete(@PathVariable(value = "id") String firstname){
		Person b = personService.getFirstName(firstname);
		personService.delete(firstname);
		return "Deleted " + b.getFirstname();
	}
	@RequestMapping("/deleteAll")
	public String deleteAll(){
		personService.deleteAll();
		return "Deleted all Person records";
	}
	
	
	

}
