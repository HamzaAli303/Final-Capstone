package com.devmountain.noteApp.service;


import com.devmountain.noteApp.Dto.EmployeeDto;
import com.devmountain.noteApp.model.Employee;
import com.devmountain.noteApp.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class EmployeeServiceImpl implements  EmployeeService{

    @Autowired
    private EmployeeRepository employeeRepository;

    public List<EmployeeDto> getAllEmployees(){
        List<Employee> employeesList = employeeRepository.findAll();
        return employeesList.stream().map(employees -> new EmployeeDto(employees)).collect(Collectors.toList());
    }

    @Override
    public void deleteEmployeeById(Long employeeId) {
        Optional<Employee> employeeOptional = employeeRepository.findById(employeeId);
        employeeOptional.ifPresent(employee ->employeeRepository.delete(employee));
    }

    @Override
    @Transactional
    public void addEmployee(EmployeeDto employeeDto) {
        Employee employee = new Employee(employeeDto);
        employeeRepository.saveAndFlush(employee);
    }

    @Override
    public void updateEmployeeById(EmployeeDto employeeDto) {
        Optional<Employee> employeeOptional = employeeRepository.findById(employeeDto.getId());
        employeeOptional.ifPresent(employee -> {
            employee.setFirstName(employeeDto.getFirstName());
            employee.setLastName(employeeDto.getLastName());
            employee.setEmail(employeeDto.getEmail());
            employeeRepository.saveAndFlush(employee);
        });
    }


}