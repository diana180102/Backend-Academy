package org.example.code.academy.model;



import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;


@Data
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@Entity
public class Student {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @EqualsAndHashCode.Include
    private Integer idStudent;

    @Column(length = 70, nullable = false)
    private String name;

    @Column(length = 70, nullable = false)
    private String surname;

    @Column(length = 50, nullable = false)
    private String DNI;

    @Column(length = 3, nullable = false)
    private int age;

}
