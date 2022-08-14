package com.sachinkhetarpal.jwt.repo;

import com.sachinkhetarpal.jwt.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepo extends JpaRepository<User,Long> {


    User findByUsername(String userName);
}
