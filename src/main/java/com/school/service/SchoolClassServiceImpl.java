package com.school.service;

import com.school.entity.SchoolClass;
import com.school.repository.BaseRepository;
import com.school.repository.SchoolRepository;
import org.springframework.stereotype.Service;

@Service
public class SchoolClassServiceImpl extends BaseServiceImpl<SchoolClass, String> implements SchoolService{
    private SchoolRepository schoolRepository;

    public SchoolClassServiceImpl(BaseRepository<SchoolClass, String> baseRepository, SchoolRepository schoolRepository) {
        super(baseRepository);
        this.schoolRepository = schoolRepository;
    }
}
