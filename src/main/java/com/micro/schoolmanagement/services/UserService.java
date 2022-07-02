package com.micro.schoolmanagement.services;

import com.micro.schoolmanagement.models.User;
import com.micro.schoolmanagement.repositories.UserRepository;
import lombok.AllArgsConstructor;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@AllArgsConstructor
public class UserService {

    private final UserRepository userRepository;

    private final BCryptPasswordEncoder bCryptPasswordEncoder;

    public User saveUser(User user){
        if(checkUserNameAlreadyTaken(user)) throw new IllegalArgumentException("userName already taken");
        encryptUserName(user);
        return userRepository.save(user);
    }

    private void encryptUserName(User user) {
        user.setPassword(bCryptPasswordEncoder.encode(user.getPassword()));
    }

    private boolean checkUserNameAlreadyTaken(User user) {
        Optional<User> userFetched = userRepository.findByUserName(user.getUserName());
        return userFetched.isPresent();
    }

    public String login(String userName,String password){
        Optional<User> userFecthedByUserName = userRepository.findByUserName(userName);
        String passwordFetched = userFecthedByUserName.map(User::getPassword)
                                                .orElseThrow(()->
                                                        new IllegalArgumentException("user not found by username"));
        boolean passwordMatches = bCryptPasswordEncoder.matches(password, passwordFetched);
        if(!passwordMatches) throw new IllegalArgumentException("password does not match");
        return "welcome Mr " + userFecthedByUserName.map(User::getFirstName).orElse(null);
    }
}
