package com.example.JMS.controllers.drugControllers;

import com.example.JMS.controllers.base.BaseRestController;
import com.example.JMS.dto.DrugDto;
import com.example.JMS.entities.Drug;
import com.example.JMS.services.DrugService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("/api/v1/drugs")
public class DrugRestController extends BaseRestController<Drug, DrugDto, Long> {
    public DrugRestController(DrugService drugService) {
        super(drugService);
    }
}
