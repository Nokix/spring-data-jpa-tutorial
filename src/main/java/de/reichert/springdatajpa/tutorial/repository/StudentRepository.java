package de.reichert.springdatajpa.tutorial.repository;

import de.reichert.springdatajpa.tutorial.entity.Student;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StudentRepository extends JpaRepository<Student, Long> {
}