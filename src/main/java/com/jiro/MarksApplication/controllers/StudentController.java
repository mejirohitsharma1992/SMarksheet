package com.jiro.MarksApplication.controllers;

import com.jiro.MarksApplication.repositories.MarksRepository;
import com.jiro.MarksApplication.repositories.StudentRepository;
import com.jiro.MarksApplication.utils.GradeCalculator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.jiro.MarksApplication.models.Student;
import com.jiro.MarksApplication.models.Marks;

import java.util.List;
import java.util.stream.Collectors;


@RestController
@RequestMapping("/student")
public class StudentController {

//    @Autowired
//    private StudentRepository studentRepository;
//
//    @Autowired
//    private MarksRepository marksRepository;
//
//    @GetMapping("/marksheet")
//    public ResponseEntity<?> getMarksheet(@RequestParam String symbolNumber, @RequestParam String dob) {
//        Student student = studentRepository.findBySymbolNumberAndDob(symbolNumber, dob)
//                .orElseThrow(() -> new RuntimeException("Student not found"));
//
//        List<Marks> marksList = marksRepository.findByStudent(student);
//        List<GradeResponse> gradeResponses = marksList.stream()
//                .map(mark -> new GradeResponse(mark.getSubject().getName(), mark.getMarksObtained(),
//                        GradeCalculator.calculateGrade(mark.getMarksObtained()),
//                        GradeCalculator.calculateGPA(mark.getMarksObtained())))
//                .collect(Collectors.toList());
//
//        return ResponseEntity.ok(gradeResponses);
//    }
//
//    public static class GradeResponse {
//        private String subjectName;
//        private double marks;
//        private String grade;
//        private double gpa;
//
//        // Constructor, Getters, and Setters
//
//        public GradeResponse(String subjectName, double marks, String grade, double gpa) {
//            this.subjectName = subjectName;
//            this.marks = marks;
//            this.grade = grade;
//            this.gpa = gpa;
//        }
//
//        public String getSubjectName() {
//            return subjectName;
//        }
//
//        public void setSubjectName(String subjectName) {
//            this.subjectName = subjectName;
//        }
//
//        public double getMarks() {
//            return marks;
//        }
//
//        public void setMarks(double marks) {
//            this.marks = marks;
//        }
//
//        public String getGrade() {
//            return grade;
//        }
//
//        public void setGrade(String grade) {
//            this.grade = grade;
//        }
//
//        public double getGpa() {
//            return gpa;
//        }
//
//        public void setGpa(double gpa) {
//            this.gpa = gpa;
//        }
//    }
@Autowired
private StudentRepository studentRepository;

    // Student views marksheet only if payment is complete
    @GetMapping("/marksheet/{studentId}")
    public String viewMarksheet(@PathVariable Long studentId) {
        Student student = studentRepository.findById(studentId)
                .orElseThrow(() -> new RuntimeException("Student not found"));

        if (!student.isPaymentComplete()) {
            return "Payment is pending. Please complete the payment to view the marksheet.";
        }

        return student.getMarks().toString(); // Assuming marks are displayed as a string.
    }

}

