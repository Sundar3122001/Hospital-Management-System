package com.example.HospitalManagementSystemApplication.controllers;

import com.example.HospitalManagementSystemApplication.models.Users;
import com.example.HospitalManagementSystemApplication.service.JwtService;
import com.example.HospitalManagementSystemApplication.service.UsersService;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/auth")
public class AuthController {

    private final UsersService usersService;
    private final JwtService jwtService;

    public AuthController(UsersService usersService, JwtService jwtService) {
        this.usersService = usersService;
        this.jwtService = jwtService;
    }

    // REGISTER USER
    @PostMapping("/register")
    public Users register(@RequestBody Users user){
        return usersService.Register(user);
    }

    // LOGIN USER
    @PostMapping("/login")
    public String login(@RequestBody Users request){

        boolean valid = usersService.verifyUser(
                request.getUsername(),
                request.getPassword()
        );

        if(valid){
            System.out.println("Genrated token => "+jwtService.generateToken(request.getUsername()));
            return jwtService.generateToken(request.getUsername());
        }

        return "Invalid Credentials";
    }
}