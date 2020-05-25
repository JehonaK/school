package com.school.service;

import com.school.entity.Level;

import java.util.List;

public interface LevelService {

    List<Level> getLevelsBySchoolId(String schoolId);

}
