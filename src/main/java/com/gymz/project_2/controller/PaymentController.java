package com.gymz.project_2.controller;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;

import com.gymz.project_2.domain.Account;
import com.gymz.project_2.domain.Member;
import com.gymz.project_2.domain.OptionGym;
import com.gymz.project_2.domain.Payment;
import com.gymz.project_2.service.MemberService;
import com.gymz.project_2.service.OptionService;
import com.gymz.project_2.service.PaymentService;

import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class PaymentController {
    private final PaymentService paymentService;
    private final MemberService memberService;
    private final OptionService optionService;

    public PaymentController(PaymentService paymentService, MemberService memberService,
            OptionService optionService) {
        this.paymentService = paymentService;
        this.memberService = memberService;
        this.optionService = optionService;
    }

    @RequestMapping("/create/payment")
    public String createPayment(Model model) {
        List<Member> member = memberService.getAllMember();
        List<OptionGym> op = optionService.getAllOption();

        model.addAttribute("op", op);
        model.addAttribute("member", member);
        model.addAttribute("newPayment", new Payment());
        return "/create/payment";
    }

    @RequestMapping(value = "/create/createPayment", method = RequestMethod.POST)
    public String getPayment(Model model, @ModelAttribute("newPayment") Payment payment) {
        this.paymentService.handleSavePayment(payment);
        return "redirect:/info/payment";
    }

    @RequestMapping("/info/payment")
    public String showpayment(Model model) {
        List<Payment> payments = this.paymentService.getAllPayment();

        model.addAttribute("payments", payments);
        return "/show/payment";
    }

}
