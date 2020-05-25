package com.school.service;

import com.school.dto.TeacherToSubjectAssignmentDto;
import com.school.entity.Level;
import com.school.entity.SchoolClass;
import com.school.entity.Subject;
import com.school.entity.User;
import com.school.repository.BaseRepository;
import com.school.repository.SubjectRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.NoSuchElementException;

@Service
public class SubjectServiceImpl extends BaseServiceImpl<Subject, String> implements SubjectService{

    private SubjectRepository subjectRepository;
    private SchoolClassServiceImpl schoolClassService;
    private UserServiceImpl userService;
    private LevelServiceImpl levelService;

    public SubjectServiceImpl(BaseRepository<Subject, String> baseRepository, SubjectRepository subjectRepository, SchoolClassServiceImpl schoolClassService,
                              UserServiceImpl userService, LevelServiceImpl levelService) {
        super(baseRepository);
        this.subjectRepository = subjectRepository;
        this.schoolClassService = schoolClassService;
        this.userService = userService;
        this.levelService = levelService;
    }

    @Override
    public void assignTeacherToSubject(TeacherToSubjectAssignmentDto assignmentDto) {
        Subject subject = findById(assignmentDto.getSubjectId());
        List<SchoolClass> schoolClasses = schoolClassService.getBatchOfSchoolClasses(assignmentDto.getSchoolClassIdList());
        User teacher = userService.findUserByEmail(assignmentDto.getEmail());
        // send the data to course service
        // notify teacher by email
    }

    @Override
    public List<Subject> getSubjectsByLevelId(String levelId) {
        Level level = levelService.findById(levelId);
        if(level == null) {
            throw new NoSuchElementException("Level with ID " + levelId + " not found!");
        }
        return level.getSubjects();
    }

}
