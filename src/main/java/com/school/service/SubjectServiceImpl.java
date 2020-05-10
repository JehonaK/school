package com.school.service;

import com.school.entity.Subject;
import com.school.repository.BaseRepository;
import com.school.repository.SubjectRepository;
import org.springframework.stereotype.Service;

@Service
public class SubjectServiceImpl extends BaseServiceImpl<Subject, String> implements SubjectService{
    private SubjectRepository subjectRepository;

    public SubjectServiceImpl(BaseRepository<Subject, String> baseRepository, SubjectRepository subjectRepository) {
        super(baseRepository);
        this.subjectRepository = subjectRepository;
    }
}
