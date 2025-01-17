package com.example.Spring.services;

import com.example.Spring.entities.Drug;
import com.example.Spring.repositories.DrugRepository;
import com.example.Spring.services.base.BaseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.NoSuchElementException;

@Service
public class DrugService implements BaseService<Drug, Long> {

    private final DrugRepository drugRepository;

    @Autowired
    public DrugService(DrugRepository drugRepository) {
        this.drugRepository = drugRepository;
    }

    @Override
    public Drug findById(Long id) {
        return drugRepository.findById(id).orElseThrow(
                () -> new NoSuchElementException("No Drug found with id: " + id)
        );
    }

    @Override
    public List<Drug> findAll() {
        return drugRepository.findAll();
    }

    @Override
    public void save(Drug entity) {
        drugRepository.save(entity);
    }

    @Override
    public void delete(Long id) {
        drugRepository.findById(id).orElseThrow(
                () -> new NoSuchElementException("No Drug found with id: " + id)
        );
        drugRepository.deleteById(id);
    }

    @Override
    public void update(Drug entity) {
        drugRepository.findById(entity.getId()).orElseThrow(
                () -> new NoSuchElementException("No Drug found with id: " + entity.getId())
        );
        drugRepository.save(entity);
    }
}
