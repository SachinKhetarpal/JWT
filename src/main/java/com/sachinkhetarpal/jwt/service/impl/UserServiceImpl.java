package com.sachinkhetarpal.jwt.service.impl;

import com.sachinkhetarpal.jwt.model.User;
import com.sachinkhetarpal.jwt.model.UserRole;
import com.sachinkhetarpal.jwt.repo.RoleRepo;
import com.sachinkhetarpal.jwt.repo.UserRepo;
import com.sachinkhetarpal.jwt.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Set;
@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepo userRepo;

    @Autowired
    private RoleRepo roleRepo;

    @Override
    public User createUser(User user, Set<UserRole> userRoles) throws Exception {

        User local = this.userRepo.findByUsername(user.getUsername());
        if(local!=null)
        {
            System.out.println("Username already present!");
            throw new Exception("Username already present!");
        }
        else if(this.userRepo.existsById(user.getMobile())){
            System.out.println("User with same mobile already present!");
            throw new Exception("User with same mobile already present!");
        }
        else
        {
            for(UserRole userRole:userRoles){
                roleRepo.save(userRole.getRole());
            }

            user.getUserRoles().addAll(userRoles);
            local = this.userRepo.save(user);
        }


        return local;
    }

    @Override
    public User getUserByUsername(String username) {
        return this.userRepo.findByUsername(username);
    }
    @Override
    public void deleteUser(Long userId){
        this.userRepo.deleteById(userId);
    }
}
