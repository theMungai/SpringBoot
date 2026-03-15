package org.theMungai.studentprofile;

import jakarta.persistence.*;
import org.theMungai.Student.Student;

@Entity
public class StudentProfile {

    @Id
    @GeneratedValue
    private Long id;
    private String bio;

    @OneToOne
    @JoinColumn(
            name = "student_id"
    )
    private Student student;

    public StudentProfile() {
    }

    public StudentProfile(String bio) {
        this.bio = bio;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getBio() {
        return bio;
    }

    public void setBio(String bio) {
        this.bio = bio;
    }
}
