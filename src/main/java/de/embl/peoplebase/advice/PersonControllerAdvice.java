package de.embl.peoplebase.advice;

import de.embl.peoplebase.exception.PersonNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

@ControllerAdvice
public class PersonControllerAdvice {
    @ResponseBody
    @ExceptionHandler(PersonNotFoundException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    public Error handlePersonNotFound(PersonNotFoundException ex) {
        return new Error(ex.getMessage());
    }
}
