package com.nest.courseapp_backend.controller;

import com.nest.courseapp_backend.model.Course;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CourseController {
    @GetMapping("/")
    public String HomePage()
    {
        return "welcome";
    }

    @PostMapping(path="/add",consumes = "application/json",produces = "application/json")
    public String AddCourse(@RequestBody Course c)
    {
        System.out.println("title: "+c.getTitle().toString());
        System.out.println("description: "+c.getDescription().toString());
        System.out.println("venue: "+c.getVenue().toString());
        System.out.println("duration: "+c.getDuration().toString());
        System.out.println("date: "+c.getDate().toString());
        System.out.println(c.toString());
        return "Course added";
    }

    @GetMapping("/view")
    public String ViewCourses()
    {
        return "Courses view";
    }
}
