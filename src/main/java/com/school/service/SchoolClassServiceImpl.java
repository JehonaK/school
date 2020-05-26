package com.school.service;

import com.school.dto.StudentToClassAssignmentDto;
import com.school.entity.Level;
import com.school.entity.SchoolClass;
import com.school.entity.User;
import com.school.integration.models.SerializableNotification;
import com.school.integration.producers.NotificationProducer;
import com.school.repository.BaseRepository;
import com.school.repository.SchoolRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class SchoolClassServiceImpl extends BaseServiceImpl<SchoolClass, String> implements SchoolClassService {

    private SchoolRepository schoolRepository;
    private UserServiceImpl userService;
    private LevelServiceImpl levelService;
    private NotificationProducer notificationProducer;

    public SchoolClassServiceImpl(BaseRepository<SchoolClass, String> baseRepository, SchoolRepository schoolRepository, UserServiceImpl userService,
                                  LevelServiceImpl levelService, NotificationProducer notificationProducer) {
        super(baseRepository);
        this.schoolRepository = schoolRepository;
        this.userService = userService;
        this.levelService = levelService;
        this.notificationProducer = notificationProducer;
    }

    @Override
    public List<SchoolClass> getBatchOfSchoolClasses(List<String> schoolClassIdList) {
        return schoolRepository.getBatchOfSchoolClasses(schoolClassIdList);
    }

    @Override
    public void assignStudentToClass(StudentToClassAssignmentDto assignmentDto) {
        User student = userService.findUserByEmail(assignmentDto.getEmail());
        SchoolClass schoolClass = findById(assignmentDto.getSchoolClassId());
        student.setSchoolClassId(schoolClass);
        userService.save(student);
        notificationProducer.sendNotification(new SerializableNotification("You have been added to the class" + schoolClass.getName(),
                        (ArrayList<String>) schoolClass.getStudents().stream().map(User::getId).collect(Collectors.toList())));
        // notify by email
        // notify course for new student to class
    }

    @Override
    public List<SchoolClass> getSchoolClassesByLevelId(String levelId) {
        return levelService.findById(levelId).getSchoolClasses();
    }

}
