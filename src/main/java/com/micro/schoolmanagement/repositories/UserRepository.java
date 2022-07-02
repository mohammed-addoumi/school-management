package com.micro.schoolmanagement.repositories;

import com.micro.schoolmanagement.models.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User,Long> {
}
