package com.aqula.dao;

import com.aqula.model.EntryMainPage;
import com.aqula.model.MetaFileDB;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import java.util.List;

@Repository
public class MFileDbDao implements MetaFileDBDao{
    @PersistenceContext
    public EntityManager entityManager;

    @Override
    public List<MetaFileDB> getAllFiles() {
        return entityManager.createQuery("select files from MetaFileDB files").getResultList();
    }

    @Override
    public void add(MetaFileDB metaFileDB) {
        entityManager.persist(metaFileDB);
    }

    @Override
    public void edit(MetaFileDB metaFileDB) {
        entityManager.merge(metaFileDB);
    }

    @Override
    public void delete(MetaFileDB file) {
        if(file != null) {
            Query query = entityManager.createQuery("DELETE FROM MetaFileDB e WHERE e.id = :paramId");
            query.setParameter("paramId",file.getId());
            query.executeUpdate();

        }
    }

    @Override
    public MetaFileDB getFileById(Long id) {
        return entityManager.find(MetaFileDB.class, id);
    }
}
