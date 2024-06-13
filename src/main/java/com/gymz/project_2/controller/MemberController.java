package com.gymz.project_2.controller;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.gymz.project_2.domain.Member;
import com.gymz.project_2.domain.OptionGym;
import com.gymz.project_2.service.MemberService;
import com.gymz.project_2.service.OptionService;

@Controller
public class MemberController {
    private final MemberService memberService;
    private final OptionService optionService;

    public MemberController(MemberService memberService, OptionService optionService) {
        this.memberService = memberService;
        this.optionService = optionService;
    }

    @RequestMapping("/create/member")
    public String createMember(Model model) {
        List<OptionGym> op = optionService.getAllOption();
        System.out.println(op);
        model.addAttribute("op", op);
        model.addAttribute("newMember", new Member());
        return "/create/member";
    }

    @RequestMapping(value = "/create/createMember", method = RequestMethod.POST)
    public String getMember(Model model, @ModelAttribute("newMember") Member member) {
        this.memberService.handleSaveMember(member);
        return "redirect:/info/member";
    }

}
