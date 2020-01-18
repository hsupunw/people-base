package de.embl.peoplebase.controller;

import de.embl.peoplebase.agent.IPersonAgent;
import de.embl.peoplebase.domain.PeopleModulePerson;
import de.embl.peoplebase.hateoas.PersonListResourceAssembler;
import de.embl.peoplebase.hateoas.PersonResourceAssembler;
import io.swagger.annotations.ApiParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.hateoas.Resource;
import org.springframework.hateoas.Resources;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping(path = "/persons", produces = MediaType.APPLICATION_JSON_VALUE)
public class PersonController {

    private final IPersonAgent personAgent;
    private final PersonResourceAssembler resourceAssembler;
    private final PersonListResourceAssembler listResourceAssembler;

    @Autowired
    public PersonController(IPersonAgent personAgent, PersonResourceAssembler resourceAssembler, PersonListResourceAssembler listResourceAssembler) {
        this.personAgent = personAgent;
        this.resourceAssembler = resourceAssembler;
        this.listResourceAssembler = listResourceAssembler;
    }

    @GetMapping
    public Resources<Resource<PeopleModulePerson>> allPersons() {
        List<Resource<PeopleModulePerson>> persons = personAgent.getAllPersons().stream()
                .map(resourceAssembler::toResource)
                .collect(Collectors.toList());
        return listResourceAssembler.toResource(persons);
    }

    @GetMapping("/{id}")
    public Resource<PeopleModulePerson> person(@PathVariable @ApiParam(name = "id", value = "id of the person", required = true, type = "path") String id) {
        return resourceAssembler.toResource(personAgent.getPerson(id));
    }

    @PostMapping
    public Resource<PeopleModulePerson> createPerson(@RequestBody @ApiParam(name = "person", value = "details of the person", required = true, type = "body") PeopleModulePerson peopleModulePerson) {
        return resourceAssembler.toResource(personAgent.createPerson(peopleModulePerson));
    }

    @PutMapping(value = "/{id}")
    public Resource<PeopleModulePerson> updatePerson(@PathVariable @ApiParam(name = "id", value = "id of the person", required = true, type = "path") String id,
                                                     @RequestBody @ApiParam(name = "person", value = "updated details of the person", required = true, type = "body") PeopleModulePerson peopleModulePerson) {
        return resourceAssembler.toResource(personAgent.updatePerson(peopleModulePerson, id));
    }

    @DeleteMapping(value = "/{id}")
    public void deletePerson(@PathVariable @ApiParam(name = "id", value = "id of the person", required = true, type = "path") String id) {
        personAgent.deletePerson(id);
    }
}
