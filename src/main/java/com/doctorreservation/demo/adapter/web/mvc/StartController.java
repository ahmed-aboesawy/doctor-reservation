package com.doctorreservation.demo.adapter.web.mvc;

import com.doctorreservation.demo.adapter.database.AuthGroupRepository;
import com.doctorreservation.demo.adapter.database.UserRepository;
import com.doctorreservation.demo.adapter.entity.AuthGroup;
import com.doctorreservation.demo.adapter.entity.User;
import lombok.AllArgsConstructor;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;


@Controller
@RequestMapping
@AllArgsConstructor
public class StartController {

    private final UserRepository userRepository;

    private final AuthGroupRepository groupRepository;

    @GetMapping
    public String homePage(){
        return "index";
    }

    @GetMapping("swagger")
    @PreAuthorize(value = "hasRole('ROLE_USER')")
    public String swaggerPage(){
        return "redirect://localhost:8080/swagger-ui.html";
    }

    @GetMapping("/login")
    public String getLoginPage(){
        return "login";
    }



    @PostMapping("/add-user")
    @ResponseBody
    @PreAuthorize(value = "hasRole('ROLE_ADMIN')")
    public String addNewUser(@RequestParam String username, @RequestParam String password, @RequestParam String role){
        User user = new User();
        BCryptPasswordEncoder encoder = new BCryptPasswordEncoder(12);
        user.setUsername(username);
        user.setPassword(encoder.encode(password));
        userRepository.save(user);

        if(role.equalsIgnoreCase("admin")){
            groupRepository.save(new AuthGroup(username,"ROLE_USER"));
            groupRepository.save(new AuthGroup(username,"ROLE_ADMIN"));
        }else
            groupRepository.save(new AuthGroup(username,"ROLE_USER"));

        return "Username:  "+username+"      ,Role:  "+role;
    }


}
