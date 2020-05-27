package com.school.entity;

import com.school.type.SubjectType;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@Entity
public class Subject extends BaseEntity<String>{

    @Column(name = "name")
    private String name;

    @Column(name = "description")
    private String description;

    @Column(name = "subject_type")
    private SubjectType subjectType;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "level_id")
    private Level level;

    public Subject() {

    }

    public Subject(String id, String name, String description, SubjectType subjectType) {
        super(id);
        this.name = name;
        this.description = description;
        this.subjectType = subjectType;
    }

    public Subject(String id, String name, String description, SubjectType subjectType, Level level) {
        super(id);
        this.name = name;
        this.description = description;
        this.subjectType = subjectType;
        this.level = level;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public SubjectType getSubjectType() {
        return subjectType;
    }

    public void setSubjectType(SubjectType subjectType) {
        this.subjectType = subjectType;
    }

    public Level getLevel() {
        return level;
    }

    public void setLevel(Level level) {
        this.level = level;
    }

}
