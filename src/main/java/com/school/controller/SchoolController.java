package com.school.controller;

import com.school.entity.School;
import com.school.exception.ResponseException;
import com.school.service.SchoolServiceImpl;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("school")
public class SchoolController {

    private SchoolServiceImpl schoolService;

    public SchoolController(SchoolServiceImpl schoolService) {
        this.schoolService = schoolService;
    }

    @GetMapping
    public School getSchoolBySchoolAdminId() {
        return schoolService.getSchoolBySchoolAdminId();
    }

    @PostMapping
    public School create(@RequestBody School school){
        try {
            return schoolService.save(school);
        } catch (Exception e) {
            throw new ResponseException(e.getMessage(), HttpStatus.BAD_REQUEST);
        }
    }

    @PutMapping("{id}")
    public Map<String, String> update(@RequestBody School school, @PathVariable String id) throws ResponseException {
        Map<String, String> responseMap = new HashMap<>();
        try {
            schoolService.update(school, id);
            responseMap.put("id", id);
        } catch (Exception e) {
            throw new ResponseException(e.getMessage(), HttpStatus.BAD_REQUEST);
        }
        return responseMap;
    }

    @GetMapping("{schoolId}")
    public School getById(@PathVariable String schoolId) {
        return schoolService.findById(schoolId);
    }

    @DeleteMapping("{id}")
    public void remove(@PathVariable String id) throws ResponseException {
        try {
            schoolService.remove(id);
        } catch (Exception e) {
            throw new ResponseException(e.getMessage(), HttpStatus.BAD_REQUEST);
        }
    }

}
