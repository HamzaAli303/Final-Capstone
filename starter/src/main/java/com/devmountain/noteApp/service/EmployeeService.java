package com.devmountain.noteApp.service;



import com.devmountain.noteApp.Dto.EmployeeDto;
import com.devmountain.noteApp.model.Employee;
import org.springframework.data.domain.Page;

import javax.transaction.Transactional;
import java.util.List;

public interface EmployeeService {
    List<EmployeeDto> getAllEmployees();
    @Transactional
    void deleteEmployeeById(Long employeeId);
    @Transactional
    void addEmployee(EmployeeDto employeeDto);

    @Transactional
    void updateEmployeeById(EmployeeDto employeeDto);
}
