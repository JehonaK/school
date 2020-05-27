package com.school.service;

import com.school.entity.SchoolClass;
import com.school.entity.User;
import com.school.repository.BaseRepository;
import com.school.repository.SchoolClassRepository;
import com.school.repository.UserRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.NoSuchElementException;

@Service
public class UserServiceImpl extends BaseServiceImpl<User, String> implements UserService {

    private UserRepository userRepository;
    private SchoolClassRepository schoolClassRepository;

    public UserServiceImpl(BaseRepository<User, String> baseRepository, UserRepository userRepository, SchoolClassRepository schoolClassRepository) {
        super(baseRepository);
        this.userRepository = userRepository;
        this.schoolClassRepository = schoolClassRepository;
    }

    @Override
    public User findUserByEmail(String email) {
        return userRepository.findByEmail(email);
    }

    @Override
    public List<User> getStudentsBySchoolClassId(String schoolClassId) {
        SchoolClass schoolClass = schoolClassRepository.findById(schoolClassId).orElseThrow(() -> new NoSuchElementException("Class Not found!"));
        if(schoolClass == null) {
            throw new NoSuchElementException("School Class with ID " + schoolClassId + " not found!");
        }
        return schoolClass.getStudents();
    }

}
