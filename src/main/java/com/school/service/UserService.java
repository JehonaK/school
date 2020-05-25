package com.school.service;

import com.school.entity.User;

import java.util.List;

public interface UserService {

    User findUserByEmail(String email);

    List<User> getStudentsBySchoolClassId(String schoolClassId);

}
