package com.school.controller;

import com.school.dto.LevelDto;
import com.school.entity.Level;
import com.school.exception.ResponseException;
import com.school.service.LevelServiceImpl;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("level")
public class LevelController {
    private LevelServiceImpl levelServiceImpl;

    public LevelController(LevelServiceImpl levelService) {
        this.levelServiceImpl = levelService;
    }

    @GetMapping
    public List<Level> getLevelsBySchoolId(@RequestParam("schoolId") String schoolId) {
        return levelServiceImpl.getLevelsBySchoolId(schoolId);
    }

    @PostMapping
    public Level create(@RequestBody LevelDto levelDto) {
        try {
            return levelServiceImpl.createLevel(levelDto);
        } catch (Exception e) {
            throw new ResponseException(e.getMessage(), HttpStatus.BAD_REQUEST);
        }
    }

    @PutMapping("{id}")
    public Map<String, String> update(@RequestBody Level level, @PathVariable String id) throws ResponseException {
        Map<String, String> responseMap = new HashMap<>();
        try {
            levelServiceImpl.update(level, id);
            responseMap.put("id", id);
        } catch (Exception e) {
            throw new ResponseException(e.getMessage(), HttpStatus.BAD_REQUEST);
        }
        return responseMap;
    }

    @GetMapping("{levelId}")
    public Level getById(@PathVariable String levelId) {
        return levelServiceImpl.findById(levelId);
    }

    @DeleteMapping("{id}")
    public void remove(@PathVariable String id) throws ResponseException {
        try {
            levelServiceImpl.remove(id);
        } catch (Exception e) {
            throw new ResponseException(e.getMessage(), HttpStatus.BAD_REQUEST);
        }
    }

}
