package com.github.jaum1981.services;

import com.github.jaum1981.data.dto.PersonDTO;
import com.github.jaum1981.exception.ResourceNotFoundException;
import com.github.jaum1981.models.Person;
import com.github.jaum1981.repositories.PersonRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import static com.github.jaum1981.mapper.ObjectMapper.parseListObject;
import static com.github.jaum1981.mapper.ObjectMapper.parseObject;

@Service
public class PersonService {

    @Autowired
    PersonRepository personRepository;
    private Logger logger = LoggerFactory.getLogger((PersonService.class));

    public List<PersonDTO> findAll() {
        logger.info("Finding all people");
        return parseListObject(personRepository.findAll(), PersonDTO.class);
    }

    public PersonDTO findById(Long id) {
        logger.info("Finding person by id " + id);
        var entity = personRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("No records found for id: " + id));
        return parseObject(entity, PersonDTO.class);
    }

    public void deleteById(long id) {
        logger.info("Deleting record with id: " + id);

        Person exists = personRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("No records found for id: " + id));
        personRepository.delete(exists);
    }

    public PersonDTO create(PersonDTO person) {

        logger.info("Saving person with id " + person.getId());
        var entity = parseObject(person, Person.class);

        return parseObject(personRepository.save(entity), PersonDTO.class);
    }

    public PersonDTO update(PersonDTO person) {

        logger.info("Updating person");

        Person exists = personRepository.findById(person.getId())
                .orElseThrow(() -> new ResourceNotFoundException("No records found for id: " + person.getId()));
        exists.setFirstName(person.getFirstName());
        exists.setLastName(person.getLastName());
        exists.setAddress(person.getAddress());
        exists.setGender(person.getGender());

        return parseObject(personRepository.save(exists), PersonDTO.class);
    }
}
