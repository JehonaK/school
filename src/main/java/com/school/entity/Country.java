package com.school.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Country extends BaseEntity<String>{
    @NotNull
    @NotBlank
    @Column(name = "name", unique = true)
    private String name;

    @OneToMany(mappedBy = "country", fetch = FetchType.LAZY, cascade={CascadeType.PERSIST, CascadeType.REFRESH, CascadeType.MERGE})
    private List<School> schools;
}
