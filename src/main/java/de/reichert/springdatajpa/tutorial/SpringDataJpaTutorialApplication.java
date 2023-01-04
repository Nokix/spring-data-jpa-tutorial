package de.reichert.springdatajpa.tutorial;

import de.reichert.springdatajpa.tutorial.entity.Guardian;
import de.reichert.springdatajpa.tutorial.entity.Student;
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
	public CommandLineRunner app(StudentRepository studentRepository) {
		return (args -> {
			Guardian guardian = Guardian.builder()
					.name("Karl")
					.mobile("000-1234")
					.email("karl@guardi.an")
					.build();

			Student student = Student.builder()
					.email("swantje@web.de")
					.firstName("Swantje")
					.lastName("Maja")
					.guardian(guardian)
					.build();

			studentRepository.save(student);

			studentRepository.findStudentByFirstNameContaining("tj").forEach(System.out::println);
		} );
	}
}
