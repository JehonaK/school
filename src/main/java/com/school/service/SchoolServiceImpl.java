package com.school.service;

import com.school.entity.School;
import com.school.entity.User;
import com.school.repository.BaseRepository;
import com.school.repository.SchoolRepository;
import org.springframework.stereotype.Service;

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
    public School getSchoolBySchoolAdminId(String schoolAdminId) {
        User schoolAdmin = userService.findById(schoolAdminId);
        return schoolRepository.findBySchoolAdmin(schoolAdmin);
    }

}
