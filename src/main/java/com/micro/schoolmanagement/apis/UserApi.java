package com.micro.schoolmanagement.apis;

import com.micro.schoolmanagement.models.User;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDate;
import java.time.Month;
import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api-user/v1")
public class UserApi {

    @GetMapping("list")
    public List<User> getUsers(){
        List<User> allUsers = new ArrayList<>();
        User user = new User();
        user.setFirstName("simo");
        user.setLastName("addoumi");
        user.setDateOfBirth(LocalDate.of(1993, Month.SEPTEMBER,9));

        User user1 = User.builder().
                        firstName("test").
                        lastName("test").
                        dateOfBirth(LocalDate.of(1992,Month.APRIL,4)).
                        build();
        allUsers.add(User.builder().firstName("new name").lastName("new last").build());
        allUsers.add(user);
        allUsers.add(user1);
        return allUsers;
    }

}
