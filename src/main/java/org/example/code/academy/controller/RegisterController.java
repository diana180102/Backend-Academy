package org.example.code.academy.controller;


import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.example.code.academy.dto.GenericResponse;
import org.example.code.academy.dto.RegisterDTO;
import org.example.code.academy.model.Register;
import org.example.code.academy.service.IRegisterService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/registers")
@RequiredArgsConstructor
public class RegisterController {

    private final IRegisterService service;

    @Qualifier("defaultMapper")
    private final ModelMapper modelMapper;


    @GetMapping
    public ResponseEntity<GenericResponse<RegisterDTO>>readAll()  throws Exception{

        List <RegisterDTO> list = service.readAll().stream().map(this::convertToDTO).toList();

        return ResponseEntity.ok(new GenericResponse<>(200, "success", new ArrayList<>(list)) );
    }

    @GetMapping("/{id}")
    public ResponseEntity<GenericResponse<RegisterDTO>>readById( @PathVariable("id") @RequestParam Integer id)  throws Exception{

        RegisterDTO register = convertToDTO(service.readById(id));

        return ResponseEntity.ok(new GenericResponse<>(200, "success", Arrays.asList(register) ));
    }

    @PostMapping
    public ResponseEntity<RegisterDTO> save(@Valid @RequestBody RegisterDTO registerDTO)  throws Exception{

        Register register = service.save(convertToEntity(registerDTO));

        return new ResponseEntity<>(convertToDTO(register), HttpStatus.CREATED);
    }


    @PutMapping("/{id}")
    public ResponseEntity<RegisterDTO> update( @Valid @PathVariable("id") Integer id, @RequestBody RegisterDTO registerDTO)  throws Exception{
        Register register = service.update(convertToEntity(registerDTO), id);

        return new ResponseEntity<>(convertToDTO(register), HttpStatus.OK);
    }


    @DeleteMapping("/{id}")
    public ResponseEntity<GenericResponse<RegisterDTO>> delete(@PathVariable("id") Integer id)  throws Exception{
        service.delete(id);

        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @GetMapping("/courseCount")
     public ResponseEntity<Map<String, Long>> getCourseCount()  throws Exception{
        Map<String, Long> byCourse = service.getCourseCountStudent();
        return ResponseEntity.ok(byCourse);
    }

    @GetMapping("/courseStudent")

    public ResponseEntity<Map<Object, List<String>>> getCourseStudent()  throws Exception{

        Map<Object, List<String>> byCourse = service.getCourseNameStudent();
        return ResponseEntity.ok(byCourse);
    }







    private RegisterDTO convertToDTO(Register register) {
        return modelMapper.map(register, RegisterDTO.class);
    }

    private Register convertToEntity(RegisterDTO registerDTO) {
        return modelMapper.map(registerDTO, Register.class);
    }



}
