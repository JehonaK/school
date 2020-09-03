package com.school.service;

import com.school.PerRequestIdStorage;
import com.school.entity.School;
import com.school.entity.User;
import com.school.repository.BaseRepository;
import com.school.repository.SchoolRepository;
import org.springframework.stereotype.Service;

import java.sql.Date;

@Service
public class SchoolServiceImpl extends BaseServiceImpl<School, String> implements SchoolService {

    private SchoolRepository schoolRepository;
    private UserServiceImpl userService;

    public SchoolServiceImpl(BaseRepository<School, String> baseRepository, SchoolRepository schoolRepository, UserServiceImpl userService) {
        super(baseRepository);
        this.schoolRepository = schoolRepository;
        this.userService = userService;
    }

    @Override
    public School save(School school) {
        User schoolAdmin = userService.findById(PerRequestIdStorage.getUserId());
        school.setSchoolAdmin(schoolAdmin);
        school.setSchoolCreationDate(new Date(System.currentTimeMillis()));
        return schoolRepository.save(school);
    }

    @Override
    public School getSchoolBySchoolAdminId() {
        User schoolAdmin = userService.findById(PerRequestIdStorage.getUserId());
        return schoolRepository.findBySchoolAdmin(schoolAdmin);
    }

    public School getSchoolBySchoolId(String schoolId) {
        return schoolRepository.findById(schoolId).orElse(null);
    }

    @Override
    public void remove(String id){
        this.schoolRepository.deleteById(id);
    }

}
