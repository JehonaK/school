package com.school.service;

import com.school.dto.SubjectDto;
import com.school.dto.TeacherToSubjectAssignmentDto;
import com.school.entity.Level;
import com.school.entity.SchoolClass;
import com.school.entity.Subject;
import com.school.entity.User;
import com.school.repository.BaseRepository;
import com.school.repository.SubjectRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.stream.Collectors;

@Service
public class SubjectServiceImpl extends BaseServiceImpl<Subject, String> implements SubjectService {

    private SubjectRepository subjectRepository;
    private SchoolClassServiceImpl schoolClassService;
    private UserServiceImpl userService;
    private LevelServiceImpl levelService;
//    private TeacherSubjectConnectionProducer producer;

    public SubjectServiceImpl(BaseRepository<Subject, String> baseRepository, SubjectRepository subjectRepository, SchoolClassServiceImpl schoolClassService,
                              UserServiceImpl userService, LevelServiceImpl levelService/*, TeacherSubjectConnectionProducer producer*/) {
        super(baseRepository);
        this.subjectRepository = subjectRepository;
        this.schoolClassService = schoolClassService;
        this.userService = userService;
        this.levelService = levelService;
//        this.producer = producer;
    }

    @Override
    public void assignTeacherToSubject(TeacherToSubjectAssignmentDto assignmentDto) {
        Subject subject = findById(assignmentDto.getSubjectId());
        if (subject == null) {
            throw new RuntimeException("Subject not found!");
        }
        List<SchoolClass> schoolClasses = new ArrayList<>();
        for (String schoolClassId : assignmentDto.getSchoolClassIdList()) {
            SchoolClass schoolClass = schoolClassService.findById(schoolClassId);
            if (schoolClass == null) {
                throw new RuntimeException("SchoolClass not found!");
            }
            schoolClasses.add(schoolClass);
        }
        User teacher = userService.findUserByEmail(assignmentDto.getTeacherEmail());
        if (teacher == null) {
            throw new RuntimeException("Teacher not found!");
        }
        String courseName = subject.getName() + " - " + subject.getLevel().getName();
        List<User> students = new ArrayList<>();
        for (SchoolClass schoolClass : schoolClasses) {
            students.addAll(schoolClass.getStudents());
        }
        ArrayList<String> studentIdList = (ArrayList<String>) students.stream().map(User::getId).collect(Collectors.toList());
        // producer.sendTeacherSubjectConnection(new SerializableTeacherSubjectConnection(courseName, teacher.getId(), studentIdList));
        // notify teacher by email
    }

    @Override
    public List<Subject> getSubjectsByLevelId(String levelId) {
        Level level = levelService.findById(levelId);
        if (level == null) {
            throw new NoSuchElementException("Level with ID " + levelId + " not found!");
        }
        return level.getSubjects();
    }

    public Subject createSubject(SubjectDto subjectDto) {
        Subject subject = new Subject();

        subject.setDescription(subjectDto.getDescription());
        Level level = levelService.findById(subjectDto.getLevelId());
        if (level == null) {
            throw new RuntimeException("Level not found!");
        }
        subject.setLevel(level);

        subject.setName(subjectDto.getName());
        subject.setSubjectType(subjectDto.getSubjectType());

        return subjectRepository.save(subject);
    }

    @Override
    public void remove(String id) {
//        Subject subject = this.subjectRepository.findById(id).get();
//        subject.getLevel().getSubjects().remove(subject);
//        subject.setLevel(null);
        subjectRepository.deleteById(id);
    }

//    @Override
//    public Subject update(Subject subject, String id) {
//        Subject old = this.subjectRepository.findById(id).get();
//        old.setName(subject.getName());
//        old.setSubjectType(subject.getSubjectType());
//        old.setDescription(subject.getDescription());
//
//        return this.subjectRepository.save(old);
//    }
}
