package com.gymz.project_2.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.gymz.project_2.domain.Course;

public interface CourseRepository extends JpaRepository<Course, Long> {
    Course save(Course course);
}
