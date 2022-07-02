package com.micro.schoolmanagement.apis;

import com.micro.schoolmanagement.models.User;
import com.micro.schoolmanagement.repositories.UserRepository;
import com.micro.schoolmanagement.services.UserService;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import javax.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.context.support.DefaultMessageSourceResolvable;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api-user/v1")
@AllArgsConstructor
public class UserApi {

    private final UserRepository userRepository;

    private final UserService userService;

    @GetMapping("list")
    public List<User> getUsers() {
        return new ArrayList<>(userRepository.findAll());
    }

    @PostMapping("save")
    public User addUser(@RequestBody @Valid User user, Errors errors) {
        if (errors.hasErrors()) {
            errors.getAllErrors().stream()
                    .map(DefaultMessageSourceResolvable::getDefaultMessage)
                    .forEach(System.out::println);
        }

        return userService.saveUser(user);
    }

    @DeleteMapping("{id}")
    public User deleteUserById(@PathVariable Long id) {
        Optional<User> user = userRepository.findById(id);
        userRepository.delete(
                user.orElseThrow(
                        () ->
                                new IllegalArgumentException(
                                        "no user with the id " + id + " found")));
        return user.orElse(null);
    }

    @GetMapping("get")
    public String fetchUserByUserNameAndPassword(
            @RequestParam String userName, @RequestParam String password) {
        return userService.login(userName, password);
    }

    @GetMapping("info")
    public String about() {
        return "school management application test";
    }
}
