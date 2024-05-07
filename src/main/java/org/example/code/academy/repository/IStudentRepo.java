package org.example.code.academy.repository;

import org.example.code.academy.model.Student;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface IStudentRepo extends IGenericRepo <Student, Integer>{


     List<Student> findAllByOrderByAgeAsc();




}
