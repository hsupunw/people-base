package de.embl.peoplebase.converter;

import de.embl.peoplebase.PersonTest;
import de.embl.peoplebase.domain.PeopleModulePerson;
import de.embl.peoplebase.entity.Person;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
@RunWith(MockitoJUnitRunner.class)
public class PersonConverterTest extends PersonTest {
    private PersonConverter personConverter;

    @Before
    public void setUp() throws Exception {
        personConverter = new PersonConverter();
    }

    @Test
    public void convert() {
        Person person = createRandomPerson();
        PeopleModulePerson peopleModulePerson = personConverter.convert(person);
        assertPersonPeople(person, peopleModulePerson);
    }

    @Test
    public void testConvert() {
        PeopleModulePerson randomPeopleModulePerson = createRandomPeopleModulePerson();
        Person person = personConverter.convert(randomPeopleModulePerson);
        assertPeoplePerson(randomPeopleModulePerson, person);
    }
}