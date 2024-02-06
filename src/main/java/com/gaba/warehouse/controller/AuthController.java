package com.gaba.warehouse.controller;

import com.gaba.warehouse.model.Role;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import com.gaba.warehouse.model.Thing;
import com.gaba.warehouse.model.User;
import com.gaba.warehouse.repository.ThingRepository;
import com.gaba.warehouse.repository.UserRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;

@Controller
public class AuthController {

    @Autowired
    private final UserRepository userRepository;
    
    public AuthController(UserRepository userRepository) {
        this.userRepository = userRepository;
    }
    

    @GetMapping("/login")
    public String login() {
        System.out.println("LOGINN!!!!!");
        return "login";
    }
    
    @GetMapping("/logout")
    public String logout() {
        return "redirect:/login";
    }
    
    
    @GetMapping("/register")
    public String register() {
        System.out.println("AAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAA");

        User user = new User();
        user.setUsername("userA");
        user.setPassword("test1234");
        user.setName("TheUser");
        user.setLastname("UserApp");
        userRepository.save(user);
              
        
        BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
        User userB = new User();
        userB.setUsername("userB");
        userB.setPassword("test123");
        userB.setName("TheUserB");
        userB.setLastname("UserBApp");
        String encodedPassword = passwordEncoder.encode(userB.getPassword());
        userB.setPassword(encodedPassword);

        userRepository.save(userB);
                              
        return "redirect:/login";
    }
    
}
