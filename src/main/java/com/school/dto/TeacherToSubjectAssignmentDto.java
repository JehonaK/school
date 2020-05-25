package com.school.dto;

import java.util.List;

public class TeacherToSubjectAssignmentDto extends DtoEntity {

    private String email;
    private List<String> schoolClassIdList;
    private String subjectId;

    public TeacherToSubjectAssignmentDto(String email, List<String> schoolClassIdList, String subjectId) {
        this.email = email;
        this.schoolClassIdList = schoolClassIdList;
        this.subjectId = subjectId;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public List<String> getSchoolClassIdList() {
        return schoolClassIdList;
    }

    public void setSchoolClassIdList(List<String> schoolClassIdList) {
        this.schoolClassIdList = schoolClassIdList;
    }

    public String getSubjectId() {
        return subjectId;
    }

    public void setSubjectId(String subjectId) {
        this.subjectId = subjectId;
    }

}
