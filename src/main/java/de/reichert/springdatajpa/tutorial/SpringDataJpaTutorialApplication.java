package de.reichert.springdatajpa.tutorial;

import de.reichert.springdatajpa.tutorial.entity.*;
import de.reichert.springdatajpa.tutorial.faker.FakeMachine;
import de.reichert.springdatajpa.tutorial.repository.CourseMaterialRepository;
import de.reichert.springdatajpa.tutorial.repository.CourseRepository;
import de.reichert.springdatajpa.tutorial.repository.StudentRepository;
import de.reichert.springdatajpa.tutorial.repository.TeacherRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;

import java.util.Collections;
import java.util.List;
import java.util.Set;

@SpringBootApplication
public class SpringDataJpaTutorialApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringDataJpaTutorialApplication.class, args);
    }

    @Bean
    public CommandLineRunner app(StudentRepository studentRepository,
                                 CourseRepository courseRepository,
                                 CourseMaterialRepository courseMaterialRepository,
                                 TeacherRepository teacherRepository,
                                 FakeMachine fakeMachine) {
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

            Teacher teacher = Teacher.builder()
                    .firstName("Oli")
                    .lastName("Kohl")
                    //.taughtCourses(Set.of(course))
                    .build();


//            teacherRepository.save(teacher);
//            courseMaterialRepository.findAll().forEach(System.out::println);


            Pageable thirdTen = PageRequest.of(2, 10);

            studentRepository.saveAll(fakeMachine.fakeStudents(10000));
            Pageable firstTen = PageRequest.of(
                    0,
                    10,
                    Sort.by("firstName").descending()
                            .and(Sort.by("lastName")));
            studentRepository.findAll(firstTen).getContent().forEach(System.out::println);

            System.out.println();
            studentRepository.findAll(thirdTen).getContent().forEach(System.out::println);
            System.out.println(studentRepository.findAll(thirdTen).getTotalPages());

            List<Student> vi_students = studentRepository.findByFirstNameContainsIgnoreCaseOrderByFirstNameAsc(
                            "vi",
                            PageRequest.of(0, 20))
                    .getContent();

            Course course = Course.builder()
                    .courseMaterial(courseMaterial)
                    .credit(20)
                    .title("Analysis 1")
                    .taughtBy(teacher)
                    .participants(Set.copyOf(vi_students))
                    .build();

            course = courseRepository.save(course);

//            course.getParticipants().add(student0);
//            courseRepository.save(course);

        });
    }
}
