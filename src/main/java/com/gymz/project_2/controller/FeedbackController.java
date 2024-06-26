package com.gymz.project_2.controller;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;

import com.gymz.project_2.domain.Course;
import com.gymz.project_2.domain.Feedback;
import com.gymz.project_2.domain.Member;
import com.gymz.project_2.service.CourseService;
import com.gymz.project_2.service.FeedbackService;
import com.gymz.project_2.service.MemberService;
import org.springframework.web.bind.annotation.PostMapping;

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

    @GetMapping("/feedback")
    public String showFeedback(Model model) {
        List<Feedback> feedbacks = this.feedbackService.getAllFeedback();

        model.addAttribute("feedbacks", feedbacks);
        return "feedback/show_feedback";
    }

    @GetMapping("/update/feedback/{id}")
    public String getUpdateFeedback(Model model, @PathVariable long id) {
        List<Member> member = memberService.getAllMember();
        List<Course> course = courseService.getAllCourse();

        Feedback currentFeedBack = this.feedbackService.getFeedbackByID(id);

        model.addAttribute("course", course);
        model.addAttribute("member", member);
        model.addAttribute("newFeedback", currentFeedBack);
        return "feedback/update_feedback";
    }

    @PostMapping("/update/feedback")
    public String getUpdateFeedback(Model model, @ModelAttribute("newFeedback") Feedback n1) {
        Feedback newFeedBack = this.feedbackService.getFeedbackByID(n1.getFeedback_id());
        if (newFeedBack != null) {
            newFeedBack.setMember(n1.getMember());
            newFeedBack.setCourse(n1.getCourse());
            newFeedBack.setComment(n1.getComment());

            this.feedbackService.handleSaveFeedback(newFeedBack);
        }
        return "redirect:/feedback";
    }

    @GetMapping("/delete/feedback/{id}")
    public String deleteFeedback(Model model, @PathVariable long id) {
        this.feedbackService.deleteFeedbackById(id);
        return "redirect:/info/feedback";
    }

    // member_role
    @GetMapping("/member/create/feedback")
    public String createFeedbackbyMember(Model model) {
        List<Member> member = memberService.getAllMember();
        List<Course> course = courseService.getAllCourse();
        model.addAttribute("course", course);
        model.addAttribute("member", member);
        model.addAttribute("newFeedback", new Feedback());
        return "layout/member/feedback/create_feedback";
    }

    @PostMapping(value = "/member/create/createFeedback")
    public String getFeedbackbyMember(Model model, @ModelAttribute("newFeedback") Feedback feedback) {
        this.feedbackService.handleSaveFeedback(feedback);
        return "redirect:/member/feedback";
    }

    @GetMapping("/member/feedback")
    public String showFeedbackbyMember(Model model) {
        List<Feedback> feedbacks = this.feedbackService.getAllFeedback();

        model.addAttribute("feedbacks", feedbacks);
        return "layout/member/feedback/show_feedback";
    }

    @GetMapping("/member/update/feedback/{id}")
    public String getUpdateFeedbackbyMember(Model model, @PathVariable long id) {
        List<Member> member = memberService.getAllMember();
        List<Course> course = courseService.getAllCourse();

        Feedback currentFeedBack = this.feedbackService.getFeedbackByID(id);

        model.addAttribute("course", course);
        model.addAttribute("member", member);
        model.addAttribute("newFeedback", currentFeedBack);
        return "layout/ member/feedback/update_feedback";
    }

    @PostMapping("/member/update/feedback")
    public String getUpdateFeedbackbyMember(Model model, @ModelAttribute("newFeedback") Feedback n1) {
        Feedback newFeedBack = this.feedbackService.getFeedbackByID(n1.getFeedback_id());
        if (newFeedBack != null) {
            newFeedBack.setMember(n1.getMember());
            newFeedBack.setCourse(n1.getCourse());
            newFeedBack.setComment(n1.getComment());

            this.feedbackService.handleSaveFeedback(newFeedBack);
        }
        return "redirect:/member/feedback";
    }
}
