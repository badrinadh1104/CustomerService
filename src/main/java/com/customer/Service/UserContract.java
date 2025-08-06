package com.customer.Service;

import com.customer.DTO.LoginRequest;
import com.customer.DTO.UserRequest;
import com.customer.Model.User;

import java.util.List;

public interface UserContract {
    User register(UserRequest request);
    String login(LoginRequest request);
    String logout(String email);
    List<User> getAllUsers();
    User getUserById(Long id);
    User updateUser(Long id, UserRequest request);
    void deleteUser(Long id);
}
