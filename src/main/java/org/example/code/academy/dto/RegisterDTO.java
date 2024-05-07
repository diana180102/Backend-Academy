package org.example.code.academy.dto;

import com.fasterxml.jackson.annotation.*;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


import java.time.LocalDateTime;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@JsonInclude(JsonInclude.Include.NON_NULL)
public class RegisterDTO {


    private Integer idRegister;

    @NotNull
    private LocalDateTime datetime;

    @NotNull
    private StudentDTO student;

    private boolean state;

    @NotNull
    @JsonManagedReference
    private List<RegisterDetailsDTO> registerDetails;


}
