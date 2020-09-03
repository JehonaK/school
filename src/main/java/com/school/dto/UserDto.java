package com.school.dto;

import java.sql.Timestamp;

public class UserDto extends DtoEntity {

    private String firstName;
    private String lastName;
    private String email;
    private String role;

    public UserDto(String id, Timestamp createDateTime) {
        super(id, createDateTime);
    }

    public UserDto(String id, Timestamp createDateTime, String firstName, String lastName, String email, String role) {
        super(id, createDateTime);
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.role = role;
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

}
