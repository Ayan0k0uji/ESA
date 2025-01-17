package com.example.drugstore.dao;


import com.example.drugstore.entities.Drug;
import jakarta.ejb.Stateless;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;


import java.util.List;


@Stateless
public class DrugDao {

    @PersistenceContext
    private EntityManager entityManager;


    public void save(Drug drug) {
        entityManager.persist(drug);
    }

    public void delete(Long id) {
        Drug drug = entityManager.find(Drug.class, id);
        if (drug != null) {
            entityManager.remove(drug);
        }
    }

    public List<Drug> findAll() {
        List<Drug> drugs =  entityManager
                .createQuery("SELECT b FROM Drug b", Drug.class)
                .getResultList();
        System.out.println("drugs: "  + drugs);
        return drugs;
    }

    public Drug findById(Long id) {
        return entityManager.find(Drug.class, id);
    }

    public List<Drug> getDrugsByDrugStoreId(Long drugstoreId) {
        return entityManager.createQuery("SELECT b FROM Drug b WHERE b.library.id = :libraryId", Drug.class)
                .setParameter("drugstoreId", drugstoreId)
                .getResultList();
    }
}
