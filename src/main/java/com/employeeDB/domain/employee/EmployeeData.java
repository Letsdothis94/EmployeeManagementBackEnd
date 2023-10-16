package com.employeeDB.domain.employee;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;

public record EmployeeData(@NotBlank String fName, @NotBlank String lName, @NotBlank @Email String email) {
}
