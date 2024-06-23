package com.gymz.project_2.controller;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;

import com.gymz.project_2.domain.Booking;
import com.gymz.project_2.domain.Member;
import com.gymz.project_2.domain.Session;
import com.gymz.project_2.service.BookingService;
import com.gymz.project_2.service.MemberService;
import com.gymz.project_2.service.SessionService;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

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

    @GetMapping("/create/booking")
    public String createBooking(Model model) {
        List<Member> member = memberService.getAllMember();
        List<Session> session = sessionService.getAllSession();

        model.addAttribute("newBooking", new Booking());
        model.addAttribute("member", member);
        model.addAttribute("session", session);

        return "booking/create_booking";
    }

    @PostMapping(value = "/create/createBooking")
    public String getBooking(Model model, @ModelAttribute("newBooking") Booking booking) {
        this.bookingService.handleSaveBooking(booking);
        return "redirect:/info/booking";
    }

    @GetMapping("/info/booking")
    public String showBooking(Model model) {
        List<Booking> bookings = this.bookingService.getAllBooking();
        model.addAttribute("bookings", bookings);
        return "booking/show_booking";
    }

    @GetMapping("/update/booking/{id}")
    public String getBooking(Model model, @PathVariable long id) {
        List<Member> member = memberService.getAllMember();
        List<Session> session = sessionService.getAllSession();
        List<Session> sessionList = sessionService.getAllSession();

        Booking currentBooking = this.bookingService.getBookingByID(id);
        model.addAttribute("member", member);
        model.addAttribute("session", session);
        model.addAttribute("sessionList", sessionList);
        model.addAttribute("newBooking", currentBooking);

        return "booking/update_booking";
    }

    @PostMapping("/update/booking")
    public String setBooking(Model model, @ModelAttribute("newBooking") Booking currentAccount) {

        Booking newBooking = this.bookingService.getBookingByID(currentAccount.getBooking_id());
        if (newBooking != null) {

            newBooking.setMember(currentAccount.getMember());
            newBooking.setSession(currentAccount.getSession());
            newBooking.setBooking_date(currentAccount.getBooking_date());
            this.bookingService.handleSaveBooking(newBooking);
        }

        return "redirect:/info/booking";
    }

    @GetMapping("/delete/booking/{id}")
    public String deleteBooking(Model model, @PathVariable long id) {
        this.bookingService.deleteBookingById(id);
        return "redirect:/info/booking";
    }

}
