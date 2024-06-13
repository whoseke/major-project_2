package com.gymz.project_2.domain;

import java.math.BigDecimal;
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

    @Column(length = 10, nullable = false)
    private BigDecimal price;

    @OneToMany(mappedBy = "course")
    private List<Feedback> feedbacks;

    @OneToMany(mappedBy = "course")
    private List<Session> sessions;

    private float duration;

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

    public float getDuration() {
        return duration;
    }

    public void setDuration(float duration) {
        this.duration = duration;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    @Override
    public String toString() {
        return "Course [course_id=" + course_id + ", name=" + name + ", price=" + price + ", feedbacks=" + feedbacks
                + ", sessions=" + sessions + ", duration=" + duration + "]";
    }

}
