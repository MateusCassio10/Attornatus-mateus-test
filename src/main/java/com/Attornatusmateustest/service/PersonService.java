package com.Attornatusmateustest.service;

import com.Attornatusmateustest.model.Address;
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
            //personRegister.getAddress().forEach(address -> address.setPerson(personRegister));
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

    public Person update(Long id, Person personRegister) {
        Optional<Person> optionalPerson = findById(id);
        if (optionalPerson.isEmpty()) {
            return null;
        }
        Person person = optionalPerson.get();
        person.setName(personRegister.getName());
        return personRepository.save(person);
    }

    public void delete(Long id) {
        personRepository.deleteById(id);
    }

}
