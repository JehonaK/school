package com.school.service;

import com.school.dto.SchoolClassDto;
import com.school.dto.StudentToClassAssignmentDto;
import com.school.entity.SchoolClass;
import com.school.entity.User;
import com.school.repository.BaseRepository;
import com.school.repository.SchoolClassRepository;
import com.school.repository.SchoolRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SchoolClassServiceImpl extends BaseServiceImpl<SchoolClass, String> implements SchoolClassService {

    private SchoolRepository schoolRepository;
    private UserServiceImpl userService;
    private LevelServiceImpl levelService;
    //    private NotificationProducer notificationProducer;
    private SchoolClassRepository schoolClassRepository;

    public SchoolClassServiceImpl(BaseRepository<SchoolClass, String> baseRepository, SchoolRepository schoolRepository, UserServiceImpl userService,
                                  LevelServiceImpl levelService/*, NotificationProducer notificationProducer*/, SchoolClassRepository schoolClassRepository) {
        super(baseRepository);
        this.schoolRepository = schoolRepository;
        this.userService = userService;
        this.levelService = levelService;
//        this.notificationProducer = notificationProducer;
        this.schoolClassRepository = schoolClassRepository;
    }

    @Override
    public List<SchoolClass> getBatchOfSchoolClasses(List<String> schoolClassIdList) {
        return schoolClassRepository.getBatchOfSchoolClasses(schoolClassIdList);
    }

    @Override
    public User assignStudentToClass(StudentToClassAssignmentDto assignmentDto) {
        User student = userService.findUserByEmail(assignmentDto.getEmail());
        SchoolClass schoolClass = findById(assignmentDto.getSchoolClassId());
        student.setSchoolClassId(schoolClass);
        userService.save(student);
//        notificationProducer.sendNotification(new SerializableNotification("You have been added to the class" + schoolClass.getName(),
//                        (ArrayList<String>) schoolClass.getStudents().stream().map(User::getId).collect(Collectors.toList())));
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
        schoolClass.setLevel(this.levelService.getLevelById(schoolClassDto.getLevelId()));

        return this.schoolClassRepository.save(schoolClass);
    }

    @Override
    public void remove(String id){
        SchoolClass old = schoolClassRepository.findById(id).get();
        old.getLevel().getSchoolClasses().remove(old);
        old.setLevel(null);
        this.schoolClassRepository.deleteById(id);
    }

}
