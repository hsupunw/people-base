package de.embl.peoplebase.hateoas;

import de.embl.peoplebase.controller.PersonController;
import de.embl.peoplebase.domain.PeopleModulePerson;
import org.springframework.hateoas.Resource;
import org.springframework.hateoas.ResourceAssembler;
import org.springframework.stereotype.Component;

import static org.springframework.hateoas.mvc.ControllerLinkBuilder.linkTo;
import static org.springframework.hateoas.mvc.ControllerLinkBuilder.methodOn;

@Component
public class PersonResourceAssembler implements ResourceAssembler<PeopleModulePerson, Resource<PeopleModulePerson>> {
    @Override
    public Resource<PeopleModulePerson> toResource(PeopleModulePerson peopleModulePerson) {
        return new Resource<>(
                peopleModulePerson,
                linkTo(methodOn(PersonController.class).person(peopleModulePerson.getId())).withSelfRel(),
                linkTo(methodOn(PersonController.class).allPersons()).withRel("employees"));
    }
}
