package com.school.controller;

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
    public Subject create(@RequestBody Subject subject){
        try {
            return subjectServiceImpl.save(subject);
        } catch (Exception e) {
            throw new ResponseException(e.getMessage(), HttpStatus.BAD_REQUEST);
        }
    }

    @PutMapping("{id}")
    public Map<String, String> update(@RequestBody Subject subject, @PathVariable String id) throws ResponseException {
        Map<String, String> responseMap = new HashMap<>();
        try {
            subjectServiceImpl.update(subject, id);
            responseMap.put("id", id);
        } catch (Exception e) {
            throw new ResponseException(e.getMessage(), HttpStatus.BAD_REQUEST);
        }
        return responseMap;
    }

    @GetMapping("{subjectId}")
    public Subject getById(@PathVariable String subjectId) {
        return subjectServiceImpl.findById(subjectId);
    }

    @DeleteMapping("{id}")
    public void remove(@PathVariable String id) throws ResponseException {
        try {
            subjectServiceImpl.remove(id);
        } catch (Exception e) {
            throw new ResponseException(e.getMessage(), HttpStatus.BAD_REQUEST);
        }
    }

    @GetMapping
    public List<Subject> findAllSorted(@RequestParam(required = false, defaultValue = "ASC") String direction, @RequestParam(defaultValue = "id") String... properties) throws ResponseException {
        try {
            return subjectServiceImpl.findAllSorted(direction, properties);
        } catch (Exception e) {
            throw new ResponseException(e.getMessage(), HttpStatus.BAD_REQUEST);
        }
    }
}
