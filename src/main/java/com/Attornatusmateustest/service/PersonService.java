package com.Attornatusmateustest.service;

import com.Attornatusmateustest.model.Person;
import com.Attornatusmateustest.repository.PersonRepository;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PersonService {

    private final PersonRepository personRepository;
    public PersonService(PersonRepository personRepository) {
        this.personRepository = personRepository;
    }

    public Person create(Person personRegister) {
        try {
            personRegister.getAddress().forEach(address -> address.setPerson(personRegister));
            return personRepository.save(personRegister);
        } catch (DataIntegrityViolationException e) {
            return null;
        }
    }

    public List findAll() {
        return personRepository.findAll();
    }

    public Optional<Person> findById(Long id) {
        return personRepository.findById(id);
    }
}
