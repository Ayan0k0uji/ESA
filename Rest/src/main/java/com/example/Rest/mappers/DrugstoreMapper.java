package com.example.Rest.mappers;


import com.example.Rest.dto.DrugstoreDto;
import com.example.Rest.entities.Drugstore;

public class DrugstoreMapper {
    public static Drugstore toEntity(DrugstoreDto dto) {
        Drugstore drugstore = new Drugstore();
        drugstore.setName(dto.getName());
        drugstore.setAddress(dto.getAddress());
        return drugstore;
    }
}
