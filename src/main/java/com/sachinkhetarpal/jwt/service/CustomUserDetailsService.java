package com.sachinkhetarpal.jwt.service;

import com.sachinkhetarpal.jwt.model.User;
import com.sachinkhetarpal.jwt.repo.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
@Service
public class CustomUserDetailsService implements UserDetailsService {

    @Autowired
    private UserRepo userRepo;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

        User user = this.userRepo.findByUsername(username);
        if(user==null){
            System.out.println("User not found.");
            throw new UsernameNotFoundException("No user found!!");
        }
        return user;
    }
}
