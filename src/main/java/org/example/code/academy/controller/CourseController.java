package org.example.code.academy.controller;


import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.example.code.academy.dto.GenericResponse;
import org.example.code.academy.dto.CourseDTO;
import org.example.code.academy.model.Course;
import org.example.code.academy.service.ICourseService;
import org.modelmapper.ModelMapper;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@RestController
@RequestMapping("/courses")
@RequiredArgsConstructor
public class CourseController {

    private final ICourseService service;

    private final ModelMapper modelMapper;


    @GetMapping
    public ResponseEntity<GenericResponse<CourseDTO>>readAll()  throws Exception{

        List <CourseDTO> list = service.readAll().stream().map(this::convertToDTO).toList();

        return ResponseEntity.ok(new GenericResponse<>(200, "success", new ArrayList<>(list)) );
    }

    @GetMapping("/{id}")
    public ResponseEntity<GenericResponse<CourseDTO>>readById( @PathVariable("id") @RequestParam Integer id)  throws Exception{

        CourseDTO course = convertToDTO(service.readById(id));

        return ResponseEntity.ok(new GenericResponse<>(200, "success", Arrays.asList(course) ));
    }

    @PostMapping
    public ResponseEntity<CourseDTO> save(@Valid @RequestBody CourseDTO courseDTO)  throws Exception{

        Course course = service.save(convertToEntity(courseDTO));

        return new ResponseEntity<>(convertToDTO(course), HttpStatus.CREATED);
    }


    @PutMapping("/{id}")
    public ResponseEntity<CourseDTO> update( @Valid @PathVariable("id") Integer id, @RequestBody CourseDTO courseDTO)  throws Exception{
        Course course = service.update(convertToEntity(courseDTO), id);

        return new ResponseEntity<>(convertToDTO(course), HttpStatus.OK);
    }


    @DeleteMapping("/{id}")
    public ResponseEntity<GenericResponse<CourseDTO>> delete(@PathVariable("id") Integer id)  throws Exception{
        service.delete(id);

        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    /* QUERY */








    private CourseDTO convertToDTO(Course course) {
        return modelMapper.map(course, CourseDTO.class);
    }

    private Course convertToEntity(CourseDTO courseDTO) {
        return modelMapper.map(courseDTO, Course.class);
    }



}
