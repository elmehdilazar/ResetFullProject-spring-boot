package com.mehdi.resetfullprojectspringboot.repositories;

import com.mehdi.resetfullprojectspringboot.models.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User,Long> {
}
