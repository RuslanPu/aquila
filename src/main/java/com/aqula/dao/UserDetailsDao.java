package com.aqula.dao;

import com.aqula.model.User;

public interface UserDetailsDao {

    User getUserByName(String username);

}
