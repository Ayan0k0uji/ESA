package com.example.Rest.controllers.drugControllers;

import com.example.Rest.controllers.base.BaseRestController;
import com.example.Rest.dto.DrugDto;
import com.example.Rest.entities.Drug;
import com.example.Rest.services.DrugService;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/api/v1/drugs")
public class DrugRestController extends BaseRestController<Drug, DrugDto, Long> {
    public DrugRestController(DrugService drugService) {
        super(drugService);
    }
}
