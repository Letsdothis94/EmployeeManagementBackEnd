package com.employeeDB.domain.employee;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity(name = "Employee")
@Table(name = "employees")
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class Employee {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "first_name")
    private String firstName;
    @Column(name = "last_name")
    private String lastName;
    @Column(name = "email")
    private String email;


    public Employee(EmployeeData employeeData) {
        this.firstName = employeeData.fName();
        this.lastName = employeeData.lName();
        this.email = employeeData.email();
    }

    public void updateData(EmployeeUpdateData employeeUpdateData) {
        if(employeeUpdateData.fName() != null){
            this.firstName = employeeUpdateData.fName();
        }
        if(employeeUpdateData.lName() != null){
            this.lastName = employeeUpdateData.lName();
        }
        if(employeeUpdateData.email() != null){
            this.email = employeeUpdateData.email();
        }
    }
}
