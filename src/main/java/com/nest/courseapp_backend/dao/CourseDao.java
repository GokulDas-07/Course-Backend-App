package com.nest.courseapp_backend.dao;

import com.nest.courseapp_backend.model.Course;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface CourseDao extends CrudRepository<Course,Integer> {
    @Query(value = "SELECT `id`, `date`, `description`, `duration`, `title`, `venue` FROM `course` WHERE `title`= :title",nativeQuery = true)
    List<Course> searchCourse(@Param("title") String title);
}
