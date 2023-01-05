package de.reichert.springdatajpa.tutorial.repository;

import de.reichert.springdatajpa.tutorial.entity.Teacher;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TeacherRepository extends JpaRepository<Teacher, Long> {
}