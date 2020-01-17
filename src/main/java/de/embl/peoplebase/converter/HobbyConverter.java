package de.embl.peoplebase.converter;

import javax.persistence.AttributeConverter;
import javax.persistence.Converter;
import java.util.Arrays;
import java.util.Collection;

@Converter
public class HobbyConverter implements AttributeConverter<Collection<String>, String> {
    private static final String SPLIT_CHAR = ";";

    @Override
    public String convertToDatabaseColumn(Collection<String> hobbies) {
        if (hobbies == null) {
            return null;
        }
        return String.join(SPLIT_CHAR, hobbies);
    }

    @Override
    public Collection<String> convertToEntityAttribute(String hobbyString) {
        return Arrays.asList(hobbyString.split(SPLIT_CHAR));
    }
}
