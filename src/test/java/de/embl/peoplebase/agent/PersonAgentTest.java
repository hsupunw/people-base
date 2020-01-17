package de.embl.peoplebase.agent;

import de.embl.peoplebase.PersonTest;
import de.embl.peoplebase.converter.PersonConverter;
import de.embl.peoplebase.domain.PeopleModulePerson;
import de.embl.peoplebase.entity.Person;
import de.embl.peoplebase.service.PersonService;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Collection;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertSame;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
@SpringBootTest
public class PersonAgentTest extends PersonTest {
    private static final String PERSON_ID = "person_id";
    private final Person person = createRandomPerson();
    private final PeopleModulePerson peopleModulePerson = createRandomPeopleModulePerson();
    @Mock
    private PersonConverter personConverter;
    @Mock
    private PersonService personService;
    private PersonAgent personAgent;

    @Before
    public void setUp() {
        personAgent = new PersonAgent(personService, personConverter);
        when(personConverter.convert(person)).thenReturn(peopleModulePerson);
    }

    @Test
    public void getAllPersons() {
        Collection<Person> personEntityCollection = createRandomPersonCollection();
        when(personService.getAllPersons()).thenReturn(personEntityCollection);
        when(personConverter.convert((Person) any())).thenReturn(peopleModulePerson);
        Collection<PeopleModulePerson> allPersonsReturned = personAgent.getAllPersons();
        assertEquals(3, allPersonsReturned.size());
        assertSame(peopleModulePerson, ((List) allPersonsReturned).get(0));
        assertSame(peopleModulePerson, ((List) allPersonsReturned).get(1));
        assertSame(peopleModulePerson, ((List) allPersonsReturned).get(2));
    }

    @Test
    public void getPerson() {
        when(personService.getPerson(PERSON_ID)).thenReturn(person);
        PeopleModulePerson personReturned = personAgent.getPerson(PERSON_ID);
        assertSame(peopleModulePerson, personReturned);
    }

    @Test
    public void createPerson() {
        when(personService.createPerson(any())).thenReturn(person);
        PeopleModulePerson personReturned = personAgent.createPerson(peopleModulePerson);
        assertSame(peopleModulePerson, personReturned);
    }

    @Test
    public void updatePerson() {
        person.setId(PERSON_ID);
        when(personService.updatePerson(any(), anyString())).thenReturn(person);
        PeopleModulePerson personReturned = personAgent.updatePerson(peopleModulePerson, PERSON_ID);
        assertSame(peopleModulePerson, personReturned);
    }
}