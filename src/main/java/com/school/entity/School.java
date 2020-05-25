package com.school.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.sql.Date;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class School extends BaseEntity<String>{

    private String name;
    private String address;
    private String city;
    private String schoolType;
    private Date schoolCreationDate;
    private User schoolAdmin;

    @OneToMany(mappedBy = "school", fetch = FetchType.LAZY)
    private List<Level> levels;

    public School(String id, String name, String address, String city, String schoolType, Date schoolCreationDate, User schoolAdmin) {
        super(id);
        this.name = name;
        this.address = address;
        this.city = city;
        this.schoolType = schoolType;
        this.schoolCreationDate = schoolCreationDate;
        this.schoolAdmin = schoolAdmin;
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

    public Date getSchoolCreationDate() {
        return schoolCreationDate;
    }

    public void setSchoolCreationDate(Date schoolCreationDate) {
        this.schoolCreationDate = schoolCreationDate;
    }

    public User getSchoolAdmin() {
        return schoolAdmin;
    }

    public void setSchoolAdmin(User schoolAdmin) {
        this.schoolAdmin = schoolAdmin;
    }

    public List<Level> getLevels() {
        return levels;
    }

    public void setLevels(List<Level> levels) {
        this.levels = levels;
    }

}
