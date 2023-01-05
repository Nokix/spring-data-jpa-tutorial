package de.reichert.springdatajpa.tutorial;

import de.reichert.springdatajpa.tutorial.entity.Course;
import de.reichert.springdatajpa.tutorial.entity.CourseMaterial;
import de.reichert.springdatajpa.tutorial.entity.Guardian;
import de.reichert.springdatajpa.tutorial.entity.Student;
import de.reichert.springdatajpa.tutorial.repository.CourseMaterialRepository;
import de.reichert.springdatajpa.tutorial.repository.CourseRepository;
import de.reichert.springdatajpa.tutorial.repository.StudentRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class SpringDataJpaTutorialApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringDataJpaTutorialApplication.class, args);
    }

    @Bean
    public CommandLineRunner app(StudentRepository studentRepository,
                                 CourseRepository courseRepository,
                                 CourseMaterialRepository courseMaterialRepository) {
        return (args -> {
            Guardian guardian = Guardian.builder()
                    .name("Karl")
                    .mobile("000-1234")
                    .email("karl@guardi.an")
                    .build();

            Student student0 = Student.builder()
                    .email("swantje@web.de")
                    .firstName("Swantje")
                    .lastName("Maja")
                    .guardian(guardian)
                    .build();

            Student student1 = Student.builder()
                    .email("viktor@web.de")
                    .firstName("Viktor")
                    .lastName("Reichert")
                    .guardian(guardian)
                    .build();

            studentRepository.save(student0);
            studentRepository.save(student1);

            //studentRepository.findStudentByFirstNameContaining("tj").forEach(System.out::println);

            //studentRepository.findByGuardian_NameLikeIgnoreCase("karl").forEach(System.out::println);

            //System.out.println(studentRepository.findByGuardian_EmailLikeIgnoreCase("karl@guardi.an"));

            //System.out.println(studentRepository.getNameById(1L));

            //studentRepository.getAllByName("Viktor").forEach(System.out::println);

            //System.out.println(studentRepository.updateEmailByName("new@mail.de", "Viktor"));
            //System.out.println(studentRepository.getAllByName("Viktor"));

            CourseMaterial courseMaterial = CourseMaterial.builder()
                    .url("ana1.de")
                    .build();

            Course course = Course.builder()
                    .courseMaterial(courseMaterial)
                    .credit(20)
                    .title("Analysis 1")
                    .build();

            courseMaterialRepository.save(courseMaterial);
            courseRepository.save(course);
        });
    }
}
