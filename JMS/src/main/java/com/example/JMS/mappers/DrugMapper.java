package com.example.JMS.mappers;

import com.example.JMS.dto.DrugDto;
import com.example.JMS.entities.Drug;
import com.example.JMS.entities.Drugstore;

public class DrugMapper {
    public static Drug toEntity(DrugDto dto) {
        Drug drug = new Drug();
        Drugstore drugstore = new Drugstore();
        drugstore.setId(dto.getDrugstoreId());
        drug.setDrugstore(drugstore);
        drug.setTitle(dto.getTitle());
        drug.setDescription(dto.getDescription());
        return drug;
    }
}
