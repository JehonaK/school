package com.school.service;

import com.school.dto.TeacherToSubjectAssignmentDto;
import com.school.entity.Level;
import com.school.entity.SchoolClass;
import com.school.entity.Subject;
import com.school.entity.User;
import com.school.integration.models.SerializableTeacherSubjectConnection;
import com.school.integration.producers.TeacherSubjectConnectionProducer;
import com.school.repository.BaseRepository;
import com.school.repository.SubjectRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.stream.Collectors;

@Service
public class SubjectServiceImpl extends BaseServiceImpl<Subject, String> implements SubjectService{

    private SubjectRepository subjectRepository;
    private SchoolClassServiceImpl schoolClassService;
    private UserServiceImpl userService;
    private LevelServiceImpl levelService;
    private TeacherSubjectConnectionProducer producer;

    public SubjectServiceImpl(BaseRepository<Subject, String> baseRepository, SubjectRepository subjectRepository, SchoolClassServiceImpl schoolClassService,
                              UserServiceImpl userService, LevelServiceImpl levelService, TeacherSubjectConnectionProducer producer) {
        super(baseRepository);
        this.subjectRepository = subjectRepository;
        this.schoolClassService = schoolClassService;
        this.userService = userService;
        this.levelService = levelService;
        this.producer = producer;
    }

    @Override
    public void assignTeacherToSubject(TeacherToSubjectAssignmentDto assignmentDto) {
        Subject subject = findById(assignmentDto.getSubjectId());
        List<SchoolClass> schoolClasses = new ArrayList<>();
        for(String schoolClassId : assignmentDto.getSchoolClassIdList()) {
            schoolClasses.add(schoolClassService.findById(schoolClassId));
        }
        User teacher = userService.findUserByEmail(assignmentDto.getEmail());
        String courseName = subject.getName() + " - " + subject.getLevel();
        List<User> students = new ArrayList<>();
        for(SchoolClass schoolClass : schoolClasses) {
            students.addAll(schoolClass.getStudents());
        }
        ArrayList<String> studentIdList = (ArrayList<String>) students.stream().map(User::getId).collect(Collectors.toList());
        producer.sendTeacherSubjectConnection(new SerializableTeacherSubjectConnection(courseName, teacher.getId(), studentIdList));
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
