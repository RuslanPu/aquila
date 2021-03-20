package com.aqula.service;

import com.aqula.model.EntryMainPage;


import java.util.List;

public interface EntryService {
    List<EntryMainPage> getAllEntry();
    void add(EntryMainPage entry);
    void edit(EntryMainPage entry);
    void delete(EntryMainPage entry);
    EntryMainPage getEntryById(Long id);
}
