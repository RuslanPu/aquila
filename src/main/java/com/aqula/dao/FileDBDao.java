package com.aqula.dao;

import com.aqula.model.FileDB;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface FileDBDao extends JpaRepository<FileDB, String> {

}
