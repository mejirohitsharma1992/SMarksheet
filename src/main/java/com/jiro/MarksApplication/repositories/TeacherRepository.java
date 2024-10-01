package com.jiro.MarksApplication.repositories;

import com.jiro.MarksApplication.models.Teacher;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TeacherRepository extends JpaRepository<Teacher, Long> {
}
