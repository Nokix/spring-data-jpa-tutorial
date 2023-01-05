package de.reichert.springdatajpa.tutorial.entity;

import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.Cascade;
import org.hibernate.annotations.Fetch;

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

//    @OneToOne
//    @Cascade(org.hibernate.annotations.CascadeType.PERSIST)

    @OneToOne(
            cascade = CascadeType.PERSIST,
            fetch = FetchType.LAZY
    )
    @ToString.Exclude
    private CourseMaterial courseMaterial;
}
