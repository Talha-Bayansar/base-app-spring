package com.talhabayansar.baseapp.authentication.repositories;

import java.util.Optional;

import com.talhabayansar.baseapp.authentication.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Integer> {

    Optional<User> findByEmail(String email);

}
