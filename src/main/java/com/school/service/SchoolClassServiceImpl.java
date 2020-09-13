package com.school.service;

import com.school.dto.SchoolClassDto;
import com.school.dto.StudentToClassAssignmentDto;
import com.school.entity.Level;
import com.school.entity.SchoolClass;
import com.school.entity.User;
import com.school.integration.models.SerializableNotification;
import com.school.integration.producers.NotificationProducer;
import com.school.repository.BaseRepository;
import com.school.repository.SchoolClassRepository;
import com.school.repository.SchoolRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class SchoolClassServiceImpl extends BaseServiceImpl<SchoolClass, String> implements SchoolClassService {

    private SchoolRepository schoolRepository;
    private UserServiceImpl userService;
    private LevelServiceImpl levelService;
    private NotificationProducer notificationProducer;
    private SchoolClassRepository schoolClassRepository;

    public SchoolClassServiceImpl(BaseRepository<SchoolClass, String> baseRepository, SchoolRepository schoolRepository, UserServiceImpl userService,
                                  LevelServiceImpl levelService, NotificationProducer notificationProducer, SchoolClassRepository schoolClassRepository) {
        super(baseRepository);
        this.schoolRepository = schoolRepository;
        this.userService = userService;
        this.levelService = levelService;
        this.notificationProducer = notificationProducer;
        this.schoolClassRepository = schoolClassRepository;
    }

    @Override
    public List<SchoolClass> getBatchOfSchoolClasses(List<String> schoolClassIdList) {
        return schoolClassRepository.getBatchOfSchoolClasses(schoolClassIdList);
    }

    @Override
    public User assignStudentToClass(StudentToClassAssignmentDto assignmentDto) {
        User student = userService.findUserByEmail(assignmentDto.getStudentEmail());
        if (student == null) {
            throw new RuntimeException("Student not found");
        }
        SchoolClass schoolClass = findById(assignmentDto.getSchoolClassId());
        if (schoolClass == null) {
            throw new RuntimeException("SchoolClass not found!");
        }
        student.setSchoolClassId(schoolClass);
        userService.save(student);
        List<String> recipients = new ArrayList<>();
        recipients.add(student.getId());
        notificationProducer.sendNotification(new SerializableNotification("You have been added to the class" + schoolClass.getName(), (ArrayList<String>) recipients));
        // notify by email
        // notify course for new student to class
        return student;
    }

    @Override
    public List<SchoolClass> getSchoolClassesByLevelId(String levelId) {
        return levelService.findById(levelId).getSchoolClasses();
    }

    public SchoolClass create(SchoolClassDto schoolClassDto) {
        SchoolClass schoolClass = new SchoolClass();
        schoolClass.setClassStatus(schoolClassDto.getClassStatus());
        schoolClass.setName(schoolClassDto.getName());

        Level level = levelService.findById(schoolClassDto.getLevelId());
        if (level == null) {
            throw new RuntimeException("Level not found!");
        }
        schoolClass.setLevel(this.levelService.getLevelById(schoolClassDto.getLevelId()));

        return schoolClassRepository.save(schoolClass);
    }

    @Override
    public void remove(String id){
        SchoolClass old = findById(id);
        List<User> students = old.getStudents();
        for (User student : students) {
            student.setSchoolClassId(null);
            userService.save(student);
        }
        schoolClassRepository.deleteById(id);
    }

}
