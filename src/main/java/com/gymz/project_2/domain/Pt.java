package com.gymz.project_2.domain;

import java.time.LocalDate;
import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;

@Entity
public class Pt {
    @Id
    @Column(length = 6, nullable = false, unique = true)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long pt_id;

    @Column(length = 100, nullable = false)
    private String name;

    @Column(length = 10, nullable = false)
    private String phoneNumber;

    @Column(length = 30, nullable = false)
    private String specialization;

    @Column(length = 2, nullable = false)
    private float experience_year;

    @Column(nullable = false)
    private LocalDate date_joined;

    @OneToMany(mappedBy = "pt", cascade = CascadeType.ALL)
    private List<Session> sessions;

    public long getPt_id() {
        return pt_id;
    }

    public void setPt_id(long pt_id) {
        this.pt_id = pt_id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSpecialization() {
        return specialization;
    }

    public void setSpecialization(String specialization) {
        this.specialization = specialization;
    }

    public float getExperience_year() {
        return experience_year;
    }

    public void setExperience_year(float experience_year) {
        this.experience_year = experience_year;
    }

    public LocalDate getDate_joined() {
        return date_joined;
    }

    public void setDate_joined(LocalDate date_joined) {
        this.date_joined = date_joined;
    }

    public List<Session> getSessions() {
        return sessions;
    }

    public void setSessions(List<Session> sessions) {
        this.sessions = sessions;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    @Override
    public String toString() {
        return "Pt [pt_id=" + pt_id + ", name=" + name + ", phoneNumber=" + phoneNumber + ", specialization="
                + specialization + ", experience_year=" + experience_year + ", date_joined=" + date_joined + "]";
    }

}
