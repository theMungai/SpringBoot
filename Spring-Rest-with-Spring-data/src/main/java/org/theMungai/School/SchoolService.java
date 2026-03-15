package org.theMungai.School;

import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class SchoolService {

    private final SchoolRepository repository;

    private final SchoolMapper schoolMapper;

    public SchoolService(SchoolRepository repository, SchoolMapper schoolMapper) {
        this.repository = repository;
        this.schoolMapper = schoolMapper;
    }

    public SchoolDTO create(SchoolDTO dto){
        var school = schoolMapper.toSchool(dto);
        repository.save(school);
        return dto;
    }

    public List<SchoolDTO> getSchools(){
        return repository.findAll()
                .stream()
                .map(schoolMapper::toSchoolDTO)
                .collect(Collectors.toList());
    }
}
