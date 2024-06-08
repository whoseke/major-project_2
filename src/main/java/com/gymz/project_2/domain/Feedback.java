package com.gymz.project_2.domain;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

@Entity
public class Feedback {
    @Id
    @Column(length = 6, nullable = false, unique = true)
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    private long feedback_id;

    @ManyToOne
    @JoinColumn(name = "member_id")
    private Member member;

    @ManyToOne
    @JoinColumn(name = "course_id")
    private Course course;

    @Column(length = 300, nullable = false)
    private String comment;

    public long getFeedback_id() {
        return feedback_id;
    }

    public void setFeedback_id(long feedback_id) {
        this.feedback_id = feedback_id;
    }

    public Member getMember() {
        return member;
    }

    public void setMember(Member member) {
        this.member = member;
    }

    public Course getCourse() {
        return course;
    }

    public void setCourse(Course course) {
        this.course = course;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    @Override
    public String toString() {
        return "Feedback [feedback_id=" + feedback_id + ", member=" + member + ", course=" + course + ", comment="
                + comment + "]";
    }

}
