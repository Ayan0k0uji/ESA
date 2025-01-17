package com.example.drugstore.services;

import com.example.drugstore.entities.Drug;
import com.example.drugstore.dao.DrugDao;
import jakarta.ejb.EJB;
import jakarta.ejb.Stateless;

import java.util.List;

@Stateless
public class DrugService {

    @EJB
    private DrugDao drugDao;

    public List<Drug> getAllDrugs() {
        List<Drug> drugs = drugDao.findAll();
        System.out.println("drugs: "  + drugs);
        return drugs;
    }

    public void createDrug(Drug newTeam) {
        drugDao.save(newTeam);
    }

    public void deleteDrug(Long id) {
        drugDao.delete(id);
    }
}
