package com.example.JMS.services;

import com.example.JMS.audit.service.AuditService;
import com.example.JMS.dto.DrugDto;
import com.example.JMS.entities.Drug;
import com.example.JMS.mappers.DrugMapper;
import com.example.JMS.repositories.DrugRepository;
import com.example.JMS.services.base.BaseService;
import com.example.JMS.services.base.XmlConvertService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.NoSuchElementException;

@Service
public class DrugService implements BaseService<Drug, DrugDto, Long>, XmlConvertService {

    private final DrugRepository drugRepository;

    private final DrugstoreService drugstoreService;

    private final AuditService auditService;

    @Autowired
    public DrugService(DrugRepository drugRepository, DrugstoreService drugstoreService, AuditService auditService) {
        this.drugRepository = drugRepository;
        this.drugstoreService = drugstoreService;
        this.auditService = auditService;
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
        Drug newDrug = drugRepository.save(drug);
        auditService.insertAuditEvent(newDrug);
    }

    @Override
    public void delete(Long id) {
        Drug drug = drugRepository.findById(id).orElseThrow(
                () -> new NoSuchElementException("No Drug found with id: " + id)
        );
        drugRepository.deleteById(id);
        auditService.deleteAuditEvent(drug);
    }

    @Override
    public void update(Drug entity) {
        drugRepository.findById(entity.getId()).orElseThrow(
                () -> new NoSuchElementException("No Drug found with id: " + entity.getId())
        );
        Drug updatedDrug = drugRepository.save(entity);
        auditService.updateAuditEvent(updatedDrug);
    }

    @Override
    public String getAsXml() {
        List<Drug> drugs = findAll();
        StringBuilder xmlBuilder = new StringBuilder();
        xmlBuilder.append("<drugs>");
        for (Drug drug : drugs) {
            xmlBuilder.append("<drug>")
                    .append("<id>").append(drug.getId()).append("</id>")
                    .append("<title>").append(drug.getTitle()).append("</title>")
                    .append("<description>").append(drug.getDescription()).append("</description>")
                    .append("</drug>");
        }
        xmlBuilder.append("</drugs>");
        return xmlBuilder.toString();
    }
}
