package com.school.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.school.annotations.ApiEntity;
import lombok.Data;
import org.hibernate.boot.jaxb.hbm.internal.CacheAccessTypeConverter;

import javax.persistence.*;

@Data
@Entity
@ApiEntity
public class User extends BaseEntity<String> {

    @Column(name = "first_name")
    private String firstName;

    @Column(name = "last_name")
    private String lastName;

    @Column(name = "email")
    private String email;

    @Column(name = "role")
    private String role;

    @OneToOne(mappedBy = "schoolAdmin", fetch = FetchType.LAZY)
    @JsonIgnore
    private School school;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "school_class_id")
    private SchoolClass schoolClassId;

    public User() {

    }

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

    @Override
    public String toString() {
        return "";
    }

}
