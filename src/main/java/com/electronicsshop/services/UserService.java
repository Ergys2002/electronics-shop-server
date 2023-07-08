package com.electronicsshop.services;

import com.electronicsshop.dto.UserRequest;
import com.electronicsshop.dto.UserResponse;
import com.electronicsshop.entities.User;
import com.electronicsshop.repositories.IUserRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class UserService implements IUserService{

    protected final IUserRepository userRepository;

    @Override
    public void save(UserRequest userDto) {

        User existingUser = userRepository.findUserByEmail(userDto.getEmail());
        if(existingUser != null){
            throw new RuntimeException("User exists");
        }

        User user = User.builder()
                .firstName(userDto.getFirstName())
                .lastName(userDto.getLastName())
                .email(userDto.getEmail())
                .password(userDto.getPassword())
                .phone(userDto.getPhone())
                .role(userDto.getRole())
                .build();

        userRepository.save(user);
    }

    @Override
    public List<UserResponse> getAllUsers() {
        return userRepository.getAll();
    }
}
