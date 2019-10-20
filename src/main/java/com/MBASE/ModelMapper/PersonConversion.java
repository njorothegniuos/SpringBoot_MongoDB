package com.MBASE.ModelMapper;

import java.text.ParseException;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.MBASE.DTO.PersonDTO;
import com.MBASE.Domain.Person;

@Component
public class PersonConversion {
	
	@Autowired
    private ModelMapper modelMapper;
	
	// mapper methods
	public PersonDTO convertToDto(Person post) throws ParseException{
			PersonDTO postDto = modelMapper.map(post, PersonDTO.class);
		    return postDto;
		}
		
		public Person convertToEntity(PersonDTO postDto) throws ParseException {
			Person person = modelMapper.map(postDto, Person.class);
		  
		    return person;
		}

}
