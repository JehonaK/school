package com.school.service;

import com.school.entity.SchoolClass;
import com.school.entity.User;
import com.school.repository.BaseRepository;
import com.school.repository.UserRepository;

import java.util.List;
import java.util.NoSuchElementException;

public class UserServiceImpl extends BaseServiceImpl<User, String> implements UserService {

    private UserRepository userRepository;
    private SchoolClassServiceImpl schoolClassService;

    public UserServiceImpl(BaseRepository baseRepository, UserRepository userRepository, SchoolClassServiceImpl schoolClassService) {
        super(baseRepository);
        this.userRepository = userRepository;
        this.schoolClassService = schoolClassService;
    }

    @Override
    public User findUserByEmail(String email) {
        return userRepository.findByEmail(email);
    }

    @Override
    public List<User> getStudentsBySchoolClassId(String schoolClassId) {
        SchoolClass schoolClass = schoolClassService.findById(schoolClassId);
        if(schoolClass == null) {
            throw new NoSuchElementException("School Class with ID " + schoolClassId + " not found!");
        }
        return schoolClass.getStudents();
    }

}
