package com.devmountain.noteApp.Dto;

import com.devmountain.noteApp.model.Employee;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class EmployeeDto implements Serializable {
    private Long id;
    private String firstName;
    private String lastName;
    private String email;

    public EmployeeDto(Employee employee){
        if(employee.getId() != null){
            this.id = employee.getId();
        }
        if(employee.getFirstName() != null){
            this.firstName = employee.getFirstName();
        }
        if(employee.getLastName() != null){
            this.lastName = employee.getLastName();
        }
        if(employee.getEmail() != null){
            this.email = employee.getEmail();
        }
    }

}