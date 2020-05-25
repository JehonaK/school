package com.school.service;

import com.school.dto.TeacherToSubjectAssignmentDto;
import com.school.entity.Subject;

import java.util.List;

public interface SubjectService {
    void assignTeacherToSubject(TeacherToSubjectAssignmentDto assignmentDto);

    List<Subject> getSubjectsByLevelId(String levelId);

}
