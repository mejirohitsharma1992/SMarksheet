package com.jiro.MarksApplication.repositories;

import com.jiro.MarksApplication.models.Marks;
import com.jiro.MarksApplication.models.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface MarksRepository extends JpaRepository<Marks, Long> {
    List<Marks> findByStudent(Student student);
}

