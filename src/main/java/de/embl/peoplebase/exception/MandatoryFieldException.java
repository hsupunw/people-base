package de.embl.peoplebase.exception;

public class MandatoryFieldException extends RuntimeException {
    public MandatoryFieldException(String message) {
        super(message);
    }
}
