package com.gymz.project_2.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.gymz.project_2.domain.Course;

@Repository
public interface CourseRepository extends JpaRepository<Course, Long> {
    Course save(Course course);

    Course findById(long id);

    void deleteById(long id);
}
