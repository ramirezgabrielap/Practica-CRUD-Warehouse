package com.gaba.warehouse.repository;

import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import com.gaba.warehouse.model.User;

import org.springframework.security.core.userdetails.UserDetails;

public interface UserRepository extends JpaRepository<User, Integer> {
    User findByUsername(String username);
}