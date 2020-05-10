package com.school.entity;

import com.school.type.SubjectType;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Subject extends BaseEntity<String>{
    private String name;
    private String description;
    private SubjectType subjectType;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "level_id")
    private Level level;
}
