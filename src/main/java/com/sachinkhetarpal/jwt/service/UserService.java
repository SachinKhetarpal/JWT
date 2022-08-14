package com.sachinkhetarpal.jwt.service;

import com.sachinkhetarpal.jwt.model.Role;
import com.sachinkhetarpal.jwt.model.User;
import com.sachinkhetarpal.jwt.model.UserRole;

import java.util.Set;

public interface UserService {
    User createUser(User user, Set<UserRole> userRoles) throws Exception;
    User getUserByUsername(String username);

    void deleteUser(Long userId);
}
