package com.devmountain.noteApp.controller;

import com.devmountain.noteApp.Dto.EmployeeDto;
import com.devmountain.noteApp.model.Employee;
import com.devmountain.noteApp.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin
@RequestMapping("/")
public class EmployeeController {

    @Autowired
    private EmployeeService employeeService;
    // display list of employees
    @GetMapping("/employees")
    public List<EmployeeDto> getAllEmployees(){
        return employeeService.getAllEmployees();
    }

    @DeleteMapping("/employees/{employeeId}")
    public void deleteEmployeeById(@PathVariable Long employeeId){
        employeeService.deleteEmployeeById(employeeId);
    }

    @PostMapping("/employees")
    public void addEmployee(@RequestBody EmployeeDto employeeDto){
        employeeService.addEmployee(employeeDto);
    }

    @PutMapping("/employees")
    public void updateEmployee(@RequestBody EmployeeDto employeeDto){
        employeeService.updateEmployeeById(employeeDto);
    }

}
