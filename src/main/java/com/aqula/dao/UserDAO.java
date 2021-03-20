package com.aqula.dao;

import com.aqula.model.User;

import java.util.List;

public interface UserDAO {
    List<User> getAllUser();
    void add(User user);
    void edit(User user);
    void delete(User user);
    User getUserById(Long id);
    boolean unicEmail(String email);
}
