package com.example.CaloriTrack.mappers;

import com.example.CaloriTrack.constants.Gender;
import com.example.CaloriTrack.constants.Goal;
import com.example.CaloriTrack.dto.request.user.UserDTO;
import com.example.CaloriTrack.model.User;
import org.junit.jupiter.api.Test;
import org.mapstruct.factory.Mappers;

import static org.junit.jupiter.api.Assertions.*;

class UserMapperTest {

    private final UserMapper userMapper = Mappers.getMapper(UserMapper.class);

    @Test
    void testToEntity() {
        UserDTO userDTO = new UserDTO();
        userDTO.setName("Иван Петров");
        userDTO.setEmail("ivan.petrov@example.com");
        userDTO.setAge(30);
        userDTO.setWeight(80.0);
        userDTO.setHeight(180.0);
        userDTO.setGoal(Goal.LOSE_WEIGHT);
        userDTO.setGender(Gender.MALE);

        User user = userMapper.toEntity(userDTO);

        assertNotNull(user);
        assertNull(user.getId());
        assertEquals(userDTO.getName(), user.getName());
        assertEquals(userDTO.getEmail(), user.getEmail());
        assertEquals(userDTO.getAge(), user.getAge());
        assertEquals(userDTO.getWeight(), user.getWeight());
        assertEquals(userDTO.getHeight(), user.getHeight());
        assertEquals(userDTO.getGoal(), user.getGoal());
        assertEquals(userDTO.getGender(), user.getGender());

        assertNull(user.getDailyCalories());
        assertNull(user.getMeals());
    }

    @Test
    void testToDto() {
        User user = new User();
        user.setId(1L);
        user.setName("Анна Смирнова");
        user.setEmail("anna.smirnova@example.com");
        user.setAge(25);
        user.setWeight(60.0);
        user.setHeight(165.0);
        user.setGoal(Goal.GAIN_WEIGHT);
        user.setGender(Gender.FEMALE);

        UserDTO userDTO = userMapper.toDto(user);

        assertNotNull(userDTO);
        assertEquals(user.getName(), userDTO.getName());
        assertEquals(user.getEmail(), userDTO.getEmail());
        assertEquals(user.getAge(), userDTO.getAge());
        assertEquals(user.getWeight(), userDTO.getWeight());
        assertEquals(user.getHeight(), userDTO.getHeight());
        assertEquals(user.getGoal(), userDTO.getGoal());
        assertEquals(user.getGender(), userDTO.getGender());
    }
}