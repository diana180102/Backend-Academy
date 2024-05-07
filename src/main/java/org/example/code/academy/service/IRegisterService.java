package org.example.code.academy.service;

import org.example.code.academy.model.Register;

import java.util.List;
import java.util.Map;

public interface IRegisterService extends ICRUD <Register, Integer> {


    //Get the count of students for each course
    Map<String, Long> getCourseCountStudent ();

    //Get name of students registered in a course specific
    Map<Object, List<String>> getCourseNameStudent();

}
