package com.example.JMS.dto;

import com.example.JMS.dto.base.BaseDto;
import lombok.Getter;
import lombok.NoArgsConstructor;


@Getter
@NoArgsConstructor
public class DrugDto implements BaseDto {

    private String title;

    private String description;

    private Long DrugstoreId;

}
