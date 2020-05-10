package com.school.service;

import com.school.entity.School;
import com.school.repository.BaseRepository;
import com.school.repository.SchoolRepository;
import org.springframework.stereotype.Service;

@Service
public class SchoolServiceImpl extends BaseServiceImpl<School, String> implements SchoolService{
    private SchoolRepository schoolRepository;

    public SchoolServiceImpl(BaseRepository<School, String> baseRepository, SchoolRepository schoolRepository) {
        super(baseRepository);
        this.schoolRepository = schoolRepository;
    }
}
