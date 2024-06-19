package com.gymz.project_2.domain;

import java.math.BigDecimal;
import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;

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

    @OneToMany(mappedBy = "op", cascade = CascadeType.ALL)
    private List<Member> members;

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

    public List<Member> getMembers() {
        return members;
    }

    public void setMembers(List<Member> members) {
        this.members = members;
    }

    @Override
    public String toString() {
        return "OptionGym [op_id=" + op_id + ", name=" + name + ", duration=" + duration + ", price=" + price + "]";
    }

}
