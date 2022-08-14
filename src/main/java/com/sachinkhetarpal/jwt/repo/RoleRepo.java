package com.sachinkhetarpal.jwt.repo;

import com.sachinkhetarpal.jwt.model.Role;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RoleRepo extends JpaRepository<Role,Long> {

}
