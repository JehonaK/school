package com.school.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.school.annotations.ApiEntity;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.sql.Date;
import java.util.List;

@Data
@Entity
@ApiEntity
public class School extends BaseEntity<String>{

    @Column(name = "name")
    private String name;

    @Column(name = "address")
    private String address;

    @Column(name = "city")
    private String city;

    @Column(name = "school_type")
    private String schoolType;

    @Column(name = "school_creation_date")
    private Date schoolCreationDate;

    @OneToOne
    @JoinColumn(name = "school_admin")
    private User schoolAdmin;

    @JsonIgnore
    @OneToMany(mappedBy = "school", fetch = FetchType.LAZY)
    private List<Level> levels;

    public School() {

    }

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

    @Override
    public String toString() {
        return "";
    }
}
