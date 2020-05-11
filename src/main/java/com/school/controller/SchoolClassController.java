package com.school.controller;

import com.school.entity.SchoolClass;
import com.school.exeption.ResponseException;
import com.school.service.SchoolClassServiceImpl;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("schoolClass")
public class SchoolClassController {
    private SchoolClassServiceImpl schoolClassService;

    public SchoolClassController(SchoolClassServiceImpl schoolClassService) {
        this.schoolClassService = schoolClassService;
    }

    @PostMapping
    public SchoolClass create(@RequestBody SchoolClass schoolClass) {
        try{
            return schoolClassService.save(schoolClass);
        } catch (Exception e) {
            throw new ResponseException(e.getMessage(), HttpStatus.BAD_REQUEST);
        }
    }

    @PutMapping("{id}")
    public Map<String, String> update(@RequestBody SchoolClass schoolClass, @PathVariable String id) throws ResponseException {
        Map<String, String> responseMap = new HashMap<>();
        try {
            schoolClassService.update(schoolClass, id);
            responseMap.put("id", id);
        } catch (Exception e) {
            throw new ResponseException(e.getMessage(), HttpStatus.BAD_REQUEST);
        }
        return responseMap;
    }

    @GetMapping("{schoolClassId}")
    public SchoolClass getById(@PathVariable String schoolClassId) {
        return schoolClassService.findById(schoolClassId);
    }

    @DeleteMapping("{id}")
    public void remove(@PathVariable String id) throws ResponseException {
        try {
            schoolClassService.remove(id);
        } catch (Exception e) {
            throw new ResponseException(e.getMessage(), HttpStatus.BAD_REQUEST);
        }
    }

    @GetMapping
    public List<SchoolClass> findAllSorted(@RequestParam(required = false, defaultValue = "ASC") String direction, @RequestParam(defaultValue = "id") String... properties) throws ResponseException {
        try {
            return schoolClassService.findAllSorted(direction, properties);
        } catch (Exception e) {
            throw new ResponseException(e.getMessage(), HttpStatus.BAD_REQUEST);
        }
    }
}
