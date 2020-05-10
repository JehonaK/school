package com.school.entity;

import com.school.type.ClassStatus;
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
public class SchoolClass extends BaseEntity<String>{
    private String name;
    private ClassStatus classStatus;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "level_id")
    private Level level;
}
