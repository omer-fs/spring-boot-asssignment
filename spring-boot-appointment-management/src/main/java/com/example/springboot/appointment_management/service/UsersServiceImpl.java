package com.example.springboot.appointment_management.service;

import com.example.springboot.appointment_management.dao.UsersRepository;
import com.example.springboot.appointment_management.entity.Users;
import com.example.springboot.appointment_management.exception.MyException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;


@Service
public class UsersServiceImpl implements UsersService{

    private UsersRepository usersRepository;

    PasswordEncoder passwordEncoder;

    @Autowired
    public UsersServiceImpl(UsersRepository theUserRepository) {
        usersRepository = theUserRepository;
        passwordEncoder = new BCryptPasswordEncoder();
    }


    @Override
    public List<Users> findAll() {
        return usersRepository.findAll();
    }

    @Override
    public Users findByUsername(String theUsername) {
        Optional<Users> result = usersRepository.findByUsername(theUsername);

        Users theUser = null;

        if(result.isPresent()) {
            theUser = result.get();
        }
        else {
            // could not find the patient
            throw new MyException("Could not find User - " + theUser);
        }

        return theUser;
    }

    @Override
    public void save(Users theUser) {

        String encodedPassword = passwordEncoder.encode(theUser.getPassword());
        theUser.setPassword(encodedPassword);

        usersRepository.save(theUser);
    }

    @Override
    public void deleteByUsername(String theUsername) {
        usersRepository.deleteByUsername(theUsername);
    }
}
