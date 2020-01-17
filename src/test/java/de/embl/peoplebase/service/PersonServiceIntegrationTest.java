package de.embl.peoplebase.service;

import de.embl.peoplebase.PersonTest;
import de.embl.peoplebase.entity.Person;
import de.embl.peoplebase.exception.PersonNotFoundException;
import de.embl.peoplebase.repository.PersonRepository;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Collection;
import java.util.List;

import static org.junit.Assert.assertEquals;

@DataJpaTest
@RunWith(SpringRunner.class)
@TestPropertySource(locations = "classpath:test.properties")
public class PersonServiceIntegrationTest extends PersonTest {
    private static final String RANDOM_ID = "randomId";
    private final Person randomPerson1 = createRandomPerson();
    private final Person randomPerson2 = createRandomPerson();
    private final Person randomPerson3 = createRandomPerson();
    @Autowired
    private TestEntityManager testEntityManager;
    @Autowired
    private PersonRepository personRepository;
    private PersonService personService;

    @Before
    public void setUp() throws Exception {
        personService = new PersonService(personRepository);
        testEntityManager.persist(randomPerson1);
        testEntityManager.persist(randomPerson2);
    }

    @Test
    public void getAllPersons() {
        Collection<Person> allPersonsReturned = personService.getAllPersons();
        assertEquals(2, allPersonsReturned.size());
        assertPerson(randomPerson1, ((List<Person>) allPersonsReturned).get(0));
        assertPerson(randomPerson2, ((List<Person>) allPersonsReturned).get(1));
    }

    @Test(expected = PersonNotFoundException.class)
    public void getPerson() {
        Person personReturned = personService.getPerson(randomPerson1.getId());
        assertPerson(randomPerson1, personReturned);
        personService.getPerson(RANDOM_ID);
    }

    @Test
    public void createPerson() {
        randomPerson3.setId(null);
        Person personReturned = personService.createPerson(randomPerson3);
        randomPerson3.setId(personReturned.getId());
        assertPerson(randomPerson3, personReturned);
        assertPerson(personReturned, personService.getPerson(personReturned.getId()));
    }

    @Test(expected = PersonNotFoundException.class)
    public void updatePerson() {
        randomPerson3.setId(null);
        Person personReturned = personService.updatePerson(randomPerson3, randomPerson1.getId());
        randomPerson3.setId(randomPerson1.getId());
        assertPerson(randomPerson3, personReturned);
        assertPerson(personReturned, personService.getPerson(randomPerson1.getId()));
        personService.getPerson(RANDOM_ID);
    }

    @Test(expected = PersonNotFoundException.class)
    public void deletePerson() {
        personService.deletePerson(randomPerson1.getId());
        personService.getPerson(randomPerson1.getId());
    }

    @Test(expected = PersonNotFoundException.class)
    public void deletePersonNotExist() {
        personService.deletePerson(RANDOM_ID);
    }
}
