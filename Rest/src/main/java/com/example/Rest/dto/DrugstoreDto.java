package com.example.Rest.dto;

import com.example.Rest.dto.base.BaseDto;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class DrugstoreDto implements BaseDto {

    private String name;

    private String address;

}
