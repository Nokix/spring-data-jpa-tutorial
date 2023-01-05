package de.reichert.springdatajpa.tutorial.faker;

import com.github.javafaker.Faker;
import de.reichert.springdatajpa.tutorial.entity.Student;
import de.reichert.springdatajpa.tutorial.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.stream.Collectors;
import java.util.stream.IntStream;

@Component
public class FakeMachine {
    @Autowired
    private Faker faker;

    public Student fakeStudent() {
        String firstName = faker.name().firstName();
        String lastName = faker.name().lastName();
        String email = firstName + "." + lastName + "@" + faker.internet().domainName();
        return Student.builder().lastName(lastName).firstName(firstName).email(email).build();
    }

    public Iterable<Student> fakeStudents(int n) {
        return IntStream.range(0, n).mapToObj(i -> fakeStudent()).collect(Collectors.toList());
    }
}
