package com.jiro.MarksApplication.repositories;

import com.jiro.MarksApplication.models.Subject;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SubjectRepository extends JpaRepository<Subject, Long> {
}
