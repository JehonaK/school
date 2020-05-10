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

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "country_id")
    private Country country;

    @OneToMany(mappedBy = "school", fetch = FetchType.LAZY)
    private List<Level> levels;
}
