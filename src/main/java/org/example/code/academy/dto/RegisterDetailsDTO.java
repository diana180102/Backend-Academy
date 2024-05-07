package org.example.code.academy.dto;



import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonInclude;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@JsonInclude(JsonInclude.Include.NON_NULL)
public class RegisterDetailsDTO {



    private Integer idDetails;

    @NotNull
    private String classroom;

    @NotNull
    private CourseDTO course;

    @JsonBackReference
    private RegisterDTO register;


}
