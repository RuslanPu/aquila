package com.aqula.dao;

import com.aqula.model.EntryMainPage;

import java.util.List;

public interface EntryDao {
    List<EntryMainPage> getAllEntry();
    void add(EntryMainPage entry);
    void edit(EntryMainPage entry);
    void delete(EntryMainPage entry);
    EntryMainPage getEntryById(Long id);

}
