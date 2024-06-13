package com.gymz.project_2.controller;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import com.gymz.project_2.domain.Course;
import com.gymz.project_2.service.CourseService;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class CourseController {
    private final CourseService courseService;

    public CourseController(CourseService courseService) {
        this.courseService = courseService;
    }

    @RequestMapping("/create/course")
    public String createCourse(Model model) {
        model.addAttribute("newCourse", new Course());

        return "create/course";
    }

    @RequestMapping(value = "/create/createCourse", method = RequestMethod.POST)
    public String getCourse(Model model, @ModelAttribute("newCourse") Course course) {

        this.courseService.handleSaveCousrse(course);
        return "redirect:/show/course";
    }

    @RequestMapping("/info/course")
    public String showCourse(Model model) {
        List<Course> courses = this.courseService.getAllCourse();

        model.addAttribute("courses", courses);
        return "/show/course";
    }
}
