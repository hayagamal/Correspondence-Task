package com.example.cms.Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.cms.Entity.*;
import com.example.cms.Repository.*;


@Service
public class PersonService {

    @Autowired
    private PersonRepository personRepository;
    
    public PersonService(PersonRepository personRepository) {
        this.personRepository = personRepository;
    }

    public PersonService() {
    }


    public boolean addPerson(Person person){
        personRepository.save(person);
        return true;
    }

    public long getPerson(String name){
        return personRepository.findByNameEquals(name).getId();
    }
}
