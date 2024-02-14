package com.ecom.userservice.service;

import com.ecom.userservice.model.User;

import java.util.List;

public interface UserService {

    User addUser(User user);
    User getUserById(Long userId);
    User getUserByEmail(String userEmail);
    List<User> getAllUser();
    User updateUser(Long userId, User user);
    String deleteUser(Long UserId);

}
