package com.github.jaum1981.repositories;

import com.github.jaum1981.models.Person;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PersonRepository extends JpaRepository<Person, Long> {
}
