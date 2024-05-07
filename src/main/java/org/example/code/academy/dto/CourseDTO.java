package org.example.code.academy.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@JsonInclude(JsonInclude.Include.NON_NULL)
public class CourseDTO {


    private Integer idCourse;

    @NotNull
    @Size(min = 4)
    private String name;

    @NotNull
    @Size(min = 3)
    private String acronym;

    private boolean state;

}
