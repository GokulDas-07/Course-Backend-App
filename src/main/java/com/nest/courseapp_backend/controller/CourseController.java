package com.nest.courseapp_backend.controller;

import com.nest.courseapp_backend.dao.CourseDao;
import com.nest.courseapp_backend.model.Course;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class CourseController {
    @Autowired
    private CourseDao dao;
    @CrossOrigin(origins = "*")
    @GetMapping("/")
    public String HomePage()
    {
        return "welcome";
    }
    @CrossOrigin(origins = "*")
    @PostMapping(path="/add",consumes = "application/json",produces = "application/json")
    public String AddCourse(@RequestBody Course c)
    {
        System.out.println("title: "+c.getTitle().toString());
        System.out.println("description: "+c.getDescription().toString());
        System.out.println("venue: "+c.getVenue().toString());
        System.out.println("duration: "+c.getDuration().toString());
        System.out.println("date: "+c.getDate().toString());
        dao.save(c);
        return "Course added";
    }
    @CrossOrigin(origins = "*")
    @GetMapping("/view")
    public List<Course> ViewCourses()
    {
        return (List<Course>)dao.findAll();
    }

    @CrossOrigin(origins = "*")
    @PostMapping(path = "/search",consumes = "application/json",produces = "application/json")
    public List<Course> searchCourse(@RequestBody Course c)
    {
        String title=c.getTitle().toString();
        System.out.println(title);
        return (List<Course>) dao.searchCourse(c.getTitle());
    }

}
