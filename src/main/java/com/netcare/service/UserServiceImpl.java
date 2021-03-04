package com.netcare.service;

import com.netcare.customexception.CustomException;
import com.netcare.entity.User;
import com.netcare.repository.UserRepository;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;


@Service
@AllArgsConstructor
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;


    @Override
    public User findUserByUsernameAndPassword(String username, String password) throws CustomException {
        return userRepository.findUserByUsernameAndPassword(username,password).orElseThrow(()->new CustomException("Developer with Username "+username+"and with password"+password+"" +
                "was not found", HttpStatus.NOT_FOUND));
    }
}
