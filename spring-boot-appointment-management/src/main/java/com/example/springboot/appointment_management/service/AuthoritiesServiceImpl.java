package com.example.springboot.appointment_management.service;

import com.example.springboot.appointment_management.dao.AuthoritiesRepository;
import com.example.springboot.appointment_management.entity.Authorities;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class AuthoritiesServiceImpl implements AuthoritiesService{

    private AuthoritiesRepository authoritiesRepository;

    @Autowired
    public AuthoritiesServiceImpl(AuthoritiesRepository theAuthoritiesRepository) {
        authoritiesRepository = theAuthoritiesRepository;
    }

    @Override
    public void save(Authorities theAuthority) {
        authoritiesRepository.save(theAuthority);
    }
}
