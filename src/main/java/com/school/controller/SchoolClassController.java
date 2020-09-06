package com.school.controller;

import com.school.dto.SchoolClassDto;
import com.school.dto.StudentToClassAssignmentDto;
import com.school.dto.mapper.SchoolClassMapper;
import com.school.entity.SchoolClass;
import com.school.entity.User;
import com.school.exception.ResponseException;
import com.school.service.SchoolClassServiceImpl;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("schoolClass")
public class SchoolClassController extends BaseController {
    private SchoolClassServiceImpl schoolClassService;

    public SchoolClassController(SchoolClassServiceImpl schoolClassService) {
        this.schoolClassService = schoolClassService;
    }

    @PostMapping
    public SchoolClass create(@RequestBody SchoolClassDto schoolClassDto) {
        try {
            return schoolClassService.create(schoolClassDto);
        } catch (Exception e) {
            throw new ResponseException(e.getMessage(), HttpStatus.BAD_REQUEST);
        }
    }

    @PutMapping("{id}")
    public SchoolClass update(@RequestBody SchoolClass schoolClass, @PathVariable String id) throws ResponseException {
        try {
            return schoolClassService.update(schoolClass, id);
        } catch (Exception e) {
            throw new ResponseException(e.getMessage(), HttpStatus.BAD_REQUEST);
        }
    }

    @GetMapping("{schoolClassId}")
    public SchoolClassDto getById(@PathVariable String schoolClassId) {
        return SchoolClassMapper.toDto(schoolClassService.findById(schoolClassId));
    }

    @GetMapping
    public List<SchoolClass> getSchoolClassesByLevelId(@RequestParam("levelId") String levelId) {
        return schoolClassService.getSchoolClassesByLevelId(levelId);
    }

    @DeleteMapping("{id}")
    public void remove(@PathVariable String id) throws ResponseException {
        try {
            schoolClassService.remove(id);
        } catch (Exception e) {
            throw new ResponseException(e.getMessage(), HttpStatus.BAD_REQUEST);
        }
    }

    @PostMapping("student")
    public User addStudentToClass(@RequestBody StudentToClassAssignmentDto assignmentDto) {
        return schoolClassService.assignStudentToClass(assignmentDto);
    }

}
