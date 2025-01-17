package com.example.Rest.services;

import com.example.Rest.dto.DrugDto;
import com.example.Rest.entities.Drug;
import com.example.Rest.mappers.DrugMapper;
import com.example.Rest.repositories.DrugRepository;
import com.example.Rest.services.base.BaseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.NoSuchElementException;

@Service
public class DrugService implements BaseService<Drug, DrugDto, Long> {

    private final DrugRepository drugRepository;

    private final DrugstoreService drugstoreService;

    @Autowired
    public DrugService(DrugRepository drugRepository, DrugstoreService drugstoreService) {
        this.drugRepository = drugRepository;
        this.drugstoreService = drugstoreService;
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
    public void save(DrugDto dto) {
        Drug drug = DrugMapper.toEntity(dto);
        drug.setDrugstore(
            drugstoreService.findById(dto.getDrugstoreId())
        );
        drugRepository.save(drug);
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

    public String getDrugsAsXml() {
        List<Drug> drugs = findAll();
        StringBuilder xmlBuilder = new StringBuilder();
        xmlBuilder.append("<drugs>");
        for (Drug drug : drugs) {
            xmlBuilder.append("<drugs>")
                    .append("<id>").append(drug.getId()).append("</id>")
                    .append("<title>").append(drug.getTitle()).append("</title>")
                    .append("<description>").append(drug.getDescription()).append("</description>")
                    .append("</drugs>");
        }
        xmlBuilder.append("</drugs>");
        return xmlBuilder.toString();
    }
}
