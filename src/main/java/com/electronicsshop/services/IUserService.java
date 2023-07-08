package com.electronicsshop.services;

import com.electronicsshop.dto.UserRequest;
import com.electronicsshop.dto.UserResponse;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface IUserService {

    void save(UserRequest userDto);

    List<UserResponse> getAllUsers();
}
