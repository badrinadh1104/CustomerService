package com.customer.Service;

import com.customer.DTO.LoginRequest;
import com.customer.DTO.UserRequest;
import com.customer.Model.User;
import com.customer.Respository.UserRespository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService implements  UserContract{

    private final UserRespository userRespository;

    public UserService(UserRespository userRespository) {
        this.userRespository = userRespository;
    }

    @Override
    public User register(UserRequest request) {
        if (userRespository.existsByEmail(request.getEmail())) {
            throw new RuntimeException("Email already in use.");
        }

        User user = new User();
        user.setName(request.getName());
        user.setEmail(request.getEmail());
        user.setPassword(request.getPassword()); // Store as-is for now (not secure)
        user.setRole("USER");

        return userRespository.save(user);
    }

    @Override
    public String login(LoginRequest request) {
        User user = userRespository.findByEmail(request.getEmail())
                .orElseThrow(() -> new RuntimeException("User not found"));

        if (!user.getPassword().equals(request.getPassword())) {
            throw new RuntimeException("Invalid credentials");
        }

        return "Login successful for " + user.getName();
    }

    @Override
    public String logout(String email) {
        // For now, simple message - no session tracking
        return "User with email " + email + " logged out.";
    }

    @Override
    public List<User> getAllUsers() {
        return userRespository.findAll();
    }

    @Override
    public User getUserById(Long id) {
        return userRespository.findById(id)
                .orElseThrow(() -> new RuntimeException("User not found"));
    }

    @Override
    public User updateUser(Long id, UserRequest request) {
        User user = getUserById(id);
        user.setName(request.getName());
        user.setEmail(request.getEmail());
        user.setPassword(request.getPassword());
        return userRespository.save(user);
    }

    @Override
    public void deleteUser(Long id) {
        userRespository.deleteById(id);
    }

    public String UserMessage(){
        return "Hello Random User";
    }
}
