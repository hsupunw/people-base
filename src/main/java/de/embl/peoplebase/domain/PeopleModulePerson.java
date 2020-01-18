package de.embl.peoplebase.domain;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import de.embl.peoplebase.constants.ExampleValues;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import org.springframework.hateoas.core.Relation;

import java.util.Collection;

@Data
@JsonPropertyOrder({"id", "first_name", "last_name", "age", "favourite_colour", "hobby"})
@Relation(collectionRelation = "persons")
public class PeopleModulePerson {
    @ApiModelProperty(hidden = true)
    private String id;
    @ApiModelProperty(required = true, notes = "first name of the person", example = ExampleValues.FIRST_NAME)
    @JsonProperty("first_name")
    private String firstName;
    @ApiModelProperty(notes = "last name of the person", example = ExampleValues.LAST_NAME)
    @JsonProperty("last_name")
    private String lastName;
    @ApiModelProperty(notes = "age of the person in years", example = ExampleValues.AGE)
    private Integer age;
    @ApiModelProperty(notes = "favourite colour of the person", example = ExampleValues.FAVOURITE_COLOUR)
    @JsonProperty("favourite_colour")
    private String favouriteColour;
    @ApiModelProperty(notes = "hobbies of the person", example = ExampleValues.HOBBIES)
    private Collection<String> hobby;
}
