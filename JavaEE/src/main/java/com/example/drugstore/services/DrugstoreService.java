package com.example.drugstore.services;

import com.example.drugstore.entities.Drugstore;
import com.example.drugstore.dao.DrugstoreDao;
import jakarta.ejb.EJB;
import jakarta.ejb.Stateless;

import java.util.List;

@Stateless
public class DrugstoreService {

    @EJB
    private DrugstoreDao drugstoreDao;

    public List<Drugstore> getAllDrugStores() {
        return drugstoreDao.findAll();
    }

    public Drugstore getDrugStoreById(Long id) {
        return drugstoreDao.findById(id);
    }

    public void createDrugStore(Drugstore drugstore) {
        drugstoreDao.save(drugstore);
    }

    public void deleteDrugStore(Long id) {
        drugstoreDao.delete(id);
    }
}
