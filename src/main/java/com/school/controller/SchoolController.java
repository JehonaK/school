package com.school.controller;

import com.school.entity.School;
import com.school.exeption.ResponseException;
import com.school.service.SchoolServiceImpl;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("school")
public class SchoolController {

    private SchoolServiceImpl schoolServiceImpl;

    public SchoolController(SchoolServiceImpl schoolService) {
        this.schoolServiceImpl = schoolService;
    }

    @PostMapping
    public School create(@RequestBody School school){
        try {
            return schoolServiceImpl.save(school);
        } catch (Exception e) {
            throw new ResponseException(e.getMessage(), HttpStatus.BAD_REQUEST);
        }
    }

    @PutMapping("{id}")
    public Map<String, String> update(@RequestBody School school, @PathVariable String id) throws ResponseException {
        Map<String, String> responseMap = new HashMap<>();
        try {
            schoolServiceImpl.update(school, id);
            responseMap.put("id", id);
        } catch (Exception e) {
            throw new ResponseException(e.getMessage(), HttpStatus.BAD_REQUEST);
        }
        return responseMap;
    }

    @GetMapping("{schoolId}")
    public School getById(@PathVariable String schoolId) {
        return schoolServiceImpl.findById(schoolId);
    }

    @DeleteMapping("{id}")
    public void remove(@PathVariable String id) throws ResponseException {
        try {
            schoolServiceImpl.remove(id);
        } catch (Exception e) {
            throw new ResponseException(e.getMessage(), HttpStatus.BAD_REQUEST);
        }
    }

    @GetMapping
    public List<School> findAllSorted(@RequestParam(required = false, defaultValue = "ASC") String direction, @RequestParam(defaultValue = "id") String... properties) throws ResponseException {
        try {
            return schoolServiceImpl.findAllSorted(direction, properties);
        } catch (Exception e) {
            throw new ResponseException(e.getMessage(), HttpStatus.BAD_REQUEST);
        }
    }
}
