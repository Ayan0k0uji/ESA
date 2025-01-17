package com.example.Rest.mappers;

import com.example.Rest.dto.DrugDto;
import com.example.Rest.entities.Drug;
import com.example.Rest.entities.Drugstore;

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
