package com.gymz.project_2.domain;

import java.time.LocalDate;
import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;

@Entity
public class Session {
    @Id
    @Column(length = 6, nullable = false, unique = true)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long session_id;

    @Column(nullable = false)
    private String session_Date;

    @Column(nullable = false)
    private LocalDate start_time;

    @Column(nullable = false)
    private LocalDate end_time;

    @OneToMany(mappedBy = "session")
    private List<Booking> bookings;

    @ManyToOne
    @JoinColumn(name = "course_id")
    private Course course;

    @ManyToOne
    @JoinColumn(name = "pt_id")
    private Pt pt;

    public long getSession_id() {
        return session_id;
    }

    public void setSession_id(long session_id) {
        this.session_id = session_id;
    }

    public String getSession_Date() {
        return session_Date;
    }

    public void setSession_Date(String session_Date) {
        this.session_Date = session_Date;
    }

    public LocalDate getStart_time() {
        return start_time;
    }

    public void setStart_time(LocalDate start_time) {
        this.start_time = start_time;
    }

    public LocalDate getEnd_time() {
        return end_time;
    }

    public void setEnd_time(LocalDate end_time) {
        this.end_time = end_time;
    }

    public List<Booking> getBookings() {
        return bookings;
    }

    public void setBookings(List<Booking> bookings) {
        this.bookings = bookings;
    }

    public Course getCourse() {
        return course;
    }

    public void setCourse(Course course) {
        this.course = course;
    }

    public Pt getPt() {
        return pt;
    }

    public void setPt(Pt pt) {
        this.pt = pt;
    }

    @Override
    public String toString() {
        return "Session [session_id=" + session_id + ", session_Date=" + session_Date + ", start_time=" + start_time
                + ", end_time=" + end_time + ", bookings=" + bookings + ", course=" + course + ", pt=" + pt + "]";
    }

}
