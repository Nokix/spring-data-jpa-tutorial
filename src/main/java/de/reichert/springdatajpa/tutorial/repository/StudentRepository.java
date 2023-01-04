package de.reichert.springdatajpa.tutorial.repository;

import de.reichert.springdatajpa.tutorial.entity.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.Optional;

public interface StudentRepository extends JpaRepository<Student, Long> {
    List<Student> findStudentByFirstNameContaining(String firstNameContaining);

    List<Student> findByGuardian_NameLikeIgnoreCase(String name);

    //JPQL
    @Query("select s from Student s where upper(s.email) like upper(?1)")
    Optional<Student> findByEmailLikeIgnoreCase(String email);

    @Query("select s from Student s where upper(s.guardian.email) like upper(?1)")
    Optional<Student> findByGuardian_EmailLikeIgnoreCase(String email);

    @Query("select s.firstName from Student s where s.id = ?1")
    Optional<String> getNameById(Long id);


}