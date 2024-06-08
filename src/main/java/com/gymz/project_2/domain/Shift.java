package com.gymz.project_2.domain;

import java.time.LocalDate;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

@Entity
public class Shift {
    @Id
    @Column(length = 6, nullable = false, unique = true)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long shift_id;

    @ManyToOne
    @JoinColumn(name = "employee_id", referencedColumnName = "employee_id")
    private Employee employee_id;

    @Column(nullable = false)
    private LocalDate shift_date;

    @Column(nullable = false)
    private LocalDate start_time;

    @Column(nullable = false)
    private LocalDate end_time;

    public long getShift_id() {
        return shift_id;
    }

    public void setShift_id(long shift_id) {
        this.shift_id = shift_id;
    }

    public Employee getEmployee_id() {
        return employee_id;
    }

    public void setEmployee_id(Employee employee_id) {
        this.employee_id = employee_id;
    }

    public LocalDate getShift_date() {
        return shift_date;
    }

    public void setShift_date(LocalDate shift_date) {
        this.shift_date = shift_date;
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

    @Override
    public String toString() {
        return "Shift [shift_id=" + shift_id + ", employee_id=" + employee_id + ", shift_date=" + shift_date
                + ", start_time=" + start_time + ", end_time=" + end_time + "]";
    }

}
