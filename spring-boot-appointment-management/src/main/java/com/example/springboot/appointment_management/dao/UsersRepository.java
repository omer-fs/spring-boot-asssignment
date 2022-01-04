package com.example.springboot.appointment_management.dao;

import com.example.springboot.appointment_management.entity.Users;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

//@Repository
public interface UsersRepository extends JpaRepository<Users, String> {

    public Optional<Users> findByUsername(String username);

    public Long deleteByUsername(String username);
}
