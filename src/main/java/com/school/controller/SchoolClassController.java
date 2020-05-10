package com.school.controller;

import com.school.entity.SchoolClass;
import com.school.exeption.ResponseException;
import com.school.service.SchoolClassServiceImpl;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

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

//    @GetMapping
//    public List<SchoolClass> findAllSorted(@RequestParam(required = false, defaultValue = "ASC") String direction, @RequestParam(defaultValue = "id") String... properties) throws ResponseException {
//        try {
//            return schoolClassService.findAllSorted(direction, properties);
//        } catch (Exception e) {
//            throw new ResponseException(e.getMessage(), HttpStatus.BAD_REQUEST);
//        }
//    }

    @GetMapping
    public List<SchoolClass> findAll() throws ResponseException {
        try {
            return schoolClassService.findAll();
        } catch (Exception e) {
            throw new ResponseException(e.getMessage(), HttpStatus.BAD_REQUEST);
        }
    }
}
