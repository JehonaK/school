package com.school.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;

@Data
@Entity
public class Level extends BaseEntity<String>{

    @Column(name = "name")
    private String name;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "school_id")
    @JsonIgnore
    private School school;

    @JsonIgnore
    @OneToMany(mappedBy = "level", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private List<SchoolClass> schoolClasses;

    @JsonIgnore
    @OneToMany(mappedBy = "level", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private List<Subject> subjects;

    public Level() {

    }

    public Level(String id, String name, School school) {
        super(id);
        this.name = name;
        this.school = school;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public School getSchool() {
        return school;
    }

    public void setSchool(School school) {
        this.school = school;
    }

    public List<SchoolClass> getSchoolClasses() {
        return schoolClasses;
    }

    public void setSchoolClasses(List<SchoolClass> schoolClasses) {
        this.schoolClasses = schoolClasses;
    }

    public List<Subject> getSubjects() {
        return subjects;
    }

    public void setSubjects(List<Subject> subjects) {
        this.subjects = subjects;
    }

}
