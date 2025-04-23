package com.example.rangoli;

import jakarta.annotation.security.PermitAll;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api")
@CrossOrigin("*")
public class UserController {
    UserRepository userRepository;
    PasswordEncoder passwordEncoder;
    @Autowired
    public UserController(UserRepository userRepository){
        this.userRepository=userRepository;
        this.passwordEncoder=new BCryptPasswordEncoder();
    }
    @PostMapping("/register")
    @PermitAll
    public ResponseEntity<?> registerUser(@RequestBody User user){
        if(userRepository.existsByEmail(user.getEmail())){
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("email already in use");
        }
        if("GOOGLE_AUTH".equals(user.getPassword())){
            System.out.println("Registering user: " + user.getEmail());
            userRepository.save(user);
            return ResponseEntity.status(HttpStatus.CREATED).body("User Registered Successfully");
        }else {
            user.setPassword(passwordEncoder.encode(user.getPassword()));
            userRepository.save(user);
            return ResponseEntity.status(HttpStatus.CREATED).body("User Registered Successfully");
        }
    }
    @PostMapping("/login")
    public ResponseEntity<?> loginUser(@RequestBody LoginRequest loginRequest){
        User user=userRepository.findByEmail(loginRequest.getEmail());
        if(user!=null && passwordEncoder.matches(loginRequest.getPassword(),user.getPassword())){
            return ResponseEntity.ok("Login Successful");
        }else {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("Invalid Email or Password!");
        }
    }
    @GetMapping("/account")
    @ResponseBody
    public ResponseEntity<?> accountDetails(@RequestParam String email){
        User details=userRepository.findByEmail(email);
        if(details!=null){
            return ResponseEntity.ok(details);
        }else{
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("User not found");
        }
    }
}
