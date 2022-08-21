package com.sachinkhetarpal.jwt.controller;

import com.sachinkhetarpal.jwt.model.User;
import com.sachinkhetarpal.jwt.service.CustomUserDetailsService;
import com.sachinkhetarpal.jwt.helper.JwtUtil;
import com.sachinkhetarpal.jwt.model.JwtRequest;
import com.sachinkhetarpal.jwt.model.JwtResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.DisabledException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.web.bind.annotation.*;

import java.security.Principal;

@RestController
@CrossOrigin
public class JwtController {

    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private CustomUserDetailsService customUserDetailsService;

    @Autowired
    private JwtUtil jwtUtil;

    @RequestMapping(value = "/token",method = RequestMethod.POST)
    public ResponseEntity<?> generateToken(@RequestBody JwtRequest jwtRequest) throws Exception {

        System.out.println(jwtRequest.getUsername()+jwtRequest.getPassword());
        try {
            this.authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(jwtRequest.getUsername(), jwtRequest.getPassword()));
        }
        catch(UsernameNotFoundException e){
            throw new Exception("User not found "+e.getMessage());
        }
        catch(DisabledException e){
            throw new Exception("User Disabled "+e.getMessage());
        }
        catch(BadCredentialsException e){
            throw new Exception("Bad credentials "+e.getMessage());
        }

        UserDetails userDetails = this.customUserDetailsService.loadUserByUsername(jwtRequest.getUsername());
        String token = this.jwtUtil.generateToken(userDetails);
        return ResponseEntity.ok(new JwtResponse(token));
    }

    @GetMapping("/current-user")
    public User getCurrentUser(Principal principal){
        return (User) this.customUserDetailsService.loadUserByUsername(principal.getName());
    }
}
