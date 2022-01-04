package com.example.springboot.appointment_management.converter;


import com.example.springboot.appointment_management.dto.UsersDto;
import com.example.springboot.appointment_management.entity.Users;
import org.mapstruct.Mapper;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
@Mapper
public class UsersConverter {

    public UsersDto entityToDto(Users users) {
        ModelMapper mapper = new ModelMapper();
        return mapper.map(users, UsersDto.class);
    }

    public Users dtoToEntity(UsersDto usersDto) {
        ModelMapper mapper = new ModelMapper();
        return mapper.map(usersDto, Users.class);
    }

    public List<UsersDto> entityToDto(List<Users> usersList) {
        return usersList.stream().map(this::entityToDto).collect(Collectors.toList());
    }

    public List<Users> dtoToEntity(List<UsersDto> usersDtoList) {
        return usersDtoList.stream().map(this::dtoToEntity).collect(Collectors.toList());
    }
}
