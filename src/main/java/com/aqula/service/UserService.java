package com.aqula.service;

import com.aqula.model.Role;
import com.aqula.model.User;

import java.util.List;

public interface UserService {
    List<User> getAllUser();
    void add(User user, String[] checkboxRoles);
    void edit(User user, String[] checkboxRoles);
    void delete(User user);
    User getUserById(Long id);
    void addRole(Role role);
    boolean unicEmail(String email);
    List<Role> getAllRole();
}
