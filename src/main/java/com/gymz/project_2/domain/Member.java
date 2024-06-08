package com.gymz.project_2.domain;

import java.time.LocalDate;
import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

import jakarta.persistence.OneToMany;

@Entity
public class Member {
    @Id
    @Column(length = 6, nullable = false, unique = true)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long member_id;

    @Column(length = 100, nullable = false, unique = true)
    private String name;

    @Column(length = 10, nullable = false, unique = true)
    private String phoneNumber;

    @Column(nullable = false)
    private LocalDate date_joined;

    @OneToMany(mappedBy = "member")
    private List<Booking> booking;

    @OneToMany(mappedBy = "member")
    private List<Feedback> feedbacks;

    @OneToMany(mappedBy = "member")
    private List<OptionGym> ops;

    public long getMember_id() {
        return member_id;
    }

    public void setMember_id(long member_id) {
        this.member_id = member_id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public LocalDate getDate_joined() {
        return date_joined;
    }

    public void setDate_joined(LocalDate date_joined) {
        this.date_joined = date_joined;
    }

    public List<Booking> getBooking() {
        return booking;
    }

    public void setBooking(List<Booking> booking) {
        this.booking = booking;
    }

    public List<Feedback> getFeedbacks() {
        return feedbacks;
    }

    public void setFeedbacks(List<Feedback> feedbacks) {
        this.feedbacks = feedbacks;
    }

    public List<OptionGym> getOps() {
        return ops;
    }

    public void setOps(List<OptionGym> ops) {
        this.ops = ops;
    }

    @Override
    public String toString() {
        return "Member [member_id=" + member_id + ", name=" + name + ", phoneNumber=" + phoneNumber + ", date_joined="
                + date_joined + ", booking=" + booking + ", feedbacks=" + feedbacks + ", ops=" + ops + "]";
    }

}
