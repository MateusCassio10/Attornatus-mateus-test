package com.Attornatusmateustest.controller;

import com.Attornatusmateustest.model.Person;
import com.Attornatusmateustest.service.PersonService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/person")
public class PersonController {

    private final PersonService personService;

    public PersonController(PersonService personService) {
        this.personService = personService;
    }

    @PostMapping
    public ResponseEntity register(@RequestBody Person personRegister) {
        Person person = personService.create(personRegister);
        if (person == null) {
            return ResponseEntity.badRequest().body("");
        }
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }

    @GetMapping
    public ResponseEntity listAll() {
        return ResponseEntity.ok(personService.findAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity getById(@PathVariable(value = "id") Long id) {
        Optional<Person> optionalPerson = personService.findById(id);
        if (optionalPerson.isEmpty()) {
            return ResponseEntity.badRequest().body("Person Not Found!");
        }
        return ResponseEntity.ok(optionalPerson.get());
    }

    @PutMapping("/{id}")
    public ResponseEntity updateRegister(@PathVariable(value = "id") Long id, @RequestBody Person personRegister) {
        Person person = personService.update(id, personRegister);
        if (person == null) {
            return ResponseEntity.badRequest().body("Person Not Found!");
        }
        return ResponseEntity.ok(person);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity delete(@PathVariable(value = "id") Long id) {
        personService.delete(id);
        return ResponseEntity.ok().build();
    }

}
