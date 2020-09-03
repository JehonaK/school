package com.school.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.school.type.ClassStatus;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;

@Data
@Entity
public class SchoolClass extends BaseEntity<String>{

    @Column(name = "name")
    private String name;

    @Column(name = "class_status")
    private ClassStatus classStatus;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "level_id")
    @JsonIgnore
    private Level level;

    @JsonIgnore
    @OneToMany(mappedBy = "schoolClassId", fetch = FetchType.LAZY)
    private List<User> students;

    public SchoolClass() {

    }

    public SchoolClass(String id, String name, ClassStatus classStatus, Level level) {
        super(id);
        this.name = name;
        this.classStatus = classStatus;
        this.level = level;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public ClassStatus getClassStatus() {
        return classStatus;
    }

    public void setClassStatus(ClassStatus classStatus) {
        this.classStatus = classStatus;
    }

    public Level getLevel() {
        return level;
    }

    public void setLevel(Level level) {
        this.level = level;
    }

    public List<User> getStudents() {
        return students;
    }

    public void setStudents(List<User> students) {
        this.students = students;
    }

    @Override
    public String toString() {
        return "";
    }
}
