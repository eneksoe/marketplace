package com.example.marketplace.service;

import com.example.marketplace.model.User;

import java.util.List;
import java.util.Map;

public interface UserService {
    boolean create(User user);
    List<User> list();
    void banUser(Long id);
    void changeUserRoles(User user, Map<String, String> form);
}
