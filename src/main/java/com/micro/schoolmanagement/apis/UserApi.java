package com.micro.schoolmanagement.apis;

import com.micro.schoolmanagement.models.User;
import com.micro.schoolmanagement.repositories.UserRepository;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDate;
import java.time.Month;
import java.util.ArrayList;
import java.util.List;

@AllArgsConstructor
@RestController
@RequestMapping("/api-user/v1")
public class UserApi {

    private final UserRepository userRepository;

    @GetMapping("list")
    public List<User> getUsers(){
        return new ArrayList<>(userRepository.findAll());
    }

}
