package com.gymz.project_2.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.gymz.project_2.domain.Payment;
import com.gymz.project_2.repository.PaymentRepository;

@Service
public class PaymentService {
    private final PaymentRepository paymentRepository;

    public PaymentService(PaymentRepository paymentRepository) {
        this.paymentRepository = paymentRepository;
    }

    public Payment handleSavePayment(Payment payment) {
        return this.paymentRepository.save(payment);
    }

    public List<Payment> getAllPayment() {
        return this.paymentRepository.findAll();
    }

    public Payment getpPaymentByID(long id) {
        return this.paymentRepository.findById(id);
    }

    public void deletePaymentById(long id) {
        this.paymentRepository.deleteById(id);
    }
}
