package com.example.Rest.controllers.drugstoreControllers;

import com.example.Rest.controllers.base.BaseRestController;
import com.example.Rest.dto.DrugstoreDto;
import com.example.Rest.entities.Drugstore;
import com.example.Rest.services.DrugstoreService;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/api/v1/drugstores")
public class DrugstoreRestController extends BaseRestController<Drugstore, DrugstoreDto, Long> {

    public DrugstoreRestController(DrugstoreService drugstoreService) {
        super(drugstoreService);
    }
}
