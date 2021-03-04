package com.netcare.service;

import com.netcare.customexception.CustomException;
import com.netcare.entity.User;


public interface UserService {
    User findUserByUsernameAndPassword(String username, String password) throws CustomException;
}
