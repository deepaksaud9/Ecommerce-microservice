package com.ecom.userservice.service;

import com.ecom.userservice.exception.NotFoundException;
import com.ecom.userservice.model.User;
import com.ecom.userservice.repository.UserRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserServiceImpl implements UserService{

    private final UserRepository userRepository;
    UserServiceImpl(UserRepository userRepository){
        this.userRepository = userRepository;
    }

    @Override
    public User addUser(User user) {

        User createUser = userRepository.save(user);

        return createUser;
    }

    @Override
    public User getUserById(Long userId) {

        Optional<User> user = userRepository.findById(userId);
        if (!user.isPresent()){
            throw new NotFoundException("this user not present");
        }
        return user.get();
    }

    @Override
    public User getUserByEmail(String userEmail) {

        Optional<User> user = userRepository.findUserByUserEmail(userEmail);

        if (!user.isPresent()){
            throw new NotFoundException("this user not found");
        }
        return user.get();
    }

    @Override
    public List<User> getAllUser() {

        List<User> users = userRepository.findAll();
        if (users==null){
            throw new NotFoundException("no user found at this time");
        }

        return users;
    }

    @Override
    public User updateUser(Long userId, User user) {

        Optional<User> updateUser = userRepository.findById(userId);
        if (!updateUser.isPresent()){
            throw new NotFoundException("user not found");
        }
        updateUser.get().setUserFullName(user.getUserFullName());
        updateUser.get().setUserEmail(user.getUserEmail());
        updateUser.get().setUserMobile(user.getUserMobile());
        updateUser.get().setUserAddress(user.getUserAddress());
        updateUser.get().setUserRole(user.getUserRole());
        userRepository.save(updateUser.get());
        return updateUser.get();
    }

    @Override
    public String deleteUser(Long userId) {

        Optional<User> user = userRepository.findById(userId);
        if (!user.isPresent()){
            throw new NotFoundException("this user not present in database");
        }
        userRepository.deleteById(userId);
        return "deleted Successfully";
    }
}
