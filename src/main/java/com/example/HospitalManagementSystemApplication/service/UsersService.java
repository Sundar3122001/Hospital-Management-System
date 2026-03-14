package com.example.HospitalManagementSystemApplication.service;

import com.example.HospitalManagementSystemApplication.Repository.UserRepository;
import com.example.HospitalManagementSystemApplication.models.Users;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UsersService {

    @Autowired
    private UserRepository repo;

    private final BCryptPasswordEncoder encoder = new BCryptPasswordEncoder(12);

    public Users Register(Users user){

        user.setPassword(encoder.encode(user.getPassword()));

        return repo.save(user);
    }

    public boolean verifyUser(String username, String password){

        Optional<Users> userOptional = repo.findByUsername(username);

        if(userOptional.isEmpty()){
            return false;
        }

        Users user = userOptional.get();

        return encoder.matches(password, user.getPassword());
    }
}