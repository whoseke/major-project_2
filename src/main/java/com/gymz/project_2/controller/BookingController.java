package com.gymz.project_2.controller;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;

import com.gymz.project_2.domain.Booking;
import com.gymz.project_2.domain.Course;
import com.gymz.project_2.domain.Member;
import com.gymz.project_2.domain.Session;
import com.gymz.project_2.service.BookingService;
import com.gymz.project_2.service.MemberService;
import com.gymz.project_2.service.SessionService;

import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class BookingController {
    private final BookingService bookingService;
    private final MemberService memberService;
    private final SessionService sessionService;

    public BookingController(BookingService bookingService, MemberService memberService,
            SessionService sessionService) {
        this.bookingService = bookingService;
        this.memberService = memberService;
        this.sessionService = sessionService;
    }

    @RequestMapping("/create/booking")
    public String createBooking(Model model) {
        List<Member> member = memberService.getAllMember();
        List<Session> session = sessionService.getAllSession();

        model.addAttribute("newBooking", new Booking());
        model.addAttribute("member", member);
        model.addAttribute("session", session);

        return "/create/booking";
    }

    @RequestMapping(value = "/create/createBooking", method = RequestMethod.POST)
    public String getBooking(Model model, @ModelAttribute("newBooking") Booking booking) {
        this.bookingService.handleSaveBooking(booking);
        return "redirect:/show/booking";
    }

    @RequestMapping("/info/booking")
    public String showBooking(Model model) {
        List<Booking> bookings = this.bookingService.getAllBooking();
        model.addAttribute("bookings", bookings);
        return "/show/booking";
    }

}
