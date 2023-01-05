package de.reichert.springdatajpa.tutorial.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.Cascade;

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
    private CourseMaterial courseMaterial;
}
