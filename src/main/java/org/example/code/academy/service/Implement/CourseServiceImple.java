package org.example.code.academy.service.Implement;

import lombok.RequiredArgsConstructor;
import org.example.code.academy.model.Course;
import org.example.code.academy.model.Student;
import org.example.code.academy.repository.ICourseRepo;
import org.example.code.academy.repository.IGenericRepo;
import org.example.code.academy.repository.IStudentRepo;
import org.example.code.academy.service.ICourseService;
import org.example.code.academy.service.IStudentService;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;

import static java.util.stream.Collectors.*;


@Service
@RequiredArgsConstructor
public class CourseServiceImple extends CRUDImpl<Course, Integer> implements ICourseService {


    private final ICourseRepo repo;

    @Override
    protected IGenericRepo<Course, Integer> getRepo() {
        return repo;
    }



}
