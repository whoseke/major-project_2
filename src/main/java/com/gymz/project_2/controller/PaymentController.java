package com.gymz.project_2.controller;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;

import com.gymz.project_2.domain.Member;
import com.gymz.project_2.domain.OptionGym;
import com.gymz.project_2.domain.Payment;
import com.gymz.project_2.service.MemberService;
import com.gymz.project_2.service.OptionService;
import com.gymz.project_2.service.PaymentService;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

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

    @GetMapping("/create/payment")
    public String createPayment(Model model) {
        List<Member> member = memberService.getAllMember();
        List<OptionGym> op = optionService.getAllOption();

        model.addAttribute("op", op);
        model.addAttribute("member", member);
        model.addAttribute("newPayment", new Payment());
        return "/create/payment";
    }

    @PostMapping(value = "/create/createPayment")
    public String getPayment(Model model, @ModelAttribute("newPayment") Payment payment) {
        this.paymentService.handleSavePayment(payment);
        return "redirect:/info/payment";
    }

    @GetMapping("/info/payment")
    public String showPayment(Model model) {
        List<Payment> payments = this.paymentService.getAllPayment();

        model.addAttribute("payments", payments);
        return "/show/payment";
    }

    @GetMapping("/update/payment/{id}")
    public String setUpdatePayment(Model model, @PathVariable long id) {
        List<Member> member = memberService.getAllMember();
        List<OptionGym> op = optionService.getAllOption();

        Payment currentPayment = this.paymentService.getpPaymentByID(id);
        model.addAttribute("op", op);
        model.addAttribute("member", member);
        model.addAttribute("newPayment", currentPayment);
        return "/update/payment";
    }

    @PostMapping("/update/payment")
    public String getUpdatePayment(Model model, @ModelAttribute("newPayment") Payment currentPayment) {

        Payment newPayment = this.paymentService.getpPaymentByID(currentPayment.getPayment_id());
        if (newPayment != null) {
            newPayment.setMember(currentPayment.getMember());
            newPayment.setOp(currentPayment.getOp());
            newPayment.setPaymentDate(currentPayment.getPaymentDate());
            this.paymentService.handleSavePayment(newPayment);
        }
        return "redirect:/info/payment";

    }

    @GetMapping("/delete/payment/{id}")
    public String deleteBooking(Model model, @PathVariable long id) {
        this.paymentService.deletePaymentById(id);
        return "redirect:/info/payment";
    }
}
