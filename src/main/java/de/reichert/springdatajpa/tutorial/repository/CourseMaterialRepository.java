package de.reichert.springdatajpa.tutorial.repository;

import de.reichert.springdatajpa.tutorial.entity.CourseMaterial;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CourseMaterialRepository extends JpaRepository<CourseMaterial, Long> {
}