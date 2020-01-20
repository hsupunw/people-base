package de.embl.peoplebase.entity;

import de.embl.peoplebase.converter.HobbyConverter;
import lombok.Data;
import org.hibernate.annotations.UpdateTimestamp;
import org.hibernate.envers.Audited;

import javax.persistence.*;
import java.util.Collection;
import java.util.Date;

@Entity
@Audited
@Data
public class Person {
    @Id
    private String id;
    @Temporal(TemporalType.TIMESTAMP)
    @Column(nullable = false)
    private Date created;
    @Temporal(TemporalType.TIMESTAMP)
    @UpdateTimestamp
    private Date modified;
    @Column(nullable = false)
    private String firstName;
    private String lastName;
    private Integer age;
    private String favouriteColour;
    @Convert(converter = HobbyConverter.class)
    @Column(length = 3000)
    private Collection<String> hobby;
}
