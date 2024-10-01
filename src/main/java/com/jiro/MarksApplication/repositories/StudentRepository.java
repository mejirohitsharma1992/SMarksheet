package com.jiro.MarksApplication.repositories;

import com.jiro.MarksApplication.models.Student;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StudentRepository extends JpaRepository<Student, Long> {
}
