package com.example.Rest.services;

import com.example.Rest.dto.DrugstoreDto;
import com.example.Rest.entities.Drugstore;
import com.example.Rest.mappers.DrugstoreMapper;
import com.example.Rest.repositories.DrugstoreRepository;
import com.example.Rest.services.base.BaseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DrugstoreService implements BaseService<Drugstore, DrugstoreDto, Long> {

    private final DrugstoreRepository drugstoreRepository;

    @Autowired
    public DrugstoreService(DrugstoreRepository drugstoreRepository) {
        this.drugstoreRepository = drugstoreRepository;
    }

    @Override
    public Drugstore findById(Long id) {
        return drugstoreRepository.findById(id).orElseThrow(
                () -> new RuntimeException("No Drugstore found with id: " + id)
        );
    }

    @Override
    public List<Drugstore> findAll() {
        return drugstoreRepository.findAll();
    }

    @Override
    public void save(DrugstoreDto dto) {
        drugstoreRepository.save(
                DrugstoreMapper.toEntity(dto)
        );
    }

    @Override
    public void delete(Long id) {
        drugstoreRepository.findById(id).orElseThrow(
                () -> new RuntimeException("No Drugstore found with id: " + id)
        );
        drugstoreRepository.deleteById(id);
    }

    @Override
    public void update(Drugstore entity) {
        drugstoreRepository.findById(entity.getId()).orElseThrow(
                () -> new RuntimeException("No Drugstore found with id: " + entity.getId())
        );
        drugstoreRepository.save(entity);
    }

    public String getDrugstoresAsXml() {
        List<Drugstore> drugstores = findAll();
        StringBuilder xmlBuilder = new StringBuilder();
        xmlBuilder.append("<drugstores>");
        for (Drugstore drugstore : drugstores) {
            xmlBuilder.append("<drugstore>")
                    .append("<id>").append(drugstore.getId()).append("</id>")
                    .append("<name>").append(drugstore.getName()).append("</name>")
                    .append("<address>").append(drugstore.getAddress()).append("</address>")
                    .append("</drugstore>");
        }
        xmlBuilder.append("</drugstores>");
        return xmlBuilder.toString();
    }
}
