package com.school.controller;

import com.school.dto.SubjectDto;
import com.school.dto.TeacherToSubjectAssignmentDto;
import com.school.dto.mapper.SubjectObjectMapper;
import com.school.entity.Subject;
import com.school.exception.ResponseException;
import com.school.service.SubjectServiceImpl;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("subject")
public class SubjectController {

    private SubjectServiceImpl subjectServiceImpl;

    public SubjectController(SubjectServiceImpl subjectService) {
        this.subjectServiceImpl = subjectService;
    }

    @PostMapping
    public Subject create(@RequestBody SubjectDto subjectDto) {
        try {
            return subjectServiceImpl.createSubject(subjectDto);
        } catch (Exception e) {
            throw new ResponseException(e.getMessage(), HttpStatus.BAD_REQUEST);
        }
    }

    @PutMapping("{id}")
    public Subject update(@RequestBody Subject subject, @PathVariable String id) throws ResponseException {
        try {
            return subjectServiceImpl.update(subject, id);
        } catch (Exception e) {
            throw new ResponseException(e.getMessage(), HttpStatus.BAD_REQUEST);
        }
    }

    @GetMapping("{subjectId}")
    public SubjectDto getById(@PathVariable String subjectId) {
        return SubjectObjectMapper.toDto(subjectServiceImpl.findById(subjectId));
    }

    @GetMapping
    public List<Subject> getSubjectsByLevelId(@RequestParam("levelId") String levelId) {
        return subjectServiceImpl.getSubjectsByLevelId(levelId);
    }

    @DeleteMapping("{id}")
    public void remove(@PathVariable String id) throws ResponseException {
        try {
            subjectServiceImpl.remove(id);
        } catch (Exception e) {
            throw new ResponseException(e.getMessage(), HttpStatus.BAD_REQUEST);
        }
    }

    @PutMapping("assignment")
    public void assignTeacherToSubject(@RequestBody TeacherToSubjectAssignmentDto assignmentDto) {
        subjectServiceImpl.assignTeacherToSubject(assignmentDto);
    }

//    @GetMapping
//    public List<Subject> findAllSorted(@RequestParam(required = false, defaultValue = "ASC") String direction, @RequestParam(defaultValue = "id") String... properties) throws ResponseException {
//        try {
//            return subjectServiceImpl.findAllSorted(direction, properties);
//        } catch (Exception e) {
//            throw new ResponseException(e.getMessage(), HttpStatus.BAD_REQUEST);
//        }
//    }

}
