package com.backendSpring.BackendSpring.Repository;

import com.backendSpring.BackendSpring.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {
    User findByUsername(String username);

}
