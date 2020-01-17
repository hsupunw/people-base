package de.embl.peoplebase.agent;

import de.embl.peoplebase.domain.PeopleModulePerson;

import java.util.Collection;

public interface IPersonAgent {
    Collection<PeopleModulePerson> getAllPersons();

    PeopleModulePerson getPerson(String id);

    PeopleModulePerson createPerson(PeopleModulePerson peopleModulePerson);

    PeopleModulePerson updatePerson(PeopleModulePerson peopleModulePerson, String id);

    void deletePerson(String id);
}
