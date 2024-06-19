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

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

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

    @GetMapping("/create/session")
    public String createSession(Model model) {
        List<Course> course = courseService.getAllCourse();
        List<Pt> pt = ptService.getAllPt();

        model.addAttribute("course", course);
        model.addAttribute("pt", pt);
        model.addAttribute("newSession", new Session());

        return "admin/user/employee/create/pt/session";
    }

    @PostMapping(value = "/create/createSession")
    public String getSession(Model model, @ModelAttribute("newSession") Session session) {

        this.sessionService.handleSaveSession(session);
        return "redirect:/info/session";
    }

    @GetMapping("/info/session")
    public String showSession(Model model) {
        List<Session> sessions = this.sessionService.getAllSession();

        model.addAttribute("sessions", sessions);
        return "admin/user/employee/show/pt/session";
    }

    @GetMapping("/update/session/{id}")
    public String getUpdateSession(Model model, @PathVariable long id) {
        List<Course> course = courseService.getAllCourse();
        List<Pt> pt = ptService.getAllPt();

        Session currentSession = this.sessionService.getSessionByID(id);
        model.addAttribute("course", course);
        model.addAttribute("pt", pt);
        model.addAttribute("newSession", currentSession);

        return "admin/user/employee/update/pt/session";
    }

    @PostMapping("/update/session")
    public String setUpdateSession(Model model, @ModelAttribute("newSession") Session currentSession) {

        Session newSession = this.sessionService.getSessionByID(currentSession.getSession_id());
        if (newSession != null) {
            newSession.setSession_Date(currentSession.getSession_Date());
            newSession.setCourse(currentSession.getCourse());
            newSession.setPt(currentSession.getPt());
            newSession.setStart_time(currentSession.getStart_time());
            newSession.setEnd_time(currentSession.getEnd_time());
            this.sessionService.handleSaveSession(newSession);
        }

        return "redirect:/info/session";
    }

    @GetMapping("/delete/session/{id}")
    public String deleteSession(Model model, @PathVariable long id) {
        this.sessionService.deleteSessionById(id);
        return "redirect:/info/session";
    }

}
