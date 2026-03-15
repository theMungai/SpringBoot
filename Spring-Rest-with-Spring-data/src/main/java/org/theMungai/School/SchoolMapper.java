package org.theMungai.School;

import org.springframework.stereotype.Component;

@Component
public class SchoolMapper {

    public School toSchool(SchoolDTO dto){
        return new School(dto.name());
    }

    public SchoolDTO toSchoolDTO(School school){
        return new SchoolDTO(school.getName());
    }
}
