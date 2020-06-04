package com.school.service;

import com.school.dto.LevelDto;
import com.school.entity.Level;
import com.school.entity.School;
import com.school.entity.SchoolClass;
import com.school.repository.BaseRepository;
import com.school.repository.LevelRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.NoSuchElementException;

@Service
public class LevelServiceImpl extends BaseServiceImpl<Level, String> implements LevelService {

    private LevelRepository levelRepository;
    private SchoolServiceImpl schoolService;

    public LevelServiceImpl(BaseRepository<Level, String> baseRepository, LevelRepository levelRepository, SchoolServiceImpl schoolService) {
        super(baseRepository);
        this.levelRepository = levelRepository;
        this.schoolService = schoolService;
    }

    @Override
    public List<Level> getLevelsBySchoolId(String schoolId) {
        School school = schoolService.findById(schoolId);
        if (school == null) {
            throw new NoSuchElementException("School with ID " + schoolId + " has not been found!");
        }
        return school.getLevels();
    }

    public Level createLevel(LevelDto levelDto) {
        Level level = new Level();
        level.setSchool(this.schoolService.getSchoolBySchoolId(levelDto.getSchoolId()));
        level.setName(levelDto.getName());
        level = levelRepository.save(level);
        level.setSchoolClasses(levelDto.getSchoolClasses());
        for (SchoolClass schoolClass : level.getSchoolClasses()) {
            schoolClass.setLevel(level);
        }
        return levelRepository.save(level);
    }

    public Level update(LevelDto levelDto, String id) {
        Level level = this.levelRepository.findById(id).get();
        level.setSchool(this.schoolService.getSchoolBySchoolId(levelDto.getSchoolId()));
        level.setName(levelDto.getName());
        return this.levelRepository.save(level);
    }

    @Override
    public void remove(String id) {
        Level level = this.levelRepository.findById(id).get();
        level.getSchool().getLevels().remove(level);
        level.setSchool(null);
        this.levelRepository.deleteById(id);
    }

    public Level getLevelById(String levelId) {
        return levelRepository.findById(levelId).orElse(null);
    }

}
