package com.gymz.project_2.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.gymz.project_2.domain.Payment;

public interface PaymentRepository extends JpaRepository<Payment, Long> {
    Payment save(Payment payment);

}
