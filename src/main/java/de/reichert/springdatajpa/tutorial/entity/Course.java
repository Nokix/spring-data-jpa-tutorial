package de.reichert.springdatajpa.tutorial.entity;

import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.Cascade;

import java.util.LinkedHashSet;
import java.util.Set;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
@Table(name = "course")
public class Course {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id", nullable = false)
    private Long id;
    private String title;
    private Integer credit;

    //@OneToOne(cascade = CascadeType.PERSIST)
    @OneToOne
    @Cascade(org.hibernate.annotations.CascadeType.PERSIST)
    @ToString.Exclude
    private CourseMaterial courseMaterial;

    @ManyToOne(cascade = CascadeType.ALL)
    private Teacher taughtBy;

    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(name = "course_participants",
            joinColumns = @JoinColumn(name = "course_id"),
            inverseJoinColumns = @JoinColumn(name = "participants_id"))
    private Set<Student> participants = new LinkedHashSet<>();

}
