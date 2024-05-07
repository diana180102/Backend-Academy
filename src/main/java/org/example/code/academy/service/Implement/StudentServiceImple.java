package org.example.code.academy.service.Implement;

import lombok.RequiredArgsConstructor;
import org.example.code.academy.model.Student;
import org.example.code.academy.repository.IGenericRepo;
import org.example.code.academy.repository.IStudentRepo;

import org.example.code.academy.service.IStudentService;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
@RequiredArgsConstructor
public class StudentServiceImple extends CRUDImpl<Student, Integer> implements IStudentService {


    private final IStudentRepo repo;

    @Override
    protected IGenericRepo<Student, Integer> getRepo() {
        return repo;
    }

    @Override
    public List<Student> findAllByOrderByAgeAsc() {
        return repo.findAllByOrderByAgeAsc();
    }
}
