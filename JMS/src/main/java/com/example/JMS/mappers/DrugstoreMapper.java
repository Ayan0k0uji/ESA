package com.example.JMS.mappers;


import com.example.JMS.dto.DrugstoreDto;
import com.example.JMS.entities.Drugstore;

public class DrugstoreMapper {
    public static Drugstore toEntity(DrugstoreDto dto) {
        Drugstore drugstore = new Drugstore();
        drugstore.setName(dto.getName());
        drugstore.setAddress(dto.getAddress());
        return drugstore;
    }
}
