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
    private Member member;

    @ManyToOne
    @JoinColumn(name = "op_id", referencedColumnName = "op_id")
    private OptionGym op;

    private LocalDate paymentDate;

    public long getPayment_id() {
        return payment_id;
    }

    public void setPayment_id(long payment_id) {
        this.payment_id = payment_id;
    }

    public Member getMember() {
        return member;
    }

    public void setMember(Member member) {
        this.member = member;
    }

    public OptionGym getOp() {
        return op;
    }

    public void setOp(OptionGym op) {
        this.op = op;
    }

    public LocalDate getPaymentDate() {
        return paymentDate;
    }

    public void setPaymentDate(LocalDate paymentDate) {
        this.paymentDate = paymentDate;
    }

    @Override
    public String toString() {
        return "Payment [payment_id=" + payment_id + ", member=" + member + ", op=" + op + ", paymentDate="
                + paymentDate + "]";
    }

}
