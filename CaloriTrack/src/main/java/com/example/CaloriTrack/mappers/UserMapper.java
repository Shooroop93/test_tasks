package com.example.CaloriTrack.mappers;

import com.example.CaloriTrack.dto.request.user.UserDTO;
import com.example.CaloriTrack.model.User;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface UserMapper {

    @Mapping(target = "id", ignore = true)
    @Mapping(target = "dailyCalories", ignore = true)
    @Mapping(target = "meals", ignore = true)
    User toEntity(UserDTO dto);

    UserDTO toDto(User user);
}