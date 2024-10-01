package com.jiro.MarksApplication.controllers;

import com.jiro.MarksApplication.models.Subject;
import com.jiro.MarksApplication.models.Teacher;
import com.jiro.MarksApplication.repositories.SubjectRepository;
import com.jiro.MarksApplication.repositories.TeacherRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/admin")
public class AdminController {

    @Autowired
    private TeacherRepository teacherRepository;

    @Autowired
    private SubjectRepository subjectRepository;

    // Admin assigns a teacher to a subject
    @PutMapping("/assign-teacher")
    public Subject assignTeacherToSubject(@RequestParam Long teacherId, @RequestParam Long subjectId) {
        Teacher teacher = teacherRepository.findById(teacherId)
                .orElseThrow(() -> new RuntimeException("Teacher not found"));
        Subject subject = subjectRepository.findById(subjectId)
                .orElseThrow(() -> new RuntimeException("Subject not found"));

        subject.setTeacher(teacher);
        return subjectRepository.save(subject);
    }
}
