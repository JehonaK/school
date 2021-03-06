package com.school.controller;

import com.school.entity.User;
import com.school.service.UserServiceImpl;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("user")
public class UserController extends BaseController {

    private UserServiceImpl userService;

    public UserController(UserServiceImpl userService) {
        this.userService = userService;
    }

    @GetMapping
    public List<User> getStudentsBySchoolClassId(@RequestParam("schoolClassId") String schoolClassId) {
        return userService.getStudentsBySchoolClassId(schoolClassId);
    }

}
