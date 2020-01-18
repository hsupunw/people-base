package de.embl.peoplebase.hateoas;

import de.embl.peoplebase.controller.PersonController;
import de.embl.peoplebase.domain.PeopleModulePerson;
import org.springframework.hateoas.Resource;
import org.springframework.hateoas.ResourceAssembler;
import org.springframework.hateoas.Resources;
import org.springframework.stereotype.Component;

import java.util.Collection;

import static org.springframework.hateoas.mvc.ControllerLinkBuilder.linkTo;
import static org.springframework.hateoas.mvc.ControllerLinkBuilder.methodOn;

@Component
public class PersonListResourceAssembler implements ResourceAssembler<Collection<Resource<PeopleModulePerson>>, Resources<Resource<PeopleModulePerson>>> {
    @Override
    public Resources<Resource<PeopleModulePerson>> toResource(Collection<Resource<PeopleModulePerson>> employees) {
        return new Resources<>(
                employees,
                linkTo(methodOn(PersonController.class).allPersons()).withRel("employees").withSelfRel());
    }
}
