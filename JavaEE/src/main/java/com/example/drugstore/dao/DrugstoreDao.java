package com.example.drugstore.dao;


import com.example.drugstore.entities.Drugstore;
import jakarta.ejb.Stateless;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;

import java.util.List;


@Stateless
public class DrugstoreDao {

    @PersistenceContext
    private EntityManager entityManager;

    public void save(Drugstore drugstore) {
        entityManager.persist(drugstore);
    }

    public Drugstore findById(Long id) {
        return entityManager.find(Drugstore.class, id);
    }

    public List<Drugstore> findAll() {
        return entityManager.createQuery("SELECT l FROM Drugstore l", Drugstore.class).getResultList();
    }

    public void delete(Long id) {
        Drugstore drugstore = entityManager.find(Drugstore.class, id);
        if (drugstore != null) {
            entityManager.remove(drugstore);
        }
    }
}
