package com.example.repo;

import com.example.model.UserRegistration;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRegistrationRepo extends JpaRepository<UserRegistration,Integer> {
}
