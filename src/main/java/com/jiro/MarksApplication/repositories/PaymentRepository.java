package com.jiro.MarksApplication.repositories;

import com.jiro.MarksApplication.models.Payment;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PaymentRepository extends JpaRepository<Payment, Long> {
}
