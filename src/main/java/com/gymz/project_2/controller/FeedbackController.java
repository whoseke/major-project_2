package com.gymz.project_2.controller;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.gymz.project_2.domain.Course;
import com.gymz.project_2.domain.Feedback;
import com.gymz.project_2.domain.Member;
import com.gymz.project_2.service.CourseService;
import com.gymz.project_2.service.FeedbackService;
import com.gymz.project_2.service.MemberService;

@Controller
public class FeedbackController {
    private final FeedbackService feedbackService;
    private final MemberService memberService;
    private final CourseService courseService;

    public FeedbackController(FeedbackService feedbackService, MemberService memberService,
            CourseService courseService) {
        this.feedbackService = feedbackService;
        this.memberService = memberService;
        this.courseService = courseService;
    }

    @RequestMapping("/create/feedback")
    public String createFeedback(Model model) {
        List<Member> member = memberService.getAllMember();
        List<Course> course = courseService.getAllCourse();

        model.addAttribute("course", course);
        model.addAttribute("member", member);
        model.addAttribute("newFeedback", new Feedback());
        return "/create/feedback";
    }

    @RequestMapping(value = "/create/createFeedback", method = RequestMethod.POST)
    public String getFeedback(Model model, @ModelAttribute("newFeedback") Feedback feedback) {
        this.feedbackService.handleSaveFeedback(feedback);
        return "redirect:/feedback";
    }

    @RequestMapping("/feedback")
    public String showFeedback(Model model) {
        List<Feedback> feedbacks = this.feedbackService.getAllFeedback();

        model.addAttribute("feedbacks", feedbacks);
        return "/show/feedback";
    }
}
