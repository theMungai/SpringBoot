package org.theMungai.School;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class SchoolController {

    private final SchoolService service;

    public SchoolController(SchoolService service) {
        this.service = service;
    }


    @PostMapping("/schools")
    public SchoolDTO create(@RequestBody SchoolDTO dto){
        return service.create(dto);
    }


    @GetMapping("/schools")
    public List<SchoolDTO> getSchools(){
        return service.getSchools();
    }
}
