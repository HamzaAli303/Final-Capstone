package com.devmountain.noteApp.repository;

import com.devmountain.noteApp.model.Employee;
import com.devmountain.noteApp.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserRepository extends JpaRepository<User, Long> {


    Optional<User> findByUsername(String username);
}
