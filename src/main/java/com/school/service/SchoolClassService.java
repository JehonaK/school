package com.school.service;

import com.school.dto.StudentToClassAssignmentDto;
import com.school.entity.SchoolClass;

import java.util.List;

public interface SchoolClassService {

    List<SchoolClass> getBatchOfSchoolClasses(List<String> schoolClassIdList);

    void assignStudentToClass(StudentToClassAssignmentDto assignmentDto);

    List<SchoolClass> getSchoolClassesByLevelId(String levelId);

}
