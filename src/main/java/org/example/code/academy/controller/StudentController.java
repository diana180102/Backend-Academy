package org.example.code.academy.controller;


import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.example.code.academy.dto.GenericResponse;
import org.example.code.academy.dto.StudentDTO;
import org.example.code.academy.model.Student;
import org.example.code.academy.service.IStudentService;
import org.modelmapper.ModelMapper;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@RestController
@RequestMapping("/students")
@RequiredArgsConstructor
public class StudentController {

    private final IStudentService service;

    private final ModelMapper modelMapper;


    @GetMapping
    public ResponseEntity<GenericResponse<StudentDTO>>readAll()  throws Exception{

        List <StudentDTO> list = service.readAll().stream().map(this::convertToDTO).toList();

        return ResponseEntity.ok(new GenericResponse<>(200, "success", new ArrayList<>(list)) );
    }

    @GetMapping("/{id}")
    public ResponseEntity<GenericResponse<StudentDTO>>readById( @PathVariable("id") @RequestParam Integer id)  throws Exception{

        StudentDTO student = convertToDTO(service.readById(id));

        return ResponseEntity.ok(new GenericResponse<>(200, "success", Arrays.asList(student) ));
    }

    @PostMapping
    public ResponseEntity<StudentDTO> save(@Valid @RequestBody StudentDTO studentDTO)  throws Exception{

        Student student = service.save(convertToEntity(studentDTO));

        return new ResponseEntity<>(convertToDTO(student), HttpStatus.CREATED);
    }


    @PutMapping("/{id}")
    public ResponseEntity<StudentDTO> update( @Valid @PathVariable("id") Integer id, @RequestBody StudentDTO studentDTO)  throws Exception{
        Student student = service.update(convertToEntity(studentDTO), id);

        return new ResponseEntity<>(convertToDTO(student), HttpStatus.OK);
    }


    @DeleteMapping("/{id}")
    public ResponseEntity<GenericResponse<StudentDTO>> delete(@PathVariable("id") Integer id)  throws Exception{
        service.delete(id);

        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }


    /* -------------QUERY----------- */

    @GetMapping("students/order")
    public ResponseEntity<GenericResponse<StudentDTO>>orderByAgeAsc()  throws Exception{
        List<StudentDTO> orderAsc = service.findAllByOrderByAgeAsc().stream().map(this::convertToDTO).toList();

        return  ResponseEntity.ok(new GenericResponse<>(200, "success", new ArrayList<>(orderAsc)));
    }







    private StudentDTO convertToDTO(Student student) {
        return modelMapper.map(student, StudentDTO.class);
    }

    private Student convertToEntity(StudentDTO studentDTO) {
        return modelMapper.map(studentDTO, Student.class);
    }



}
