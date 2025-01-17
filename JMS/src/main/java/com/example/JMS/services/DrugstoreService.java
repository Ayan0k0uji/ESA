package com.example.JMS.services;

import com.example.JMS.audit.service.AuditService;
import com.example.JMS.dto.DrugstoreDto;
import com.example.JMS.entities.Drugstore;
import com.example.JMS.mappers.DrugstoreMapper;
import com.example.JMS.repositories.DrugstoreRepository;
import com.example.JMS.services.base.BaseService;
import com.example.JMS.services.base.XmlConvertService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DrugstoreService implements BaseService<Drugstore, DrugstoreDto, Long>, XmlConvertService {

    private final DrugstoreRepository drugstoreRepository;

    private final AuditService auditService;


    @Autowired
    public DrugstoreService(DrugstoreRepository drugstoreRepository, AuditService auditService) {
        this.drugstoreRepository = drugstoreRepository;
        this.auditService = auditService;
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
    public void save(DrugstoreDto dto) {
        Drugstore newDrugstore = drugstoreRepository.save(
                DrugstoreMapper.toEntity(dto)
        );
        auditService.insertAuditEvent(newDrugstore);
    }

    @Override
    public void delete(Long id) {
        Drugstore drugstore = drugstoreRepository.findById(id).orElseThrow(
                () -> new RuntimeException("No drugstore found with id: " + id)
        );
        drugstoreRepository.deleteById(id);
        auditService.deleteAuditEvent(drugstore);
    }

    @Override
    public void update(Drugstore entity) {
        drugstoreRepository.findById(entity.getId()).orElseThrow(
                () -> new RuntimeException("No drugstore found with id: " + entity.getId())
        );
        Drugstore updatedDrugstore = drugstoreRepository.save(entity);
        auditService.updateAuditEvent(updatedDrugstore);
    }

    @Override
    public String getAsXml() {
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
