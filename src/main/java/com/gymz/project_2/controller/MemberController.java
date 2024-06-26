package com.gymz.project_2.controller;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.gymz.project_2.domain.Member;
import com.gymz.project_2.domain.OptionGym;
import com.gymz.project_2.service.CustomUserDetailsService;
import com.gymz.project_2.service.MemberService;
import com.gymz.project_2.service.OptionService;

@Controller
public class MemberController {
    private final MemberService memberService;
    private final OptionService optionService;
    private final CustomUserDetailsService customUserDetailsService;

    public MemberController(MemberService memberService, OptionService optionService,
            CustomUserDetailsService customUserDetailsService) {
        this.memberService = memberService;
        this.optionService = optionService;
        this.customUserDetailsService = customUserDetailsService;
    }

    @GetMapping("/create/member")
    public String createMember(Model model) {
        List<OptionGym> op = optionService.getAllOption();
        System.out.println(op);
        model.addAttribute("op", op);
        model.addAttribute("newMember", new Member());
        return "member/create_member";
    }

    @PostMapping(value = "/create/createMember")
    public String getMember(Model model, @ModelAttribute("newMember") Member member) {
        this.memberService.handleSaveMember(member);
        return "redirect:/info/member";
    }

    @GetMapping("/info/member")
    public String showMember(Model model) {
        List<Member> members = this.memberService.getAllMember();

        model.addAttribute("members", members);
        return "member/show_member";
    }

    @GetMapping("/update/member/{id}")
    public String getUpdateMember(Model model, @PathVariable long id) {
        List<OptionGym> op = optionService.getAllOption();

        Member currentMember = this.memberService.getMemberByID(id);
        model.addAttribute("op", op);
        model.addAttribute("newMember", currentMember);
        return "member/update_member";
    }

    @PostMapping("/update/member")
    public String setUpdateMember(Model model, @ModelAttribute("newMember") Member currentMember) {

        Member newMember = this.memberService.getMemberByID(currentMember.getMember_id());
        if (newMember != null) {
            newMember.setName(currentMember.getName());
            newMember.setPhoneNumber(currentMember.getName());
            newMember.setDate_joined(currentMember.getDate_joined());
            newMember.setOp(currentMember.getOp());
            this.memberService.handleSaveMember(newMember);
        }
        return "redirect:/info/member";
    }

    @GetMapping("/delete/member/{id}")
    public String deleteBooking(Model model, @PathVariable long id) {
        this.memberService.deledeleteBy(id);
        return "redirect:/info/member";
    }

    @GetMapping("/member/member")
    public String showMemberByMember(Model model) {
        String username = customUserDetailsService.getCurrentUsername();
        Member members = memberService.getMemberByUserName(username);
        System.out.println("xxxxxxxxxxxx " + username);
        System.out.println("zzzzzzz " + members);
        model.addAttribute("members", members);
        return "layout/member/member/show_member";
    }

    @GetMapping("/member/update/member/{id}")
    public String getUpdateMemberByMember(Model model, @PathVariable long id) {
        List<OptionGym> op = optionService.getAllOption();

        Member currentMember = this.memberService.getMemberByID(id);
        model.addAttribute("op", op);
        model.addAttribute("newMember", currentMember);
        return "layout/member/member/update_member";
    }

    @PostMapping("/member/update/member")
    public String setUpdateMemberByMember(Model model, @ModelAttribute("newMember") Member currentMember) {

        Member newMember = this.memberService.getMemberByID(currentMember.getMember_id());
        if (newMember != null) {
            newMember.setName(currentMember.getName());
            newMember.setPhoneNumber(currentMember.getName());
            newMember.setDate_joined(currentMember.getDate_joined());
            newMember.setOp(currentMember.getOp());
            this.memberService.handleSaveMember(newMember);
        }
        return "redirect:/member/member";
    }
}
