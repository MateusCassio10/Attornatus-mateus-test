package com.Attornatusmateustest.repository;

import com.Attornatusmateustest.model.Person;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PersonRepository extends JpaRepository <Person, Long> {
    Person findById(Person id);
}
