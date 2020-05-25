package com.school.entity;

import javax.persistence.*;

@Entity
@Table(name = "user")
public class User extends BaseEntity<String> {

    private String firstName;
    private String lastName;
    private String email;
    private String role;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "school_class_id")
    private SchoolClass schoolClassId;

    public User(String id, String firstName, String lastName, String email, String role) {
        super(id);
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.role = role;
    }

    public User(String id, String firstName, String lastName, String email, String role, SchoolClass schoolClassId) {
        super(id);
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.role = role;
        this.schoolClassId = schoolClassId;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public SchoolClass getSchoolClassId() {
        return schoolClassId;
    }

    public void setSchoolClassId(SchoolClass schoolClassId) {
        this.schoolClassId = schoolClassId;
    }

}
