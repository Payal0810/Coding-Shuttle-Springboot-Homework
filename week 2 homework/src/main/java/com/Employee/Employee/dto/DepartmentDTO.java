package com.Employee.Employee.dto;

import com.Employee.Employee.validation.PrimeNumber;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.PastOrPresent;
import jakarta.validation.constraints.Size;
import lombok.Data;

import java.time.LocalDateTime;

@Data
public class DepartmentDTO {
    private Long id;

    @NotBlank(message = "Title cannot be blank.")
    @Size(min = 3, max = 30)
    private String title;

    @NotNull
    private Boolean isActive;

    @PastOrPresent
    private LocalDateTime createdAt;

    @PrimeNumber
    private Integer departmentCode;
}
