package com.Attornatusmateustest.service;

import com.Attornatusmateustest.model.Person;
import com.Attornatusmateustest.repository.PersonRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(MockitoExtension.class)
public class PersonServiceTest {

    @Mock
    private PersonRepository personRepository;

    @InjectMocks
    private PersonService personService;

    @Test
    void testCreatePersonOk() {
        //mock
        Person person = new Person();
        person.setId(50L);

        Mockito.when(personRepository.save(person)).thenReturn(person);

        //service call
        Person personReturned = personService.create(person);

        //assert
        assertEquals(50, personReturned.getId());

        Mockito.verify(personRepository).save(person);
    }

    @Test
    void testDelete() {
        //mock
        Long id = 15L;

        personService.delete(id);

        Mockito.verify(personRepository).deleteById(id);
    }
}