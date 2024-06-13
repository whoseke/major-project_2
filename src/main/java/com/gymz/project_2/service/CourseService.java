package com.gymz.project_2.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.gymz.project_2.domain.Course;
import com.gymz.project_2.repository.CourseRepository;

@Service
public class CourseService {
    private final CourseRepository courseRepository;

    public CourseService(CourseRepository courseRepository) {
        this.courseRepository = courseRepository;
    }

    public Course handleSaveCousrse(Course course) {
        return this.courseRepository.save(course);
    }

    public List<Course> getAllCourse() {
        return this.courseRepository.findAll();
    }
}
