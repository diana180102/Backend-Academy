package org.example.code.academy.repository;

import org.example.code.academy.model.Course;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.Objects;


public interface ICourseRepo extends IGenericRepo <Course, Integer>{

    @Query(nativeQuery = true,
            value = " SELECT COUNT(*), c.name FROM register r " +
                    "INNER JOIN  student s ON r.id_student = s.id_student " +
                    "INNER JOIN register_details rd ON rd.id_register = r.id_register " +
                    "INNER JOIN course c ON c.id_course = rd.id_course  GROUP BY  c.name" )
    List<Objects[]>countAllByStudentsGroupByCourse();
}
