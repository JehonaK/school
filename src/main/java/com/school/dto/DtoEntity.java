package com.school.dto;

import java.sql.Timestamp;

public abstract class DtoEntity {

    private String id;
    private Timestamp createDateTime;

    public DtoEntity() {
    }

    public DtoEntity(String id, Timestamp createDateTime) {
        this.id = id;
        this.createDateTime = createDateTime;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Timestamp getCreateDateTime() {
        return createDateTime;
    }

    public void setCreateDateTime(Timestamp createDateTime) {
        this.createDateTime = createDateTime;
    }

}
