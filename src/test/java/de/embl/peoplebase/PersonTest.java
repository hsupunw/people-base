package de.embl.peoplebase;

import de.embl.peoplebase.domain.PeopleModulePerson;
import de.embl.peoplebase.entity.Person;
import org.jeasy.random.EasyRandom;
import org.jeasy.random.EasyRandomParameters;

import java.util.Collection;
import java.util.stream.Collectors;

import static org.junit.Assert.assertEquals;

public class PersonTest {
    private static final int TEST_COLLECTION_SIZE = 3;
    private final EasyRandomParameters easyRandomParameters = new EasyRandomParameters();
    private final EasyRandom easyRandom = new EasyRandom(easyRandomParameters);

    protected Person createRandomPerson() {
        return easyRandom.nextObject(Person.class);
    }

    protected Collection<Person> createRandomPersonCollection() {
        return easyRandom.objects(Person.class, TEST_COLLECTION_SIZE).collect(Collectors.toList());
    }

    protected PeopleModulePerson createRandomPeopleModulePerson() {
        return easyRandom.nextObject(PeopleModulePerson.class);
    }

    protected void assertPerson(Person expect, Person real) {
        assertEquals(expect.getId(), real.getId());
        assertEquals(expect.getFirstName(), real.getFirstName());
        assertEquals(expect.getLastName(), real.getLastName());
        assertEquals(expect.getAge(), real.getAge());
        assertEquals(expect.getFavouriteColour(), real.getFavouriteColour());
        assertEquals(expect.getHobby(), real.getHobby());
    }

    protected void assertPeoplePerson(PeopleModulePerson expect, Person real) {
        assertEquals(expect.getId(), real.getId());
        assertEquals(expect.getFirstName(), real.getFirstName());
        assertEquals(expect.getLastName(), real.getLastName());
        assertEquals(expect.getAge(), real.getAge());
        assertEquals(expect.getFavouriteColour(), real.getFavouriteColour());
        assertEquals(expect.getHobby(), real.getHobby());
    }

    protected void assertPersonPeople(Person expect, PeopleModulePerson real) {
        assertEquals(expect.getId(), real.getId());
        assertEquals(expect.getFirstName(), real.getFirstName());
        assertEquals(expect.getLastName(), real.getLastName());
        assertEquals(expect.getAge(), real.getAge());
        assertEquals(expect.getFavouriteColour(), real.getFavouriteColour());
        assertEquals(expect.getHobby(), real.getHobby());
    }
}
