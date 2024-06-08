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
public class Payment {
    @Id
    @Column(length = 6, nullable = false, unique = true)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long payment_id;

    @ManyToOne
    @JoinColumn(name = "member_id")
    private Member member_id;

    @ManyToOne
    @JoinColumn(name = "op_id", referencedColumnName = "op_id")
    private OptionGym op_id;

    private LocalDate paymenDate;

    public long getPayment_id() {
        return payment_id;
    }

    public void setPayment_id(long payment_id) {
        this.payment_id = payment_id;
    }

    public Member getMember_id() {
        return member_id;
    }

    public void setMember_id(Member member_id) {
        this.member_id = member_id;
    }

    public OptionGym getOp_id() {
        return op_id;
    }

    public void setOp_id(OptionGym op_id) {
        this.op_id = op_id;
    }

    public LocalDate getPaymenDate() {
        return paymenDate;
    }

    public void setPaymenDate(LocalDate paymenDate) {
        this.paymenDate = paymenDate;
    }

    @Override
    public String toString() {
        return "Payment [payment_id=" + payment_id + ", member_id=" + member_id + ", op_id=" + op_id + ", paymenDate="
                + paymenDate + "]";
    }

}
