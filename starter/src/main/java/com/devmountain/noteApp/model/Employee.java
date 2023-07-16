package com.devmountain.noteApp.model;


import com.devmountain.noteApp.Dto.EmployeeDto;
import com.fasterxml.jackson.annotation.JsonBackReference;

import javax.persistence.*;

@Entity
@Table(name = "employees")
public class Employee {

    @Id
    @GeneratedValue(strategy =  GenerationType.IDENTITY)

    private Long id;
    @Column(name = "first_name")
    private String firstName;
    @Column(name = "last_name")
    private String lastName;
    @Column(name = "email")
    private String email;
    @ManyToOne
    @JsonBackReference
    private User user;

    public Long getId() {
        return id;
    }
    public void setId(Long id) {
        this.id = id;
    }
    public String getFirstName() {
        return firstName;
    }
    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }
    public String getLastName() {
        return lastName;
    }
    public void setLastName(String lastName) {
        this.lastName = lastName;
    }
    public String getEmail(){
        return email;
    }
    public void setEmail(String email) {
        this.email = email;
    }

    public Employee(EmployeeDto employeeDto){
        if(employeeDto.getFirstName() != null){
            this.firstName = employeeDto.getFirstName();
        }
        if(employeeDto.getLastName() != null){
            this.lastName = employeeDto.getLastName();
        }
        if(employeeDto.getEmail() != null){
            this.email = employeeDto.getEmail();
        }
    }
    public Employee(){

    }


}
