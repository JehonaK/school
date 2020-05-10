package com.school.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Level extends BaseEntity<String>{
    private String name;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "school_id")
    private School school;

    @OneToMany(mappedBy = "level", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private List<SchoolClass> schoolClasses;

    @OneToMany(mappedBy = "level", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private List<Subject> subjects;
}
