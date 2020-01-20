package de.embl.peoplebase.service;

import de.embl.peoplebase.entity.Person;
import de.embl.peoplebase.exception.MandatoryFieldException;
import de.embl.peoplebase.exception.PersonNotFoundException;
import de.embl.peoplebase.repository.PersonRepository;
import org.springframework.stereotype.Service;

import java.time.Instant;
import java.util.Collection;
import java.util.Date;
import java.util.UUID;

@Service
public class PersonService {

    private final PersonRepository personRepository;

    public PersonService(PersonRepository personRepository) {
        this.personRepository = personRepository;
    }

    public Collection<Person> getAllPersons() {
        return personRepository.findAll();
    }

    public Person getPerson(String id) {
        return personRepository.findById(id).orElseThrow(() -> new PersonNotFoundException(id));
    }

    public Person createPerson(Person person) {
        validate(person);
        person.setId(UUID.randomUUID().toString());
        person.setCreated(Date.from(Instant.now()));
        return personRepository.save(person);
    }

    public Person updatePerson(Person person, String id) {
        validate(person);
        Person personSaved = personRepository.findById(id).orElseThrow(() -> new PersonNotFoundException(id));
        personSaved.setFirstName(person.getFirstName());
        personSaved.setLastName(person.getLastName());
        personSaved.setAge(person.getAge());
        personSaved.setFavouriteColour(person.getFavouriteColour());
        personSaved.setHobby(person.getHobby());
        return personRepository.save(personSaved);
    }

    public void deletePerson(String id) {
        Person person = personRepository.findById(id).orElseThrow(() -> new PersonNotFoundException(id));
        personRepository.delete(person);
    }

    private void validate(Person person) {
        if (person.getFirstName() == null || person.getFirstName().isEmpty()) {
            throw new MandatoryFieldException("first name can't be empty");
        }
    }
}
