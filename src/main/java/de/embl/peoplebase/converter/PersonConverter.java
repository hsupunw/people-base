package de.embl.peoplebase.converter;

import de.embl.peoplebase.domain.PeopleModulePerson;
import de.embl.peoplebase.entity.Person;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

@Component
public class PersonConverter {
    private ModelMapper modelMapper = new ModelMapper();

    public PeopleModulePerson convert(Person person) {
        return modelMapper.map(person, PeopleModulePerson.class);
    }

    public Person convert(PeopleModulePerson peopleModulePerson) {
        return modelMapper.map(peopleModulePerson, Person.class);
    }
}
