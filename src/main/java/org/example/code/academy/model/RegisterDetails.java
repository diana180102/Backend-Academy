package org.example.code.academy.model;

import com.fasterxml.jackson.annotation.JsonIdentityReference;
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
public class RegisterDetails {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idDetails;

    @ManyToOne
    @JoinColumn(name = "id_register", nullable = false, foreignKey = @ForeignKey(name = "FK_DETAIL_REGISTER"))
    private Register register;


    @ManyToOne
    @JoinColumn(name = "id_course", nullable = false, foreignKey = @ForeignKey(name = "FK_DETAIL_COURSE"))
    Course course;

    @Column(length = 50, nullable = false)
    private String classroom;




}
