package com.aqula.repository;

import com.aqula.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserDaoRepository extends JpaRepository<User, Long> {
}
