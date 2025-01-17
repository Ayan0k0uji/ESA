package com.example.JMS.dto;

import com.example.JMS.dto.base.BaseDto;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class DrugstoreDto implements BaseDto {

    private String name;

    private String address;

}
