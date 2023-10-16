package com.employeeDB.controller;

import com.employeeDB.domain.employee.Employee;
import com.employeeDB.domain.employee.EmployeeData;
import com.employeeDB.domain.employee.EmployeeUpdateData;
import com.employeeDB.infra.exceptions.ExceptionHandler;
import com.employeeDB.infra.exceptions.ResourceNotFoundException;
import com.employeeDB.repository.EmployeeRepository;
import jakarta.transaction.Transactional;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "http://localhost:5173")
@RestController
@RequestMapping("/api/v1/")
public class EmployeeController {
    @Autowired
    private EmployeeRepository employeeRepository;

//    @PostMapping("/employees")
//    public Employee postEmployee(@RequestBody @Valid EmployeeData employeeData){
//        Employee employee = new Employee(employeeData);
//        return employeeRepository.save(employee);
//    }

    @PostMapping("/employees")
    public ResponseEntity postEmployee(@RequestBody @Valid EmployeeData employeeData){
        Employee employee = employeeRepository.save(new Employee(employeeData));
        return ResponseEntity.ok().build();
    }

    @GetMapping("/employees")
    public List<Employee> allEmployees(){
        return employeeRepository.findAll();
    }

    @GetMapping("/employees/{id}")
    public ResponseEntity<Employee> getEmployeeeById(@PathVariable Long id){
        Employee employee = employeeRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Employee with that id could not be found!"));
        return ResponseEntity.ok(employee);
    }

    @PutMapping("/employees")
    @Transactional
    public ResponseEntity<Employee> updateEmployee(@RequestBody @Valid EmployeeUpdateData employeeUpdateData){
        Employee employee = employeeRepository.getReferenceById(employeeUpdateData.id());
        employee.updateData(employeeUpdateData);
        return ResponseEntity.ok().build();
    }

    @DeleteMapping("/employees/{id}")
    public ResponseEntity deleteEmployee(@PathVariable Long id){
        System.out.println(id);
        employeeRepository.deleteById(id);
        return ResponseEntity.noContent().build();
    }
}
