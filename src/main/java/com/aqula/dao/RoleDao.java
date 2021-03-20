package com.aqula.dao;

import com.aqula.model.Role;

import java.util.List;

public interface RoleDao {
    void add(Role role);
    Role getRoleById(Long id);
    Role getRoleByName(String name);
    List<Role> getAllRole();

}
