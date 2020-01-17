package de.embl.peoplebase.exception;

public class PersonNotFoundException extends RuntimeException {
    public PersonNotFoundException(String id) {
        super("Could not find person with id " + id);
    }
}
