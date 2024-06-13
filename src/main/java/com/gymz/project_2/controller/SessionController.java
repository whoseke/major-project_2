package com.gymz.project_2.controller;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;

import com.gymz.project_2.domain.Course;
import com.gymz.project_2.domain.Pt;
import com.gymz.project_2.domain.Session;
import com.gymz.project_2.service.CourseService;
import com.gymz.project_2.service.PtService;
import com.gymz.project_2.service.SessionService;

import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class SessionController {
    private final SessionService sessionService;
    private final CourseService courseService;
    private final PtService ptService;

    public SessionController(SessionService sessionService, CourseService courseService, PtService ptService) {
        this.sessionService = sessionService;
        this.courseService = courseService;
        this.ptService = ptService;
    }

    @RequestMapping("/create/session")
    public String createSession(Model model) {
        List<Course> course = courseService.getAllCourse();
        List<Pt> pt = ptService.getAllPt();

        model.addAttribute("course", course);
        model.addAttribute("pt", pt);
        model.addAttribute("newSession", new Session());

        return "/create/session";
    }

    @RequestMapping(value = "/create/createSession", method = RequestMethod.POST)
    public String getSession(Model model, @ModelAttribute("newSession") Session session) {
        this.sessionService.handleSaveSession(session);
        return "redirect:/info/session";
    }

    @RequestMapping("/info/session")
    public String showSession(Model model) {
        List<Session> sessions = this.sessionService.getAllSession();

        model.addAttribute("sessions", sessions);
        return "/show/session";
    }

}
