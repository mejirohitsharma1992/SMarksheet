package com.jiro.MarksApplication.controllers;

import com.jiro.MarksApplication.models.Payment;
import com.jiro.MarksApplication.models.Student;
import com.jiro.MarksApplication.repositories.PaymentRepository;
import com.jiro.MarksApplication.repositories.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/payment")
public class PaymentController {

    @Autowired
    private PaymentRepository paymentRepository;

    @Autowired
    private StudentRepository studentRepository;

    @PostMapping("/pay")
    public Payment makePayment(@RequestParam Long studentId, @RequestParam double amount, @RequestParam String description) {
        Student student = studentRepository.findById(studentId)
                .orElseThrow(() -> new RuntimeException("Student not found"));

        Payment payment = new Payment();
        payment.setStudent(student);
        payment.setAmount(amount);
        payment.setDescription(description);

        student.setPaymentComplete(true);  // Mark payment as complete
        studentRepository.save(student);   // Update student payment status

        return paymentRepository.save(payment);
    }
}
