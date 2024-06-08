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
public class Course {
    @Id
    @Column(length = 6, nullable = false, unique = true)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long course_id;

    @Column(length = 100, nullable = false)
    private String name;

    @OneToMany(mappedBy = "course")
    private List<Feedback> feedbacks;

    @OneToMany(mappedBy = "course")
    private List<Session> sessions;

    private LocalDate start_day;
    private LocalDate end_Date;

    public long getCourse_id() {
        return course_id;
    }

    public void setCourse_id(long course_id) {
        this.course_id = course_id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public LocalDate getStart_day() {
        return start_day;
    }

    public void setStart_day(LocalDate start_day) {
        this.start_day = start_day;
    }

    public LocalDate getEnd_Date() {
        return end_Date;
    }

    public void setEnd_Date(LocalDate end_Date) {
        this.end_Date = end_Date;
    }

    public List<Feedback> getFeedbacks() {
        return feedbacks;
    }

    public void setFeedbacks(List<Feedback> feedbacks) {
        this.feedbacks = feedbacks;
    }

    public List<Session> getSessions() {
        return sessions;
    }

    public void setSessions(List<Session> sessions) {
        this.sessions = sessions;
    }

    @Override
    public String toString() {
        return "Course [course_id=" + course_id + ", name=" + name + ", feedbacks=" + feedbacks + ", sessions="
                + sessions + ", start_day=" + start_day + ", end_Date=" + end_Date + "]";
    }

}
