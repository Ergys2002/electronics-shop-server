package com.electronicsshop.repositories;

import com.electronicsshop.dto.UserResponse;
import com.electronicsshop.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.UUID;
@Repository
public interface IUserRepository extends JpaRepository<User, UUID> {

    @Query(" from User s where s.email = ?1")
    User findUserByEmail(String email);

    @Query(" from User u")
    List<UserResponse> getAll();
}
