package de.embl.peoplebase.agent;

import de.embl.peoplebase.converter.PersonConverter;
import de.embl.peoplebase.domain.PeopleModulePerson;
import de.embl.peoplebase.entity.Person;
import de.embl.peoplebase.service.PersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Collection;
import java.util.stream.Collectors;

@Component
public class PersonAgent implements IPersonAgent {
    private final PersonService personService;
    private final PersonConverter personConverter;

    @Autowired
    public PersonAgent(PersonService personService, PersonConverter personConverter) {
        this.personService = personService;
        this.personConverter = personConverter;
    }

    @Override
    public Collection<PeopleModulePerson> getAllPersons() {
        Collection<Person> allPersons = personService.getAllPersons();
        return allPersons.stream().map(personConverter::convert).collect(Collectors.toList());
    }

    @Override
    public PeopleModulePerson getPerson(String id) {
        return personConverter.convert(personService.getPerson(id));
    }

    @Override
    public PeopleModulePerson createPerson(PeopleModulePerson peopleModulePerson) {
        return personConverter.convert(personService.createPerson(personConverter.convert(peopleModulePerson)));
    }

    @Override
    public PeopleModulePerson updatePerson(PeopleModulePerson peopleModulePerson, String id) {
        return personConverter.convert(personService.updatePerson(personConverter.convert(peopleModulePerson), id));
    }

    @Override
    public void deletePerson(String id) {
        personService.deletePerson(id);
    }
}
