package com.zafar.course.CourseApp;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@RestController
public class CourseController {

    @Autowired
    private CourseRepository courseRepository;

    @RequestMapping("/")
    public String getCourseAppHHome() {

        return ("Course App Home");
    }

    @RequestMapping("/courses")
    public List<Course> getCourses() {
        return courseRepository.findAll();
    }


    @RequestMapping("/courses/{id}")
    public Course getSpecificCourse(@PathVariable("id") BigInteger id) {

        return courseRepository.getOne(id);
    }

    @RequestMapping(method = RequestMethod.POST, value = "/courses")
    public void saveCourse(@RequestBody Course course) {
        courseRepository.save(course);
    }

    @RequestMapping(method = RequestMethod.PUT, value = "/courses/{id}")
    public void updateCourse(@RequestBody Course course) {
        courseRepository.save(course);
    }

    @RequestMapping(method = RequestMethod.DELETE, value = "/courses/{id}")
    public void deleteCourse(@PathVariable BigInteger id) {
        courseRepository.deleteById(id);
    }
}
