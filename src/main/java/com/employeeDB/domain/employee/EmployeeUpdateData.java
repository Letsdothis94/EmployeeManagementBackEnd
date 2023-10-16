package com.employeeDB.domain.employee;

import jakarta.validation.constraints.NotNull;

public record EmployeeUpdateData(@NotNull Long id, String fName, String lName, String email) {
}
