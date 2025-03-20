package com.example.CaloriTrack.service;

import com.example.CaloriTrack.dto.request.user.UserDTO;
import com.example.CaloriTrack.mappers.UserMapper;
import com.example.CaloriTrack.model.DailyCalories;
import com.example.CaloriTrack.model.User;
import com.example.CaloriTrack.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class UserService {

    private final UserRepository userRepository;
    private final CaloriesService caloriesService;
    private final UserMapper userMapper;

    @Transactional(isolation = Isolation.SERIALIZABLE)
    public void registrationUser(UserDTO request) {

        User user = userMapper.toEntity(request);
        List<DailyCalories> dailyCalories = caloriesService.calculateDailyCalories(user);
        user.setDailyCalories(dailyCalories);
        userRepository.save(user);
    }

    @Transactional(readOnly = true)
    public Optional<User> findById(Long id) {
        return userRepository.findById(id);
    }
}