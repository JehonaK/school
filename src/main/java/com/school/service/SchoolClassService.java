package com.school.service;

import com.school.dto.StudentToClassAssignmentDto;
import com.school.entity.SchoolClass;
import com.school.entity.User;

import java.util.List;

public interface SchoolClassService {

    List<SchoolClass> getBatchOfSchoolClasses(List<String> schoolClassIdList);

    User assignStudentToClass(StudentToClassAssignmentDto assignmentDto);

    List<SchoolClass> getSchoolClassesByLevelId(String levelId);

}
