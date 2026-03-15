package org.theMungai.Student;

import jakarta.validation.constraints.NotEmpty;

public record StudentDTO(

        @NotEmpty(message = "Firstname should not be empty")
        String firstname,

        @NotEmpty(message = "Lastname should not be empty")
        String lastname,

        @NotEmpty(message = "Email should not be empty")
        String email,

        Long schoolId
) {
}
