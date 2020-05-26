package com.school.entity;

import com.school.type.RecordStatus;
import lombok.*;
import org.hibernate.annotations.*;

import javax.persistence.*;
import java.sql.Timestamp;

@MappedSuperclass
@Data
@NoArgsConstructor
public abstract class BaseEntity<T> {
    @Id
    private T id;

    @Enumerated(EnumType.STRING)
    private RecordStatus recordStatus = RecordStatus.ACTIVE;

    @CreationTimestamp
    private Timestamp createDateTime;

    @UpdateTimestamp
    private Timestamp updateDateTime;

    private Timestamp deletedDateTime;

    private String createdByUserId;

    private String updatedByUserId;

    @Column(length = 1000)
    private String note;

    public BaseEntity() {

    }

    public BaseEntity(T id) {
        this.id = id;
    }

    public T getId() {
        return id;
    }

    public void setId(T id) {
        this.id = id;
    }
}