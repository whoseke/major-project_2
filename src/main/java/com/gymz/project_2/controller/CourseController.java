package com.gymz.project_2.controller;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;

import com.gymz.project_2.domain.Course;
import com.gymz.project_2.service.CourseService;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class CourseController {
    private final CourseService courseService;

    public CourseController(CourseService courseService) {
        this.courseService = courseService;
    }

    @GetMapping("/create/course")
    public String createCourse(Model model) {
        model.addAttribute("newCourse", new Course());

        return "admin/user/employee/create/course";
    }

    @PostMapping("/create/createCourse")
    public String getCourse(Model model, @ModelAttribute("newCourse") Course course) {

        this.courseService.handleSaveCousrse(course);
        return "redirect:/info/course";
    }

    @GetMapping("/info/course")
    public String showCourse(Model model) {
        List<Course> courses = this.courseService.getAllCourse();

        model.addAttribute("courses", courses);
        return "admin/user/employee/show/course";
    }

    @GetMapping("/update/course/{id}")
    public String getUpdateCourse(Model model, @PathVariable long id) {

        Course currentCourse = this.courseService.getCourseByID(id);
        model.addAttribute("newCourse", currentCourse);

        return "admin/user/employee/update/course";
    }

    @PostMapping("/update/course")
    public String setUpdateCourse(Model model, @ModelAttribute("newCourse") Course currentCourse) {

        Course newCourse = this.courseService.getCourseByID(currentCourse.getCourse_id());
        if (newCourse != null) {
            newCourse.setName(currentCourse.getName());
            newCourse.setDuration(currentCourse.getDuration());
            newCourse.setPrice(currentCourse.getPrice());
            newCourse.setStart_date(currentCourse.getStart_date());
            newCourse.setEnd_date(currentCourse.getEnd_date());
        }
        this.courseService.handleSaveCousrse(newCourse);
        return "redirect:/info/course";
    }

    @GetMapping("/delete/course/{id}")
    public String deleteCourse(Model model, @PathVariable long id) {
        this.courseService.deleteCourseByID(id);
        return "redirect:/info/course";
    }

}