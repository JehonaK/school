package com.school.service;

import com.school.entity.Level;
import com.school.entity.School;
import com.school.repository.BaseRepository;
import com.school.repository.LevelRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.NoSuchElementException;

@Service
public class LevelServiceImpl extends BaseServiceImpl<Level, String> implements LevelService{

    private LevelRepository levelRepository;
    private SchoolServiceImpl schoolService;

    public LevelServiceImpl(BaseRepository<Level, String> baseRepository, LevelRepository levelRepository, SchoolServiceImpl schoolService) {
        super(baseRepository);
        this.levelRepository = levelRepository;
        this.schoolService = schoolService;
    }

    @Override
    public List<Level> getLevelsBySchoolId(String schoolId) {
        School school =  schoolService.findById(schoolId);
        if(school == null) {
            throw new NoSuchElementException("School with ID " + schoolId + " has not been found!");
        }
        return school.getLevels();
    }

}
