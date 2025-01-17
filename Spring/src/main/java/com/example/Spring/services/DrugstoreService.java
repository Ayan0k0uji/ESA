package com.example.Spring.services;

import com.example.Spring.entities.Drugstore;
import com.example.Spring.repositories.DrugstoreRepository;
import com.example.Spring.services.base.BaseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DrugstoreService implements BaseService<Drugstore, Long> {

    private final DrugstoreRepository drugstoreRepository;

    @Autowired
    public DrugstoreService(DrugstoreRepository drugstoreRepository) {
        this.drugstoreRepository = drugstoreRepository;
    }

    @Override
    public Drugstore findById(Long id) {
        return drugstoreRepository.findById(id).orElseThrow(
                () -> new RuntimeException("No drugstore found with id: " + id)
        );
    }

    @Override
    public List<Drugstore> findAll() {
        return drugstoreRepository.findAll();
    }

    @Override
    public void save(Drugstore entity) {
        drugstoreRepository.save(entity);
    }

    @Override
    public void delete(Long id) {
        drugstoreRepository.findById(id).orElseThrow(
                () -> new RuntimeException("No drugstore found with id: " + id)
        );
        drugstoreRepository.deleteById(id);
    }

    @Override
    public void update(Drugstore entity) {
        drugstoreRepository.findById(entity.getId()).orElseThrow(
                () -> new RuntimeException("No drugstore found with id: " + entity.getId())
        );
        drugstoreRepository.save(entity);
    }
}
