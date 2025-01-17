package com.example.JMS.controllers.drugstoreControllers;

import com.example.JMS.controllers.base.BaseRestController;
import com.example.JMS.dto.DrugstoreDto;
import com.example.JMS.entities.Drugstore;
import com.example.JMS.services.DrugstoreService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("/api/v1/drugstores")
public class DrugstoreRestController extends BaseRestController<Drugstore, DrugstoreDto, Long> {

    public DrugstoreRestController(DrugstoreService drugstoreService) {
        super(drugstoreService);
    }
}
