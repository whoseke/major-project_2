package com.gymz.project_2.domain;

import java.math.BigDecimal;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

@Entity
public class OptionGym {
    @Id
    @Column(length = 6, nullable = false, unique = true)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long op_id;

    @Column(length = 100, nullable = false)
    private String name;

    @Column(length = 30, nullable = false)
    private double duration;

    @Column(precision = 10, scale = 3, nullable = false, unique = true)
    private BigDecimal price;

    @Column(length = 6, nullable = false, unique = true)
    public long getOp_id() {
        return op_id;
    }

    @ManyToOne()
    @JoinColumn(name = "member_id")
    private Member member;

    public void setOp_id(long op_id) {
        this.op_id = op_id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getDuration() {
        return duration;
    }

    public void setDuration(double duration) {
        this.duration = duration;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public Member getMember() {
        return member;
    }

    public void setMember(Member member) {
        this.member = member;
    }

    @Override
    public String toString() {
        return "OptionGym [op_id=" + op_id + ", name=" + name + ", duration=" + duration + ", price=" + price
                + ", member=" + member + "]";
    }

}
