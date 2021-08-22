package com.sms.secondhomework.controller;

import com.sms.secondhomework.model.Course;
import com.sms.secondhomework.service.CourseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class CourseController {
    CourseService courseService;

    @Autowired
    public CourseController(CourseService courseService){
        this.courseService=courseService;
    }

    @GetMapping("/courses")
    public ResponseEntity<List<Course>> findCourses(){
        return new ResponseEntity<>(courseService.findAll(), HttpStatus.OK);
    }
//finds all courses
    @GetMapping("/courses/{id}")
    public ResponseEntity<Course> findCoursesById(@PathVariable int id){
        return new ResponseEntity<>(courseService.findById(id),HttpStatus.OK);
    }
//find a course with id
    @PostMapping("/courses")
    public ResponseEntity<Course> saveCourse(@RequestBody Course course){
        return new ResponseEntity<>(courseService.save(course),HttpStatus.CREATED);
    }
// save to database a new object
    @PutMapping("/courses")
    public ResponseEntity<Course> updateCourse(@RequestBody Course course){
        return new ResponseEntity<>(courseService.update(course),HttpStatus.OK);
    }
// updates course
    @DeleteMapping("/courses/{id}")
    public ResponseEntity<String> deleteCourseById(@PathVariable int id){
        courseService.deletebyId(id);
        return new ResponseEntity<>("Deleted...",HttpStatus.OK);
    }
// delete with id
    @DeleteMapping("/courses")
    public ResponseEntity<String> deleteCourse(@RequestBody Course course){
        courseService.delete(course);
        return new ResponseEntity<>("Deleted...",HttpStatus.OK);
    }
    //delete an object
}
