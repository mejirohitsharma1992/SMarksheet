package com.jiro.MarksApplication.controllers;

import com.jiro.MarksApplication.models.Marks;
import com.jiro.MarksApplication.models.Student;
import com.jiro.MarksApplication.models.Subject;
import com.jiro.MarksApplication.repositories.MarksRepository;
import com.jiro.MarksApplication.repositories.StudentRepository;
import com.jiro.MarksApplication.repositories.SubjectRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/teacher")
public class TeacherController {

    @Autowired
    private MarksRepository marksRepository;

    @Autowired
    private SubjectRepository subjectRepository;

    @Autowired
    private StudentRepository studentRepository;

    // Teacher updates marks for a student for their subject
    @PostMapping("/marks")
    public Marks enterMarks(@RequestParam Long studentId, @RequestParam Long subjectId, @RequestParam double marks) {
        Subject subject = subjectRepository.findById(subjectId)
                .orElseThrow(() -> new RuntimeException("Subject not found"));
        Student student = studentRepository.findById(studentId)
                .orElseThrow(() -> new RuntimeException("Student not found"));

        Marks mark = new Marks();
        mark.setMarksObtained(marks);
        mark.setStudent(student);
        mark.setSubject(subject);

        return marksRepository.save(mark);
    }
}
