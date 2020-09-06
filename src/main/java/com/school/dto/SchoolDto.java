package com.school.dto;

import com.school.annotations.ApiEntity;

import java.sql.Timestamp;
import java.util.List;

@ApiEntity
public class SchoolDto extends DtoEntity {

    private String name;
    private String address;
    private String city;
    private String schoolType;
    private UserDto schoolAdmin;
    private List<LevelDto> levels;

    public SchoolDto() {
    }

    public SchoolDto(String id, Timestamp createDateTime) {
        super(id, createDateTime);
    }

    public SchoolDto(String id, Timestamp createDateTime, String name, String address, String city, String schoolType, UserDto schoolAdmin, List<LevelDto> levels) {
        super(id, createDateTime);
        this.name = name;
        this.address = address;
        this.city = city;
        this.schoolType = schoolType;
        this.schoolAdmin = schoolAdmin;
        this.levels = levels;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getSchoolType() {
        return schoolType;
    }

    public void setSchoolType(String schoolType) {
        this.schoolType = schoolType;
    }

    public UserDto getSchoolAdmin() {
        return schoolAdmin;
    }

    public void setSchoolAdmin(UserDto schoolAdmin) {
        this.schoolAdmin = schoolAdmin;
    }

    public List<LevelDto> getLevels() {
        return levels;
    }

    public void setLevels(List<LevelDto> levels) {
        this.levels = levels;
    }

}
