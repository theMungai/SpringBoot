package org.theMungai;

public record StudentDTO(
        String firstname,
        String lastname,
        String email,
        Long schoolId
) {
}
