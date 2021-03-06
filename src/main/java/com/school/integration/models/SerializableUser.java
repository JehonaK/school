package com.school.integration.models;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.io.Serializable;

public final class SerializableUser implements Serializable {

    private final String id;
    private final String firstName;
    private final String lastName;
    private String email;
    private final String role;

    public SerializableUser(@JsonProperty("id") String id,
                            @JsonProperty("firstName") String firstName,
                            @JsonProperty("lastName") String lastName,
                            @JsonProperty("email") String email,
                            @JsonProperty("role") String role) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.role = role;
    }

    public String getId() {
        return id;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getEmail() {
        return email;
    }

    public String getRole() {
        return role;
    }

    @Override
    public String toString() {
        return "SerializableUser{" +
                "id='" + id + '\'' +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", email='" + email + '\'' +
                ", role='" + role + '\'' +
                '}';
    }

}
