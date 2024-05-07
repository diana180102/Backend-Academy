package org.example.code.academy.service;

import org.example.code.academy.model.Student;

import java.util.List;

public interface IStudentService extends ICRUD <Student, Integer> {

        List<Student> findAllByOrderByAgeAsc();
}
