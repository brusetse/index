package com.brusetse.phoenix.api.repository;

import com.brusetse.phoenix.api.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface UserRepository extends JpaRepository<User, Long> {
    List<User> findByAge(Integer age);
}
